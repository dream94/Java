package com.jni;

public class OrderCl {
	public native double getPrice(String name);
	public native Order getOrder(String name, int amount);
	public native Order getRandomOrder();
	public native void analyzeOrder(Order order);
	
	static{
		//º”‘ÿ∂ØÃ¨¡¥Ω”ø‚
		System.loadLibrary("JNI1");
	}
	
	public void notification(){
		System.out.println("Got a notification");
	}
	
	public static void norificationByStatic(){
		System.out.println("Got a static notify");
	}
	
	public static void main(String[] args) {
		OrderCl o = new OrderCl();
		System.out.println(o.getPrice("Apple"));
		
		Order o1 = o.getOrder("dream", 12);
		System.out.println(o1);
		
		Order o2 = o.getRandomOrder();
		System.out.println(o2);
		
		o.analyzeOrder(o1);
	}

}
