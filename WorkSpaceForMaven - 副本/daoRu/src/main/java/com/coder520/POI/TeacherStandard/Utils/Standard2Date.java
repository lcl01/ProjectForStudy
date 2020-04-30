package com.coder520.POI.TeacherStandard.Utils;

import com.coder520.POI.TeacherStandard.entity.TeacherStandard;
import com.coder520.POI.TeacherStandard.entity.TeacherStandard;
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
public class Standard2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Standard2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherStandard> createTeacherStandard() throws ParseException {
        List<TeacherStandard> standardList =new ArrayList<TeacherStandard>();
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
            TeacherStandard teacherStandard = new TeacherStandard();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            teacherStandard.setStandarduuid(cell.getStringCellValue());
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            teacherStandard.setStandardname(cell3.getStringCellValue());
            HSSFCell cell4=row.getCell(4);
            teacherStandard.setLastmodifiedman(cell4.getStringCellValue());
            HSSFCell cell5=row.getCell(5);
            HSSFCell cell6=row.getCell(6);
            teacherStandard.setStandardtype(cell6.getStringCellValue());
            HSSFCell cell7=row.getCell(7);
            teacherStandard.setReleasedate(cell7.getStringCellValue());

            standardList.add(teacherStandard);
        }
        return standardList ;
    }

    public static void main(String[] args) throws ParseException {
        List<TeacherStandard> standardList = new Standard2Date("E:\\10_标准.xls").createTeacherStandard();
        //for (TeacherStandard : standardList){
        //    System.out.println(literature.toString());
        //}
        System.out.println(standardList.get(0));

    }
}
