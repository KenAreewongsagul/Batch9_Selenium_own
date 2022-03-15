package excelTests;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import utilities.BaseClass;



public class firstExcelTests {
	
	public static void main(String[] args) throws Exception {
		
		
		String excelPath = "/Users/ken/eclipse-workspace/Batch9_Selenium_own/src/test/resources/dataFolder/Data.xlsx";
		FileInputStream fs = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		
		
		
		System.out.println("1-" + sheet.getRow(0).getCell(0));
		
		
		////
		System.out.println("\n\n Iterating over Rows and columns using for each");
		
		DataFormatter objDefaultFormat = new DataFormatter();
		
		//
		for(Row row1 : sheet) {
			
			for(Cell cell1 : row1) {
				
				String cellValue = objDefaultFormat.formatCellValue(cell1);
				System.out.print(cellValue + " | ");
			}
			System.out.println(" ");
			
			
		}
		
		
		
		System.out.println(BaseClass.excelFiles(0,1));
		
		
	}

}
