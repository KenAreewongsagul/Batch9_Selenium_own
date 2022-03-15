package Day5_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homework {
	
//		1. go to http://automationpractice.com/index.php
//	    2. click on DRESSES button
//	    3. add items on sale to cart and checkout
//	    4. continue to checkout until you see the 'authentication' page and verify it
	
	
	
	WebDriver driver;

		@BeforeMethod
		public void beforeTest() {
			
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		    driver.get("http://automationpractice.com");
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Only open browser
		   
		
		}
		
		@Test
		public void TestSalePrice() throws InterruptedException {
			
	
			driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]")).click();
			Thread.sleep(3000);
			
			List<WebElement> listDress = driver.findElements(By.xpath("//*[@id='center_column']/ul/li"));
			
			for(int i=1; i<= listDress.size(); i++) {
				
			WebElement eachPrice = driver.findElement(By.xpath("//*[@id='center_column']/ul/li["+i+"]"));
			
			// checking on sale product														//1 or 0
			if(driver.findElements(By.xpath("//*[@id='center_column']/ul/li["+i+"]/div/div[1]/div/div[2]/span[2]")).size() >0) {
				
				
//				System.out.println(driver.findElements(By.xpath("//*[@id='center_column']/ul/li["+i+"]/div/div[1]/div/div[2]/span[2]")).size() >0);
				
				  // click on product name
                driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+ i +"]/div/div[2]/h5/a")).click();
                Thread.sleep(3000);
                System.out.println(i +". ON SALE" );
                // add to cart
                driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
                Thread.sleep(3000);
                // click "continue shopping"
                driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]")).click();
                Thread.sleep(3000);
                driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
                Thread.sleep(3000);
                // back to product page
                driver.navigate().back();

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
        driver.close();
    }	

		
}