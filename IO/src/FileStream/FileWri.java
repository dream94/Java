package FileStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWri {

	public static void main(String[] args) {
		File file = new File("D:\\�����װ\\ecilpse�ļ�\\IO\\content1.txt");
		try {
			Writer out = new FileWriter(file);        
			String str = "�й� Welcome";
			out.write(str);
			out.flush();     //ˢ�»�����
			out.close();   //�������ַ��������ֽ�����������ǣ��ַ����л����������ݻ��ȴ���������У����رպ���д���ļ��У�����ʹ��flushˢ�»�������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
