package com.confuse;

public class classloader {
	
	public static void main(String[] args) {
		Class c;
		ClassLoader cl;
		cl = ClassLoader.getSystemClassLoader();
		System.out.println(cl);
		System.out.println("---------");
		while(cl!=null){
			cl = cl.getParent();
			System.out.println(cl);
		}
		System.out.println("----------");
		try {
			c = Class.forName("java.lang.Object");      //������java.lang.Object����bootstrapװ�ص�
			cl = c.getClassLoader();
			System.out.println(cl);
			System.out.println("----------");
			c = Class.forName("com.confuse.classloader");
			cl = c.getClassLoader();
			System.out.println(cl);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
