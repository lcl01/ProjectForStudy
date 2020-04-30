import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {
    @Test//读取xlsx文件
    public void fun01() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\wps\\sjdz.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
//        for (Row cells : sheetAt) {
//            for (Cell cell : cells) {
//                System.out.println(cell.getStringCellValue());
//            }
//            System.out.println("--");
//        }
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {
            if (i==0) {
                for (Cell cell : sheet.getRow(0)) {
                    System.out.print(cell.getStringCellValue()+"----");
                }
                System.out.println("");
            }else {
                XSSFRow row = sheet.getRow(i);
                short lastCellNum = row.getLastCellNum();
                for (int j = 0; j < lastCellNum; j++) {
                    if (j==3 || j==5 || j==8 || j==10) {
                        XSSFCell cell1 = row.getCell(j);
                        System.out.print(cell1.getStringCellValue()+"----");
                    }else {
                        XSSFCell cell2 = row.getCell(j);
                        System.out.print(cell2.getNumericCellValue()+"----");
                    }

                }
                System.out.println("");

            }
            }

        workbook.close();
        }
     @Test//写入xslx文件
    public void fun02() throws IOException {
         XSSFWorkbook workbook = new XSSFWorkbook();
         XSSFSheet xssfSheet = workbook.createSheet("学生名单");
         XSSFRow row1 = xssfSheet.createRow(0);
         row1.createCell(0).setCellValue("姓名");
         row1.createCell(1).setCellValue("性别");
         row1.createCell(2).setCellValue("地址");
         XSSFRow row2 = xssfSheet.createRow(1);
         row2.createCell(0).setCellValue("张三");
         row2.createCell(1).setCellValue("男");
         row2.createCell(2).setCellValue("深圳");
         XSSFRow row03 = xssfSheet.createRow(2);
         row03.createCell(0).setCellValue("李四");
         row03.createCell(1).setCellValue("男");
         row03.createCell(2).setCellValue("北京");
         FileOutputStream os = new FileOutputStream("D:\\wps\\student.xlsx");
         workbook.write(os);
         os.flush();
         os.close();
         workbook.close();





     }
    }

