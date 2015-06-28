package ObjectStream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Person implements Serializable{
	transient int id;       //如果不想让id序列化，则可以加上transient关键字 。 当对象存储时，它的值不需要维持
	String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return "[id="+id+" , name="+name+"]";
	}
}
public class Objectoutputstream {

	public static void main(String[] args) {
		try {
			OutputStream o = new FileOutputStream("D:\\软件安装\\ecilpse文件\\IO\\person.tmp");     
			BufferedOutputStream o1 = new BufferedOutputStream(o);
			ObjectOutputStream out = new ObjectOutputStream(o1);   //构建字节对象输出流
			out.writeInt(12);      //写入序列化数据,要是想让数据显示出来则要反序列化也就是ObjectInputStream
			out.writeUTF("你好");
			out.writeObject(new Person(1, "zhang"));
			Person []p = {new Person(1,"a"), new Person(2, "b")};
			out.writeObject(p);
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
