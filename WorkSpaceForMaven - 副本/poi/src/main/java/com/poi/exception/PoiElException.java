package com.poi.exception;
/**
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public class PoiElException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    /**
     * 异常错误码
     */
    protected int code;

	public PoiElException(int code, String message) {
		super(message);
		this.code = code;
	}
	
	public PoiElException(int code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}
}
