package com.innerclass;
/**
 * �����ڲ���
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
			System.out.println(name);       //�����ⲿ��ĳ�Ա
		}
	}
	public void useshow(){          //ʵ�����ڲ������
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
