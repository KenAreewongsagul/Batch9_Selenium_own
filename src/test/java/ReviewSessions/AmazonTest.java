package ReviewSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
	
	/*
	 * Go to Amazon.com
	 * send "any key"
	 * click search
	 * select one of the item
	 * add it to cart
	 * validate the item in the cart
	 * remove the item
	 * validate the cart is empty
	 * navigate to Youtube
	 * validate the title is youtube
	 * search video
	 * play the video
	 * */
	
WebDriver driver;

	
	@BeforeMethod
	public void beforeTest() {
		
	
    WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    driver.get("https://www.amazon.com");
    driver.manage().window().maximize();
    
	
	}
	
	@Test
	public void AmazonTest() throws InterruptedException {
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Sony camera");
		Thread.sleep(2000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
//		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[2]/div/div[3]/span/div[1]/div/div/div[4]/ul/li[1]/span/a/span")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"p_n_feature_nineteen_browse-bin/10099178011\"]/span/a/span")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//*[@id=\"p_n_feature_eleven_browse-bin/21608136011\"]/span/a/span")).click();
//		Thread.sleep(3000);
		driver.findElement(By.linkText("Sony Alpha 1 Full-frame Interchangeable Lens Mirrorless Camera")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("style_name_2")).click();
		
		Thread.sleep(3000);
//		driver.findElement(By.id("quantity_1")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("attachSiAddCoverage")).click();
		driver.findElement(By.id("nav-cart-count")).click();
		
		Thread.sleep(3000);
		String checkItems = driver.findElement(By.id("sc-subtotal-label-buybox")).getText();
		String checkAmount = driver.findElement(By.id("sc-subtotal-amount-buybox")).getText();
		System.out.println(checkItems+checkAmount);
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[4]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[3]/div[4]/div/div[2]/div[1]/div/form/div[2]/div[1]/div[4]/div/div[1]/div/div/div[2]/div[1]/span[2]/span/input")).click();
		
		Thread.sleep(3000);
		String checkItemsEmpty = driver.findElement(By.id("sc-subtotal-label-activecart")).getText();
		String checkAmountEmpty  = driver.findElement(By.id("sc-subtotal-amount-activecart")).getText();
		System.out.println(checkItemsEmpty+checkAmountEmpty);
		
		Thread.sleep(5000);
		driver.navigate().to("https://www.youtube.com");
		
		String actualPageTitle = driver.getTitle();
		String expectedPageTitle = "Youtube";
		
		if(expectedPageTitle.equalsIgnoreCase(actualPageTitle)) {
			System.out.println("Title matched and passed");
		}else {
			System.out.println("Failed Title no matched");
		
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys("ihook channel");
		Thread.sleep(3000);
		driver.findElement(By.id("search-icon-legacy")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("ถือกล้องเดินเที่ยว : Wakefield Chapel Park | iHooK Channel")).click();
	
		Thread.sleep(240000);
		
		driver.close();
		
		
	}
	
	
	
	
	@AfterMethod
	public void afterTest() {
//		driver.close();
	}
	

}
