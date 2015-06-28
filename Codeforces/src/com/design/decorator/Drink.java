package com.design.decorator;
/**
 * 抽象构件角色：定义一个抽象接口，来规范准备附加功能的类
 * @author Admin
 *
 */
public interface Drink {             //被装饰者的基类
	public String description();
	public int price();
}
