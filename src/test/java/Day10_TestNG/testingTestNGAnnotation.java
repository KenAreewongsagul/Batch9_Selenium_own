package Day10_TestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testingTestNGAnnotation {
	
//	@BeforeMethod: This will be executed before every @test annotated method.
//  @AfterMethod: This will be executed after every @test annotated method.
//  @BeforeClass: This will be executed before first @Test method execution. It will be executed one only time throughout the test case.
//  @AfterClass: This will be executed after all test methods in the current class have been run
//  @BeforeTest: This will be executed before the first @Test annotated method. It can be executed multiple times before the test case.
//  @AfterTest: A method with this annotation will be executed when all @Test annotated methods complete the execution of those classes inside the <test> tag in the TestNG.xml file.
//  @BeforeSuite: It will run only once, before all tests in the suite are executed.
//  @AfterSuite: A method with this annotation will run once after the execution of all tests in the suite is complete.
//  @BeforeGroups: This method will run before the first test run of that specific group.
//  @AfterGroups: This method will run after all test methods of that group complete their execution
	
	
	
	//actitation
	@Test      (priority=1) //actibew
	public void test1() {
		System.out.println("test1");
		
	}
	
	@Test(priority=2)
	public void test2() {
		System.out.println("test2");
		
	}

					   //false=skip
	@Test(priority=3, enabled=false)
	public void test3() {
		System.out.println("test3");
		
	}
	
	@Test(priority=4)//if same priority will run by alphabet
	public void test4() {
		System.out.println("test4");
		
	}
	
	
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}
	
	
	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
		
	}
	
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
		
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
		
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
		
	}
	
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
		
	}
	
	
	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
		
	}
	
	@BeforeGroups
	public void beforeGroup() {
		System.out.println("beforeGroup");
		
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("afterGroups");
		
		
		
		
		
		
	
	
	
	
	}	
}
