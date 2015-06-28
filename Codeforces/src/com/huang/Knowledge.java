package com.huang;

/**
 * synchronized 关键字，它包括两种用法：synchronized 方法(可以是静态的，但是也是遵循synchronized原则)和
 * synchronized 块(synchronized(调用类实例))。
 * 一、当两个并发线程访问(同一个对象)object中的这个synchronized(this)同步代码块时，一个时间内只能有一个线程得到执行。
 * 另一个线程必须等待当前线程执行完这个代码块以后才能执行该代码块。 注意：不同对象不同锁，同一个对象只有一把锁
 * 二、然而，当一个线程访问object的一个synchronized(this)同步代码块时，
 * 另一个线程仍然可以访问该object中的非synchronized(this)同步代码块。
 * 
 * 三、尤其关键的是，当一个线程访问object的一个synchronized(this)同步代码块时，
 * 其他线程对object中所有其它synchronized(this)同步代码块的访问将被阻塞。
 * 
 * 四、第三个例子同样适用其它同步代码块。也就是说，当一个线程访问object的一个synchronized(this)同步代码块时，
 * 它就获得了这个object的对象锁。结果，其它线程对该object对象所有同步代码部分的访问都被暂时阻塞。
 * 
 * 五、以上规则对其它对象锁同样适用.
 * 
 * @author Admin
 * 
 */
public class Knowledge {
	public synchronized static void test(){
		for(int t=0; t<5; ++t){
			System.out.println(t);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void way1(){
		synchronized(this){
			for(int t=0; t<5; ++t){
				System.out.println(Thread.currentThread().getName()+" :"+t);
				try {
					//Thread.sleep(500);
					wait(1000); //一直睡眠下去，释放对象锁
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public void way2(){
		for (int t = 0; t < 5; ++t) {
			System.out.println(Thread.currentThread().getName() + " :" + t);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void way3(){
		synchronized(this){
			for(int t=0; t<5; ++t){
				System.out.println(Thread.currentThread().getName()+" :"+t);
				try {
					Thread.sleep(500);
					//wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Knowledge.test();
		Knowledge.test();
		*/final Knowledge k = new Knowledge();
		final Knowledge k1 = new Knowledge();
		Thread A = new Thread(new Runnable(){
			public void run(){
				k.way1();
			}
		}, "A"); 
		Thread B = new Thread(new Runnable(){
			public void run(){
				//k1.way1();
				k.way3();
			}
			}, "B");
		
		A.start();
		B.start();
		
	}
	
}
