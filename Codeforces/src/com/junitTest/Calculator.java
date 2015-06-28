package com.junitTest;

public class Calculator {
	private static int result;
	public void add(int n){
		result += n;
	}
	public void sub(int n){
		result -= 1;
	}
	public void mul(int n){
		
	}
	public void div(int n){
		result /= n;
	}
	public void square(int n){
		result = n*n;
	}
	public void squareRoot(int n){
		for(;;){
			
		}
	}
	public void clear(){
		result = 0;
	}
	public int getResult(){
		return result;
	}
	
}
