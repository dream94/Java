package ObjectStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class Objectinputstream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStream in = new FileInputStream("D:\\软件安装\\ecilpse文件\\IO\\person.tmp");
			BufferedInputStream in1 = new BufferedInputStream(in);
			ObjectInputStream input = new ObjectInputStream(in1);
			int a = input.readInt();    //这里读入序列化的数据要按顺序，前面(ObjectOutputStream)写入的顺序是怎样，这里读入数据的顺序就是怎样，如果不同则会报错
			String s =input.readUTF();
			Person p = (Person) input.readObject();
			
			Person []ps = (Person[]) input.readObject(); 

			System.out.println(a);
			System.out.println(s);
			System.out.println(p);
			for(Person p1:ps){
				System.out.println(p1);       //前面的id为transient，不会被序列化，所以输出时输出默认值0
			}
			input.close();
			in1.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
