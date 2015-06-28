package com.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
/**
 * Java 反射机制
 * @author Admin
 *
 */
public class Test6 {
	public static void main(String[] args) {
		Person p1 = new Person("ds", 1);
		Person p2 = new Person("as", 2);
		//获取Class类对象 方法1
		Class a = p1.getClass();
		Class b = p2.getClass();
		System.out.println(a==b);
		//方法2
		Class c = Person.class;
		System.out.println(a==c);
	
		//方法3
		try {
			Class d = Class.forName("com.huang.Person");
			System.out.println(a==d);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//通过Class类对象来实例化类对象
		//静态获取,调用无参的构造方法
		Person a1 = null;
		try {
			a1 = (Person)a.newInstance();
			System.out.println(a1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		//动态获取，调用有参的构造方法
		try {
			System.out.println("动态获取");
			Constructor con = c.getConstructor(String.class, int.class);      //参数类型
			Person d = (Person)con.newInstance("huang", 12);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("包名:"+c.getPackage().getName());        //输出包名
		
		Method methods[] = c.getMethods();       //输出公有的和继承于父类的方法
		// c.getDeclaredMethods(); // 返回 Method 对象的一个数组，这些对象反映此 Class
		// 对象表示的类或接口声明的所有方法，包括公共、保护、默认（包）访问和私有方法，但不包括继承的方法。
		for (Method m : methods) {
			System.out.print(Modifier.toString(m.getModifiers()) + " "
					+ m.getName()+"(");
			Class<?> parms[] = m.getParameterTypes();        //输出该方法所有参数
			for(Class<?> parm: parms){
				System.out.print(parm.getName()+",");
			}
			System.out.println(")");
		}
		
		//调用方法
		try {
			
			//Method m1 =c.getMethod("say", String.class);
			Method m1 = c.getDeclaredMethod("say", String.class);
			m1.setAccessible(true);         //设置忽略修饰符，访问所有方法
			m1.invoke(a1, "dream123");       
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//修改属性
		try{
			Field field = c.getField("name");
			field.set(a1, "field");
			System.out.println();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
