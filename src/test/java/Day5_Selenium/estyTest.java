package Day5_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class estyTest {
	
	

	WebDriver driver;

	WebDriverWait wait;

	
	
	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://www.etsy.com");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Only open browser
	   
	
	}
	
	@Test
	public void etsyTest() throws InterruptedException {
		
		driver.findElement(By.id("global-enhancements-search-query")).sendKeys("light");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"gnav-search\"]/div/div[1]/button")).click();
		
		Thread.sleep(2000);
		
		
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul/li"));
		
		for(int i = 7; i < list.size(); i++) {}
			
			
			WebElement price = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/div[4]/div[5]/div[3]/div[9]/div/div/div[1]/ul/li[1]"));
			
			System.out.println(price.getText());
			
		}
		
	
			
			
			
		}
	

