package Day10_TestNG;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class dependOnTest {
	
	
	@Test(dependsOnMethods = {"OpenBrowser"}, dependsOnGroups= {"SmokeTest"})
	public void SignIn() {
		System.out.println("This will execute depending on the success of the Open Browser");
		
	}
	
	
	@Test
	public void OpenBrowser() {
		System.out.println("This will execute first(Open Browser)");
		AssertJUnit.assertTrue(false);
	}
	

}
