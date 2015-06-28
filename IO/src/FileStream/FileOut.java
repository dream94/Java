package FileStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOut {

	public static void main(String[] args) {
		File file = new File("D:\\软件安装\\ecilpse文件\\IO\\content.txt");
		try {
			OutputStream out = new FileOutputStream(file, true);    //第二个参数判断文件操作类型（true表示在文件尾追加内容，false表示重写文件内容）
			String str = "你好\n";
			byte []b = str.getBytes();
			System.out.println(b.length);
			/*
			//单个字节写入文件
			for(int t=0; t<b.length; ++t){
				out.write(b[t]);
			}*/
			
			//多字节写入文件
			//out.write(b, 0, b.length);   //写入b.length个字节
			out.write(b);      //全部写入
			out.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
