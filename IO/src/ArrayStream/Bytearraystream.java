package ArrayStream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
/**
 * �ֽ�������
 * @author Admin
 *
 */
public class Bytearraystream {

	public static void main(String[] args) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		String s = "��ã�����";
		try {
			out.write(s.getBytes());   //д���ڴ���
			out.flush();
			out.close();       //�ر�ByteArrayOutputStream����Ч,�����Լ���ʹ��
			
			ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray()); //��ȡ�����������ֽ����鹹���ֽ�������
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
