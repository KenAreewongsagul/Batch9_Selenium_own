package Day2_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sampleAutomationWebElementTesting {
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void beforeMethod() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://demo.automationtesting.in/Index.html");
	    driver.manage().window().maximize();
	}
	
	
	
	
	@Test
	public void inputTest() {
		driver.findElement(By.id("email")).sendKeys("ken@gmail.com");
		driver.findElement(By.id("enterimg")).click();
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input")).sendKeys("Ken");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[2]/input")).sendKeys("Areewongsagul");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[2]/div/textarea")).sendKeys("1510 H St. NW Washington D.C. 20005");
		driver.findElement(By.xpath("//*[@id=\"eid\"]/input")).sendKeys("Ken@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[4]/div/input")).sendKeys("(301)661-4278");
		driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label[1]/input")).click();
		driver.findElement(By.xpath("//*[@id=\"checkbox2\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"msdd\"]")).click();
		driver.findElement(By.xpath("/<a style=\"text-decoration:none\" class=\"ui-corner-all\">English</a>")).click();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
