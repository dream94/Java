package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Test5 implements Serializable{           //ʵ�ִ��л�
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
		Test5 t = new Test5("dream", "123");     //�ɹ����name��password
		System.out.println(t);
		try {
			ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("output.out"));
			o.writeObject(t); // д���ļ������ڳ־û����棬��ʱֻ�����Serializable�����б�������ݣ���������transient��ֵ
			o.close();
			ObjectInputStream r = new ObjectInputStream(new FileInputStream("output.out"));
			System.out.println(r.readObject());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
