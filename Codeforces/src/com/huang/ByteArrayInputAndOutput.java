package com.huang;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ByteArrayInputAndOutput {
	private int k1;
	public static void main(String[] args) {
		File file = new File("D:\\软件安装\\ecilpse文件\\Codeforces\\words.txt");
		Object []o = new Object[10];
		o[0] = 1;
		o[1] = 2f;
		o[2] = "sd";
		System.out.println(o[0] + " "+ o[1]+ " "+o[2]);
		cal(file);
		try {
			FileInputStream in = new FileInputStream(file);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			int k;
			byte[] b = new byte[1024];
			while((k=in.read(b))!=-1){
				out.write(b, 0, k);
			}
			System.out.println(out.toString());
			byte res[] = out.toByteArray();
			System.out.println("second:"+new String(res));
			out.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void cal(File file){
		long len = file.length();   //B
 		System.out.println(len+"B");
		len /= 1024;           //KB
 		System.out.println(len+"kB");
	}
}
