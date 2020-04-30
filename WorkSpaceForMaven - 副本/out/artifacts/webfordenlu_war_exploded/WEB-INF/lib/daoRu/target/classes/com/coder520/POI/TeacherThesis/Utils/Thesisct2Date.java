package com.coder520.POI.TeacherThesis.Utils;

import com.coder520.POI.TeacherThesis.entity.TeacherThesis;
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
public class Thesisct2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Thesisct2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherThesis> CreateThesis() throws ParseException {
        List<TeacherThesis> thesisList =new ArrayList<TeacherThesis>();
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
            TeacherThesis thesis = new TeacherThesis();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            thesis.setThesisuuid(cell.getStringCellValue());
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            thesis.setThesstname(cell3.getStringCellValue());
            HSSFCell cell4=row.getCell(4);
            thesis.setFirstauthor(cell4.getStringCellValue());
            HSSFCell cell5=row.getCell(5);
            HSSFCell cell6=row.getCell(6);
            thesis.setCorrespondingauthor(cell6.getStringCellValue());
            HSSFCell cell7=row.getCell(7);
            thesis.setPublication(cell7.getStringCellValue());
            HSSFCell cell8=row.getCell(8);
            thesis.setIssn(cell8.getStringCellValue());
            HSSFCell cell9=row.getCell(9);
            if (cell9.getStringCellValue().equals("/")){
                thesis.setImpactfactor("0");
            }else {
                thesis.setImpactfactor(cell9.getStringCellValue());
            }
            HSSFCell cell10=row.getCell(10);
            thesis.setPublishtime(cell10.getStringCellValue());
            HSSFCell cell11=row.getCell(11);
            thesis.setMaxquotecounts(cell11.getStringCellValue());

            thesisList.add(thesis);
        }
        return thesisList ;
    }
    public Map<String,String> getlabName(){
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
            String name = row.getCell(3).getStringCellValue();
            idAndName.put(id, name);
        }
        return idAndName;
    }

    public static void main(String[] args) throws ParseException {
        List<TeacherThesis> thesisList = new Thesisct2Date("E:\\07_论文.xls").CreateThesis();
        System.out.println(thesisList.get(0));
        //Map<String,String> idAndName = new Thesisct2Date("E:\\01_基本信息.xls").getTeacherName();
        //for (Map.Entry<String, String> entry : idAndName.entrySet()) {
        //
        //	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        //
        //}

    }
}
