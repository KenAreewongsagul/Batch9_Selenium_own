package Day5_Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
	
	
	WebDriver driver;

    @BeforeMethod
	public void beforeMethod() {
//        1) Open the browser
//        2) Enter the URL “http://practice.automationtesting.in/”

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");

    }

    @Test
    public void test() {

        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("iphone", Keys.ENTER);

        List<WebElement> searchResults = driver
                .findElements(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div"));

//        for(WebElement eachItem:searchResults) {
//        String text =    eachItem.getText();
//        System.out.println("---------------------------\n"+ text + "---------------------------\n");
//        }

        /// //*[@id="search"]/div[1]/div[1]/div/span[3]/div[2]/div[9]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span[1]

        for (int i = 8; i < searchResults.size(); i++) {

            WebElement eachPrice = driver
                    .findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[" + i
                            + "]/div/div/div/div/div/div[2]/div/div/div[3]/div[1]/div/div[1]/div/a/span[1]/span[2]/span[2]"));

            System.out.println(eachPrice.getText());

            if (Integer.parseInt(eachPrice.getText()) <= 150) {
                eachPrice.click();
            }

        }

    }

	

}
