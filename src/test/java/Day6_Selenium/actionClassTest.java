package Day6_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class actionClassTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://amazon.com");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Only open browser
	   
	
	}
	@Test
	public void Test1() {
		
		
		Actions action = new Actions(driver);
		
		WebElement accountListButton = driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]/span"));
		
		action.moveToElement(accountListButton).build().perform();
		
		
	}
}
