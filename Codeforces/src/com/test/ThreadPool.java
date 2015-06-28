package com.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * java提供的线程API学习
 * @author Admin
 */
public class ThreadPool {
	/**
	 * 1.newSingleThreadExecutor
	 * 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
	 * @param args
	 */
	/**
	 * 2.newFixedThreadPool
	 * 创建固定大小的线程池。每次提交一个任务就创建一个线程，直到线程达到线程池的最大大小。
	 * 线程池的大小一旦达到最大值就会保持不变，如果某个线程因为执行异常而结束，那么线程池会补充一个新线程。
	 * @param args
	 */
	/**
	 * 3.newCachedThreadPool
	 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
	 * @param args
	 */
	/**
	 * 4.newScheduledThreadPool
	 * 创建一个大小无限的线程池。此线程池支持定时以及周期性执行任务的需求。
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* 1.newSingleThreadExecutor
		ExecutorService single = Executors.newSingleThreadExecutor();
		for(int t=0; t<10; ++t){
			final int k = t;
			single.execute(new Runnable(){
				public void run(){
					System.out.println(k);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		}*/
		//2.newFixedThreadPool
		/*ExecutorService fix = Executors.newFixedThreadPool(3);      //线程池大小,3个线程并发执行
		for(int t=0; t<10; ++t){
			final int k = t;
			fix.execute(new Runnable(){
				public void run(){
					System.out.println(k);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			*/
		/**
		 * 3.newCachedThreadPool
		 */
	/*	ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
		    final int index = i;
		    try {
		        Thread.sleep(index * 1000);
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		 
		    cachedThreadPool.execute(new Runnable() {
		 
		        @Override
		        public void run() {
		            System.out.println(index);
		        }
		    });
		}
	  }	*/
	/**
	 * 线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程。
	 */
	
	/**
	 * 4.newScheduledThreadPool
	 */
	ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
	scheduledThreadPool.schedule(new Runnable() {
	 
	    @Override
	    public void run() {
	        System.out.println("delay 3 seconds");
	    }
	}, 3, TimeUnit.SECONDS);     //表示延迟3秒执行。
	
	scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
		 
	    @Override
	    public void run() {
	        System.out.println("delay 1 seconds, and excute every 3 seconds");
	    }
	}, 1, 3, TimeUnit.SECONDS);   //表示延迟1秒后每3秒执行一次。
  }
}
