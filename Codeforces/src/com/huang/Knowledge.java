package com.huang;

/**
 * synchronized �ؼ��֣������������÷���synchronized ����(�����Ǿ�̬�ģ�����Ҳ����ѭsynchronizedԭ��)��
 * synchronized ��(synchronized(������ʵ��))��
 * һ�������������̷߳���(ͬһ������)object�е����synchronized(this)ͬ�������ʱ��һ��ʱ����ֻ����һ���̵߳õ�ִ�С�
 * ��һ���̱߳���ȴ���ǰ�߳�ִ�������������Ժ����ִ�иô���顣 ע�⣺��ͬ����ͬ����ͬһ������ֻ��һ����
 * ����Ȼ������һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
 * ��һ���߳���Ȼ���Է��ʸ�object�еķ�synchronized(this)ͬ������顣
 * 
 * ��������ؼ����ǣ���һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
 * �����̶߳�object����������synchronized(this)ͬ�������ķ��ʽ���������
 * 
 * �ġ�����������ͬ����������ͬ������顣Ҳ����˵����һ���̷߳���object��һ��synchronized(this)ͬ�������ʱ��
 * ���ͻ�������object�Ķ�����������������̶߳Ը�object��������ͬ�����벿�ֵķ��ʶ�����ʱ������
 * 
 * �塢���Ϲ��������������ͬ������.
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
					wait(1000); //һֱ˯����ȥ���ͷŶ�����
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
