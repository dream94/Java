package com.test;


public final class StudyFrame implements Runnable{
	class dreamException extends RuntimeException{
		
	}
	public static class dimen{
		public static final int k=0;
	}
	
	public void test(int t){
		//throw new ArithmeticException();          //直接抛出不报错（不用处理）继承于RuntimeException
	//	throw new Exception("da");                  //直接抛出Exception类报错（一定要处理，否则编译没法通过）
		try{
			throw new dreamException();                 //直接抛出不报错（不用处理）
		}catch(Exception e){
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this){
			try {
				System.out.println("start");
				this.wait();          //wait会释放对象锁，同时线程睡眠,除非notify唤醒此线程，才会继续执行
				//wait不写参数则永久，写则睡眠多久
				System.out.println("resume");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o;       
		String s;    
		StringBuffer s1;
		StringBuilder s2;
		StudyFrame f = new StudyFrame();
		//new Thread(f).start();*/
		f.test(1);
		//Class
		System.out.println(0x80000000);
		System.out.println(0x7fffffff);
		char a[]=new char[]{'a','a','a','a','a'};
		int a1[] = new int[]{1, 2, 3, 4, 5};
		System.out.println(a.length);
		System.out.println(StudyFrame.dimen.k);
	}

}
