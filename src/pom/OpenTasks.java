package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenTasks {

	public OpenTasks(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@alt='Logout']")
	private WebElement logout_Btn;

	
	public void logout()
	{
		logout_Btn.click();
	}
	
	
	public void verifyTitle(WebDriver driver, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try
		{
			Assert.assertEquals(driver.getTitle(), title);
		//	wait.until(ExpectedConditions.titleIs(title));
			Reporter.log("Title displayed as Expected");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			Reporter.log("Title displayed is not as Expected" + e);
			//Assert.fail();
		}
	}
}
