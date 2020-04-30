import com.health.dao.Dao;
import com.health.pojo.ShengShiBiao;
import com.health.pojo.User;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.IOException;

public class test {
    private Dao dao=new Dao();
    private ShengShiBiao shengShiBiao=new ShengShiBiao();
    @Test
    public void fun01() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook("D:\\wps\\收货地址三级编码(1)(1)(1).20200316131019389.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
        int lastRowNum = sheet.getLastRowNum();
        for (int i= 1; i <= lastRowNum; i++) {
            XSSFRow row = sheet.getRow(i);
            short lastCellNum = row.getLastCellNum();
            for (int j = 1; j < lastCellNum; j++) {
                if(j==1){
                   shengShiBiao.setId((int) row.getCell(j).getNumericCellValue());
                }else if(j==2){
                    shengShiBiao.setProvince_id((int) row.getCell(j).getNumericCellValue());
                }else if(j==3){
                    shengShiBiao.setProvince_name(row.getCell(j).getStringCellValue());
                }
                else if(j==4){
                    shengShiBiao.setRegion3_province_id((int) row.getCell(j).getNumericCellValue());
                }else if(j==5){
                    shengShiBiao.setRegion3_province_name(row.getCell(j).getStringCellValue());
                }else if(j==6){
                    shengShiBiao.setRegion3_city_id((int) row.getCell(j).getNumericCellValue());
                }else if(j==7){
                    shengShiBiao.setCity_id((int) row.getCell(j).getNumericCellValue());
                }else if(j==8){
                    shengShiBiao.setRegion3_city_name(row.getCell(j).getStringCellValue());
                }else if(j==9){
                    shengShiBiao.setRegion3_town_id((int) row.getCell(j).getNumericCellValue());
                }else if(j==10){
                    shengShiBiao.setRegion3_town_name(row.getCell(j).getStringCellValue());
                }


            }
            dao.daoru(shengShiBiao);
        }

        workbook.close();
    }
    @Test
    public void test(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        User user = new User();
        user.setPassword(encoder.encode("123456"));
        System.out.println(user.getPassword());
    }

}
