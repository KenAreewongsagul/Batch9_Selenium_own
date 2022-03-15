package Day5_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pete_Homework {
	
WebDriver driver;
	

	@BeforeMethod
	public void beforeMethod() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1() {
		

		//click dress button
		driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a")).click();
		//list of dress
		List<WebElement> items = driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li"));
		//access to the item
//		for (WebElement webElement : items) {
//			System.out.println(webElement.getText());
//			
//		}
		for (int i = 1; i <= items.size(); i++) {
			//print product detail
			WebElement item = driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+i+"]"));
			System.out.println( i + ". "+item.getText());
			
			// checking on sale product
            if(!driver.findElements(By.xpath("//*[@id=\"center_column\"]/ul/li[" + i + "]/div/div[1]/div/div[2]/span[3]")).isEmpty()) {
                
                // click on product name
                driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li["+ i +"]/div/div[2]/h5/a")).click();
                System.out.println("ON SALE" );
                // add to cart
                driver.findElement(By.xpath("//*[@id=\"add_to_cart\"]/button")).click();
                System.out.println("Added to cart");
                // click "continue shopping"
                driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]")).click();
                driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span")).click();
                // back to product page
                driver.navigate().back();

            }else {
                System.out.println("NOT ON SALE ");
            }
		}
            
            // go to Cart
            driver.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")).click();
            // proceed to check out
            driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span")).click();
            
            // verify "Authentication" page
            String actualTitle = driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText();
            String expectedTitle = "AUTHENTICATION";
            
            if(expectedTitle.equalsIgnoreCase(actualTitle)) {
                System.out.println("Passed");
            }else {
                System.out.println("Failed");
                System.out.println("Expected to see > " + expectedTitle);
                System.out.println("The Driver got  > " + actualTitle);
            }
		
		
	}
	
	

}
