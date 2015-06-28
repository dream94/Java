package com.huang;

public class KnowledgeClass {
	private A a = new A();
	public KnowledgeClass(){
		System.out.println("KnowledgeClass()");
	}
	
	class A{
		public A(){
			System.out.println("A make");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnowledgeClass a1 = new KnowledgeClass();
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = str2.intern();
		System.out.println(str1==str2);		
		System.out.println(str1==str3);
	}

}
