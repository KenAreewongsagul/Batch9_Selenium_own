package Day1_Selenium;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestShop {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	By shopMenu = By.xpath("//*[@id='menu-item-40']/a");
	By filterButton = By.xpath("//*[@id='woocommerce_price_filter-2']/form/div/div[2]/button");
	
//	By registerPassword = By.id("reg_password");
//	String email = "123abc@gmail.com";
//	String password = "TechCircle789!qe";
	
//	wait = new WebDriverWait(driver,30);
//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("welcome")));
	

	@BeforeMethod
	public void beforeTest() {
		
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://practice.automationtesting.in");
//	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	
	@AfterMethod (enabled=false)
	public void afterTest() {
		
		driver.close();
	}
	    
	@Test 
	public void ShopFilterPriceFunctionality() {
		
//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on Shop Menu
//	4) Adjust the filter by price between 150 to 450 rps
//	5) Now click on Filter button
//	6) User can view books only between 150 to 450 rps price
	
	
	
		driver.findElement(shopMenu).click();
		String currentUrl = driver.getCurrentUrl();
		WebElement slider = driver.findElement(By.xpath(
				"//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']//span[2]"));
		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(slider, -28, 0).build();
		action.perform();
		driver.findElement(filterButton).click();
		List<WebElement> books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li[\"i\"]"));
		for (WebElement book : books) {
			System.out.println(book.getText());
		}
		
		String nextUrl = driver.getCurrentUrl();
		Assert.assertNotEquals(currentUrl, nextUrl);
		
	}


	
		@Test 
		public void ShopProductCategoriesFunctionality() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click any of the product links available in the product category
//		5) Now user can view only that particular product

			driver.findElement(shopMenu).click();
			String currentUrl = driver.getCurrentUrl();
			driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[1]/h3")).click();
			String nextUrl = driver.getCurrentUrl();
			Assert.assertNotEquals(currentUrl, nextUrl);
			System.out.println(driver.getTitle());

		}

		@Test
		public void ShopDefaultSortingFunctionalityPopularity() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on Sort by Popularity item in Default sorting dropdown
//		5) Now user can view the popular products only

			driver.findElement(shopMenu).click();
			String currentUrl = driver.getCurrentUrl();
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
			select.selectByValue("popularity");
			String nextUrl = driver.getCurrentUrl();
			Assert.assertNotEquals(currentUrl, nextUrl);
			List<WebElement> books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li[\"i\"]"));
			for (WebElement book : books) {
				System.out.println(book.getText());
			}

		}

		@Test
		public void ShopDefaultSortingFunctionalityRating() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on Sort by Average ratings in Default sorting dropdown
//		5) Now user can view the popular products only
			
			driver.findElement(shopMenu).click();
			String currentUrl = driver.getCurrentUrl();
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
			select.selectByValue("rating");
			String nextUrl = driver.getCurrentUrl();
			Assert.assertNotEquals(currentUrl, nextUrl);
			List<WebElement> books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li[\"i\"]"));
			for (WebElement book : books) {
				System.out.println(book.getText());
			}

		}

		@Test
		public void ShopDefaultSortingFunctionalityDate() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on Sort by Newness ratings in Default sorting dropdown
//		5) Now user can view the popular products only

			driver.findElement(shopMenu).click();
			String currentUrl = driver.getCurrentUrl();
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
			select.selectByValue("date");
			String nextUrl = driver.getCurrentUrl();
			Assert.assertNotEquals(currentUrl, nextUrl);
			List<WebElement> books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li[\"i\"]"));
			for (WebElement book : books) {
				System.out.println(book.getText());
			}

		}

		@Test
		public void ShopDefaultSortingFunctionalityPrice() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on Sort by Low to High Item in Default sorting dropdown
//		5) Now user can view the popular products only

			driver.findElement(shopMenu).click();
			String currentUrl = driver.getCurrentUrl();
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
			select.selectByValue("price");
			String nextUrl = driver.getCurrentUrl();
			Assert.assertNotEquals(currentUrl, nextUrl);
			List<WebElement> books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li[\"i\"]"));
			for (WebElement book : books) {
				System.out.println(book.getText());
			}

		}

		@Test
		public void ShopDefaultSortingFunctionalityPriceDesc() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on Sort by High to Low Item in Default sorting dropdown
//		5) Now user can view the popular products only

			driver.findElement(shopMenu).click();
			String currentUrl = driver.getCurrentUrl();
			Select select = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
			select.selectByValue("price-desc");
			String nextUrl = driver.getCurrentUrl();
			Assert.assertNotEquals(currentUrl, nextUrl);
			List<WebElement> books = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li[\"i\"]"));
			for (WebElement book : books) {
				System.out.println(book.getText());
			}

		}

		@Test
		public void ShopReadMoreFunctionality() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on read more button in home page
