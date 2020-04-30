package com.poi.imp.processor;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import com.poi.imp.anno.ExcelDateColum;

/**
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public class DateFieldResolver extends AbstractResolver<ExcelDateColum> {
	private ExcelDateColum excelDateColum;

	public DateFieldResolver(Field field, ExcelDateColum edc) {
		super();
		this.field = field;
		this.excelDateColum = edc;
	}

	@Override
	public Object process() {
		String columnName = excelDateColum.value();
		int indexOfColumn = head.indexOf(columnName);
		Object columnRawValue = row.get(indexOfColumn);
		//DateTimeFormatter format = DateTimeFormat.forPattern(excelDateColum.pattern());
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		// 时间解析
		try {
			return sf.parse(sf.format(columnRawValue));
		} catch (ParseException e) {
			return null;
		}
	}

	
}
