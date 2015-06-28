package com.classloader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * 自定义的ClassLoader，默认父加载器是App ClassLoader
 * @author dream
 *
 */
public class MyClassLoader extends ClassLoader{
	String name;    //加载器的名字
	
	public MyClassLoader(String name) {
		super();        //使用系统默认的加载器App ClassLoader作为父加载器
		this.name = name;
	}
	
	/**
	 * 
	 * @param parent
	 * @param name
	 */
	public MyClassLoader(ClassLoader parent, String name) {
		super(parent);     //指明使用规定的加载器作为父加载器
		this.name = name;
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		byte []b = loadClassData();        //得到类文件的二进制数据
		return defineClass(name, b, 0, b.length);
	}
	
	private byte[] loadClassData() {      //这里先指定读取Sample类文件
		File file = new File("D:\\软件安装\\ecilpse文件\\Codeforces\\bin\\com\\classloader\\Sample.class");
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
