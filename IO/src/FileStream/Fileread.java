package FileStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Fileread {
	
	public static void main(String[] args) {
		File file = new File("D:\\�����װ\\ecilpse�ļ�\\IO\\content1.txt");
		try {
			Reader in = new FileReader(file);
			char s[] = new char[4];    //�������ַ�������FileIn�����ֽڣ��������ﲻ�������С���������룬��Ϊchar�������ֽڵĴ�С���������Ĳ�������,��FileIn���ܻ���Ϊ����̫С���������
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
