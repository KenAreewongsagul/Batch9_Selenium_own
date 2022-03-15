package Day11_TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	
	
	 @Test(dataProvider = "nameList")
	    public void myTest(String myName, String lastName) {
	        System.out.println("My Name is " + myName + lastName);
	    }
	    
	    @Test(dataProvider = "ageList", enabled=true)
	    public void ageTest(Integer age) {
	        System.out.println("My age is " + age);
	    }
	    
	    
	    @DataProvider(name ="nameList")
	    public Object[][] nameMethod(){
	        
	        return new Object[][] {{"Shafkat", "Ali"},{"Irfan"},{"TechCircle"}};
	    }
	    
	    @DataProvider(name ="ageList")
	    public Integer[][] ageMethod(){
	        
	        return new Integer[][] {{33},{44}};
	    }

}
