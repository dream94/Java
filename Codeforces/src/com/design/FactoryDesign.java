package com.design;
/**
 * 简单工厂设计模式
 * @author Admin
 *
 */
public class FactoryDesign {

	public static void main(String[] args) {
		Car car1 = Factory.getCar("small");     //通过接口来接收对象降低依赖度（耦合性）
		Car car2 = Factory.getCar("big");
		if(car1!=null){
			car1.run();
		}
		if(car2!=null){
			car2.run();
		}
	}

}

class Factory{            //工厂类,来间接控制生产对象
	public static Car getCar(String name){
		if(name.equals("small")){
			return new smallCar();      //生产小汽车
		}else if(name.equals("big")){
			return new bigCar();       // 生产大汽车
		}else return null;
	}
}

interface Car{
	public void run();
}
class smallCar implements Car{
	@Override
	public void run() {
		System.out.println("小汽车在跑");
	}
}
class bigCar implements Car{
	@Override
	public void run() {
		System.out.println("大汽车在跑");
	}
}