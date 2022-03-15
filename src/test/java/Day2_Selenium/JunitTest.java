package Day2_Selenium;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JunitTest {
	
	
	@BeforeMethod
	public void setup() {
		
		
//		 WebDriver driver;
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://www.wikipedia.com");
		System.out.println("Opening Browser");
	}
	
	@AfterMethod
	public void tearDown() {
		
		System.out.println("Closeing Browser");
	}
	
	
	
	@Test
	public void test1() {
		System.out.println("Test1");

		
	}
	@Test
	public void test2() {
		System.out.println("Test2");

		
	}
	
	
	

}
