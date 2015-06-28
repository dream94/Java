package com.innerclass;
/**
 * 方法内部类
 * @author Admin
 *
 */
public class MethodInnerClass {
	public void show(final String name){       //必须要定义为final
		class A{
			public void show(){
				System.out.println(name);
			}
		}
		new A().show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MethodInnerClass().show("aaa");
	}

}
