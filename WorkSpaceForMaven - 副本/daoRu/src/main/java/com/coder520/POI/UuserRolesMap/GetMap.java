package com.coder520.POI.UuserRolesMap;

import com.coder520.POI.LabInfo.entity.LabInfo;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import com.coder520.POI.TeacherProject.entity.TeacherProject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2017/10/17.
 */
public class GetMap {
    private String filePath;
    HSSFWorkbook wb;
    public GetMap(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")

        public List<LabInfo> getLabName(){
        try {
            wb = new HSSFWorkbook(new FileInputStream(filePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("解析Excel文件出错");
            e.printStackTrace();
        }
        HSSFSheet sheet=wb.getSheet("Sheet1");
        int rowLength=sheet.getLastRowNum();
        List<LabInfo> labInfoList = new ArrayList<>();
        for (int i = 1; i <=rowLength; i++) {
            LabInfo labInfo = new LabInfo();
            HSSFRow row = sheet.getRow(i);
            labInfo.setLabaddress(row.getCell(0).getStringCellValue());
            labInfo.setLabname(row.getCell(3).getStringCellValue());
            labInfo.setLabmajor(row.getCell(8).getStringCellValue());
            labInfo.setManager(row.getCell(19).getStringCellValue());
            if (row.getCell(9)==null){
                labInfo.setRelieddept(row.getCell(3).getStringCellValue());
            }else {
                if (row.getCell(9).getStringCellValue().equals("无")){
                    labInfo.setRelieddept(row.getCell(3).getStringCellValue());
                }else {
                    labInfo.setRelieddept(row.getCell(9).getStringCellValue());
                }
            }

            labInfoList.add(labInfo);
        }
        return labInfoList;
    }
    public List<TeacherBaseInfo> getTeacherName(){
        try {
            wb = new HSSFWorkbook(new FileInputStream(filePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("解析Excel文件出错");
            e.printStackTrace();
        }
        HSSFSheet sheet=wb.getSheet("Sheet1");
        int rowLength=sheet.getLastRowNum();
        List<TeacherBaseInfo> teacherList = new ArrayList<>();
        for (int i = 1; i <=rowLength; i++) {
            TeacherBaseInfo teacherBaseInfo = new TeacherBaseInfo();
            HSSFRow row = sheet.getRow(i);
            teacherBaseInfo.setBranchoflab(row.getCell(0).getStringCellValue());
            teacherBaseInfo.setTeachername(row.getCell(3).getStringCellValue());
            teacherList.add(teacherBaseInfo);
        }
        return teacherList;
    }

    public static void main(String[] args) throws ParseException {
        List<LabInfo> labInfoList = new GetMap("E:\\01_基本信息.xls").getLabName();

    }
}
