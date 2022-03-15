package Day5_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Leng_Homework {

	private static String baseUrl =
		      "http://automationpractice.com/index.php?id_category=8&controller=category";
	
		   static By discountedProductPics =
		      By.xpath("//div[@class='product-image-container'][./parent::div/following-sibling::div//span[@class='price-percent-reduction']]");
		   static By addToCartBtn = By.xpath("//*[@id='add_to_cart']/button");
		   static By closeWindowBtn = By.xpath("//span[@title='Close window']");
		   static String xpath = "//someXpath";

		   public static void main(String[] args) {
		      WebDriverManager.chromedriver().setup();
		      WebDriver driver = new ChromeDriver();
		      driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		      
		      driver.get(baseUrl);

		      for (int i = 0; i < driver.findElements(discountedProductPics).size(); i++) {
		         List<WebElement> productPics = driver.findElements(discountedProductPics);
		         // click on Product name
		         productPics.get(i).click();
		         // go Product page
		         driver.findElement(addToCartBtn).click();
		         // dismiss the popup/confirmation popup
		         driver.findElement(closeWindowBtn).click();
		         driver.navigate().back();
		      }
		   }
	
	
}
