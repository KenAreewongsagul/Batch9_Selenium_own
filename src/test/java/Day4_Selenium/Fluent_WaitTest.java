package Day4_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluent_WaitTest {
	
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
		public void fluentWait() {
			
			Wait wait= new FluentWait(driver);
			
			
//			.waitTimeout(30, TimeUnit.SECONDS);
//			.pollingEvery(5, TimeUnit.SECONDS);
//			.wait(Exceotion.class);
//			
//			
//			
//			wait.until(expectedCoditions.alertIsPresent());
			
			
			
			
		}
}
