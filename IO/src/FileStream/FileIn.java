package FileStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileIn {

	public static void main(String[] args) {
		File file = new File("D:\\�����װ\\ecilpse�ļ�\\IO\\content.txt");
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			int k;
			/*
		    //���ֽڶ�ȡ�ļ�����
			while((k=in.read())!=-1){
				System.out.print((char)k);
			}*/
			
			//���ֽڶ�ȡ�ļ�����
			byte[] b = new byte[4];
			StringBuilder sd = new StringBuilder();
			int time = 0;
			while((k=in.read(b))!=-1){          //�������ֽ�����ÿ�ζ�ȡ���ᾡ���ܶ����������飬���Ǻ������������������ֽ���ɣ���byte����С�Ļ����ܻ��������
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
