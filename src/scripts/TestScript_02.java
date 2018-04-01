package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.BaseTest1;
import generic.Generic;
import pom.Login;
import pom.OpenTasks;

public class TestScript_02 extends BaseTest1{

	@Test
	public void test_verifySuccessfullLogin()
	{
		try
		{
		Login login = new Login(driver);
		//	login.actiTime_login("admin"), "manager");
		login.actiTime_login(
		Generic.getProperties(fw_properties_path+"\\app_credentials", "userName_invalid"), 
		Generic.getProperties(fw_properties_path+"\\app_credentials", "password_invalid"));
		
		login.verifyErrorMsg(driver, "Username or Password is invalid. Please try again..");	
		
		Reporter.log("Test case 02 executed ", true);
		Reporter.log("Verify that Error page is displayed" ,true);
		}
		catch(Exception e)
		{
			
			Generic.takeSS(driver, "TestScript_02");
			
			e.printStackTrace();
			throw e;
		}
	}
	
	
	
}
