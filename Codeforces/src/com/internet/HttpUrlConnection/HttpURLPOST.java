package com.internet.HttpUrlConnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpURLPOST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("http://localhost:3000/Home/log");
			HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
			urlCon.setReadTimeout(3000);
			urlCon.setDoInput(true);
			urlCon.setDoOutput(true);
			urlCon.setRequestMethod("POST");
			urlCon.setDefaultUseCaches(false);
			urlCon.setRequestProperty("Content-Type","application/x-www-form-urlencoded");  
			String param = "username=zhangsan";
			urlCon.connect();
			OutputStream os = urlCon.getOutputStream();
			os.write(param.getBytes());
			int responseCode = urlCon.getResponseCode();
			BufferedReader br = null;
			if(responseCode == 200){
				br = new BufferedReader(new InputStreamReader(urlCon.getInputStream()));
				String str;
				while((str=br.readLine())!=null){
					System.out.println(str);
				}
			}else{
				System.out.println("fail");
			}
			br.close();
			os.close();
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
