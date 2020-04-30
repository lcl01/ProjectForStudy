package com.coder520.POI.TeacherPatent.Utils;

import com.coder520.POI.TeacherPatent.entity.TeacherPatent;
import com.coder520.POI.TeacherPatent.entity.TeacherPatent;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang on 2017/10/17.
 */
public class Patent2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Patent2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherPatent> CreateTeacherLiterature() throws ParseException {
        List<TeacherPatent> patentList =new ArrayList<TeacherPatent>();
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
            TeacherPatent teacherPatent = new TeacherPatent();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            teacherPatent.setLastmodifiedmanid(cell.getStringCellValue());
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            teacherPatent.setPatentname(cell3.getStringCellValue());
            HSSFCell cell4=row.getCell(4);
            teacherPatent.setFirstinventor(cell4.getStringCellValue());
            HSSFCell cell5=row.getCell(5);
            HSSFCell cell6=row.getCell(6);
            teacherPatent.setOtherinventor(cell6.getStringCellValue());
            HSSFCell cell7=row.getCell(7);
            teacherPatent.setPatentcategory(cell7.getStringCellValue());
            if (teacherPatent.getPatentcategory().equals("实用新型专利")){
                teacherPatent.setPatentcategory("实用新型");
            }
            HSSFCell cell8=row.getCell(8);
            teacherPatent.setPatentno(cell8.getStringCellValue());
            HSSFCell cell9=row.getCell(9);
            HSSFCell cell10=row.getCell(10);
            if (cell9.getStringCellValue().equals("已授权")){
                teacherPatent.setIsgranted("1");
                teacherPatent.setIsapplied("1");
                teacherPatent.setGranteddate(cell10.getStringCellValue());
                teacherPatent.setApplieddate(cell10.getStringCellValue());
            }else {
                teacherPatent.setIsgranted("0");
                teacherPatent.setIsapplied("1");
                teacherPatent.setApplieddate(cell10.getStringCellValue());
            }
            patentList.add(teacherPatent);
        }
        return patentList ;
    }

    public static void main(String[] args) throws ParseException {
        List<TeacherPatent> patentList = new Patent2Date("E:\\09_专利.xls").CreateTeacherLiterature();
        //for (TeacherPatent : patentList){
        //    System.out.println(literature.toString());
        //}
        System.out.println(patentList.get(0));

    }
}
