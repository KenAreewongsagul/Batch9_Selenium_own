package Day6_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class homeworkReview {

	WebDriver driver;

	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://automationpractice.com");
//	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Only open browser
	   
	
	}
	
	@Test
	public void TestSalePrice() throws InterruptedException {
		

		driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]")).click();
		Thread.sleep(3000);
		
		List<WebElement> listDress = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));

		for(int i=1; i<= listDress.size(); i++) {
						
									//1 or 0
			if(driver.findElements(By.xpath("//*[@id='center_column']/ul/li["+i+"]/div/div[1]/div/div[2]/span[2]")).size() >0) {
			
			Actions action = new Actions(driver);
			
			WebElement discountPrice = driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+i+"]"));
			
			action.moveToElement(discountPrice).build().perform();
			
			
			driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]/div/div[2]/div[2]/a[1]/span")).click();
			Thread.sleep(3000);

            driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span/span")).click();
            Thread.sleep(3000);
            System.out.println(i +". ON SALE" );


        }else {
            System.out.println(i + ". NOT ON SALE ");
        }
    }
    // go to Cart
    driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
    Thread.sleep(3000);
    // proceed to check out
    driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
    Thread.sleep(3000);
    
    // verify "Authentication" page
    String actualPageTitle = driver.getTitle();
    String expectedPageTitle = "Login - My Store";
    
    if(expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
        System.out.println("Passed");
    }else {
        System.out.println("Failed");
        System.out.println("Expected to see > " + expectedPageTitle);
        System.out.println("The Driver got  > " + actualPageTitle);
    }
}

@AfterMethod
public void afterMethod() {
//    driver.close();
}	

	
	
}
