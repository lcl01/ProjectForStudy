package com.coder520.POI.TeacherProject.Utils;

import com.coder520.POI.TeacherProject.entity.TeacherProject;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
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
public class Project2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Project2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherProject> CreateTeacherBaseInfo() throws ParseException {
        List<TeacherProject> projectList =new ArrayList<TeacherProject>();
        try {
            wb = new HSSFWorkbook(new FileInputStream(filePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("解析Excel文件出错");
            e.printStackTrace();
        }
        HSSFSheet sheet=wb.getSheet("Sheet1");
        int rowLength=sheet.getLastRowNum();
        for (int i = 1; i <=rowLength; i++) {
            TeacherProject teacherProject = new TeacherProject();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            teacherProject.setLastmodifedmanid(cell.getStringCellValue());
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            teacherProject.setProjectname(cell3.getStringCellValue());
            HSSFCell cell4=row.getCell(4);
            if (cell4.getStringCellValue().equals("国家级")){
                teacherProject.setProjectcategory("5577");
            }else if (cell4.getStringCellValue().equals("省级")){
                teacherProject.setProjectcategory("5578");
            }else if(cell4.getStringCellValue().equals("市级")) {
                teacherProject.setProjectcategory("5579");
            }

            HSSFCell cell5=row.getCell(5);
            HSSFCell cell6=row.getCell(6);
            HSSFCell cell7=row.getCell(7);
            teacherProject.setProjectissueddept(cell7.getStringCellValue());
            HSSFCell cell8=row.getCell(8);
            teacherProject.setProjectmajor(cell8.getStringCellValue());
            HSSFCell cell9=row.getCell(9);
            HSSFCell cell10=row.getCell(10);
            teacherProject.setCooperation(cell10.getStringCellValue());
            HSSFCell cell11=row.getCell(11);
            //立项金额
            cell11.setCellType(Cell.CELL_TYPE_STRING);
            String s = cell11.getStringCellValue();
            Double d = Double.valueOf(s);
            if (d>10000){
                String ss = String.valueOf((d/1000));
                BigDecimal projecttype2 = new BigDecimal(ss);
                teacherProject.setProjecttype2(projecttype2);
            }else {
                BigDecimal projecttype21 = new BigDecimal(s);
                teacherProject.setProjecttype2(projecttype21);
            }

            HSSFCell cell12=row.getCell(12);
            //实际到账金额
            cell11.setCellType(Cell.CELL_TYPE_STRING);
            String s1 = cell12.getStringCellValue();
            Double d1 = Double.valueOf(s1);
            if (d1>10000){
                String ss1 = String.valueOf((d1/1000));
                BigDecimal receivedfee = new BigDecimal(ss1);
                teacherProject.setReceivedfee(receivedfee);
            }else {
                BigDecimal receivedfee1 = new BigDecimal(s1);
                teacherProject.setReceivedfee(receivedfee1);
            }
            HSSFCell cell13=row.getCell(13);
            teacherProject.setBegintime(cell13.getStringCellValue());
            HSSFCell cell14=row.getCell(14);
            teacherProject.setEndtime(cell14.getStringCellValue());
            HSSFCell cell15=row.getCell(15);
            if (cell15 != null){
                teacherProject.setProjectothers(cell15.getStringCellValue());
            }

            projectList.add(teacherProject);
        }
        return projectList ;
    }
    public Map<String,String> getTeacherName(){
        try {
            wb = new HSSFWorkbook(new FileInputStream(filePath));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("解析Excel文件出错");
            e.printStackTrace();
        }
        HSSFSheet sheet=wb.getSheet("Sheet1");
        int rowLength=sheet.getLastRowNum();
        Map<String, String> idAndName = new HashMap<String, String>();
        for (int i = 1; i <=rowLength; i++) {
            HSSFRow row = sheet.getRow(i);
            String id = row.getCell(0).getStringCellValue();
            String name = row.getCell(19).getStringCellValue();
            idAndName.put(id, name);
        }
        return idAndName;
    }

    public static void main(String[] args) throws ParseException {
        List<TeacherProject> projectList = new Project2Date("E:\\06_承载项目new.xls").CreateTeacherBaseInfo();
        //Map<String,String> idAndName = new Project2Date("E:\\01_基本信息.xls").getTeacherName();
        //for (Map.Entry<String, String> entry : idAndName.entrySet()) {
        //
        //	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        //
        //}
        //System.out.println(projectList.get(9279));
        //for (TeacherProject teacherProject: projectList){
        //    System.out.println(teacherProject.toString());
        //}
        System.out.println(projectList.get(0));
    }
}
