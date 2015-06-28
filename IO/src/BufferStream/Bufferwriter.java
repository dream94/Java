package BufferStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class Bufferwriter {

	public static void main(String[] args) {
		File file = new File("D:\\软件安装\\ecilpse文件\\IO\\content3.txt");
		try {
			Writer writer = new FileWriter(file);
			BufferedWriter out = new BufferedWriter(writer);
			String s = "中国，你好\n";
			out.write(s);
			out.flush();
			out.close();
			writer.close();		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
