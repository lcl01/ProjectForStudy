package com.poi.imp.processor;

import java.lang.reflect.Field;

/**
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
@SuppressWarnings("rawtypes")
public class EmptyResolver extends AbstractResolver {
	
	private EmptyResolver() {
		super();
	}

	public static class SINGLE {
		public static final EmptyResolver INSTANCE = new EmptyResolver();
	}

	/**
	 * 永远为true
	 */
	@Override
	public boolean support(Field field) {
		return true;
	}

	@Override
	public Object process() {
		return null;
	}

}
