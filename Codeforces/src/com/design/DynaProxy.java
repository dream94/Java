package com.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 动态代理类
 * @author Admin
 *InvocationHandler 是代理实例的调用处理程序 实现的接口
 */
public class DynaProxy implements InvocationHandler {
	private Object object;      //被代理对象
	public DynaProxy(Object o) {
		object = o;
	}
	// 在代理实例上处理方法调用并返回结果。
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object o = method.invoke(object, args);  //实现的是被代理类实现接口的方法 
		return o;
	}
	private void before(){
		System.out.println("MPerson正在做准备");
	}

}
