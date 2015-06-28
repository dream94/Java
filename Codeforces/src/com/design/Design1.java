package com.design;
/**
 * 单例设计模式
 * @author Admin
 *
 */
public class Design1 {
	private String name;
	private static Design1 d;
	private Design1(String name){
		this.name = name;
	}
	public static Design1 getDesign(){
		if(d==null){
			System.out.println("构造");
			d = new Design1("ddd");
		}
		return d;
	}
	@Override
	public String toString() {
		return name+"单例";
	}
	public static void main(String[] args) {
		Design1 d = Design1.getDesign();
		System.out.println(d);
	}

}
