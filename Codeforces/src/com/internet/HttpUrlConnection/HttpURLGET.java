package com.internet.HttpUrlConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLGET {
	//HttpURLConnection���ȡ������һ��ͼƬ
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://localhost:80/12.jpg");
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setReadTimeout(3000);  //�������ӷ�������ʱʱ��
			urlCon.setDoInput(true);     //���ôӷ�������ȡ����
			urlCon.setDoOutput(true);    //�������������������
			//HttpURLConnection��û��������ʽ����Ĭ��ΪGET����   urlCon.setRequestMethod("POST");
			
			//urlCon.connect();
			InputStream input = urlCon.getInputStream();    //�����ӹ��ܣ����Բ�д�����Ǿ�
			FileOutputStream fs = new FileOutputStream(new File("F:\\test.jpg"));
			byte[] b = new byte[1024];
			while(input.read(b)!=-1){
				fs.write(b);
			}
			System.out.println("���سɹ�");
			fs.close();
			input.close();
			urlCon.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}

}
