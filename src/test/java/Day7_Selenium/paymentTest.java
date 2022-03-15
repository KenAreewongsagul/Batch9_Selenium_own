package Day7_Selenium;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paymentTest {

	WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
//		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void test1() {

		String email = "agent@phptravels.com";
		String password = "demoagent";
		// open up front end page(new tab)
		driver.findElement(By.xpath("(//small[contains(text(),'http://www.phptravels.net/login')])[2]")).click();

		Set<String> ids = driver.getWindowHandles();

		Iterator<String> it = ids.iterator();

		String parentID = it.next(); // old tab or window
		String childID = it.next(); // new tab or window
		
		
		driver.switchTo().window(childID);

		// input email
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input"))
				.sendKeys(email);
		// input password
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input"))
				.sendKeys(password);

        
		// click login
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[2]/div[2]/div/form/div[3]/button")).click();

		
		//click add funds
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[3]/a")).click();
		
		//click bank transfer
		driver.findElement(By.xpath("//*[@id=\"myTab\"]/div[1]/div")).click();
		
		//click pay now
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/section[1]/div/div[2]/div/div[1]/div/div/div[2]/form/div/div[2]/div/button")).click();
		
		//verify pay page
		String actualTitle = driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/p[1]")).getText();
		String expectedTitle = "Bank Name Western Bank CBP";
		
		AssertJUnit.assertEquals(actualTitle, expectedTitle);
		System.out.println("Passed");
		
		
		//click back to invoice
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/a")).click();
		
		//click logout
		driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[1]/div/div[3]/ul/li[5]/a")).click();
		
		//verify logout
		String actualPage = driver.getTitle();
		String expectedPage = "Login - PHPTRAVELS";
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(actualPage, expectedPage);
		System.out.println("Logout");
		
	}
	
}
