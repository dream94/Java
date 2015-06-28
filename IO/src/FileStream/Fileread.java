package FileStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Fileread {
	
	public static void main(String[] args) {
		File file = new File("D:\\软件安装\\ecilpse文件\\IO\\content1.txt");
		try {
			Reader in = new FileReader(file);
			char s[] = new char[4];    //这里是字符，而在FileIn中是字节，所以这里不管数组多小都不会乱码，因为char是两个字节的大小，所以中文不会乱码,而FileIn可能会因为数组太小而造成乱码
			StringBuilder sd = new StringBuilder();
			int k;
			while((k=in.read(s))!=-1){
				sd.append(s, 0, k);
			}
			System.out.println(sd);
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
