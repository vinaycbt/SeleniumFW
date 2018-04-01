package generic;

public interface IAutoConst {

	public static final String chrome_key="webdriver.chrome.driver";
	public static final String chrome_value=System.getProperty("user.dir")+"\\driverExecutables\\chromedriver.exe";
	
	public static final String ff_key="webdriver.gecko.driver";
	public static final String ff_value=System.getProperty("user.dir")+"\\driverExecutables\\geckodriver.exe";
	
	public static final String ie_key="webdriver.ie.driver";
	public static final String ie_value=System.getProperty("user.dir")+"\\driverExecutables\\IEDriverServer.exe";
	
	public static final long implicitwait = 5000;
	
	public static final String fw_path = System.getProperty("user.dir");
	
	public static final String fw_properties_path = System.getProperty("user.dir")+"\\properties"; 

	public static final String fw_testData_path = System.getProperty("user.dir")+"\\testData"; 

}
