package com.design.decorator;
/**
 * ����װ�ν�ɫ��ʵ�ֳ���װ���߽�ɫ������Ϊ���幹����Ӷ��⹦��.
 * @author Admin
 *
 */
public class Sugar extends Decorator{       //װ���߾�����
	public Sugar(Drink drink) {
		super(drink);
	}
	public String description() {
		return super.description()+" ��";
	}
	public int price() {
		return super.price()+1;
	}
}
