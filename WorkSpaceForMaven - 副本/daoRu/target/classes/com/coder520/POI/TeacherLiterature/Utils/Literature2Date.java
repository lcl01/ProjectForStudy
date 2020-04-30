package com.coder520.POI.TeacherLiterature.Utils;

import com.coder520.POI.TeacherLiterature.entity.TeacherLiterature;
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
public class Literature2Date {
    private String filePath;
    HSSFWorkbook wb;
    public Literature2Date(String filePath) {
        this.filePath=filePath;
    }
    @SuppressWarnings("null")
    public List<TeacherLiterature> CreateTeacherLiterature() throws ParseException {
        List<TeacherLiterature> literatureList =new ArrayList<TeacherLiterature>();
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
            TeacherLiterature literature = new TeacherLiterature();
            HSSFRow row=sheet.getRow(i);
            HSSFCell cell=row.getCell(0);
            literature.setLiteratureuuid(cell.getStringCellValue());
            HSSFCell cell1 =row.getCell(1);
            HSSFCell cell2=row.getCell(2);
            HSSFCell cell3=row.getCell(3);
            if (!cell3.getStringCellValue().equals("无") && !cell3.getStringCellValue().equals("/") ){
                literature.setLiteraturename(cell3.getStringCellValue());
            }

            HSSFCell cell4=row.getCell(4);
            literature.setFirstauthor(cell4.getStringCellValue());
            HSSFCell cell5=row.getCell(5);
            HSSFCell cell6=row.getCell(6);
            literature.setOtherauthor(cell6.getStringCellValue());
            HSSFCell cell7=row.getCell(7);
            literature.setPress(cell7.getStringCellValue());
            HSSFCell cell8=row.getCell(8);
            literature.setLiterauretype(cell8.getStringCellValue());
            HSSFCell cell9=row.getCell(9);
            literature.setIssn(cell9.getStringCellValue());
            HSSFCell cell10=row.getCell(10);
            literature.setPublicationdate(cell10.getStringCellValue());
            HSSFCell cell11=row.getCell(11);

            if (literature.getLiteraturename() !=null){
                literatureList.add(literature);
            }
        }
        return literatureList ;
    }

    public static void main(String[] args) throws ParseException {
        List<TeacherLiterature> literatureList = new Literature2Date("E:\\08_专著.xls").CreateTeacherLiterature();
        //for (TeacherLiterature literature: literatureList){
        //    System.out.println(literature.toString());
        //}
        System.out.println(literatureList.size());

    }
}
