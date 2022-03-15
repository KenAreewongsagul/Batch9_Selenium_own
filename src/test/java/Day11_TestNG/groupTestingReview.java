package Day11_TestNG;

import org.testng.annotations.Test;

public class groupTestingReview {
	
	

	@Test(groups = { "SmokeTest", "Regression" })
	public void firstTest() {
		System.out.println("This will execute first(Open Browser");

	}

	@Test(groups = { "SmokeTest" })
	public void AnotherTest() {
		System.out.println("This will execute first(Open Browser2");

	}

	@Test(groups = { "SmokeTest" })
	public void ThirdTest() {
		System.out.println("This will execute first(Open Browser3");

	}

	@Test(groups = { "Regression", "Integration" })
	public void FourTest() {
		System.out.println("This will execute first(Open Browser4");

	}
	
	
	
	
	
	
	
	
	
	

}
