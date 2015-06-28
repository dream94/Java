package com.Annotation;

import java.lang.reflect.Method;

/**
 * 测试自定义注解类（MyAnnotation)
 * @author dream
 *
 */
@MyAnnotation(k1="zhang")
public class Test {
	@MyAnnotation(k1="zhang123")
	public void test(){
		System.out.println("testing");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class c = Test.class;
		try {
			Test a1 = (Test)c.newInstance();
			Method method = c.getMethod("test", new Class[]{});
			if(Test.class.isAnnotationPresent(MyAnnotation.class)){
				System.out.println("MyAnnotation");				
			}else{
				System.out.println("No MyAnnotation");
			}
			if(method.isAnnotationPresent(MyAnnotation.class)){
				System.out.println("method yes");
				MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
				System.out.println(annotation.k1());
				System.out.println(annotation.k2());
				int a12[] = annotation.arr();
				for(int k:a12){
					System.out.println(k);
				}
			}else{
				System.out.println("method no");
			}
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
