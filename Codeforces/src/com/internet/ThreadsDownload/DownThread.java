package com.internet.ThreadsDownload;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 单个线程下载类
 * @author Admin
 *
 */
public class DownThread extends Thread {
	private RandomAccessFile file;   //注意这个文件中有流，当使用时记得要关闭
	private int startPos;
	private int currentPartSize;
	private int length;       //表示该线程已经下载了多少字节
	private String path;      //下载源
	public DownThread(RandomAccessFile file, String path, int startPos, int currentPartSize) {
		this.file = file;
		this.startPos = startPos;
		this.currentPartSize = currentPartSize;
		this.path = path;
		length = 0;
	}
	
	@Override
	public void run() {
		try {
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000);
			con.setRequestMethod("GET");
			con.setRequestProperty("Charset", "UTF-8");
			InputStream input = con.getInputStream();
			input.skip(startPos);    //跳过startPos个字节，表明该线程只下载自己负责的那部分文件
			byte[] b = new byte[1024];
			int len;
			while((len=input.read(b))>0&&length<currentPartSize){
				file.write(b, 0, len);   
				length += len;     
			}
			input.close();
			file.close();     
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	
	
	
	
	
}
