package com.test;

import java.util.Scanner;


public class Test1 {
	private int k1;
	public void way(){
		synchronized (this) {
			try {
				wait();
				System.out.println(123);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}	
	}
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.way();
	}

}
