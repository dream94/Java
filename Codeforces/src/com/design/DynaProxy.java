package com.design;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * ��̬������
 * @author Admin
 *InvocationHandler �Ǵ���ʵ���ĵ��ô������ ʵ�ֵĽӿ�
 */
public class DynaProxy implements InvocationHandler {
	private Object object;      //���������
	public DynaProxy(Object o) {
		object = o;
	}
	// �ڴ���ʵ���ϴ��������ò����ؽ����
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object o = method.invoke(object, args);  //ʵ�ֵ��Ǳ�������ʵ�ֽӿڵķ��� 
		return o;
	}
	private void before(){
		System.out.println("MPerson������׼��");
	}

}
