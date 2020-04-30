package com.coder520.POI.common.poiUtils;

import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.user.entity.User;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by yang on 2017/10/16.
 */
public class labInfo2Excle {
    HSSFWorkbook wb=null;
    HSSFSheet sheet=null;
    @SuppressWarnings("deprecation")
    public labInfo2Excle(List<LabInfo> infoList, String filePath, String title, String...titles) {
        wb=new HSSFWorkbook();
        sheet=wb.createSheet(("Sheet1"));
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
        for(LabInfo labInfo: infoList){
            HSSFRow row2=sheet.createRow(index);
            for(int x=0;x<titles.length;x++){
                row2.createCell(0).setCellValue(labInfo.getLabname());
                row2.createCell(1).setCellValue(labInfo.getLabmajor());
                row2.createCell(2).setCellValue(labInfo.getRelieddept());
                row2.createCell(3).setCellValue(labInfo.getManager());
                row2.createCell(4).setCellValue(labInfo.getManagerphone());
                row2.createCell(5).setCellValue(labInfo.getManageremail());
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
