package com.huang;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

class Person{
	int id;
	String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() {
		return id+" "+name;
	}
	
}
class PersonCompare implements Comparator<Person>{
	@Override
	public int compare(Person o1, Person o2) {
		if(o1.id<o2.id){
			return -1;
		}else if(o1.id>o2.id){
			return 1;
		}else return 0;
	}
}
public class StringStudy{
	public static void main(String[] args) {
		Person []a = new Person[4];
		a[0] = new Person(3, "c");
		a[1] = new Person(2, "b");
		a[2] = new Person(4, "d");
		a[3] = new Person(1, "a");		
		Arrays.sort(a, new PersonCompare());
		for(Person a1:a){
			System.out.println(a1);
		}
		List
		
	}

}
