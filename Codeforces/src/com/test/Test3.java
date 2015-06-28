package com.test;
interface t1{
	  public void run();
}
public class Test3 {
	
	public volatile static int count=0;
	public static void inc(){
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		count++;
	}
	public static void main(String[] args) {
		for(int t=0; t<1000; ++t){
			new Thread(new Runnable(){
				public void run(){
					Test3.inc();
				}
			}).start();
		}
		System.out.println(Test3.count);
		close(new t1(){
				public void run(){
					System.out.println("dsa");
				}
		});
		new t1(){
			public void run(){
				System.out.println("1");
			}
		}.run();;
	}
	
	public static void close(t1 k){
		k.run();
		System.out.println(System.nanoTime());
	}
}
