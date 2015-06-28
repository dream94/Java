package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * Java �������
 * @author Admin
 *
 */
public class Test6 {
	public static void main(String[] args) {
		Person p1 = new Person("ds", 1);
		Person p2 = new Person("as", 2);
		//��ȡClass����� ����1
		Class a = p1.getClass();
		Class b = p2.getClass();
		System.out.println(a==b);
		//����2
		Class c = Person.class;
		System.out.println(a==c);
	
		//����3
		try {
			Class d = Class.forName("com.huang.Person");
			System.out.println(a==d);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//ͨ��Class�������ʵ���������
		//��̬��ȡ,�����޲εĹ��췽��
		Person a1 = null;
		try {
			a1 = (Person)a.newInstance();
			System.out.println(a1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//��̬��ȡ�������вεĹ��췽��
		try {
			System.out.println("��̬��ȡ");
			Constructor con = c.getConstructor(String.class, int.class);      //��������
			Person d = (Person)con.newInstance("huang", 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("����:"+c.getPackage().getName());        //�������
		
		Method methods[] = c.getMethods();       //������еĺͼ̳��ڸ���ķ���
		// c.getDeclaredMethods(); // ���� Method �����һ�����飬��Щ����ӳ�� Class
		// �����ʾ�����ӿ����������з���������������������Ĭ�ϣ��������ʺ�˽�з��������������̳еķ�����
		for (Method m : methods) {
			System.out.print(Modifier.toString(m.getModifiers()) + " "
					+ m.getName()+"(");
			Class<?> parms[] = m.getParameterTypes();        //����÷������в���
			for(Class<?> parm: parms){
				System.out.print(parm.getName()+",");
			}
			System.out.println(")");
		}
		
		//���÷���
		try {
			
			//Method m1 =c.getMethod("say", String.class);
			Method m1 = c.getDeclaredMethod("say", String.class);
			m1.setAccessible(true);         //���ú������η����������з���
			m1.invoke(a1, "dream123");       
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//�޸�����
		try{
			Field field = c.getField("name");
			field.set(a1, "field");
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
