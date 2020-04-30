package org.lee.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
public class Main {
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		String path = "D:\\DownLoad\\lcL.xlsx";
		InputStream in = new FileInputStream(new File(path));
		InsertExcel.start(in,path);		
	}	
}
