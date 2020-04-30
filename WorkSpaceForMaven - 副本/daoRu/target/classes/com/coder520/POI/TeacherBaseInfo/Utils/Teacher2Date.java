package com.coder520.POI.TeacherBaseInfo.Utils;

import com.coder520.POI.LabEquipment.entity.LabEquipment;
import com.coder520.POI.TeacherBaseInfo.entity.TeacherBaseInfo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yang on 2017/10/17.
 */
public class Teacher2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Teacher2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherBaseInfo> CreateTeacherBaseInfo() throws ParseException {
        List<TeacherBaseInfo> teacherBaseInfoList =new ArrayList<TeacherBaseInfo>();
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
            TeacherBaseInfo teacherBaseInfo = new TeacherBaseInfo();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            teacherBaseInfo.setTeachername(cell3.getStringCellValue());
            HSSFCell cell4=row.getCell(4);
            if (cell4.getStringCellValue().equals("男")){
                teacherBaseInfo.setSex("1");
            }else{
                teacherBaseInfo.setSex("0");
            }

            HSSFCell cell5=row.getCell(5);
            teacherBaseInfo.setBirthday(cell5.getStringCellValue());
            HSSFCell cell6=row.getCell(6);
            teacherBaseInfo.setEducation(cell6.getStringCellValue());
            HSSFCell cell7=row.getCell(7);
            teacherBaseInfo.setGraschool(cell7.getStringCellValue());
            HSSFCell cell8=row.getCell(8);
            teacherBaseInfo.setTitles(cell8.getStringCellValue());
            HSSFCell cell9=row.getCell(9);
            teacherBaseInfo.setDeptment(cell9.getStringCellValue());
            HSSFCell cell10=row.getCell(10);
            teacherBaseInfo.setLaboratory(cell10.getStringCellValue());
            HSSFCell cell11=row.getCell(11);
            if (cell11.getStringCellValue().equals("否")){
                teacherBaseInfo.setSituationofpost("在编");
            }else {
                teacherBaseInfo.setSituationofpost("其他");
            }

            HSSFCell cell12=row.getCell(12);
            teacherBaseInfo.setTalentscategory(cell12.getStringCellValue());
            HSSFCell cell13=row.getCell(13);
            teacherBaseInfo.setDuties(cell13.getStringCellValue());
            HSSFCell cell14=row.getCell(14);
            teacherBaseInfo.setTalentsareas(cell14.getStringCellValue());
            HSSFCell cell15=row.getCell(15);
            teacherBaseInfo.setPhone(cell15.getStringCellValue());
            //HSSFCell cell16=row.getCell(16);
            //HSSFCell cell17=row.getCell(17);
            //HSSFCell cell18=row.getCell(18);
            //HSSFCell cell19=row.getCell(19);
            //HSSFCell cell20=row.getCell(20);
            //HSSFCell cell21=row.getCell(21);

            teacherBaseInfoList.add(teacherBaseInfo);
        }
        return teacherBaseInfoList ;
    }

    public static void main(String[] args) throws ParseException {
        List<TeacherBaseInfo> teacherBaseInfoList = new Teacher2Date("E:\\03_人员状况.xls").CreateTeacherBaseInfo();
        System.out.println(teacherBaseInfoList.size());
        //for (TeacherBaseInfo teacherBaseInfo: teacherBaseInfoList){
        //    System.out.println(teacherBaseInfo.toString());
        //}
    }
}
