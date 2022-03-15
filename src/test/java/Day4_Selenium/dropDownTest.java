package Day4_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropDownTest {
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
		public void dropDown() throws InterruptedException {
			
			WebElement staticDropdown = driver.findElement(By.id("dropdown"));
			
			Select select = new Select(staticDropdown);
			
			Thread.sleep(2000);
			
			select.selectByIndex(1);
			Thread.sleep(2000);
			select.selectByValue("2");
			Thread.sleep(1000);
			select.selectByVisibleText("Option 1");
			
			
	
		}

}
