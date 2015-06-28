package com.design;

import java.lang.reflect.Proxy;

public class TextDynaProxy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person("asd");
		DynaProxy d = new DynaProxy(p);
		xiangqin p1=(xiangqin)Proxy.newProxyInstance(p.getClass().getClassLoader(), p.getClass().getInterfaces(), d);
		p1.see();           //注意这里要用接口
	}

}
