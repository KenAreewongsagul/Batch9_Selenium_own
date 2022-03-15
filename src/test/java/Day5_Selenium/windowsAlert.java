package Day5_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowsAlert {
	
	
	
	WebDriver driver;

	WebDriverWait wait;


	
	
	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Only open browser
	    
	}
	
	

    @Test
    public void alert1() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[1]/button")).click();
        String firstAlertText = driver.switchTo().alert().getText();
        System.out.println(firstAlertText);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
    }
    
    @Test
    public void alert2() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[2]/button")).click();
        String secondAlertText = driver.switchTo().alert().getText();
        System.out.println(secondAlertText);
        driver.switchTo().alert().dismiss();
        Thread.sleep(3000);
    }
    
    @Test
    public void alert3() {
        driver.findElement(By.xpath("//*[@id='content']/div/ul/li[3]/button")).click();
        String thirdAlertText = driver.switchTo().alert().getText();
        System.out.println(thirdAlertText);

        String enteredText = "Batch9";

        driver.switchTo().alert().sendKeys(enteredText);
        driver.switchTo().alert().accept();

        String actualTextRetrieved = driver.findElement(By.xpath("//*[@id=\"result\"]")).getText();

        if (actualTextRetrieved.contains(enteredText)) {
            System.out.println("Prompt Took the text successfully and displayed it on the page");
        }
    }
 
    
    
    
    
		
    	@AfterMethod
		public void afterTest() {
    		
    		
    		driver.close();
			
		}
		
		
		
	
	
	
	
	
}

