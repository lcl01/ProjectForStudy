package com.poi.exp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.poi.exception.PoiElErrorCode;
import com.poi.exp.context.PoiExporterContext;
import com.poi.exp.function.FunctionRegister;
import com.poi.exp.processor.RowProcessorStrategy;
import com.poi.log.Log;

/**
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
public class PoiExporter {
	private static final Logger logger = LoggerFactory.getLogger(PoiExporter.class);
	

	static {
		FunctionRegister.registerInternalFunction();
	}
	
	public static void export(XSSFWorkbook wb, Map<String, Object> rootObjectMap) {
		Long start = System.currentTimeMillis();
		
		PoiExporterContext peContext = new PoiExporterContext(new SpelExpressionParser(), rootObjectMap);
		
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			XSSFSheet sheet = wb.getSheetAt(i);
			int j = sheet.getFirstRowNum();
			while (j <= sheet.getLastRowNum()) {
				XSSFRow row = sheet.getRow(j);
				if (row == null) {
					continue;
				}
				int dealRows = RowProcessorStrategy.getRowProcessor(row).dealRow(row, peContext);
				j = j + dealRows;
			}
		}
		
		long end = System.currentTimeMillis();
		
		logger.info(Log.op("PoiEl#parse").msg("PoiEl时间[{0}]ms", (end - start)).toString());
	}
	
	/**
	 * 
	 * @param templateFile
	 * @param rootObjectMap
	 * @param des
	 * @return
	 * update by lijunjie
	 * 2019年11月11日
	 */
	public static XSSFWorkbook export2Destination(File templateFile, Map<String, Object> rootObjectMap, OutputStream des){
		InputStream in = null;
		try {
			in = new FileInputStream(templateFile);
		} catch (FileNotFoundException e) {
			throw PoiElErrorCode.TEMPLATE_FILE_NOT_FOUND.exp(e, templateFile.getName());
		}
		return export2Destination(in, rootObjectMap, des);
	}
	
	/**
	 * 
	 * @param templateInputStream
	 * @param rootObjectMap
	 * @param des
	 * @return
	 * update by lijunjie
	 * 2019年11月11日
	 */
	public static XSSFWorkbook export2Destination(InputStream templateInputStream, Map<String, Object> rootObjectMap, OutputStream des){
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(templateInputStream);
		} catch (IOException e) {
			throw PoiElErrorCode.SYSTEM_ERROR.exp(e);
		}
		PoiExporter.export(wb, rootObjectMap);
		
		try {
			wb.write(des);
			des.flush();
			des.close();
		} catch (IOException e) {
			throw PoiElErrorCode.SYSTEM_ERROR.exp(e);
		}
		
		return wb;
	}
}
