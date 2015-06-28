package com.internet.ThreadsDownload;

import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * ���߳����صĹ�����
 * @author Admin
 *
 */
public class DownUtil {
	private String path;         //������Դ��·��
	private String targetFile;   //�����ļ��ı���λ��
	private int threadNum;       //��Ҫ�ö����߳���������Դ 
	private DownThread[] threads;   //�������ص��̶߳���
	private int fileSize;         //���������ļ��Ĵ�С
	public DownUtil(String path, String targetFile, int threadNum) {
		this.path = path;
		this.targetFile = targetFile;
		this.threadNum = threadNum;
		threads = new DownThread[threadNum];
	}
	
	//����
	public void download(){
		try {
			URL url = new URL(path);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(5000);   //�������ӳ�ʱ��ʱ��
			con.setRequestMethod("GET");   //�������󷽷�ΪGET����
			con.setRequestProperty("Charset", "UTF-8");
			fileSize = con.getContentLength();    //�õ��ļ���С
			con.disconnect();    //�Ͼ�����
			int currentPartSize = fileSize / threadNum + 1;        //��ֹ����������
			RandomAccessFile file = new RandomAccessFile(targetFile, "rw");   //����һ�����ļ������ó���������Դ��ͬ��С�Ŀ��ļ�
			file.setLength(currentPartSize);
			file.close();
			for(int t=0; t<threadNum; ++t){
				int startPos = t*currentPartSize;   //��λ���߳�Ҫ���ص�Ŀ��λ��  
				RandomAccessFile part = new RandomAccessFile(targetFile, "rw");
				part.seek(t*currentPartSize);    
				threads[t] = new DownThread(part, path, startPos, currentPartSize);   //ָ��ÿ���߳����ص������Լ��������ص�λ��
				threads[t].start();       //�����������߳�
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�������صİٷ���
	public int getCompleteRate(){
		int total = 0;
		for(int t=0; t<threadNum; ++t){
			total += threads[t].getLength();
		}
		return (int)(total*100.0/fileSize);
	}
}
