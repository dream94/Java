package FileStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOut {

	public static void main(String[] args) {
		File file = new File("D:\\�����װ\\ecilpse�ļ�\\IO\\content.txt");
		try {
			OutputStream out = new FileOutputStream(file, true);    //�ڶ��������ж��ļ��������ͣ�true��ʾ���ļ�β׷�����ݣ�false��ʾ��д�ļ����ݣ�
			String str = "���\n";
			byte []b = str.getBytes();
			System.out.println(b.length);
			/*
			//�����ֽ�д���ļ�
			for(int t=0; t<b.length; ++t){
				out.write(b[t]);
			}*/
			
			//���ֽ�д���ļ�
			//out.write(b, 0, b.length);   //д��b.length���ֽ�
			out.write(b);      //ȫ��д��
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
