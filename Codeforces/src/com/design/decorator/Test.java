package com.design.decorator;
/**
 * �����ࣨ����װ����ģʽ��
 * @author Admin
 *
 */
public class Test {

	public static void main(String[] args) {
		Drink drink = new SoyaBeanMilk();       //��װ����(����)
		System.out.println(drink.description()+"���ѣ�"+drink.price());
		Drink drink1 = new Sugar(drink);        //����װ�����࣬����װ�ζ���
		System.out.println(drink1.description()+"���ѣ�"+drink1.price());
		Drink drink2 = new BlackBean(drink);    //�úڶ���װ�ζ���
		System.out.println(drink2.description()+"���ѣ�"+drink2.price());
		Drink drink3 = new BlackBean(drink1);   //�úڶ���װ���Ƕ���
		System.out.println(drink3.description()+"���ѣ�"+drink3.price());
	}

}
