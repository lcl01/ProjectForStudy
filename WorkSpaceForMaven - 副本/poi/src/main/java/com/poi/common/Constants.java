package com.poi.common;

/**
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public class Constants {
	public static final String POI_FOREACH_START_REGEXP = "<poi:foreach\\s+list=\"(\\w+)\">";
	public static final String POI_FOREACH_END_REGEXP = "</poi:foreach>";
	
	public static final String POI_PROPERTY_START_REGEXP = "<poi:property\\s+item=\"(\\w+)\">";
	public static final String POI_PROPERTY_END_REGEXP = "</poi:property>";
	
	// 处理类似${key}的串
	public static final String POI_KEY_REGEXP = "\\$\\{(\\w+)\\}";
//	public static final String POI_KEY_REGEXP = "\\$\\{([^.]+?)\\}";
	// 处理类似${vo.key}的串
	public static final String POI_VO_DOT_KEY_REGEXP = "\\$(\\{)(\\w+\\.)(.+?\\})";
}
