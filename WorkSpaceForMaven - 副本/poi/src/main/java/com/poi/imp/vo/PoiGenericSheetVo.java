package com.poi.imp.vo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.poi.common.PoiUtils;
import com.poi.exception.PoiElErrorCode;
import com.poi.imp.anno.ExcelColum;
import com.poi.imp.anno.ExcelDateColum;
import com.poi.imp.processor.DefaultFieldResolver;
import com.poi.imp.processor.ResolverAdaptor;

/**
 * 作为excel解析结果的载体（单sheet）。<br/>
 * 分为两部分，head头信息 和 body内容
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public class PoiGenericSheetVo<T> {
	/**
	 * 头信息（第一行）
	 */
	private List<Object> head;

	/**
	 * 内容
	 */
	private List<T> body;
	
	/**
	 *  解析状态码
	 */
	private int code=1;

	public List<Object> getHead() {
		return head;
	}

	public void setHead(List<Object> head) {
		this.head = head;
	}

	public List<T> getBody() {
		return body;
	}

	public void setBody(List<T> body) {
		this.body = body;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * 转换字段对应
	 * @param rawSheetVo
	 * @param clazz
	 * @return
	 * update by lijunjie
	 * 2019年11月12日
	 */
	public static <T> PoiGenericSheetVo<T> resolve2Generic(PoiSheetVo rawSheetVo, final Class<T> clazz) {
		final PoiGenericSheetVo<T> genericSheetVo = new PoiGenericSheetVo<T>();

		genericSheetVo.setHead(rawSheetVo.getHead());

		// 解析body 将时间格式做转换
		List<List<Object>> rawBody = rawSheetVo.getRawBody();
		List<T> body = Lists.transform(rawBody, new Function<List<Object>, T>() {
			@Override
			public T apply(List <Object> input) {
				return transfer2Generic(input, clazz);
			}

			private T transfer2Generic(List<Object> input, Class<T> clazz) {
				if (CollectionUtils.isEmpty(input)) {
					return null;
				}

				try {
					T vo = clazz.newInstance();
					Field[] fields = clazz.getDeclaredFields();
					for (Field f : fields) {
						Object columnGenericValue = ResolverAdaptor.adapt(f).build(input, genericSheetVo.getHead()).process();
						Method setter = findSetter(clazz, f);
						setter.invoke(vo, columnGenericValue);
					}
					return vo;
				} catch (Exception e) {
					//异常设置为null
					genericSheetVo.setCode(-1);
					throw PoiElErrorCode.SYSTEM_ERROR.exp(e);
				}

			}

			private Method findSetter(Class<T> clazz, Field f) {
				String setterName = "set" + StringUtils.capitalize(f.getName());
				try {
					return clazz.getMethod(setterName, f.getType());
				} catch (NoSuchMethodException | SecurityException e) {
					genericSheetVo.setCode(-1);
					throw PoiElErrorCode.SYSTEM_ERROR.exp(e);
				}
			}
		});

		genericSheetVo.setBody(body);
		return genericSheetVo;


	}
}
