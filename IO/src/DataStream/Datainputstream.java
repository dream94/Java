package DataStream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Datainputstream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStream in = new FileInputStream("D:\\�����װ\\ecilpse�ļ�\\IO\\content3.txt");
			BufferedInputStream in1 = new BufferedInputStream(in);
			DataInputStream input = new DataInputStream(in1);
			String a = input.readUTF();       //˳��Ҫ��д���˳����ͬ������ᱨ��
			System.out.println(a);
			int b = input.readInt();
			System.out.println(b);
			input.close();
			in1.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
