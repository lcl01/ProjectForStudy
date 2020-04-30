package com.poi.entity;

import java.io.Serializable;
import java.util.Map;

/**
 * 接收Excel参数
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public class ExcelExportBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//输出路径
	private String outPutUrl;
	
	//模板路径
	private String templateUrl;
	
	//数据
	private Map<String,Object> dataMap;

	public String getOutPutUrl() {
		return outPutUrl;
	}

	public void setOutPutUrl(String outPutUrl) {
		this.outPutUrl = outPutUrl;
	}

	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}
