package TransStream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class inputstreamreader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStream in = new FileInputStream("D:\\�����װ\\ecilpse�ļ�\\IO\\content3.txt");
			InputStreamReader input = new InputStreamReader(in);      //�ֽ���ת�ַ���
			BufferedReader reader = new BufferedReader(input);     //�û�������װ
			
			String s;
			while((s=reader.readLine())!=null){
				System.out.println(s);
			}
			reader.close();
			input.close();
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
