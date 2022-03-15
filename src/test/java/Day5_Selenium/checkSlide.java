package Day5_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkSlide {
	
	
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeTest() {
		
//		1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://practice.automationtesting.in");
	    driver.manage().window().maximize();
	
	}
	
	@Test
	public void Testcase1() {
		
//		3) Click on Shop Menu
		
		driver.findElement(By.xpath("//li[@id='menu-item-40']")).click();
		
		
//		4) Now click on Home menu button
		
		driver.findElement(By.xpath("//div[@id='content']/nav/a")).click();
		
		
//		5) Test whether the Home page has Three Sliders only
//		6) The Home page must contains only three sliders
		
		List<WebElement> sliders = driver.findElements(By.xpath("//*[@id='n2-ss-6']/div"));
		
		int numberOfSliders = sliders.size();
		
		if(numberOfSliders == 3) {
			
			System.out.println("Sliders count is 3");
			
		}else {
			System.out.println("failed");
		}
		

		
		
		
	}
	
	
	
	
	
	

}




