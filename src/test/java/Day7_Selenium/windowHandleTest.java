package Day7_Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandleTest {

	WebDriver driver;
	String Email = "ken@gmail.com";
	String firstName = "First";
	String lastName = "Last";
	String password = "12345678";
	String date = "18";
	String month = "08";
	String year = "1982";
	String company = "BUEI llc";
	String addressStreet = "12345 H St. NW";
	String city = "Washington";
	String state = "DC";
	String zipCode = "12345";
	String mobilePhone = "123-456-7890";

	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://phptravels.com/");
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Only open browser
	   
	}
	
	@Test
	public void test1() {
		
		String Email = "agent@phptravels.com";
        String Password  = "demoagent";
		
		driver.findElement(By.xpath("/html/body/header/div/nav/a[5]")).click();
		
		System.out.println("Befor switching"+ driver.getTitle());
		
		Set<String> ids = driver.getWindowHandles();
		
		Iterator<String> it = ids.iterator();
		
		String parentID = it.next();
		
		String childId = it.next();
		
		driver.switchTo().window(childId);
		
		System.out.println("After switching to child window"+ driver.getTitle());
		
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input")).sendKeys(Email);
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input")).sendKeys(Password);
		
		
//		driver.switchTo().window(parentID);
		
		
		
		
		
		
		
		
		
	}
	
	
}

