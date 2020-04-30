package com.poi.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Component;

/**
 * Excel导入导出配置
 * 
 * @author lijunjie
 * 
 * create 2019年11月18日
 */
@Component
@PropertySource(value = { "/ExcelPoi.properties" })
@ConfigurationProperties(prefix = "poi")
public class ExcelPoi {

	private String fileHost;//导出地址
	private String localHost;//本机地址
	private String exportFileHost;//导出文件
	private String fileXLSHost;//xls文件上传路径

	public String getFileHost() {
		return fileHost;
	}
	public void setFileHost(String fileHost) {
		this.fileHost = fileHost;
	}
	public String getExportFileHost() {
		return exportFileHost;
	}
	public void setExportFileHost(String exportFileHost) {
		this.exportFileHost = exportFileHost;
	}
	public String getLocalHost() {
		return localHost;
	}
	public void setLocalHost(String localHost) {
		this.localHost = localHost;
	}
	
public String getFileXLSHost() {
		return fileXLSHost;
	}
	public void setFileXLSHost(String fileXLSHost) {
		this.fileXLSHost = fileXLSHost;
	}
@Bean
   public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
      return new PropertySourcesPlaceholderConfigurer();
   }
	
}
