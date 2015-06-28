package DataStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Dataoutputstream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			OutputStream o1 = new FileOutputStream("D:\\软件安装\\ecilpse文件\\IO\\content3.txt");
			BufferedOutputStream o = new BufferedOutputStream(o1);
			DataOutputStream out = new DataOutputStream(o);
			String s = "Windows, 欢迎你";
			out.writeUTF(s);
			out.writeInt(1);
			out.flush();
			out.close();
			o.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
