package com.wsft.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.wsft.excel.domain.Vegetable;

public class ReadExcel {
	public static final String filename = "lib/2018-07-23_益民菜市(长顺街店).xls";
	public String prename,testtm,testaddr;
	public List<Vegetable> readXls() throws IOException {
		InputStream is = new FileInputStream(filename);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Vegetable vegetable = null;
		List<Vegetable> list = new ArrayList<Vegetable>();
        int dot = filename.lastIndexOf('.');
        int slash = filename.lastIndexOf('/');
        if ((dot >-1) && (slash >-1) && (dot < (filename.length())) && (slash < (filename.length()))) { 
        	prename = filename.substring(slash+1, dot);
        } 
        String[] temps = prename.split("_");
        testtm = temps[0];
        testaddr = temps[1];
		// 循环工作表Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// 循环行Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					vegetable = new Vegetable();
					HSSFCell id = hssfRow.getCell(0);
					id.setCellType(HSSFCell.CELL_TYPE_STRING);
					HSSFCell manage = hssfRow.getCell(1);
					HSSFCell sampname = hssfRow.getCell(2);
					HSSFCell location = hssfRow.getCell(3);
					HSSFCell channels = hssfRow.getCell(4);
					HSSFCell testidx = hssfRow.getCell(5);
					testidx.setCellType(HSSFCell.CELL_TYPE_STRING);
					HSSFCell result = hssfRow.getCell(6);
                    
					vegetable.setId(Integer.valueOf(getValue(id)));
					vegetable.setTesttm(Date.valueOf(testtm));
					vegetable.setManage(getValue(manage));
					vegetable.setSampName(getValue(sampname));
					vegetable.setLocation(getValue(location));
					vegetable.setChannels(getValue(channels));
					vegetable.setTestidx(Float.valueOf(getValue(testidx)));
					vegetable.setResult(getValue(result));
					vegetable.setTestaddr(testaddr);
					list.add(vegetable);
				}
			}
		}
		return list;
	}
	
	 @SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
	        //if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
	            // 返回布尔类型的值
	        //    return String.valueOf(hssfCell.getBooleanCellValue());
	        //} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
	            // 返回数值类型的值
	        //    return String.valueOf(hssfCell.getNumericCellValue());
	        //} else {
	            // 返回字符串类型的值
	            return String.valueOf(hssfCell.getStringCellValue());
	        //}
	    }
}
