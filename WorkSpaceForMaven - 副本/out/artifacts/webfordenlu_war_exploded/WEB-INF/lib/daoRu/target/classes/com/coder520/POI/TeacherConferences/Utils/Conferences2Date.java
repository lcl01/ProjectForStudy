package com.coder520.POI.TeacherConferences.Utils;

import com.coder520.POI.TeacherConferences.entity.TeacherConferences;
import com.coder520.POI.TeacherConferences.entity.TeacherConferences;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yang on 2017/10/17.
 */
public class Conferences2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Conferences2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherConferences> createConferences() throws ParseException {
        List<TeacherConferences> conferencesList =new ArrayList<TeacherConferences>();
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
            TeacherConferences conferences = new TeacherConferences();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            conferences.setLastmodifiedmanid(cell.getStringCellValue());
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            conferences.setConferencename(cell3.getStringCellValue().trim());
            HSSFCell cell4=row.getCell(4);
            conferences.setSponsor(cell4.getStringCellValue().trim());
            HSSFCell cell5=row.getCell(5);
            conferences.setHoldingtime(cell5.getStringCellValue().trim());
            HSSFCell cell6=row.getCell(6);
            conferences.setType2(cell6.getStringCellValue().trim());
            HSSFCell cell7=row.getCell(7);
            if (cell7 != null){
                conferences.setChairman(cell7.getStringCellValue().trim());
            }
            HSSFCell cell8=row.getCell(8);
            if (cell8 != null){
                conferences.setNumbersofattending(cell8.getStringCellValue().trim());
            }

            conferencesList.add(conferences);
        }
        return conferencesList ;
    }


    public static void main(String[] args) throws ParseException {
        List<TeacherConferences> conferencesList = new Conferences2Date("E:\\12_学术会议活动.xls").createConferences();
        System.out.println(conferencesList.size());
        System.out.println(conferencesList.get(0));


    }
}
