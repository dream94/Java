package com.huang;

public class ThreadKnowledge implements Runnable{
	 private String name;   
	    private Object prev;   
	    private Object self;   
	  
	    public ThreadKnowledge(String name, Object prev, Object self) {   
	        this.name = name;   
	        this.prev = prev;   
	        this.self = self;   
	    }  
	  
	    @Override  
	    public void run() {   
	        int count = 10;   
	        while (count > 0) {   
	            synchronized (prev) {   
	                synchronized (self) {   
	                    System.out.print(name);   
	                    count--;  
	                    
	                    self.notify();    //释放对象锁
	                }   
	                try {   
	                    prev.wait();     //释放对象锁，同时一直睡眠下去
	                } catch (InterruptedException e) {   
	                    e.printStackTrace();   
	                }   
	            }   
	  
	        }   
	    }   
	  
	    public static void main(String[] args) throws Exception {   
	        Object a = new Object();   
	        Object b = new Object();   
	        Object c = new Object();   
	       ThreadKnowledge pa = new ThreadKnowledge("A", c, a);  
	       ThreadKnowledge pb = new ThreadKnowledge("B", a, b);   
	       ThreadKnowledge pc = new ThreadKnowledge("C", b, c);   
	           
	           
	        new Thread(pa).start();
	        new Thread(pb).start();
	        new Thread(pc).start();    }   
}
