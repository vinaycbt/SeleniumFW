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
import org.testng.xml.XmlTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.Login;
import pom.OpenTasks;

public class BaseTest1 implements IAutoConst{

	public WebDriver driver =  null;
	
	static
	{
		//System.setProperty(ff_key,ff_value);
		//System.setProperty(chrome_key,chrome_value);
		System.setProperty(ie_key,ie_value);	
	}
	
	@BeforeClass
	public void launchBrowser(XmlTest param)
	{
		
		String browserName = param.getParameter("browser");
		
		
		if(browserName.equalsIgnoreCase("ff"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver  = new FirefoxDriver();
			//Reporter.log("Before class executed ", true);
			Reporter.log("FF Launched Browser sucessfully", true);
		}
		if(browserName.equalsIgnoreCase("ch"))
		{
			WebDriverManager.chromedriver().setup();
			driver  = new ChromeDriver();
			//Reporter.log("Before class executed ", true);
			Reporter.log("CH Launched Browser sucessfully", true);
		}
		
		
	}
	
	
	@BeforeMethod
	public void login()
	{
		driver.get(Generic.getProperties(fw_properties_path+"\\app_credentials", "app_url"));
		driver.manage().timeouts().implicitlyWait(implicitwait, TimeUnit.MILLISECONDS);
		//Reporter.log("Before Method executed ", true);
		Reporter.log("URL entered success fully", true);
		//Reporter.log("Launched Browser sucessfully", true);
	}
	
	@AfterMethod
	public void logout()
	{
		
		//Reporter.log("After Method executed ", true);
		//Reporter.log("Logout successfully", true);
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		//Reporter.log("After class executed ", true);
		Reporter.log("Browser closed sucessfully", true);
	}
}
