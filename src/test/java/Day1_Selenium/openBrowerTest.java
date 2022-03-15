package Day1_Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class openBrowerTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
//		driver.get("https://www.google.com");
		
		driver.get("http://www.wikipedia.org");

		        WebElement link;

		        link = driver.findElement(By.linkText("English"));

		        link.click();

		        Thread.sleep(5000);

		        WebElement searchBox;

		        searchBox = driver.findElement(By.id("searchInput"));

		        searchBox.sendKeys("software");

		        Thread.sleep(5000);

		        driver.quit();

	}

}
