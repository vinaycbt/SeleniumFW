package scripts;

import org.testng.Reporter;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.BaseTest1;
import generic.Generic;
import pom.Login;
import pom.OpenTasks;

public class TestScript_01 extends BaseTest1{

	@Test
	public void test_verifySuccessfullLogin()
	{
		Login login = new Login(driver);
		//	login.actiTime_login("admin"), "manager");
		login.actiTime_login(
		Generic.getProperties(fw_properties_path+"\\app_credentials", "userName"), 
		Generic.getProperties(fw_properties_path+"\\app_credentials", "password"));
		
		Reporter.log("Login sucessfully ", true);
		
		OpenTasks open_Tasks = new OpenTasks(driver);
		open_Tasks.verifyTitle(driver,"actiTIME - Open Tasks");
		
		Reporter.log("Title verified successfully", true);
		
		OpenTasks open_Task = new OpenTasks(driver);
		open_Task.logout();
		Reporter.log("Logout sucessfully ", true);
		
		
		Reporter.log("Test case 01 executed ", true);
		Reporter.log("Verify that home page is displayed" ,true);
		
	}
	
	
	
}
