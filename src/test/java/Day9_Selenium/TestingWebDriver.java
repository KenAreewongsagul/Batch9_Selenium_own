package Day9_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utilities.Driver;

public class TestingWebDriver {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		Driver.getDriver();
		
	
	}
	

	@Test
	public void Test1() {
		
		
		
		Driver.driver.findElement(By.id("dfd")).sendKeys("username");
		
	
		
	}
	
	@AfterMethod
	public void afterMethod() {
		Driver.tearDown();
		
	}
	
}
