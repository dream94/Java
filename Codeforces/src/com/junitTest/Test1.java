package com.junitTest;
interface A{}
class B implements A{}

public class Test1 {
	public static void main(String[] args) {
		Object o = new Object();
		String o1 = "a";
		StringBuffer o2 = new StringBuffer();
		B b =new B();
		if(b instanceof A){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}
	
}
