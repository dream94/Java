package com.design;
/**
 * ������ģʽ
 * @author Admin
 *
 */
public class Adapter {
	public static void start(powerA p){        //ֻ���ܽӿ�A�ĵ���,��ʱ��Ҫ�õ�PowerAdapter���������ýӿ�BҲ���Ե���
		p.chong();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start(new  PowerAImpl());
		start(new PowerAdapter(new PowerBImpl()));
	}

}
class PowerAdapter implements powerA{        //Ϊ��ʵ�ֽӿ�B������ת���ɽӿ�A����
	private powerB p1;
	public PowerAdapter(powerB p) {
		p1 = p;
	}
	@Override
	public void chong() {
		// TODO Auto-generated method stub
		p1.check();
	}
}
interface powerA{
	public void chong();
}
class PowerAImpl implements powerA{
	@Override
	public void chong() {
		System.out.println("powerA���ڳ��");
	}
}
interface powerB{
	public void check();
}
class PowerBImpl implements powerB{
	@Override
	public void check() {
		System.out.println("powerB���ڳ����");
	}
}