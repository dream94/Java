package com.innerclass;
/**
 * 方法内部类
 * @author Admin
 *
 */
public class MemberInnerClass {
	
	String name;
	public MemberInnerClass(String name) {
		this.name = name;
	}
	class A{
		public void show(){
			System.out.println(name);       //调用外部类的成员
		}
	}
	public void useshow(){          //实例化内部类对象
		A a = new A();
		a.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberInnerClass a = new MemberInnerClass("dream");
		a.useshow();
		A a1 = a.new A();
		a1.show();
	}

}
