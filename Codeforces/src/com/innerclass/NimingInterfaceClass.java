package com.innerclass;
/**
 * 接口式匿名内部类
 * @author Admin
 *
 */
interface B{
	public void show();
}
public class NimingInterfaceClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B a = new B(){
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("hello");
			}
		};
		a.show();
	}

}
