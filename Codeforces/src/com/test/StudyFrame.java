package com.test;


public final class StudyFrame implements Runnable{
	class dreamException extends RuntimeException{
		
	}
	public static class dimen{
		public static final int k=0;
	}
	
	public void test(int t){
		//throw new ArithmeticException();          //ֱ���׳����������ô����̳���RuntimeException
	//	throw new Exception("da");                  //ֱ���׳�Exception�౨��һ��Ҫ�����������û��ͨ����
		try{
			throw new dreamException();                 //ֱ���׳����������ô���
		}catch(Exception e){
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized(this){
			try {
				System.out.println("start");
				this.wait();          //wait���ͷŶ�������ͬʱ�߳�˯��,����notify���Ѵ��̣߳��Ż����ִ��
				//wait��д���������ã�д��˯�߶��
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
