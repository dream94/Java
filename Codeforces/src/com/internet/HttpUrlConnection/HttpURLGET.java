package com.internet.HttpUrlConnection;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLGET {
	//HttpURLConnection类获取服务器一张图片
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://localhost:80/12.jpg");
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setReadTimeout(3000);  //设置连接服务器超时时间
			urlCon.setDoInput(true);     //设置从服务器读取数据
			urlCon.setDoOutput(true);    //设置向服务器发送数据
			//HttpURLConnection若没设置请求方式，则默认为GET请求   urlCon.setRequestMethod("POST");
			
			//urlCon.connect();
			InputStream input = urlCon.getInputStream();    //有连接功能，可以不写上面那句
			FileOutputStream fs = new FileOutputStream(new File("F:\\test.jpg"));
			byte[] b = new byte[1024];
			while(input.read(b)!=-1){
				fs.write(b);
			}
			System.out.println("下载成功");
			fs.close();
			input.close();
			urlCon.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	
	}

}
