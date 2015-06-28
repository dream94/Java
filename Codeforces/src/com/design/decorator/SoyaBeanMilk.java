package com.design.decorator;
/**
 * 具体构件角色：将要被附加功能的类，实现抽象构件角色接口
 * @author Admin
 *
 */
public class SoyaBeanMilk implements Drink{       //被装饰者的具体类

	public String description() {
		return "豆浆";
	}
	
	public int price() {
		return 2;
	}

}
