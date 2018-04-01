package scripts;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.BaseTest1;
import generic.Generic;
import pom.Login;
import pom.OpenTasks;

public class TestScript_04 extends BaseTest1{

	
	@Test()
	public void test_verifyMultipleUnSuccessfullLogins_TestData()
	{
		
		
		Login login = new Login(driver);
		//	login.actiTime_login("admin"), "manager");
		/*login.actiTime_login(
		Generic.getProperties(fw_properties_path+"\\app_credentials", "userName_invalid"), 
		Generic.getProperties(fw_properties_path+"\\app_credentials", "password_invalid"));
		 */
		//login.actiTime_login(un, pwd);
		
		//String un = Generic.getCellValue(fw_testData_path+"\\TestData.xlsx", "TestScript_04", 1, 1);
		//String pwd = Generic.getCellValue(fw_testData_path+"\\TestData.xlsx", "TestScript_04", 1, 2);
		
		int noOfRows = Generic.getrowCount(fw_testData_path+"\\TestData.xlsx", "TestScript_04");
		
		for(int i=1;i<=noOfRows;i++)
		{
			String un = 
			Generic.getCellValue(fw_testData_path+"\\TestData.xlsx", "TestScript_04", i, 1);
			System.out.println(un);
			String pwd = 
			Generic.getCellValue(fw_testData_path+"\\TestData.xlsx", "TestScript_04", i, 2);
			System.out.println(pwd);
			if(pwd=="null" || pwd=="none")
			{
				pwd = "";
			}
			login.actiTime_login(un, pwd);
			login.verifyErrorMsg(driver, "Username or Password is invalid. Please try again.");	
			Generic.setCellValue(fw_testData_path+"\\TestData.xlsx", "TestScript_04", i, 3, 
					"verfied");
		}

		Reporter.log("Test case 04 executed ", true);
		Reporter.log("Verify that Error page is displayed" ,true);
	
	}
	
	
	
}
