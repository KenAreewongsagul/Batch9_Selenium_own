package Day10_TestNG;

import org.testng.annotations.Test;

public class groupTests {

	
	@Test(groups = {"SmokeTest", "Regression"})
	public void test1() {
		System.out.println("This will execute first(Open Browser");
		
	}
	
		@Test(groups = {"SmokeTest"})
		public void test2() {
			System.out.println("This will execute first(Open Browser2");
	
		}
			@Test(groups = {"SmokeTest"})
			public void test3() {
				System.out.println("This will execute first(Open Browser3");
	

			}
			
			
			@Test(groups = {"Regression", "Integration"})
			public void test4() {
				System.out.println("This will execute first(Open Browser4");
	

			}
		
			
			
			
			
		
}
		
		
		
		
		
		
		
		
		
		