package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (propertiesReader.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			case "headless":
				// code
				break;

			}

		}
		driver.get(propertiesReader.getProperty("url"));
		// maximize
		driver.manage().window().maximize();

		return driver;
	}

	// close/quit browser
	@AfterMethod
	public static void tearDown() {
		if (driver != null) {
			driver.close();
			// driver.quit();
			driver = null;
		}
	}
	
	
	
	
	private static Properties configFile;

	static {

		try {
			String filePath = Constants.CONFIGURATION_FILEPATH;

			FileInputStream input = new FileInputStream(filePath);

			configFile = new Properties();
			configFile.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}
	
	
	public static XSSFCell excelFiles(int row1 , int cell1) throws Exception {
		
		String excelPath = Constants.CONFIGURATION_excelPath;
		FileInputStream fs = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("sheet1");
//		Row row = sheet.getRow(0);
//		Cell cell = row.getCell(0);
		
		XSSFCell userName = sheet.getRow(row1).getCell(cell1);
		
		return userName;
		
	}
	
	
}
