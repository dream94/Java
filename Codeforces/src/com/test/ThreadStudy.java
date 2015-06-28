package com.test;

import java.util.Scanner;

public class ThreadStudy{
	public volatile static int k;
	public static void test(){
		try{
			Thread.sleep(1);
		} catch(Exception e){
			
		}
		k++;
	}
	public static void main(String[] args) {
		/*for(int t=0; t<1000; ++t){
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					test();
				}
			}).start();
		}
		System.out.println(k);*/
		
	}
}
