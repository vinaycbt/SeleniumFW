package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pom.Login;
import pom.OpenTasks;

public class BaseTest implements IAutoConst{

	public WebDriver driver =  null;
	
	static
	{
		System.setProperty(ff_key,ff_value);
		System.setProperty(chrome_key,chrome_value);
		System.setProperty(ie_key,ie_value);	
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		driver  = new FirefoxDriver();
		//Reporter.log("Before class executed ", true);
		Reporter.log("Launched Browser sucessfully", true);
	}
	
	
	@BeforeMethod
	public void login()
	{
		driver.get(Generic.getProperties(fw_properties_path+"\\app_credentials", "app_url"));
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.MILLISECONDS);
		//Reporter.log("Before Method executed ", true);
		Reporter.log("URL entered success fully", true);
		Login login = new Login(driver);
	//	login.actiTime_login("admin"), "manager");
		
		login.actiTime_login(
				Generic.getProperties(fw_properties_path+"\\app_credentials", "userName"), 
				Generic.getProperties(fw_properties_path+"\\app_credentials", "password"));
		//Reporter.log("Launched Browser sucessfully", true);
	}
	
	@AfterMethod
	public void logout()
	{
		OpenTasks open_Tasks = new OpenTasks(driver);
		open_Tasks.logout();
		//Reporter.log("After Method executed ", true);
		Reporter.log("Logout successfully", true);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		//Reporter.log("After class executed ", true);
		Reporter.log("Browser closed sucessfully", true);
	}
}
