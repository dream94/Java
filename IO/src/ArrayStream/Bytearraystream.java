package ArrayStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
 * 字节数组流
 * @author Admin
 *
 */
public class Bytearraystream {

	public static void main(String[] args) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String s = "你好，晴天";
		try {
			out.write(s.getBytes());   //写进内存中
			out.flush();
			out.close();       //关闭ByteArrayOutputStream流无效,还可以继续使用
			
			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray()); //读取操作，根据字节数组构建字节数组流
			byte []b = new byte[1024];
			int k;
			StringBuilder sd = new StringBuilder();
			while((k=in.read(b))!=-1){
				sd.append(new String(b, 0, k));
			}
			System.out.println(sd.toString());
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
