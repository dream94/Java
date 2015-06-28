package com.test;

/**
 * 　大多数人以为,一个线程象调用了interrupt()方法,那它对应的线程就应该被中断而抛出异常,
 * 事实中,当一个线程对象调用interrupt()方法,它对应的线程并没有被中断,只是改变了它的中断状态.
 * 使当前线程的状态变以中断状态,如果没有其它影响,线程还会自己继续执行.
 * 只有当线程执行到sleep,wait,join等方法时,或者自己检查中断状态而抛出异常的情况下,线程 才会抛出异常.
 * http://www.cnblogs.com/biGpython/archive/2012/03/05/2380858.html
 * @author Admin
 * 
 */
public class ThreadStudy1 extends Thread{
	int t;
	boolean check = true;
	public static void main(String[] args) {
		ThreadStudy1 a = new ThreadStudy1();
		a.start();
		try {
			Thread.sleep(3000);
			System.out.println("sleep finish");
			if(a.t==3){
				//a.check = false;
				a.interrupt();  //调用这个方法
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(check){
			try{
				t++;
				System.out.println(t);
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println("dream: +"+e.getMessage());
			}
		}
		System.out.println("exit run");
	}

}
