package com.cain.bos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

public class POITest {

	@Test
	public void test01() throws FileNotFoundException, IOException{
		
		String file ="/Users/yunshan/Downloads/区域导入测试数据.xls";
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File(file)));
		
		HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
		
		for(Row row:sheetAt){
			System.out.println();
			for(Cell cell:row){
				String stringCellValue = cell.getStringCellValue();
				System.out.print(stringCellValue+"  ");
			}
		}
		
	}
}
