package com.innerclass;
/**
 * �����ڲ���
 * @author Admin
 *
 */
public class MethodInnerClass {
	public void show(final String name){       //����Ҫ����Ϊfinal
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
