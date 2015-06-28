package com.design;
/**
 * 适配器模式
 * @author Admin
 *
 */
public class Adapter {
	public static void start(powerA p){        //只接受接口A的调用,这时就要用到PowerAdapter适配器来让接口B也可以调用
		p.chong();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		start(new  PowerAImpl());
		start(new PowerAdapter(new PowerBImpl()));
	}

}
class PowerAdapter implements powerA{        //为了实现接口B能类似转化成接口A调用
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
		System.out.println("powerA正在充电");
	}
}
interface powerB{
	public void check();
}
class PowerBImpl implements powerB{
	@Override
	public void check() {
		System.out.println("powerB正在充电检查");
	}
}