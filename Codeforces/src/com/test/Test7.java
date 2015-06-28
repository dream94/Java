package com.test;

public class Test7 {
	
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				int t=0;
				while(true){
					try {
						Thread.sleep(1000);
						System.out.println("子线程"+(++t));
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
		System.out.println("宿主进程终止了");
	}
}
