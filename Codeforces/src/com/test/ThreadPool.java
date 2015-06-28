package com.test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * java�ṩ���߳�APIѧϰ
 * @author Admin
 */
public class ThreadPool {
	/**
	 * 1.newSingleThreadExecutor
	 * ����һ�����̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ�����񣬱�֤����������ָ��˳��(FIFO, LIFO, ���ȼ�)ִ�С�
	 * @param args
	 */
	/**
	 * 2.newFixedThreadPool
	 * �����̶���С���̳߳ء�ÿ���ύһ������ʹ���һ���̣߳�ֱ���̴߳ﵽ�̳߳ص�����С��
	 * �̳߳صĴ�Сһ���ﵽ���ֵ�ͻᱣ�ֲ��䣬���ĳ���߳���Ϊִ���쳣����������ô�̳߳ػᲹ��һ�����̡߳�
	 * @param args
	 */
	/**
	 * 3.newCachedThreadPool
	 * ����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ����̣߳����޿ɻ��գ����½��̡߳�
	 * @param args
	 */
	/**
	 * 4.newScheduledThreadPool
	 * ����һ����С���޵��̳߳ء����̳߳�֧�ֶ�ʱ�Լ�������ִ�����������
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
		/*ExecutorService fix = Executors.newFixedThreadPool(3);      //�̳߳ش�С,3���̲߳���ִ��
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
	 * �̳߳�Ϊ���޴󣬵�ִ�еڶ�������ʱ��һ�������Ѿ���ɣ��Ḵ��ִ�е�һ��������̣߳�������ÿ���½��̡߳�
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
	}, 3, TimeUnit.SECONDS);     //��ʾ�ӳ�3��ִ�С�
	
	scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
		 
	    @Override
	    public void run() {
	        System.out.println("delay 1 seconds, and excute every 3 seconds");
	    }
	}, 1, 3, TimeUnit.SECONDS);   //��ʾ�ӳ�1���ÿ3��ִ��һ�Ρ�
  }
}
