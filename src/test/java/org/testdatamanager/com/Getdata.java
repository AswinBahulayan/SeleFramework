package org.testdatamanager.com;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.report.generator.com.Extent_report;

public class Getdata  {

	public static Object[][] getdata(String filename) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbook wb=new XSSFWorkbook("./data/"+filename+".xlsx");
		XSSFSheet sheet = wb.getSheetAt(0);
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum =sheet.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRowNum][lastCellNum];
		for(int j=1;j<=lastRowNum;j++)
		{
			XSSFRow row = sheet.getRow(j);
			
			//obj=new Object[lastRowNum][lastCellNum];
			for (int i = 0; i <lastCellNum; i++) {
				String stringCellValue = row.getCell(i).getStringCellValue();
				obj[j-1][i]=stringCellValue;
				System.out.println(row.getCell(i));
			}
		}
		wb.close();
		return obj;

	}

}
