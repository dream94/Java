package BufferStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Bufferinstream {
	public static void main(String[] args) {
		File file = new File("D:\\�����װ\\ecilpse�ļ�\\IO\\content2.txt");
		try {
			InputStream in = new FileInputStream(file);
			BufferedInputStream input = new BufferedInputStream(in);
			byte []b= new byte[1024];    //�ֽ����鿪��㣬��ֹÿ�ζ�ȡʱֻ�������ĵĲ����ֽ�,��������
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
