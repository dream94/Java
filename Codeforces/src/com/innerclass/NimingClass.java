package com.innerclass;
/**
 * 参数式匿名内部类
 * @author Admin
 *
 */
abstract class C{
	public abstract void show();
}
public class NimingClass {
	public void way(C c){
		c.show();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NimingClass a = new NimingClass();
		a.way(new C(){
			@Override
			public void show() {
				// TODO Auto-generated method stub
				System.out.println("你好");
			}
		});
	}

}
