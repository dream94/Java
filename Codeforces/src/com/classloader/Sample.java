package com.classloader;

public class Sample {
	public Sample() {
		//������ظ�����������
		System.out.println("����Sample��ļ�������:"+this.getClass().getClassLoader());
		
	}
}
