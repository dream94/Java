package ObjectStream;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class Person implements Serializable{
	transient int id;       //���������id���л�������Լ���transient�ؼ��� �� ������洢ʱ������ֵ����Ҫά��
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
			OutputStream o = new FileOutputStream("D:\\�����װ\\ecilpse�ļ�\\IO\\person.tmp");     
			BufferedOutputStream o1 = new BufferedOutputStream(o);
			ObjectOutputStream out = new ObjectOutputStream(o1);   //�����ֽڶ��������
			out.writeInt(12);      //д�����л�����,Ҫ������������ʾ������Ҫ�����л�Ҳ����ObjectInputStream
			out.writeUTF("���");
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
