package com.design;

public class Design {

	interface xiangqin{
		public void see();
	}
	//������
	class MPerson implements xiangqin{
		private Person person;	         //���Ʊ����������	
		public MPerson(Person p) {
			person = p;
		}
		@Override
		public void see() {
			before();
			person.see();
		}
		private void before(){
			System.out.println("MPerson������׼��");
		}
	}
	
	
	//��������
	class Person implements xiangqin{
		private String name;
		public Person(String name) {
			this.name = name;
		}
		public void see(){
			System.out.println(name+"��������");
		}
	}
	
	
	public static void main(String[] args) {
		Design d = new Design();
		Person p = d.new Person("hhh");         //�����ڲ���
		d.new MPerson(p).see();;
	}

}
