package com.Annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * ����ע����
 * @author dream
 *
 */
@Retention(RetentionPolicy.RUNTIME)          //��������������ʱʶ��
public @interface MyAnnotation {     //�����ע�����¶�������
	String k1();         //��ʵ������
	String k2() default "hello";
	int[] arr() default {1, 2, 3};
}
