package com.design.decorator;
/**
 * 具体装饰角色：实现抽象装饰者角色，负责为具体构件添加额外功能.
 * @author Admin
 *
 */
public class Sugar extends Decorator{       //装饰者具体类
	public Sugar(Drink drink) {
		super(drink);
	}
	public String description() {
		return super.description()+" 糖";
	}
	public int price() {
		return super.price()+1;
	}
}
