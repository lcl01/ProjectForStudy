package com.poi.entity;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 返回
 * 
 * @author lijunjie
 * 
 * create 2019年11月11日
 */
@JsonInclude(Include.NON_NULL)	//如果字段为null，则不在json中返回
public class JsonResult<T> {
	private int code=1;	//返回的错误码，为0则没有错误
	private T data;		//返回的内容，泛型
	private String message="成功";		//返回的错误信息
	
	//返回错误码
	public static final int SERVER_ERR = 0;
	public static final String SERVER_ERR_MSG = "服务器繁忙，请稍后再试...";

 

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

 
}
