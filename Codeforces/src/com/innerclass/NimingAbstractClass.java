package com.innerclass;
/**
 * �̳�ʽ�����ڲ���
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
