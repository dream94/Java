package com.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * �Զ����ClassLoader��Ĭ�ϸ���������App ClassLoader
 * @author dream
 *
 */
public class MyClassLoader extends ClassLoader{
	String name;    //������������
	
	public MyClassLoader(String name) {
		super();        //ʹ��ϵͳĬ�ϵļ�����App ClassLoader��Ϊ��������
		this.name = name;
	}
	
	/**
	 * 
	 * @param parent
	 * @param name
	 */
	public MyClassLoader(ClassLoader parent, String name) {
		super(parent);     //ָ��ʹ�ù涨�ļ�������Ϊ��������
		this.name = name;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte []b = loadClassData();        //�õ����ļ��Ķ���������
		return defineClass(name, b, 0, b.length);
	}
	
	private byte[] loadClassData() {      //������ָ����ȡSample���ļ�
		File file = new File("D:\\�����װ\\ecilpse�ļ�\\Codeforces\\bin\\com\\classloader\\Sample.class");
		try {
			InputStream in = new FileInputStream(file);
			byte []b = new byte[(int)file.length()];
			int k = in.read(b);
			if(k!=-1){
				return b;
			}else {
				return null;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
    }
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ClassLoader: " + name;
	}
}
