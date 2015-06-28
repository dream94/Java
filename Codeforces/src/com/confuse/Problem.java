package com.confuse;

public class Problem {
	private static Problem p = new Problem();
	public static int count1;
	public static int count2 = 5;
	
	private Problem(){
		count1++;
		System.out.println("count2:"+count2);
		count2++;
		System.out.println("count2:"+count2);
	}
	
	public Problem getInstance(){
		return p;
	}
	
	public static void main(String[] args) {
		System.out.println(count2);
	}	

}
