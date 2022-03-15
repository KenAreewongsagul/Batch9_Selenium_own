package excelTests;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class firstWriteExcelTest {

	public static void main(String[] args) throws IOException {
		
		
		String excelPath = "/Users/ken/eclipse-workspace/Batch9_Selenium_own/src/test/resources/dataFolder/Data.xlsx";
		
		FileInputStream fs = new FileInputStream(excelPath);
		
		XSSFWorkbook wb = new XSSFWorkbook(fs);
		XSSFSheet sheet = wb.getSheet("sheet1");
		
		int lastRow = sheet.getLastRowNum();
		
		System.out.println(lastRow);
		
		for(int i = 2; i <= lastRow; i++) {
			
			Row row = sheet.getRow(i);
			
			Cell cell = row.createCell(2);
			
			cell.setCellValue("Aree");
		}
		
//		Row row = sheet.getRow(3);
//		
//		Cell cell = row.createCell(9);
//		
//		cell.setCellValue("Aree");
		
		FileOutputStream fos = new FileOutputStream(excelPath);
		
		wb.write(fos);
		fos.close();
		wb.close();

	}

}
