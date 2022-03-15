package Day6_Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assertionsTest {

	WebDriver driver;

    @BeforeMethod
	public void beforeMethod() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
    public void assertFalseTest() {

        // checkbox 1
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));

        AssertJUnit.assertFalse(checkbox1.isSelected());
        // Assert.assertFalse(false); -- Pass
        System.out.println("hello");

        // checkbox2

        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        AssertJUnit.assertFalse(checkbox2.isSelected());
        // Assert.assertFalse(true); --> failed
        System.out.println("hello2");

    }

    @Test
    public void assertTrueTest() {

        AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).isDisplayed());
        System.out.println("code didn't throw an exception on assertTrueTest");
        // Assert.assertTrue(true);

    }
    
    
    @Test
    public void assertEqualsTest() {
        String actualTitle = driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
        
        String expectedTitle = "Checkboxez";
        
        
        
        AssertJUnit.assertEquals(actualTitle, expectedTitle);
        
        
        
        
    }
}