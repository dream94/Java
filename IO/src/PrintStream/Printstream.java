package PrintStream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
class Person{
	String name;
	public Person(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
}
public class Printstream {

	public static void main(String[] args) {
		try {
			OutputStream o = new FileOutputStream("D:\\�����װ\\ecilpse�ļ�\\IO\\content3.txt");
			BufferedOutputStream o1 = new BufferedOutputStream(o);     //��װһ�»�����
			PrintStream out = new PrintStream(o1);
			out.println("��");
			out.println(true);
			out.println(new Person("huang"));
			out.flush();
			out.close();
			o1.close();
			o.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
