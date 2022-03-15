package Day11_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class parallelTest {

	
public WebDriver driver;
    
    
    @Test
    public void SafariTest() {
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
        driver.get("https://www.google.com");
    }
    
    @Test
    public void ChromeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }
    
	
	
	
	
	
}
