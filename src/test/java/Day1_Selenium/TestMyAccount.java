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

public class TestMyAccount {

	
	WebDriver driver;
	WebDriverWait wait;
	
//	wait = new WebDriverWait(driver,30);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
	
	By accountMenu = By.id("menu-item-50");
	By loginButton = By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]");
	By userName = By.id("username");
	By password = By.id("password");
	By logoutButton = By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[6]/a");
	
	
	

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
	public void myAccountsDashboard() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on Myaccount link which leads to Dashboard
//	9) User must view Dashboard of the site
		
		
		driver.findElement(accountMenu).click();
		driver.findElement(userName).sendKeys("aabb@gmail.com");
		driver.findElement(password).sendKeys("aabbccdd1234");
		driver.findElement(loginButton).click();
		driver.findElement(accountMenu).click();
		String dashboard = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div")).getText();
		System.out.println(dashboard);
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div")).getText());
		driver.findElement(logoutButton).click();
	
		
	}
	
	
	@Test (enabled=false)
	public void myAccountsOrdersLinks() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on Myaccount link
//	9) Click on Orders link
//	10) User must view their orders on clicking orders link
		
		
		driver.findElement(accountMenu).click();
		driver.findElement(userName).sendKeys("aabb@gmail.com");
		driver.findElement(password).sendKeys("aabbccdd1234");
		driver.findElement(loginButton).click();
		driver.findElement(accountMenu).click();
		driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/nav/ul/li[2]/a")).click();
		String OrderMenu = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/div")).getText();
		System.out.println(OrderMenu);
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div")).getText());
		driver.findElement(logoutButton).click();
		
	}
	
	
	@Test (enabled=false)
	public void myAccountsOrdersDetails() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on Myaccount link
//	9) Click on Orders link
//	10) Click view button
//	11) User must view his Order details,customer details and billing details on clicking view button
		
		
		driver.findElement(accountMenu).click();
//		4) Enter registered username in username textbox
		driver.findElement(userName).sendKeys("aabb@gmail.com");
//		5) Enter password in password textbox
		driver.findElement(password).sendKeys("aabbccdd1234");
//		6) Click on login button
		driver.findElement(By.id("body")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());
//		8) Click on Myaccount link which leads to Dashboard	
		driver.findElement(accountMenu).click();
//		9) Click on Orders link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")).click();
//		10) Click view button
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/table/tbody/tr/td[5]/a")).click();
//		11) User must view Order Number Ordered date and Status of the order on clicking view button		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("/html/body")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("/html/body")).getText());
	
		
	}
	
	@Test 
	public void myAccountsOrdersStatus() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on Myaccount link
//	9) Click on Orders link
//	10) Click view button
//	11) User must view Order Number Ordered date and Status of the order on clicking view button
		
		driver.findElement(accountMenu).click();
//		4) Enter registered username in username textbox
		driver.findElement(userName).sendKeys("aabb@gmail.com");
//		5) Enter password in password textbox
		driver.findElement(password).sendKeys("aabbccdd1234");
//		6) Click on login button
		driver.findElement(By.id("body")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());
//		8) Click on Myaccount link which leads to Dashboard	
		driver.findElement(accountMenu).click();
//		9) Click on Orders link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")).click();
//		10) Click view button
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/table/tbody/tr/td[5]/a")).click();
//		11) User must view Order Number Ordered date and Status of the order on clicking view button		
		AssertJUnit.assertTrue(driver.findElement(By.xpath("/html/body")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("/html/body")).getText());
		
		
		
		
		
	}
	
	
	@Test 
	public void myAccountsAddressFunctionalityBilling() throws InterruptedException {
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on Myaccount link which leads to Dashboard
//	9) Click on Address link
//	10) User must view billing address and ship address
		
		
		driver.findElement(accountMenu).click();
//		4) Enter registered username in username textbox
		driver.findElement(userName).sendKeys("aabb@gmail.com");
//		5) Enter password in password textbox
		driver.findElement(password).sendKeys("aabbccdd1234");
//		6) Click on login button
		driver.findElement(By.id("body")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());
//		8) Click on Myaccount link which leads to Dashboard	
		driver.findElement(accountMenu).click();
//		9) Click on Address link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")).click();
//		10) User must view billing address and ship address
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div")).getText());
	

		
		
	}
	
	
	@Test 
	public void myAccountsAddressFunctionalityShipping() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on Myaccount link
//	9) Click on Address link
//	10) Click Edit on Shipping Address
//	11) User can Edit Shipping address
		
		driver.findElement(accountMenu).click();
//		4) Enter registered username in username textbox
		driver.findElement(userName).sendKeys("aabb@gmail.com");
//		5) Enter password in password textbox
		driver.findElement(password).sendKeys("aabbccdd1234");
//		6) Click on login button
		driver.findElement(By.id("body")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());
//		8) Click on Myaccount link which leads to Dashboard	
		driver.findElement(accountMenu).click();
//		9) Click on Address link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")).click();
//		10) Click Edit on Shipping Address
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")).click();
//		11) User can Edit Shipping address	
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/form")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/form")).getText());
		
		
	}
	
	
	@Test 
	public void myAccountsAccountDetails() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on Myaccount link
//	9) Click on Account details
//	10) User can view account details where he can change his password also.
		
		driver.findElement(accountMenu).click();
//		4) Enter registered username in username textbox
		driver.findElement(userName).sendKeys("aabb@gmail.com");
//		5) Enter password in password textbox
		driver.findElement(password).sendKeys("aabbccdd1234");
//		6) Click on login button
		driver.findElement(By.id("body")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());
//		8) Click on Myaccount link which leads to Dashboard	
		driver.findElement(accountMenu).click();
//		9) Click on Address link
		driver.findElement(By.xpath("//*[@id='content']/nav/a")).click();
//		10) Click Edit info
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")).click();
//		11) User can Edit 	
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/form")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/form")).getText());
		
		
	}
	
	
	@Test 
	public void myAccountsLogOut() throws InterruptedException {
		
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on My Account Menu
//	4) Enter registered username in username textbox
//	5) Enter password in password textbox
//	6) Click on login button
//	7) User must successfully login to the web page
//	8) Click on My Account link
//	9) Click on Logout button
//	10) On clicking logout,User successfully comes out from the site
		
		driver.findElement(accountMenu).click();
//		4) Enter registered username in username textbox
		driver.findElement(userName).sendKeys("aabb@gmail.com");
//		5) Enter password in password textbox
		driver.findElement(password).sendKeys("aabbccdd1234");
//		6) Click on login button
		driver.findElement(By.id("body")).click();
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
//		7) User must successfully login to the web page
		System.out.println(driver.getTitle());
//		8) Click on Myaccount link which leads to Dashboard	
		driver.findElement(accountMenu).click();
//		9) Click on Logout button
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")).click();
//		10) On clicking logout,User successfully comes out from the site
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]")).isDisplayed());
		System.out.println(driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]")).getText());
		
		
	}
	
	
}