//		5) Read More option indicates the Out Of Stock.
//		6) User cannot add the product which has read more option as it was out of stock.

			driver.findElement(shopMenu).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[7]/a[2]")).click();	
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[2]/p")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[2]/p")).getText());

		}

		@Test
		public void ShopSaleFunctionality() {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on Sale written product in home page
//		5) User can clearly view the actual price with old price striken for the sale written products

			driver.findElement(shopMenu).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/span[1]")).click();
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/div[1]/p")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/div[1]/p")).getText());
		}

		@Test
		public void ShopAddBasketViewBasketFunctionality() throws InterruptedException {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on the Add To Basket button which adds that book to your basket
//		5) User can view that Book in the Menu item with price .
//		6) Now click on View Basket link which navigates to proceed to check out page.
//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always < subtotal because taxes are added in the subtotal
//		9) Now click on Proceed to Check out button which navigates to payment gateway page.
//		10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
//		12) Now click on Place Order button to complete process
//		13) On clicking place order button user completes his process where the page navigates to Order confirmation page with order details,bank details,customer details and billing details.

			driver.findElement(shopMenu).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a")).getText());
			driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a")).click();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table")).getText());
			driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
			System.out.println(driver.getTitle());
			// fake info
			Faker faker = new Faker();
			// input info
			driver.findElement(By.id("billing_first_name")).sendKeys(faker.name().firstName());
			driver.findElement(By.id("billing_last_name")).sendKeys(faker.name().firstName());
			driver.findElement(By.id("billing_email")).sendKeys(faker.name().firstName() + "@gmail.com");
			driver.findElement(By.id("billing_phone")).sendKeys(faker.phoneNumber().cellPhone());
			driver.findElement(By.id("billing_address_1")).sendKeys(faker.address().streetAddress());
			driver.findElement(By.id("billing_city")).sendKeys(faker.address().city());
			driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")).click();
			driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[7]")).click();
			driver.findElement(By.id("billing_postcode")).sendKeys(faker.address().zipCode());
			driver.findElement(By.xpath("//input[@id='place_order']")).click();
			Thread.sleep(3000);
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]")).getText());

		}

		@Test
		public void ShopAddBasketViewBasketThroughItemLink() throws InterruptedException {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on the Add To Basket button which adds that book to your basket
//		5) User can view that Book in the Menu item with price .
//		6) Now click on Item link which navigates to proceed to check out page.
//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always < subtotal because taxes are added in the subtotal
//		9) Now click on Proceed to Check out button which navigates to payment gateway page.
//		10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//		11) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
//		12) Now click on Place Order button to complete process
//		13) On clicking place order button user completes his process where the page navigates to Order confirmation page
//		with order details,bank details,customer details and billing details

			driver.findElement(shopMenu).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a")).getText());
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[3]")))).click();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table")).getText());
			driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
			System.out.println(driver.getTitle());
			// fake info
			Faker faker = new Faker();
			// input info
			driver.findElement(By.id("billing_first_name")).sendKeys(faker.name().firstName());
			driver.findElement(By.id("billing_last_name")).sendKeys(faker.name().firstName());
			driver.findElement(By.id("billing_email")).sendKeys(faker.name().firstName() + "@gmail.com");
			driver.findElement(By.id("billing_phone")).sendKeys(faker.phoneNumber().cellPhone());
			driver.findElement(By.id("billing_address_1")).sendKeys(faker.address().streetAddress());
			driver.findElement(By.id("billing_city")).sendKeys(faker.address().city());
			driver.findElement(By.xpath("//a[@class='select2-choice select2-default']")).click();
			driver.findElement(By.xpath("//*[@id=\"select2-results-2\"]/li[7]")).click();
			driver.findElement(By.id("billing_postcode")).sendKeys(faker.address().zipCode());
			driver.findElement(By.xpath("//input[@id='place_order']")).click();
			Thread.sleep(3000);
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]")).isDisplayed());
			System.out.println(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]")).getText());

		}

		@Test
		public void ShopAddBasketViewBasketTaxFunctionality() throws InterruptedException {
			
//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Click on the Add To Basket button which adds that book to your basket
//		5) User can view that Book in the Menu item with price .
//		6) Now click on Item link which navigates to proceed to check out page.
//		7) Now user can find total and subtotal values just above the Proceed to Checkout button.
//		8) The total always < subtotal because taxes are added in the subtotal
//		9) The tax rate variers for India compared to other countries
//		10) Tax rate for indian should be 2% and for abroad it should be 5%

			driver.findElement(shopMenu).click();
			driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a")).getText());
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions
					.elementToBeClickable(driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[3]")))).click();
			System.out.println(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table")).getText());
			driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"s2id_billing_country\"]")).isDisplayed());
			driver.findElement(By.xpath("//*[@id=\"s2id_billing_country\"]")).click();
			List<WebElement> countries = driver.findElements(By.xpath("//*[@id=\"select2-results-1\"]/li"));
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter your full name of country");
			String input = scan.nextLine();
			for (WebElement country : countries) {
				String c = country.getText();
				System.out.println(c);
				if (c.equalsIgnoreCase(input)) {
					if (c.equalsIgnoreCase("India")) {
						country.click();
						Thread.sleep(3000);
						String subtotal = driver
								.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[1]/td/span")).getText()
								.replace("₹", "");
						String tax = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[2]/td"))
								.getText().replace("₹", "");
						if ((Double.parseDouble(tax) / Double.parseDouble(subtotal)) * 100 == 2) {
							System.out.println(c + " tax is 2%");
							break;
						}

					}
					country.click();
					String subtotal = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[1]/td/span"))
							.getText().replace("₹", "");
					String tax = driver.findElement(By.xpath("//*[@id=\"order_review\"]/table/tfoot/tr[2]/td")).getText()
							.replace("₹", "");
					if ((Double.parseDouble(tax) / Double.parseDouble(subtotal)) * 100 == 5) {
						System.out.println(c + " tax is 5%");
						break;
					}

				}
			}

		}

}
