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
			out = new FileOutputStream("D:\\软件安装\\ecilpse文件\\IO\\content3.txt");
			OutputStreamWriter writer = new OutputStreamWriter(out);    //字节流转字符流,若不写第二个参数则使用系统默认字符编码
			String s = "你好，晴天!\n";
			writer.write(s);
			writer.flush();
			writer.close();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     //字节流
		
		
	}

}
