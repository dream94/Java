package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileIn {

	public static void main(String[] args) {
		File file = new File("D:\\软件安装\\ecilpse文件\\IO\\content.txt");
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int k;
			/*
		    //单字节读取文件内容
			while((k=in.read())!=-1){
				System.out.print((char)k);
			}*/
			
			//多字节读取文件内容
			byte[] b = new byte[4];
			StringBuilder sd = new StringBuilder();
			int time = 0;
			while((k=in.read(b))!=-1){          //这里是字节流，每次读取都会尽可能读满整个数组，可是汉字是由两个或三个字节组成，若byte数组小的话可能会造成乱码
				sd.append(new String(b, 0, k));
				time++;
			}
			System.out.println(sd.toString());
			System.out.println(time);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
