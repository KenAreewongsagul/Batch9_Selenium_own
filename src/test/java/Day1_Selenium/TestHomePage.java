package Day1_Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestHomePage {

	WebDriver driver;
	WebDriverWait wait;

	By shopMenu = By.xpath("//*[@id='menu-item-40']/a");
	By homeMenu = By.xpath("//*[@id='content']/nav/a");

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
	
	@AfterMethod
	public void afterTest() {
		driver.close();
	}	

	@Test(enabled = false)

	public void  HomePagewiththreeSlidersonly() throws InterruptedException {

//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on Shop Menu
//	4) Now click on Home menu button
//	5) Test whether the Home page has Three Sliders only
//	6) The Home page must contains only three sliders

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> slide = driver.findElements(By.xpath("//*[@id='n2-ss-6']/div[1]/div/div/div"));

		AssertJUnit.assertTrue(slide.size() == 3);

		System.out.println("Home page has only 3 slide");

	}

	@Test(enabled = false)

	public void  HomepagewiththreeArrivalsonly() {

//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on Shop Menu
//	4) Now click on Home menu button
//	5) Test whether the Home page has Three Arrivals only
//	6) The Home page must contains only three Arrivals

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

	}

	@Test(enabled = false)

	public void  HomepageImagesinArrivalsnavigate() {

//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on Shop Menu
//	4) Now click on Home menu button
//	5) Test whether the Home page has Three Arrivals only
//	6) The Home page must contains only three Arrivals
//	7) Now click the image in the Arrivals
//	8) Test whether it is navigating to next page where the user can add that book into his basket.
//	9) Image should be clickable and should navigate to next page where user can add that book to his basket

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {
				
				AssertJUnit.assertEquals(driver.findElement(By.xpath("(//button[normalize-space()='Add to basket'])[1]")).getText(),
						"ADD TO BASKET");

				System.out.println("Arrivals can add that book into his basket.");

			} else {

				driver.navigate().back();

			}

		}

	}

	@Test(enabled = false)

	public void  HomepageArrivalsImagesDescription() {

//	1) Open the browser
//	2) Enter the URL “http://practice.automationtesting.in/”
//	3) Click on Shop Menu
//	4) Now click on Home menu button
//	5) Test whether the Home page has Three Arrivals only
//	6) The Home page must contains only three Arrivals
//	7) Now click the image in the Arrivals
//	8) Test whether it is navigating to next page where the user can add that book into his basket.
//	9) Image should be clickable and should navigate to next page where user can add that book to his basket
//	10) Click on Description tab for the book you clicked on.
//	11) There should be a description regarding that book the user clicked on

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li")).click();

				String orderVerify = driver.findElement(By.xpath("//*[@id='content']/div/div[3]")).getText();
				if (orderVerify.contains("Description")) {
					
					AssertJUnit.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Product Description']")).getText(),
							"Product Description");
					System.out.println("Description, sucessfully PASSED");

					driver.navigate().back();

				}

			} else {

				System.out.println("OUT OF STOCK.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li")).click();

				String orderVerify = driver.findElement(By.xpath("//*[@id='content']/div/div[3]")).getText();
				if (orderVerify.contains("Description")) {
					
					AssertJUnit.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Product Description']")).getText(),
							"Product Description");
					System.out.println("Description, sucessfully PASSED");

					driver.navigate().back();
				}
			}
		}
	}

	@Test(enabled = false)

	public void  HomepageArrivalsImagesReviews() {

//		1) Open the browser
//		2) Enter the URL “http://practice.automationtesting.in/”
//		3) Click on Shop Menu
//		4) Now click on Home menu button
//		5) Test whether the Home page has Three Arrivals only
//		6) The Home page must contains only three Arrivals
//		7) Now click the image in the Arrivals
//		8) Test whether it is navigating to next page where the user can add that book into his basket.
//		9) Image should be clickable and should navigate to next page where user can add that book to his basket
//		10) Now clock on Reviews tab for the book you clicked on.
//		11) There should be a Reviews regarding that book the user clicked on

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String orderVerify = driver.findElement(By.xpath("//*[@id='content']/div/div[3]")).getText();
				if (orderVerify.contains("Reviews")) {
					
					AssertJUnit.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Reviews']")).getText(), "Reviews");
					System.out.println("Reviews, sucessfully PASSED");

					driver.navigate().back();

				}

			} else {

				System.out.println("OUT OF STOCK.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String orderVerify = driver.findElement(By.xpath("//*[@id='content']/div/div[3]")).getText();
				if (orderVerify.contains("Reviews")) {
					
					AssertJUnit.assertEquals(driver.findElement(By.xpath("//h2[normalize-space()='Reviews']")).getText(), "Reviews");
					System.out.println("Reviews, sucessfully PASSED");

					driver.navigate().back();
				}
			}
		}
	}

	@Test(enabled = false)

	public void  HomepageArrivalsImagesAddtoBasket() {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and should navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket

		driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		driver.findElement(By.xpath("//*[@id='content']/nav/a")).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed());
				
				System.out.println("Total prices in bassket : " + totalPrice);



			} else {

				System.out.println("OUT OF STOCK.");


				driver.navigate().back();
			}
		}
	}

	@Test(enabled = false)

	public void  HomepageArrivalsAddtoBasketwithmorebooks() {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) User can add a book by clicking on Add To Basket button which adds that book in to his Basket
