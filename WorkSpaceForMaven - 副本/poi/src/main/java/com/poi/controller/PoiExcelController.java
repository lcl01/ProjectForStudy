package com.poi.controller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.poi.exp.PoiExporter;
import com.poi.imp.PoiImporter;
import com.poi.imp.vo.PoiGenericSheetVo;
import com.poi.imp.vo.PoiSheetVo;
import com.poi.service.impl.ITequipmentInfoService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.poi.config.ExcelPoi;
import com.poi.controller.TEquipmentSpotCheck;
import com.poi.entity.JsonResult;
import com.poi.entity.swai_wise.TEquipmentInfo;

/**
 * Excel操作模板导出
 * 
 * @author lijunjie
 * 
 * create 2019年11月8日
 */
@Controller
public class PoiExcelController {

	@Autowired
	ExcelPoi excelPoi;
	
	@Autowired
	ITequipmentInfoService equipmentInfoService;

	/**
	 * 导出ModelExcelList
	 * @param request
	 * @param response
	 * @throws FileNotFoundException
	 * update by lijunjie
	 * 2019年11月11日
	 */
	@ResponseBody
	@RequestMapping(value="/ModelExcelExportListByClass",method=RequestMethod.POST)
	public JsonResult<Map<String,Object>> excelModelExportList(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		
		//模板地址
		File file =new File(excelPoi.getFileHost()+request.getParameter("fileUrl").split("/templete")[1]);
		InputStream is = new FileInputStream(file);
		//类
		String clazz=request.getParameter("fExcelExportModel");
		//输出路径
		//String exportUrl=request.getParameter("fileUrl");
		OutputStream des = new FileOutputStream(excelPoi.getExportFileHost());
		
		Map<String,Object> dataMap=new HashMap<String,Object>();
		List list=new ArrayList();
		String s=request.getParameter("dataList");
		//解析状态
		//返回值Map
		switch(clazz) {        
		case "com.iot.wise.common.bean.equipment.TEquipmentSpotCheck":
			list=JSONObject.parseArray(request.getParameter("dataList"), TEquipmentSpotCheck.class);
			break;
		default:
			break;
			
		}
		dataMap.put("list", list);
		dataMap.put("date", new Date());
		PoiExporter.export2Destination(is, dataMap, des);
		JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
		jsonResult.setCode(1);
		jsonResult.setData(null);
		jsonResult.setMessage("导出成功");
		return jsonResult;
		
	}
	
	/**
	 * 导出ModelExcel根据Map
	 * @param request
	 * @param response
	 * @throws FileNotFoundException
	 * update by lijunjie
	 * 2019年11月11日
	 */
	@ResponseBody
	@RequestMapping(value="/ModelExcelExportByMap",method=RequestMethod.POST)
	public JsonResult<Map<String,Object>> excelModelExportByMap(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		Map<String,String[]> paramMap=request.getParameterMap();
		//模板地址
		String extension=request.getParameter("fileUrl").substring(request.getParameter("fileUrl").lastIndexOf(".")+1);
		//是否Excel
		if(!Lists.newArrayList("xls","xlsx","XLS","XLSX").contains(extension)) {
			JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
			jsonResult.setCode(0);
			jsonResult.setData(null);
			jsonResult.setMessage("DataModelExport.xlsx");
			return jsonResult;
		};
		File file =new File(excelPoi.getFileHost()+request.getParameter("fileUrl").split("/templete")[1]);
		InputStream is = new FileInputStream(file);
		//输出路径
		OutputStream des = new FileOutputStream(excelPoi.getExportFileHost());
		Map<String,Object> dataMap=new HashMap<String,Object>();
		//接收平台传递过来的List<Map>形式的数据
		List list =JSON.parseObject(request.getParameter("dataList"),new TypeReference<List<Map<String, Object>>>() {});
		dataMap.put("list", list);
		dataMap.put("date", new Date());
		try {
			System.out.println("开始导出。。。。"+new Date());
			PoiExporter.export2Destination(is, dataMap, des);
		}catch(Exception e) {
			System.out.println(new Date());
			JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
			jsonResult.setCode(0);
			jsonResult.setData(null);
			jsonResult.setMessage("DataModelExport.xlsx");
			return jsonResult;
		}
		System.out.println("导出结束。。。。"+new Date());
		JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
		jsonResult.setCode(1);
		jsonResult.setData(null);
		jsonResult.setMessage("DataModelExport.xlsx");
		return jsonResult;

	}
	
