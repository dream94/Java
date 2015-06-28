package com.classloader;

/**
 * ClassLoader 类使用委托模型来搜索类和资源。每个 ClassLoader实例都有一个相关的父类加载器。
 * 需要查找类或资源时，ClassLoader 实例会在试图亲自查找类或资源之前，将搜索类或资源的任务委托给其父类加载器。
 */

public class Test {
	
	public static void main(String[] args) {
		MyClassLoader loader1 = new MyClassLoader("loader1");  //使用系统指定的加载器作为父加载器
		
		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2");  //使用loader1作为父加载器，但是加载该类实际是AppClassLoader，和上面那个相同效果
		
		MyClassLoader loader3 = new MyClassLoader(null, "loader3");   //指明父加载器为null，则为bootstrap ClassLoader,加载该类时先一直传到最上面的父类就是
		//bootstrap,而bootstrap由于安全问题，只会加载java核心api类，所以不会加载，而丢回来，则由本身加载
		
		test(loader1);
		test(loader2);
		test(loader3);
		
	}
	
	public static void test(ClassLoader loader){
		try {
			Class c = loader.loadClass("com.classloader.Sample");
			c.newInstance();     //构造类对象
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
