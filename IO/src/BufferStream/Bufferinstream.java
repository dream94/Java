package BufferStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Bufferinstream {
	public static void main(String[] args) {
		File file = new File("D:\\软件安装\\ecilpse文件\\IO\\content2.txt");
		try {
			InputStream in = new FileInputStream(file);
			BufferedInputStream input = new BufferedInputStream(in);
			byte []b= new byte[1024];    //字节数组开大点，防止每次读取时只读到中文的部分字节,出现乱码
			StringBuilder sd = new StringBuilder();
			int k;
			while((k=input.read(b))!=-1){
				sd.append(new String(b, 0, k));
			}
			System.out.println(sd.toString());
			input.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
