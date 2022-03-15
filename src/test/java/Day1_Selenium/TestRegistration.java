package Day1_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestRegistration {

	WebDriver driver;
	WebDriverWait wait;
	
//	wait = new WebDriverWait(driver,30);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
	

	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://practice.automationtesting.in");
//	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 	   
	
	}
	
	@AfterMethod
	public void afterTest() {
		driver.close();
	}
	
	@Test (enabled=false)
	public void registrationSignin() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered Email Address in Email-Address textbox
//	5) Enter your own password in password textbox
//	6) Click on Register button
//	7) User will be registered successfully and will be navigated to the Home page
		
		
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("reg_email")).sendKeys("aabb@gmail.com");
		
		driver.findElement(By.id("reg_password")).sendKeys("aabbccdd1234", Keys.ENTER);
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]")).isDisplayed());
		System.out.println(driver.getTitle());
	
	}
	
	
	@Test (enabled=false)
	public void rgistrationWithInvalidEmailid() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered Email Address in Email-Address textbox
//	5) Enter your own password in password textbox
//	6) Click on Register button
//	7) User will be registered successfully and will be navigated to the Home page
		
		
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("reg_email")).sendKeys("aabb@gmail.com");
		
		driver.findElement(By.id("reg_password")).click();
		
		driver.findElement(By.id("reg_password")).sendKeys("aabbccdd1234", Keys.ENTER);
		Thread.sleep(3000);
		
		String currentUrl = driver.getCurrentUrl();
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]")).click();
	
		String ErrorMessage = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul")).getText();
		System.out.println(ErrorMessage);
		
		String nextUrl = driver.getCurrentUrl();
		AssertJUnit.assertTrue(currentUrl.equals(nextUrl));
		System.out.println("Registration failed");
		
	}
	
	
	@Test (enabled=false)
	public void registrationWithEmptyEmailId() throws InterruptedException {
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter empty Email Address in Email-Address textbox
//	5) Enter your own password in password textbox
//	6) Click on Register button
//	7) Registration must fail with a warning message(ie please provide valid email address)
		
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("reg_email")).click();
		
//		driver.findElement(By.id("reg_password")).click();
		
		driver.findElement(By.id("reg_password")).sendKeys("aabbccdd1234");
		Thread.sleep(3000);
		
		String currentUrl = driver.getCurrentUrl();
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]")).click();
	
		String ErrorMessage = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul")).getText();
		System.out.println(ErrorMessage);
		
		String nextUrl = driver.getCurrentUrl();
		AssertJUnit.assertTrue(currentUrl.equals(nextUrl));
		System.out.println("Registration failed");
		
	}

	@Test (enabled=false)
	public void registrationWithEmptyPassword() throws InterruptedException {
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter valid Email Address in Email-Address textbox
//	5) Enter empty password in password textbox
//	6) Click on Register button
//	7) Registration must fail with a warning message(ie please enter an account password)
		
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("reg_email")).sendKeys("aabb1@gmail.com");
		
		driver.findElement(By.id("reg_password")).click();
		
//		driver.findElement(By.id("reg_password")).sendKeys("aabbccdd1234");
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]")).click();
	
		String ErrorMessage = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		System.out.println(ErrorMessage);
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText());
		
		
	}
	
	
	@Test
	public void registrationWithEmptyEmailIdAndPassword() throws InterruptedException {
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter empty Email Address in Email-Address textbox
//	5) Enter empty password in password textbox
//	6) Click on Register button
//	7) Registration must fail with a warning message(ie please provide valid email address)
		
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("reg_email")).click();
		
		driver.findElement(By.id("reg_password")).click();
		
//		driver.findElement(By.id("reg_password")).sendKeys("aabbccdd1234");
//		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]")).click();
	
		String ErrorMessage = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		System.out.println(ErrorMessage);
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText());
		
	}
	
	
	
	
	
}
