package org.lee.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public ReadExcel() {

	}
	
	public static void start(String path) throws FileNotFoundException, IOException {
		Workbook book = getWorkBook(path);
		List<Sheet> sheets = getSheets(book);
		SheetIterator(sheets);
		

	}

	private static void SheetIterator(List<Sheet> sheets) {
		for (int i = 0; i < sheets.size(); i++) {
			Sheet sheet = sheets.get(i);
			if (sheet.getLastRowNum() > 1) {
				System.out.println(sheet.getSheetName() + "=============");
			}
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (nextRow.getRowNum() < 1) {
					continue;
				}
				Iterator<Cell> cellIterator = nextRow.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						System.out.print(String.valueOf(cell.getStringCellValue()));
						break;
					case Cell.CELL_TYPE_BOOLEAN:
						System.out.print(String.valueOf(cell.getBooleanCellValue()));
						break;
					case Cell.CELL_TYPE_NUMERIC:
						System.out.print(String.valueOf(cell.getNumericCellValue()));
						break;
					}
					System.out.print("   ");
				}
				System.out.println("   ");
			}
			System.out.println("   ");
		}
	}

	/*
	 * while(iterator.hasNext()){ Row nextRow = iterator.next();
	 * if(nextRow.getRowNum()<3){ continue; } Iterator<Cell> cellIterator =
	 * nextRow.cellIterator(); while (cellIterator.hasNext()) { Cell cell =
	 * cellIterator.next();
	 * 
	 * switch (cell.getCellType()) { case Cell.CELL_TYPE_STRING:
	 * System.out.print(cell.getStringCellValue()); break; case
	 * Cell.CELL_TYPE_BOOLEAN: System.out.print(cell.getBooleanCellValue());
	 * break; case Cell.CELL_TYPE_NUMERIC:
	 * System.out.print(cell.getNumericCellValue()); break; }
	 * System.out.print("   "); } System.out.println("   "); }
	 * System.out.println("   ");
	 */
	

	private static List<Sheet> getSheets(Workbook book) {
		int numberOfSheets = book.getNumberOfSheets();
		System.out.println("numberOfSheets:" + numberOfSheets);
		List<Sheet> sheets = new ArrayList<Sheet>();
		for (int i = 0; i < numberOfSheets; i++) {
			sheets.add(book.getSheetAt(i));
		}
		return sheets;
	}

	public static Workbook getWorkBook(String path) throws FileNotFoundException, IOException {
		return path.endsWith(".xls") ? (new HSSFWorkbook(new FileInputStream(new File(path))))
				: (path.endsWith(".xlsx") ? (new XSSFWorkbook(new FileInputStream(new File(path)))) : (null));
	}
	
	
	

}
