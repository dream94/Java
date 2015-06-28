package com.huang;

import java.util.Random;

public class FatherClass {
	public enum type{
		k1(),k2();         //可以重写它们的构造函数
	}
	public static void main(String[] args) {
		/*Random random = new Random();
		System.out.println(random.nextDouble());*/
		long t1= System.nanoTime();
		System.out.println(System.nanoTime()-t1);
	
	}
}
