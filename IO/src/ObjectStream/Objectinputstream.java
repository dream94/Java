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
			InputStream in = new FileInputStream("D:\\�����װ\\ecilpse�ļ�\\IO\\person.tmp");
			BufferedInputStream in1 = new BufferedInputStream(in);
			ObjectInputStream input = new ObjectInputStream(in1);
			int a = input.readInt();    //����������л�������Ҫ��˳��ǰ��(ObjectOutputStream)д���˳��������������������ݵ�˳����������������ͬ��ᱨ��
			String s =input.readUTF();
			Person p = (Person) input.readObject();
			
			Person []ps = (Person[]) input.readObject(); 

			System.out.println(a);
			System.out.println(s);
			System.out.println(p);
			for(Person p1:ps){
				System.out.println(p1);       //ǰ���idΪtransient�����ᱻ���л����������ʱ���Ĭ��ֵ0
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
