package ArrayStream;

import java.io.DataOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * �ַ�����
 * @author Admin
 *
 */
public class Bytearraywrirea {

	public static void main(String[] args) {
		try{
			StringWriter sw = new StringWriter();
			sw.write("��ã��й�!");
			sw.close();
			StringReader sr = new StringReader(sw.toString());   //��ȡ����������һ���ַ�������һ���ַ���������  
			char s[] = new char[4];
			StringBuilder sd = new StringBuilder();
			int k;
			while((k=sr.read(s))!=-1){
				sd.append(new String(s, 0, k));
			}
			System.out.println(sd.toString());
			sr.close();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
