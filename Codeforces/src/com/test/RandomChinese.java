package com.test;

import java.io.UnsupportedEncodingException;
import java.util.Random;
/**
 * 随机生成汉字
 * @author Admin
 *
 */
public class RandomChinese {            

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		for(int t=0; t<10; ++t){
			int hightPos = (176 + Math.abs(random.nextInt(39)));// 获取高位值
			int lowPos = (161 + Math.abs(random.nextInt(93)));// 获取低位值
			byte[] b = new byte[2];              //每个汉字是由两个字节组成
			b[0] = (new Integer(hightPos).byteValue());
			b[1] = (new Integer(lowPos).byteValue());
			String str;
			try {
				str = new String(b, "GBk");
				System.out.println(str);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// 转成中文
		}
	}
}
