package com.coder520.POI.common.poiUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.coder520.POI.user.entity.User;
public class Data2Excel {
	HSSFWorkbook wb=null;
	HSSFSheet sheet=null;
	@SuppressWarnings("deprecation")
	public Data2Excel(List<User> user,String filePath,String title,String...titles) {
		wb=new HSSFWorkbook();
		sheet=wb.createSheet(("sheet1"));
		/*
		 *第一行合并单元格 
		 */
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, titles.length-1));
		HSSFRow row0=sheet.createRow((short)0);
		row0.createCell(0).setCellValue(title);
		HSSFRow row1=sheet.createRow((short)1);
		for(int x=0;x<titles.length;x++){
			row1.createCell(x).setCellValue(titles[x]);
		}
		/**
		 * 根据数据表的具体情况设置内容
		 * 从零开始
		 */
		int index=2;
		for(User users:user){
			HSSFRow row2=sheet.createRow(index);
			for(int x=0;x<titles.length;x++){
					row2.createCell(0).setCellValue(users.getId());
					row2.createCell(1).setCellValue(users.getUsername());
					HSSFCellStyle cellStyle=wb.createCellStyle();//建立新的cell样式
					//设置cell的样式为定制的日期格格式
					cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
					HSSFCell cellbir=row2.createCell(2);
					cellbir.setCellValue(users.getBirthday());//设置cell的类型为日期格式
					cellbir.setCellStyle(cellStyle);//设置该cell日期的风格为事先设置好的日期风格
					row2.createCell(3).setCellValue(users.getSex());
					row2.createCell(4).setCellValue(users.getAddress());
				}
			index++;
		}
		writeExcel(filePath);
	}
	private void writeExcel(String filePath) {
		// TODO Auto-generated method stub
		FileOutputStream out=null;
		try {
			out=new FileOutputStream(filePath);
			wb.write(out);
			out.flush();
			System.out.println("文件已生成");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("生成文件出错");
		}finally {
			try {
				out.close();
				System.out.println("io流已经关闭");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("io流关闭出错");
			}
		}
	}
}
