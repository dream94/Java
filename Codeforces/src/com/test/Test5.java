package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Test5 implements Serializable{           //实现串行化
	private String name;
	private transient String pwd;
	public Test5(String name, String pwd) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.pwd = pwd;
	}
	@Override
	public String toString() {
		if(pwd == null){
			return pwd;
		}else{
			return name+" "+pwd;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test5 t = new Test5("dream", "123");     //成功输出name和password
		System.out.println(t);
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("output.out"));
			o.writeObject(t); // 写进文件中属于持久化保存，这时只会包括Serializable机制中保存的数据，但不包括transient的值
			o.close();
			ObjectInputStream r = new ObjectInputStream(new FileInputStream("output.out"));
			System.out.println(r.readObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
