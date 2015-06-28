package com.instanceOf;
class A{}
class B extends A{}
interface C{}
class D implements C{}
public class Test {
	
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		System.out.println(a instanceof B);
		System.out.println(b instanceof A);
		D d = new D();
		System.out.println(d instanceof C);
	}
}
