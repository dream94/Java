package BufferStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Bufferoutstream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:\\�����װ\\ecilpse�ļ�\\IO\\content2.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream output = new BufferedOutputStream(out);  //�൱���ǰ�װ�࣬��FileOutputStream�����ϼ��ϻ��壬��װ����    
			String str = "�й�,���\n";
			output.write(str.getBytes());
			output.flush();        //ˢ�»�����
			output.close();        //�رջ�����ʱҲ��ˢ��һ�λ�����
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
