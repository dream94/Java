package com.innerclass;
/**
 * 继承式匿名内部类
 * @author Admin
 *
 */
abstract class A{
	public abstract void show();
}

public class NimingAbstractClass {

	public static void main(String[] args) {
		A a = new A(){
			@Override
			public void show() {
				System.out.println("welcome");
			}
		};
		a.show();
	}

}
