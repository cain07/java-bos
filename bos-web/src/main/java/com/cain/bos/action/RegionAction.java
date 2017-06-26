package com.cain.bos.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.cain.bos.action.base.BaseAction;
import com.cain.bos.domain.Region;
import com.cain.bos.service.IRegionService;

@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region>{

	private File regionFile;
	@Autowired
	private IRegionService regionService;

	public File getRegionFile() {
		return regionFile;
	}

	public void setRegionFile(File regionFile) {
		this.regionFile = regionFile;
	}
	
	public String importXml() throws FileNotFoundException, IOException{
		System.out.println(regionFile);
		List<Region> regions = new ArrayList<>();
	   HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(regionFile));
		
		HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
		
		for(Row row:sheetAt){
			int rowNum = row.getRowNum();
			if(rowNum == 0){
				continue;
			}
			
			String id = row.getCell(0).getStringCellValue();
			String province = row.getCell(1).getStringCellValue();
			String city = row.getCell(2).getStringCellValue();
			String district = row.getCell(3).getStringCellValue();
			String postcode = row.getCell(4).getStringCellValue();
			
			Region region = new Region(id, province, city, district, postcode, null, null, null);
			
			
			regions.add(region);
		}
		regionService.addBatch(regions);
		
		
		return NONE;
	}
}