	/**
	 * 导入ModelExcel
	 * @param request
	 * @param response
	 * @throws FileNotFoundException
	 * update by lijunjie
	 * 2019年11月11日
	 */
	@ResponseBody
	@RequestMapping(value="/ModelExcelImport",method=RequestMethod.POST)
	public JsonResult<Map<String,Object>> excelModelImport(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		//获取输入流
		File file =new File(excelPoi.getFileXLSHost()+request.getParameter("fileUrl").split("/xls")[1]);
		InputStream is = new FileInputStream(file);
		//实体模板类
		String clazz=request.getParameter("fExcelImportModel");
		//反射读取类对应关系
		//存在本地的文件，相对路径
		//InputStream is = PoiExcelController.class.getClassLoader().getResourceAsStream("excel/spotCheckImport.xlsx");
		//解析状态
		int status=0;
		//返回值Map
		Map<String,Object> map=new HashMap<String,Object>();
		switch(clazz) {        
		case "com.iot.wise.common.bean.equipment.TEquipmentInfo":
			PoiGenericSheetVo<TEquipmentInfo> genericSheetVo=equipmentInfoService.transExcel2Model(is);
			if(genericSheetVo.getCode()==1) {
				map.put("data", genericSheetVo.getBody());
				status=1;
			}
			break;
		default:
			break;
			
		}
		//PoiGenericSheetVo<TEquipmentSpotCheck> genericSheetVo = PoiImporter.importFirstSheetFrom(is, TEquipmentSpotCheck.class);
		//System.out.println("===>" + JSON.toJSONString(genericSheetVo.getHead()));
		//System.out.println("===>" + JSON.toJSONString(genericSheetVo.getBody()));
		if(status==0) {
			JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
			jsonResult.setCode(0);
			jsonResult.setData(null);
			jsonResult.setMessage("解析失败");
			return jsonResult;
		}else {
			JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
			jsonResult.setCode(1);
			jsonResult.setData(map);
			jsonResult.setMessage("解析成功");
			return jsonResult;
		}
	}
	
	/**
	 * 导入ModelExcelByMap
	 * @param request
	 * @param response
	 * @throws FileNotFoundException
	 * update by lijunjie
	 * 2019年11月11日
	 */
	@ResponseBody
	@RequestMapping(value="/ModelExcelImportByMap",method=RequestMethod.POST)
	public JsonResult<Map<String,Object>> excelModelImportByMap(HttpServletRequest request,HttpServletResponse response) throws FileNotFoundException {
		//获取输入流
		File file =new File(excelPoi.getFileXLSHost()+request.getParameter("fileUrl").split("/xls")[1]);
		InputStream is = new FileInputStream(file);
		//解析状态
		int status=0;
		//解析excel
		PoiSheetVo sheetVo=new PoiSheetVo();
		try
		{
			sheetVo=PoiImporter.importFirstSheetFrom(is);
			status=1;
		}catch(Exception e) {
			
		}
		//改造sheetVo 为 key:value 即List<Map<String,Object>>
		List resultList=new ArrayList<>();
		List<List<Object>> resultSheet=sheetVo.getContent();
		List keyList=resultSheet.remove(0);//key
		List<List<Object>> valueList=resultSheet;//value
		for(int i=0;i<valueList.size();i++) {
			Map<String,Object> dataMap=new HashMap<>();
			List tmpList=valueList.get(i);
			for(int j=0;j<keyList.size()-1;j++) {
				dataMap.put(keyList.get(j).toString(), tmpList.get(j));
			}
			resultList.add(dataMap);
		}
		
		//返回值Map
		Map<String,Object> resultMap=new HashMap<>();
		resultMap.put("data",resultList);
		if(status==0) {
			JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
			jsonResult.setCode(0);
			jsonResult.setData(null);
			jsonResult.setMessage("解析失败");
			return jsonResult;
		}else {
			JsonResult<Map<String,Object>> jsonResult = new JsonResult<>();
			jsonResult.setCode(1);
			jsonResult.setData(resultMap);
			jsonResult.setMessage("解析成功");
			return jsonResult;
		}
	}
}
