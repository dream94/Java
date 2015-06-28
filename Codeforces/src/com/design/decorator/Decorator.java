package com.design.decorator;
/**
 * 抽象装饰者角色:持有对具体构件角色的引用（被装饰者）并实现抽象构件角色一致的接口
 * @author Admin
 *
 */
public class Decorator implements Drink{           //装饰者的基类
	private Drink drink;
	public Decorator(Drink drink) {
		this.drink = drink;
	}
	
	public String description() {
		return drink.description();
	}

	public int price() {
		return drink.price();
	}
}
