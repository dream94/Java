package PrintStream;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Printwriter {

	public static void main(String[] args) {
		try {
			Writer w = new FileWriter("D:\\软件安装\\ecilpse文件\\IO\\content3.txt");
			BufferedWriter w1 = new BufferedWriter(w);
			PrintWriter out = new PrintWriter(w1);
			out.println(false);
			out.println(123);
			out.println("dream");
			out.close();
			w1.close();
			w.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
