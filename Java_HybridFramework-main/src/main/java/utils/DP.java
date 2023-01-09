package utils;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DP {
	
	
	public static String[][]getData(String sheetName){
		
		String [][] testData = null;

		try {
			FileInputStream file = new FileInputStream("./testData/TestDatas.xlsx");
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheetAt(0);
			int rowCount = 1 ;//sheet.getLastRowNum();
			int columnCount =8;// sheet.getRow(0).getLastCellNum();
			testData = new String[rowCount][columnCount];
			System.out.println(testData);
			for (int r = 1; r <= rowCount; r++) {
				XSSFRow row = sheet.getRow(r);
				for (int c = 0; c < columnCount; c++) {
					String cellValue = row.getCell(c).getStringCellValue();
					System.out.println(testData[r - 1][c] = cellValue);
					testData[r - 1][c] = cellValue;
				}
			}
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return testData;
	

 }
}