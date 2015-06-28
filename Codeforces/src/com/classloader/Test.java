package com.classloader;

/**
 * ClassLoader ��ʹ��ί��ģ�������������Դ��ÿ�� ClassLoaderʵ������һ����صĸ����������
 * ��Ҫ���������Դʱ��ClassLoader ʵ��������ͼ���Բ��������Դ֮ǰ�������������Դ������ί�и��丸���������
 */

public class Test {
	
	public static void main(String[] args) {
		MyClassLoader loader1 = new MyClassLoader("loader1");  //ʹ��ϵͳָ���ļ�������Ϊ��������
		
		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");  //ʹ��loader1��Ϊ�������������Ǽ��ظ���ʵ����AppClassLoader���������Ǹ���ͬЧ��
		
		MyClassLoader loader3 = new MyClassLoader(null, "loader3");   //ָ����������Ϊnull����Ϊbootstrap ClassLoader,���ظ���ʱ��һֱ����������ĸ������
		//bootstrap,��bootstrap���ڰ�ȫ���⣬ֻ�����java����api�࣬���Բ�����أ��������������ɱ������
		
		test(loader1);
		test(loader2);
		test(loader3);
		
	}
	
	public static void test(ClassLoader loader){
		try {
			Class c = loader.loadClass("com.classloader.Sample");
			c.newInstance();     //���������
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
