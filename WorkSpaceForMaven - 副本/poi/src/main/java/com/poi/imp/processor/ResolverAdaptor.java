package com.poi.imp.processor;

import java.lang.reflect.Field;

import com.poi.imp.anno.ExcelColum;
import com.poi.imp.anno.ExcelDateColum;

/**
 * 解析器适配器
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public class ResolverAdaptor {
	
	public static AbstractResolver<?> adapt(Field field) {
		ExcelColum ec = field.getAnnotation(ExcelColum.class);
		if (ec != null) {
			return new DefaultFieldResolver(field, ec);
		}

		ExcelDateColum edc = field.getAnnotation(ExcelDateColum.class);
		if (edc != null) {
			return new DateFieldResolver(field, edc);
		}

		return EmptyResolver.SINGLE.INSTANCE;
	}

}
