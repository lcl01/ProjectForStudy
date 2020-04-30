package com.poi.imp.anno;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
@Target({ FIELD })
@Retention(RUNTIME)
public @interface ExcelColum {
	String value(); // 导入excel的列名
}
