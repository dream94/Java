package BufferStream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Bufferreader {

	public static void main(String[] args) {
		try {
			Reader reader = new FileReader("D:\\软件安装\\ecilpse文件\\IO\\content3.txt");
			BufferedReader in = new BufferedReader(reader);
			char s[] = new char[4];
			StringBuilder sd = new StringBuilder();
			int k;
			while((k=in.read(s))!=-1){
				sd.append(new String(s, 0, k));
			}
			System.out.println(sd.toString());
			in.close();
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
