package com.huang;

public class MutiParam {
	public static class A{}
	public class B{}
	public static void test(String... str){
		for(String s: str){
			System.out.println(s);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test("1", "2", "3");
		System.out.println();
		new MutiParam.A();    //��̬�ڲ���
		new MutiParam().new B();   //�ڲ���
	}

}
