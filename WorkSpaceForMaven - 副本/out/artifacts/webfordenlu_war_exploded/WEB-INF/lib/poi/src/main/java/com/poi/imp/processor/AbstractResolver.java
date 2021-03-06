package com.poi.imp.processor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import com.poi.common.ReflectionUtil;

/**
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public abstract class AbstractResolver<T extends Annotation> implements Resolver {
	protected Field field;
	/**
	 * 行内容
	 */
	protected List<Object> row;
	/**
	 * 头信息
	 */
	protected List<Object> head;
	
	public Resolver build(List<Object> input, List<Object> head) {
		this.row = input;
		this.head = head;
		return this;
	}
	
	@Deprecated
	public boolean support(Field field) {
		ParameterizedType parameterizedType = (ParameterizedType) this.getClass().getGenericSuperclass();
		Type pa = parameterizedType.getActualTypeArguments()[0];
		Class<T> anno = null;
		try {
			anno = (Class<T>) ReflectionUtil.getClass(pa);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		return field.getAnnotation(anno) != null;
	}

}
