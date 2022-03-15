package Day4_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class implicitWaitTest {
	
	
WebDriver driver;

WebDriverWait wait;



	
	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://the-internet.herokuapp.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Only open browser
	   
	
	}
	
	@Test
	public void Testcase1() {
		
		driver.findElement(By.id("textUsername")).sendKeys("Admin");
		driver.findElement(By.id("textPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		wait = new WebDriverWait(driver,30);
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
		
		
		String actualWecomeText = driver.findElement(By.id("welcome")).getText();
		String expected = "Welcomw Paul";
		
		
		
		if(actualWecomeText.equalsIgnoreCase(expected)) {
			
			System.out.println("PASSED");
			
		}else {
			
			System.out.println("Fail");
		}
		
		
		
		
		
	}
	
	

}
