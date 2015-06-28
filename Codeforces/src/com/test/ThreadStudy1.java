package com.test;

/**
 * �����������Ϊ,һ���߳��������interrupt()����,������Ӧ���߳̾�Ӧ�ñ��ж϶��׳��쳣,
 * ��ʵ��,��һ���̶߳������interrupt()����,����Ӧ���̲߳�û�б��ж�,ֻ�Ǹı��������ж�״̬.
 * ʹ��ǰ�̵߳�״̬�����ж�״̬,���û������Ӱ��,�̻߳����Լ�����ִ��.
 * ֻ�е��߳�ִ�е�sleep,wait,join�ȷ���ʱ,�����Լ�����ж�״̬���׳��쳣�������,�߳� �Ż��׳��쳣.
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
				a.interrupt();  //�����������
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
