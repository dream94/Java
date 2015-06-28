package com.design.decorator;
/**
 * 测试类（测试装饰者模式）
 * @author Admin
 *
 */
public class Test {

	public static void main(String[] args) {
		Drink drink = new SoyaBeanMilk();       //被装饰者(豆浆)
		System.out.println(drink.description()+"花费："+drink.price());
		Drink drink1 = new Sugar(drink);        //糖是装饰者类，用来装饰豆浆
		System.out.println(drink1.description()+"花费："+drink1.price());
		Drink drink2 = new BlackBean(drink);    //用黑豆来装饰豆浆
		System.out.println(drink2.description()+"花费："+drink2.price());
		Drink drink3 = new BlackBean(drink1);   //用黑豆来装饰糖豆浆
		System.out.println(drink3.description()+"花费："+drink3.price());
	}

}
