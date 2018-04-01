package scripts;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.BaseTest1;
import generic.Generic;
import pom.Login;
import pom.OpenTasks;

public class TestScript_05{

	@Parameters({"browser","browser1"})
	@Test()
	public void test_verify(String browserName, 
			String browserName1)
	{
		System.out.println(browserName);
		
		System.out.println(browserName1);
	}
	
	
	
}
