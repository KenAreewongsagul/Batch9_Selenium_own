package Day5_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nat_Homework {
	
	WebDriver driver;
	WebDriverWait wait;
	String email = "baabbanbc347689@gmail.com";
	String firstName = "First";
	String lastName = "Last";
	String password = "12345";
	String date = "12";
	String month = "1";
	String year = "2015";
	String company = "Kinsen llc";
	String addressStreet = "12345 Perfect St.";
	String city = "Germantown";
	String state = "Maryland";
	String zipCode = "12345";
	String mobilePhone = "123-456-7865";
	
	@BeforeMethod
	public void beforeTest() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() throws InterruptedException {
		//click on DRESSES button
		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
		//click on Special items
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='special_block_right']/div/div/a")));
		driver.findElement(By.xpath("//*[@id='special_block_right']/div/div/a")).click();
		//add all items 
		List<WebElement> specialItems = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
		int sizeOfList = specialItems.size();
		for(int i = 1 ; i <= sizeOfList ; i++) {
			//click on each item
			driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+i+"]")).click();
			wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='add_to_cart']/button")));
			//add to cart
			driver.findElement(By.xpath("//*[@id='add_to_cart']/button")).click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")));
			//click continue shopping
			driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")).click();
			driver.navigate().back();
		}
		//go to cart
		driver.findElement(By.xpath("//*[@id='header']/div[3]/div/div/div[3]/div/a")).click();
		
		//checking out
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")).click();
		//first page sign up entered email and click create new account
		driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		//fill all info
		//check male
		driver.findElement(By.id("id_gender1")).click();
		//fill in first name
		driver.findElement(By.id("customer_firstname")).sendKeys(firstName);
		//fill in last name
		driver.findElement(By.id("customer_lastname")).sendKeys(lastName);
		//fill in password
		driver.findElement(By.id("passwd")).sendKeys(password);
		//dropdown day
		WebElement dayDrop = driver.findElement(By.id("days"));
		Select dateSelect = new Select(dayDrop);
		dateSelect.selectByValue(date);
		//dropdown month
		WebElement monthDrop = driver.findElement(By.id("months"));
		Select monthSelect = new Select(monthDrop);
		monthSelect.selectByValue(month);
		//dropdown year
		WebElement yearDrop = driver.findElement(By.id("years"));
		Select yearSelect = new Select(yearDrop);
		yearSelect.selectByValue(year);
		//uncheck news letter sign up
		WebElement news = driver.findElement(By.id("newsletter"));
		if(news.isSelected()) {
			news.click();
		}
		//uncheck special sign up
		WebElement specialSignUp = driver.findElement(By.id("optin"));
		if(specialSignUp.isSelected()) {
			specialSignUp.click();
		}
		//fill in first name
		driver.findElement(By.id("firstname")).sendKeys(firstName);
		//filll in last name
		driver.findElement(By.id("lastname")).sendKeys(lastName);
		//fill in company name
		driver.findElement(By.id("company")).sendKeys(company);
		//fill in street address
		driver.findElement(By.id("address1")).sendKeys(addressStreet);
		//fill in city
		driver.findElement(By.id("city")).sendKeys(city);
		//select state from dropdown
		WebElement dropdown = driver.findElement(By.id("id_state"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(state);
		//fill in zip code
		driver.findElement(By.id("postcode")).sendKeys(zipCode);
		//fill in mobile phone number
		driver.findElement(By.id("phone_mobile")).sendKeys(mobilePhone);
		//fll in alias address
		driver.findElement(By.id("alias")).sendKeys(addressStreet);
		//click submit
		driver.findElement(By.id("submitAccount")).click();
		//add some comment
		driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea")).sendKeys("automation testing");
		//click submit
		driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button/span")).click();
		//click check agree
		driver.findElement(By.id("cgv")).click();
		//proceed to check out
		driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
		//click pay by check
		driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")).click();
		//click confirm order
		driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button/span")).click();
		//verify completed
		String orderVerify = driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[1]")).getText();
		if(orderVerify.contains("complete")) {
			System.out.println("Completed, sucessfully PASSED");
		}
	}
	
	
	
	
	

}
