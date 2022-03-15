package Day11_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class mutiBrowser {
	
	WebDriver driver;

	@Parameters("browser")
    @BeforeClass
    public void beforeTest(String browser) {
        if (browser.equalsIgnoreCase("safari")) {
            WebDriverManager.safaridriver().setup();
            driver = new SafariDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        driver.get("https://www.google.com");
    }

    @Test
    public void searchItem() {
        System.out.println("hello");
    }

    @AfterClass
    public void afterTest() {
        // driver.quit();
    }
	
	
}
