package generic;

import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.out.println(Generic.getProperties("./properties/app_credentials.properties", "app_url"));
	/*try
	{
		FileInputStream fis = new FileInputStream("E:\\Weekendselenium\\AutomationFW\\testData\\TestData.xlsx");
		Workbook wis = new WorkbookFactory().create(fis);
		Sheet s1 = wis.getSheet("TestScript_04");
		Row r1 = s1.getRow(0);
		String value = r1.getCell(2).getStringCellValue();
		System.out.println(value);
		
		
	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}*/
	
	//int rowcount =	Generic.getCellCount("E:\\Weekendselenium\\AutomationFW\\testData\\TestData.xlsx", "TestScript_04",13);
	//System.out.println(rowcount);
	
		
		/*int noOfRows = Generic.getrowCount("E:\\Weekendselenium\\AutomationFW\\testData\\TestData.xlsx", "TestScript_04");
		
		for(int i=1;i<=noOfRows;i++)
		{
			String un = Generic.getCellValue("E:\\Weekendselenium\\AutomationFW\\testData\\TestData.xlsx", "TestScript_04", i, 1);
			System.out.println(un);
			String pwd = Generic.getCellValue("E:\\Weekendselenium\\AutomationFW\\testData\\TestData.xlsx", "TestScript_04", i, 2);
			System.out.println(pwd);
		}*/
		
		
		//Generic.setCellValue("E:\\Weekendselenium\\AutomationFW\\testData\\TestData.xlsx", "TestScript_04", 3, 5, "pass");
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
	}

}
