package com.coder520.POI.common.poiUtils;

import static org.hamcrest.CoreMatchers.nullValue;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import com.coder520.POI.LabEquipment.entity.LabEquipment;
import com.coder520.POI.LabInfo.entity.LabInfo;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

import com.coder520.POI.user.entity.User;

public class Excel2Data {
	private String filePath;
	HSSFWorkbook wb;
	public Excel2Data(String filePath) {
		this.filePath=filePath;
	}
	@SuppressWarnings("null")
	public List<User> CreateUserList(){
		List<User> users =new ArrayList<User>();
		try {
			wb = new HSSFWorkbook(new FileInputStream(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("解析Excel文件出错");
			e.printStackTrace();
		}
		HSSFSheet sheet=wb.getSheet("sheet1");
		int rowLength=sheet.getLastRowNum();
		for (int i = 2; i <=rowLength; i++) {
			User user = new User();
			HSSFRow row=sheet.getRow(i);
			HSSFCell cell=row.getCell(0);
			user.setId((int) cell.getNumericCellValue());
			HSSFCell cell1=row.getCell(1);
			user.setUsername(cell1.getStringCellValue());
			HSSFCell cell2=row.getCell(2);
			user.setBirthday(cell2.getDateCellValue());
			HSSFCell cell3=row.getCell(3);
			user.setSex(cell3.getStringCellValue());
			HSSFCell cell4=row.getCell(4);
			user.setAddress(cell4.getStringCellValue());
			users.add(user);
		}
		return users;
	}

	public  List<LabInfo> CreateLabInfoList() throws ParseException {
		List<LabInfo> labInfoList =new ArrayList<LabInfo>();
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
			LabInfo labInfo = new LabInfo();
			HSSFRow row=sheet.getRow(i);
			HSSFCell cell=row.getCell(0);
			//labInfo.setLabseqno((cell.getStringCellValue()));
			HSSFCell cell1 =row.getCell(1);
			labInfo.setDepartmentseqno(Long.valueOf(cell1.getStringCellValue()));
			HSSFCell cell2=row.getCell(2);
			HSSFCell cell3=row.getCell(3);
			labInfo.setLabname(cell3.getStringCellValue());
			HSSFCell cell4=row.getCell(4);
			labInfo.setTypeoflab(cell4.getStringCellValue());
			HSSFCell cell5=row.getCell(5);
			labInfo.setLeveloflab(cell5.getStringCellValue());
			HSSFCell cell6=row.getCell(6);
			labInfo.setSuperiordep(cell6.getStringCellValue());
			HSSFCell cell7=row.getCell(7);
			HSSFCell cell8=row.getCell(8);
			labInfo.setLabmajor(cell8.getStringCellValue());
			HSSFCell cell9=row.getCell(9);
			if (cell9!=null){
				labInfo.setRelieddept(cell9.getStringCellValue());
			}
			HSSFCell cell10=row.getCell(10);
			HSSFCell cell11=row.getCell(11);
			labInfo.setApprovalno(cell11.getStringCellValue());
			HSSFCell cell12=row.getCell(12);
			labInfo.setRegistingtime(cell12.getStringCellValue());

			HSSFCell cell13=row.getCell(13);
			String s13 = cell13.getStringCellValue();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
			Date date = simpleDateFormat.parse(s13);
			labInfo.setAccepttime(date);

			HSSFCell cell14=row.getCell(14);
			labInfo.setLastassessedtime(cell14.getStringCellValue());
			HSSFCell cell15=row.getCell(15);
			if (cell15!=null){
				labInfo.setAreaoflab(cell15.getStringCellValue());
			}

			HSSFCell cell16=row.getCell(16);
			if (cell16!=null){
				labInfo.setAreaoflab(cell16.getStringCellValue());
			}
			HSSFCell cell17=row.getCell(17);
			labInfo.setLabaddress(cell17.getStringCellValue());
			HSSFCell cell18=row.getCell(18);
			labInfo.setPostcode(cell18.getStringCellValue());
			HSSFCell cell19=row.getCell(19);
			labInfo.setManager(cell19.getStringCellValue());
			HSSFCell cell20=row.getCell(20);
			labInfo.setManagerphone(cell20.getStringCellValue());
			HSSFCell cell21=row.getCell(21);
			labInfo.setManageremail(cell21.getStringCellValue());
			labInfoList.add(labInfo);
		}
		return labInfoList ;
	}

	public  List<LabEquipment> CreateLabEquipmentList() throws ParseException {
		List<LabEquipment> labEquipmentList =new ArrayList<LabEquipment>();
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
			LabEquipment labEquipment = new LabEquipment();
			HSSFRow row=sheet.getRow(i);
			HSSFCell cell=row.getCell(0);
			labEquipment.setAttention(cell.getStringCellValue());
			HSSFCell cell1 =row.getCell(1);
			HSSFCell cell2=row.getCell(2);
			HSSFCell cell3=row.getCell(3);
			labEquipment.setChinesename(cell3.getStringCellValue());
			HSSFCell cell4=row.getCell(4);
			labEquipment.setKind(cell4.getStringCellValue());
			HSSFCell cell5=row.getCell(5);
			if (cell5!=null){
				labEquipment.setSpecfication(cell5.getStringCellValue());
			}
			HSSFCell cell6=row.getCell(6);
			HSSFCell cell7=row.getCell(7);
			HSSFCell cell8=row.getCell(8);
			cell8.setCellType(Cell.CELL_TYPE_STRING);
			String s = cell8.getStringCellValue();
			Double rawValue =Double.valueOf(s);
			if (rawValue>2000){
				rawValue=rawValue/10000;
			}
			labEquipment.setRawvalue(rawValue);
			HSSFCell cell9=row.getCell(9);
			HSSFCell cell10=row.getCell(10);
			labEquipment.setGainedway("购置");
			HSSFCell cell11=row.getCell(11);
			if (cell11!=null){
				labEquipment.setOrigin(cell11.getStringCellValue());
			}
			HSSFCell cell12=row.getCell(12);
			labEquipment.setOriginoffund(cell12.getStringCellValue());
			HSSFCell cell13=row.getCell(13);
			if (cell13!=null){
				labEquipment.setKeyfeature(cell13.getStringCellValue());
			}
			HSSFCell cell14=row.getCell(14);
			labEquipment.setRunningstate("1");
			HSSFCell cell15=row.getCell(15);
			labEquipment.setSharestate("0");

			//HSSFCell cell16=row.getCell(16);
			//
			//HSSFCell cell17=row.getCell(17);
			//
			//HSSFCell cell18=row.getCell(18);
            //
			//HSSFCell cell19=row.getCell(19);
            //
			//HSSFCell cell20=row.getCell(20);
            //
			//HSSFCell cell21=row.getCell(21);

			labEquipmentList.add(labEquipment);
		}
		return labEquipmentList ;
	}
	public Map<String,String> getLabName(){
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

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		//List<User> users=new Excel2Data("E:\\User.xls").CreateUserList();
		//for(User user:users) {
		//	System.out.println(user.toString());
		//}
		//List<LabInfo> labInfoList = new Excel2Data("E:\\01_基本信息.xls").CreateLabInfoList();
		//int sum = 0;
		//for (LabInfo labInfo: labInfoList){
		//	System.out.println(labInfo.toString());
		//	sum++;
		//}
		//System.out.println(sum);

		List<LabEquipment> labEquipmentList = new Excel2Data("E:\\02_基础设施条件.xls").CreateLabEquipmentList();
		//int sum = 0;
		//for (LabEquipment labEquipment: labEquipmentList){
		//	System.out.println(labEquipment.toString());
		//	sum++;
		//}
		//System.out.println(sum);
		LabEquipment labEquipment = labEquipmentList.get(904);
		System.out.println(labEquipment.toString());

		//Map<String,String> idAndName = new Excel2Data("E:\\01_基本信息.xls").getLabName();
		//for (Map.Entry<String, String> entry : idAndName.entrySet()) {
        //
		//	System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        //
		//}
	}
}
