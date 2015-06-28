package com.internet.ThreadsDownload;

import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * �����߳�������
 * @author Admin
 *
 */
public class DownThread extends Thread {
	private RandomAccessFile file;   //ע������ļ�����������ʹ��ʱ�ǵ�Ҫ�ر�
	private int startPos;
	private int currentPartSize;
	private int length;       //��ʾ���߳��Ѿ������˶����ֽ�
	private String path;      //����Դ
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
			input.skip(startPos);    //����startPos���ֽڣ��������߳�ֻ�����Լ�������ǲ����ļ�
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
