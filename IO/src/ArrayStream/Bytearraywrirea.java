package ArrayStream;

import java.io.DataOutputStream;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * 字符串流
 * @author Admin
 *
 */
public class Bytearraywrirea {

	public static void main(String[] args) {
		try{
			StringWriter sw = new StringWriter();
			sw.write("你好，中国!");
			sw.close();
			StringReader sr = new StringReader(sw.toString());   //读取操作，根据一个字符串构造一个字符串输入流  
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
