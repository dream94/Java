package com.design.decorator;
/**
 * ����װ�ν�ɫ��ʵ�ֳ���װ���߽�ɫ������Ϊ���幹����Ӷ��⹦��.
 * @author Admin
 *
 */
public class BlackBean extends Decorator{
	public BlackBean(Drink drink) {
		super(drink);
	}
	public String description() {
		return super.description()+" �ڶ�";
	}
	public int price() {
		return super.price()+3;
	}

}
