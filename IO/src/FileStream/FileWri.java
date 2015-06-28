package FileStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWri {

	public static void main(String[] args) {
		File file = new File("D:\\软件安装\\ecilpse文件\\IO\\content1.txt");
		try {
			Writer out = new FileWriter(file);        
			String str = "中国 Welcome";
			out.write(str);
			out.flush();     //刷新缓冲流
			out.close();   //这里是字符流，与字节流最大区别是，字符流有缓冲区，数据会先存进缓冲区中，流关闭后再写入文件中（或者使用flush刷新缓冲区）
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
