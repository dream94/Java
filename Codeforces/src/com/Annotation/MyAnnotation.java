package com.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 定义注解类
 * @author dream
 *
 */
@Retention(RetentionPolicy.RUNTIME)          //这样才能在运行时识别
public @interface MyAnnotation {     //在这个注解类下定义属性
	String k1();         //其实是属性
	String k2() default "hello";
	int[] arr() default {1, 2, 3};
}
