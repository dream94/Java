package com.test;
class A{}
class B extends A{
	public void run(){
		System.out.println("da");
	}
}

public class TestStringFormat {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = String.format("你好吗?%1$s%1$s", "sd");
		System.out.println(s);
		A a = new B();
		((B)a).run();
		
		int min1, min2;        //得出最小的和次小的数
		min1 = min2 = 0x7fffffff;
		int temp[] = new int[]{1, 3, 2, 5, 4, 34, 12,3};
		for(int t=0; t<temp.length; ++t){
			if(temp[t]<min1){
				min2 = min1;
				min1 = temp[t];
			}else if(temp[t]<min2){
				min2 = temp[t];
			}
		}
		System.out.println("min1:"+min1+"  min2:"+min2);
	}

}
