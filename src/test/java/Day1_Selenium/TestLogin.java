package Day1_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestLogin {
	
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
	public void loginWithValidUsernameAndPassword() {
	
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
	
	
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).sendKeys("aabb@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("aabbccdd1234");
		
		String currentUrl = driver.getCurrentUrl();
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		String nextUrl = driver.getCurrentUrl();
		
		AssertJUnit.assertTrue(currentUrl.equals(nextUrl));
	
		String verifyLogin = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]")).getText();
		
		System.out.println(verifyLogin);
		
		
		
	}
	
	
	@Test (enabled=false)
	public void  loginWithIncorrectUsernameAndPassword() {
	
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter incorrect username in username textbox
//	5) Enter incorrect password in password textbox.
//	6) Click on login button
//	7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
	
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).sendKeys("aabbz@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("aabbccdd1234z");
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).getText());
	
		String verifyLogin = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		
		System.out.println(verifyLogin);
		
		
		
	}
	
	
	@Test (enabled=false)
	public void loginWithCorrectUsernameEmptyPassword() {
	
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter valid username in username textbox
//	5) Now enter empty password in the password textbox
//	6) Click on login button.
//	7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
	
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).sendKeys("aabb@gmail.com");
		
		driver.findElement(By.id("password")).click();
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).getText());
	
		String verifyLogin = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		System.out.println(verifyLogin);
		
	}
	
	
	@Test (enabled=false)
	public void loginWithEmptyUsernameValidPassword() {
	
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter empty username in username textbox
//	5) Now enter valid password in the password textbox
//	6) Click on login button.
//	7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
	
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).click();
		
		driver.findElement(By.id("password")).sendKeys("aabbccdd1234");
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).getText());
	
		String verifyLogin = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul")).getText();
		System.out.println(verifyLogin);
		
	}
	
	
	@Test (enabled=false)
	public void loginWithEmptyUsernameEmptyPassword() {
	
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter empty username in username textbox
//	5) Now enter valid password in the password textbox
//	6) Click on login button.
//	7) Proper error must be displayed(ie required username) and prompt to enter login again
	
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).click();
		
		driver.findElement(By.id("password")).sendKeys("aabbccdd1234");
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).getText());
	
		String verifyLogin = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul")).getText();
		System.out.println(verifyLogin);
		
	}
	
	
	@Test (enabled=false)
	public void loginPasswordShouldBeMasked() {
	
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter the password field with some characters.
//	5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen
	
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).sendKeys("aabb@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("aabbccdd12345678");
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		boolean isEncryped = driver.findElement(By.id("password")).getAttribute("type").equals("password");
		AssertJUnit.assertTrue(isEncryped);
		System.out.println(isEncryped);
	
		String verifyLogin = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul")).getText();
		System.out.println(verifyLogin);
		
	}
	
	
	
	@Test (enabled=false)
	public void loginHandlesCaseSensitive() {
	
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on My Account Menu
//		4) Enter the case changed username in username textbox
//		5) Enter the case chenged password in the password tetxbox
//		6) Now click on login button
//		7) Login must fail saying incorrect username/password.
	
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).sendKeys("AABB@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("AABBCCDD1234");
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).getText());
	
		String verifyLogin = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul")).getText();
		System.out.println(verifyLogin);
		
	}
	
	
	@Test 
	public void loginAuthentication() {
	
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter the case changed username in username textbox
//	5) Enter the case chenged password in the password tetxbox
//	6) Now click on login button
//	7) Once your are logged in, sign out of the site
//	8) Now press back button
//	9) User shouldn’t be signed in to his account rather a general webpage must be visible
	
		
		driver.findElement(By.id("menu-item-50")).click();
		
		driver.findElement(By.id("username")).sendKeys("aabb@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("aabbccdd1234");
		
		driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]")).click();
		
		driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/a")).click();
		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/h2")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/h2")).getText()+" Page");
		
		
	}
	

}
