package com.design;
/**
 * �򵥹������ģʽ
 * @author Admin
 *
 */
public class FactoryDesign {

	public static void main(String[] args) {
		Car car1 = Factory.getCar("small");     //ͨ���ӿ������ն��󽵵������ȣ�����ԣ�
		Car car2 = Factory.getCar("big");
		if(car1!=null){
			car1.run();
		}
		if(car2!=null){
			car2.run();
		}
	}

}

class Factory{            //������,����ӿ�����������
	public static Car getCar(String name){
		if(name.equals("small")){
			return new smallCar();      //����С����
		}else if(name.equals("big")){
			return new bigCar();       // ����������
		}else return null;
	}
}

interface Car{
	public void run();
}
class smallCar implements Car{
	@Override
	public void run() {
		System.out.println("С��������");
	}
}
class bigCar implements Car{
	@Override
	public void run() {
		System.out.println("����������");
	}
}