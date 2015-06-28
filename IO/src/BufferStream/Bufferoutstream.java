package BufferStream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class Bufferoutstream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:\\软件安装\\ecilpse文件\\IO\\content2.txt");
		try {
			OutputStream out = new FileOutputStream(file);
			BufferedOutputStream output = new BufferedOutputStream(out);  //相当于是包装类，在FileOutputStream基础上加上缓冲，包装起来    
			String str = "中国,你好\n";
			output.write(str.getBytes());
			output.flush();        //刷新缓冲区
			output.close();        //关闭缓冲流时也会刷新一次缓冲区
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
