package com.internet.ThreadsDownload;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 多线程下载的工具类
 * @author Admin
 *
 */
public class DownUtil {
	private String path;         //下载资源的路径
	private String targetFile;   //下载文件的保存位置
	private int threadNum;       //需要用多少线程来下载资源 
	private DownThread[] threads;   //定义下载的线程对象
	private int fileSize;         //定义下载文件的大小
	public DownUtil(String path, String targetFile, int threadNum) {
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
	}
	
	//下载
	public void download(){
		try {
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000);   //设置连接超时的时间
			con.setRequestMethod("GET");   //设置请求方法为GET请求
			con.setRequestProperty("Charset", "UTF-8");
			fileSize = con.getContentLength();    //得到文件大小
			con.disconnect();    //断绝连接
			int currentPartSize = fileSize / threadNum + 1;        //防止整除有余数
			RandomAccessFile file = new RandomAccessFile(targetFile, "rw");   //创建一个空文件，设置成与网络资源相同大小的空文件
			file.setLength(currentPartSize);
			file.close();
			for(int t=0; t<threadNum; ++t){
				int startPos = t*currentPartSize;   //定位该线程要下载的目标位置  
				RandomAccessFile part = new RandomAccessFile(targetFile, "rw");
				part.seek(t*currentPartSize);    
				threads[t] = new DownThread(part, path, startPos, currentPartSize);   //指定每个线程下载的任务以及负责下载的位置
				threads[t].start();       //启动下载子线程
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//返回下载的百分率
	public int getCompleteRate(){
		int total = 0;
		for(int t=0; t<threadNum; ++t){
			total += threads[t].getLength();
		}
		return (int)(total*100.0/fileSize);
	}
}
