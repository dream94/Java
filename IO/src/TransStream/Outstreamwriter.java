package TransStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Outstreamwriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OutputStream out;
		try {
			out = new FileOutputStream("D:\\�����װ\\ecilpse�ļ�\\IO\\content3.txt");
			OutputStreamWriter writer = new OutputStreamWriter(out);    //�ֽ���ת�ַ���,����д�ڶ���������ʹ��ϵͳĬ���ַ�����
			String s = "��ã�����!\n";
			writer.write(s);
			writer.flush();
			writer.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     //�ֽ���
		
		
	}

}
