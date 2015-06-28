package com.design;

public class Design {

	interface xiangqin{
		public void see();
	}
	//代理类
	class MPerson implements xiangqin{
		private Person person;	         //控制被代理类对象	
		public MPerson(Person p) {
			person = p;
		}
		@Override
		public void see() {
			before();
			person.see();
		}
		private void before(){
			System.out.println("MPerson正在做准备");
		}
	}
	
	
	//被代理类
	class Person implements xiangqin{
		private String name;
		public Person(String name) {
			this.name = name;
		}
		public void see(){
			System.out.println(name+"正在相亲");
		}
	}
	
	
	public static void main(String[] args) {
		Design d = new Design();
		Person p = d.new Person("hhh");         //调用内部类
		d.new MPerson(p).see();;
	}

}
