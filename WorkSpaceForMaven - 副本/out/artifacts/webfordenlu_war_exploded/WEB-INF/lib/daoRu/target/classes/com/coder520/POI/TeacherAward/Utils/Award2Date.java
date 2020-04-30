package com.coder520.POI.TeacherAward.Utils;

import com.coder520.POI.TeacherAward.entity.TeacherAward;
import com.coder520.POI.TeacherAward.entity.TeacherAward;
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
public class Award2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Award2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherAward> createTeacherAward() throws ParseException {
        List<TeacherAward> teacherAwardList =new ArrayList<TeacherAward>();
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
            TeacherAward teacherAward = new TeacherAward();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            teacherAward.setLastmodifiedtime(cell.getStringCellValue());
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            teacherAward.setAwardname(cell3.getStringCellValue());
            HSSFCell cell4=row.getCell(4);
            teacherAward.setFirstwinner(cell4.getStringCellValue());
            HSSFCell cell5=row.getCell(5);
            HSSFCell cell6=row.getCell(6);
            teacherAward.setOtherwinner(cell6.getStringCellValue());
            HSSFCell cell7=row.getCell(7);
            teacherAward.setAwardcategory(cell7.getStringCellValue());
            HSSFCell cell8=row.getCell(8);
            HSSFCell cell9=row.getCell(9);
            teacherAward.setAwardlevel(cell9.getStringCellValue());
            HSSFCell cell10=row.getCell(10);
            teacherAward.setWinningdate(cell10.getStringCellValue());

            teacherAwardList.add(teacherAward);
        }
        return teacherAwardList ;
    }

    public static void main(String[] args) throws ParseException {
        List<TeacherAward> teacherAwardList = new Award2Date("E:\\11_所获奖项.xls").createTeacherAward();
        //for (TeacherAward : teacherAwardList){
        //    System.out.println(literature.toString());
        //}
        System.out.println(teacherAwardList.get(0));

    }
}
