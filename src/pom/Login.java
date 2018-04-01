package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Login {

	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement uN_txt_bx;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement pwd_txt_bx;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit_btn;
	
	@FindBy(xpath="//span[@class='errormsg']")
	private WebElement err_msg;
	
	
	public void actiTime_login(String un, String pwd)
	{
		try
		{
		uN_txt_bx.clear();
		uN_txt_bx.sendKeys(un);
		pwd_txt_bx.sendKeys(pwd);
		submit_btn.click();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
	}
	
	public void verifyErrorMsg(WebDriver driver, String errorms)
	{
		WebDriverWait wait = new WebDriverWait(driver, 80);
		try
		{
			wait.until(ExpectedConditions.visibilityOf(err_msg));
			Assert.assertEquals(err_msg.getText(), errorms);
			Reporter.log("Error msg is as Expected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Error msg displayed is not as Expected" + e);
			Assert.fail();
			throw e;
		}
	}
}
