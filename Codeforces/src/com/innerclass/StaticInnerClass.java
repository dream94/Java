package com.innerclass;
/**
 * ��̬�ڲ���
 * @author Admin
 *
 */
public class StaticInnerClass {
	static String name = "das";
	public StaticInnerClass() {
	}
	
	static class A{
		public void show(){
			System.out.println("hello world " + name);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticInnerClass.A a = new StaticInnerClass.A();
		a.show();
	}

}