//			13) Select more books than the books in stock.Ex if the stock has 20 books, try to add 21.
//			14) Click the add to basket button
//			15) Now it throws an error prompt like you must enter a value between 1 and 20

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);
				
				String cartBefore = driver.findElement(By.id("wpmenucartli")).getText();

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/div/input")).sendKeys("7752");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				String cartAfter = driver.findElement(By.id("wpmenucartli")).getText();
				AssertJUnit.assertTrue(cartBefore.equals(cartAfter));


			} else {

				System.out.println("OUT OF STOCK.");


				driver.navigate().back();
			}
		}
	}

	@Test(enabled = false)

	public void  HomeArrivalsAddtoBasketItems() {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();
				
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed());

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();


			} else {

				System.out.println("OUT OF STOCK.");



				driver.navigate().back();
			}
		}
	}

	@Test(enabled = true)

	public void HomeArrivalsAddtoBasketItemsCoupon() throws InterruptedException {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
//			14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
//			15) User can able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");
				
				driver.findElement(By.xpath("//input[@name='apply_coupon']")).click();
				
				System.out.println("Coupon Applied :"
						+ driver.findElement(By.xpath("//td[@data-title='Coupon: krishnasakinala']")).getText());

				AssertJUnit.assertTrue(driver.findElement(By.xpath("//td[@data-title='Coupon: krishnasakinala']")).isDisplayed());



			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test(enabled = false)

	public void HomeArrivalsAddtoBasketItemsCouponvalueless450() throws InterruptedException {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
//			14) Enter the Coupon code as ‘krishnasakinala’ to get 50rps off on the total.
//			15) User can not able to apply coupon by entering ‘krishnasakinala’ in the coupon textbox which give 50rps off on the total price
//			because the coupon is applicable for the book price > 450 rps				

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[@id='body']//li[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@id='body']//li[1]")).getText());


			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test(enabled = false)

	public void HomeArrivalsAddtoBasketItemsRemovebook() throws InterruptedException {

//				
//					1) Open the browser
//				    2) Enter the URL “http://practice.automationtesting.in/”
//					3) Click on Shop Menu
//					4) Now click on Home menu button
//					5) Test whether the Home page has Three Arrivals only
//					6) The Home page must contains only three Arrivals
//					7) Now click the image in the Arrivals
//					8) Test whether it is navigating to next page where the user can add that book into his basket.
//					9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//					10) Click on the Add To Basket button which adds that book to your basket
//					11) User can view that Book in the Menu item with price.
//					12) Now click on Item link which navigates to proceed to check out page.
//					13) Now click on Remove this icon in Check out page which removes that book from the grid.
//					14) User has the feasibility to remove the book at the time of check out also	

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//p[@class='cart-empty']")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//p[@class='cart-empty']")).getText());


			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test(enabled = false)

	public void HomeArrivalsAddtoBasketItemsAddbook() throws InterruptedException {

//					1) Open the browser
//					2) Enter the URL “http://practice.automationtesting.in/”
//					3) Click on Shop Menu
//					4) Now click on Home menu button
//					5) Test whether the Home page has Three Arrivals only
//					6) The Home page must contains only three Arrivals
//					7) Now click the image in the Arrivals
//					8) Test whether it is navigating to next page where the user can add that book into his basket.
//					9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//					10) Click on the Add To Basket button which adds that book to your basket
//					11) User can view that Book in the Menu item with price.
//					12) Now click on Item link which navigates to proceed to check out page.
//					13) Click on textbox value under quantity in Check out page to add or subtract books.
//					14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
//					15) Now click on Update Basket to reflect those changes
//					16) User has the feasibility to Update Basket at the time of check out.	

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("2");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();
				System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText());
				AssertJUnit.assertFalse(driver.findElement(By.xpath("//input[@name='update_cart']")).isEnabled());

				Thread.sleep(5000);


			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test(enabled = false)

	public void HomeArrivalsAddtoBasketItemsCheckoutBookFinalprice() throws InterruptedException {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) Now User can find the Total price of the book in the Check out grid.
//			14) User has the feasibility to find the total price of the books at to find the total price of the books at the time of check out	

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("2");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();

				Thread.sleep(5000);

				String totalPrice2 = driver
						.findElement(
								By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span"))
						.getText();
				AssertJUnit.assertTrue(driver
						.findElement(
								By.xpath("//td[@class='product-subtotal']//span[@class='woocommerce-Price-amount amount']"))
						.isDisplayed());
				System.out.println("Total prices in bassket : " + totalPrice2);



			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test(enabled = false)

	public void HomeArrivalsAddtoBasketItemsCheckoutUpdateBasket() throws InterruptedException {

//			
//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) Click on textbox value under quantity in Check out page to add or subtract books.
//			14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
//			15) Now click on Update Basket to reflect those changes
//			16) User has the feasibility to Update Basket at the time of check out

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in bassket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("2");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();

				Thread.sleep(5000);

				String totalPrice2 = driver
						.findElement(
								By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span"))
						.getText();
				System.out.println("Total prices in bassket : " + totalPrice2);

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("3");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();
				
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//div[@class='woocommerce-message']")).getText());

				Thread.sleep(5000);



			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test(enabled = false)

	public void HomeArrivalsAddtoBasketItemsCheckoutTotalAndSubtotalcondition() throws InterruptedException {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//			14) The total always < subtotal because taxes are added in the subtotal
//			15) Total

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in basket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("2");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();

				Thread.sleep(5000);

				String subtotal = driver.findElement(By.xpath("//td[@data-title='Subtotal']")).getText();
				String total = driver.findElement(By.xpath("//tr[@class='order-total']//td[@data-title='Total']")).getText();
				System.out.println("Subtotal: " + subtotal);
				System.out.println("Total: " + total);
				AssertJUnit.assertFalse(subtotal.equals(total));


			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test(enabled = false)

	public void HomeArrivalsAddtoBasketItemsCheckoutfunctionality() throws InterruptedException {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//			14) The total always < subtotal because taxes are added in the subtotal
//			15) Now click on Proceed to Check out button which navigates to payment gateway page.
//			16) Clicking on Proceed to Checkout button leads to payment gateway page
//			17)Clicking on Proceed to Checkout button leads to payment gateway page

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in basket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("2");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();

				Thread.sleep(5000);

				String totalPrice2 = driver
						.findElement(
								By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span"))
						.getText();
				System.out.println("Total prices in basket : " + totalPrice2);

				String subTotal = driver
						.findElement(By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[1]")).getText();
				System.out.println("SubTotal prices in basket : " + subTotal);
				
				String currentUrl = driver.getCurrentUrl();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/div/a")).click();
				
				String nextUrl = driver.getCurrentUrl();
				
				AssertJUnit.assertFalse(currentUrl.equals(nextUrl));
				
				System.out.println(driver.getTitle());

				
				


			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test (enabled = false)

	public void HomeArrivalsAddtoBasketItemsCheckoutPaymentGateway() throws InterruptedException {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13)Now user can find total and subtotal values just above the Proceed to Checkout button.
//			14)The total always < subtotal because taxes are added in the subtotal
//			15)Now click on Proceed to Check out button which navigates to payment gateway page.
//			16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
//			17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
//			18)User has the feasibility to add coupon in the payment gateway page and also he can find billing,order and additional details.

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in basket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("2");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();

				Thread.sleep(5000);


				driver.findElement(By.xpath("//*[@id='coupon_code']")).sendKeys("krishnasakinala");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/div/input[2]"))
						.click();

				String totalPrice2 = driver
						.findElement(
								By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span"))
						.getText();
				System.out.println("Total prices in basket : " + totalPrice2);

				String subTotal = driver
						.findElement(By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[1]")).getText();
				System.out.println("SubTotal prices in basket : " + subTotal);

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/div/a")).click();
				Thread.sleep(5000);

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
//				18)User has the feasibility to add coupon in the payment gateway page and also he can find billing,order and additional details.
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[2]/div/h3")).isDisplayed());
				driver.findElement(By.xpath("//a[normalize-space()='Click here to enter your code']")).click();
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]/form[2]/p[2]/input")).isEnabled());
				driver.findElement(By.xpath("(//input[@id='payment_method_cod'])[1]")).click();



			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

	@Test (enabled = false)
	public void HomeArrivalsAddtoBasketItemsCheckoutPaymentGatewayPlaceorder() throws InterruptedException {

//			1) Open the browser
//			2) Enter the URL “http://practice.automationtesting.in/”
//			3) Click on Shop Menu
//			4) Now click on Home menu button
//			5) Test whether the Home page has Three Arrivals only
//			6) The Home page must contains only three Arrivals
//			7) Now click the image in the Arrivals
//			8) Test whether it is navigating to next page where the user can add that book into his basket.
//			9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
//			10) Click on the Add To Basket button which adds that book to your basket
//			11) User can view that Book in the Menu item with price.
//			12) Now click on Item link which navigates to proceed to check out page.
//			13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//			14) The total always < subtotal because taxes are added in the subtotal
//			15) Now click on Proceed to Check out button which navigates to payment gateway page.
//			16) User can view Billing Details,Order Details,Additional details and Payment gateway details.
//			17) Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer,cheque,cash or paypal.
//			18) Now click on Place Order button to complete process
//			19) On clicking place-order button user completes the process where the page navigates to Order confirmation page
//			with order details,bank details,customer details and billing details.

		driver.findElement(shopMenu).click();
		driver.findElement(homeMenu).click();

		List<WebElement> Arrivals = driver
				.findElements(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div"));

		AssertJUnit.assertTrue(Arrivals.size() == 3);

		System.out.println("Home page has only 3 Arrivals");

		for (int i = 1; i <= Arrivals.size(); i++) {

			driver.findElement(By.xpath("//*[@id='themify_builder_content-22']/div[2]/div/div/div/div/div[2]/div[" + i
					+ "]/div/div/ul/li/a/img")).click();

			if (!driver.findElements(By.xpath("//*[@id='content']/div/div[2]/form/button")).isEmpty()) {

				System.out.println("Arrivals can add this book into basket.");

				driver.findElement(By.xpath("//*[@id='content']/div/div[2]/form/button")).click();

				driver.findElement(By.xpath("//*[@id='content']/div/div[3]/ul/li[2]")).click();

				String totalPrice = driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).getText();
				System.out.println("Total prices in basket : " + totalPrice);

				driver.findElement(By.xpath("//*[@id='wpmenucartli']/a/span[2]")).click();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.clear();

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"))
						.sendKeys("2");

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]"))
						.click();

				Thread.sleep(5000);
				

				String totalPrice2 = driver
						.findElement(
								By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[3]/td/strong/span"))
						.getText();
				System.out.println("Total prices in basket : " + totalPrice2);

				String subTotal = driver
						.findElement(By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/table/tbody/tr[1]")).getText();
				System.out.println("SubTotal prices in basket : " + subTotal);

				driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/div[2]/div/div/a")).click();
				Thread.sleep(5000);

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

				// click place order
				driver.findElement(By.xpath("//input[@id='place_order']")).click();
				// print order details
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]")).isDisplayed());
				System.out.println(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]")).getText());

			} else {

				System.out.println("OUT OF STOCK.");

				driver.navigate().back();

			}
		}
	}

}
