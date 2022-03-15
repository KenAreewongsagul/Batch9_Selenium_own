package Day11_TestNG;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class passingParameters {
	
	
	@Parameters
	@Test
	public void SumOf(int val1 , int val2) {
		
		System.out.println(val1 + val2);
		
		
	}
	

}
