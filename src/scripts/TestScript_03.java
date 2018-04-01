package scripts;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import generic.BaseTest;
import generic.BaseTest1;
import generic.Generic;
import pom.Login;
import pom.OpenTasks;

public class TestScript_03 extends BaseTest1{

	@DataProvider
	public String[][] getData()
	{
		
		String data[][] = new String[5][2];
		data[0][0]="admin"; data[0][1]="123";
		data[1][0]="admin"; data[1][1]="234";
		data[2][0]="admin"; data[2][1]="pwd";
		data[3][0]="pwd"; data[3][1]="admin";
		data[4][0]="pwd1"; data[4][1]="admin";
		return data;
	}
	
	
	@Test(dataProvider="getData")
	public void test_verifyMultipleUnSuccessfullLogins(String un, String pwd)
	{
		
		System.out.println(un+" "+pwd);
		Login login = new Login(driver);
		//	login.actiTime_login("admin"), "manager");
		/*login.actiTime_login(
		Generic.getProperties(fw_properties_path+"\\app_credentials", "userName_invalid"), 
		Generic.getProperties(fw_properties_path+"\\app_credentials", "password_invalid"));
		 */
		login.actiTime_login(un, pwd);
		
		login.verifyErrorMsg(driver, "Username or Password is invalid. Please try again.");	
		
		Reporter.log("Test case 03 executed ", true);
		Reporter.log("Verify that Error page is displayed" ,true);
		
	}
	
	
	
}
