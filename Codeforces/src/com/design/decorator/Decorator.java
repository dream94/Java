package com.design.decorator;
/**
 * ����װ���߽�ɫ:���жԾ��幹����ɫ�����ã���װ���ߣ���ʵ�ֳ��󹹼���ɫһ�µĽӿ�
 * @author Admin
 *
 */
public class Decorator implements Drink{           //װ���ߵĻ���
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
