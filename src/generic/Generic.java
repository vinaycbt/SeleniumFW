package generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Generic {

	
	public static String getProperties(String path, String key)
	{
		String value = null;
		try
		{
			Properties prop = new Properties();
			prop.load(new FileInputStream(path+".properties"));
			value = prop.getProperty(key);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	
	
	public static String setProperties(String path, String key, String value)
	{
		try
		{
			Properties prop = new Properties();
			prop.load(new FileInputStream(path));
			prop.setProperty(key, value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}

	public static void takeSS(WebDriver driver, String TestcaseName)
	{
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		//System.out.println(dateFormat.format(date));
		try {
			FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\screenShots\\"+TestcaseName+dateFormat.format(date)+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getCellValue(String filepath,String sheetName,int rowNo, 
			int cellNo)
	{
		String value = null;
		
		try
		{
			FileInputStream fis = new FileInputStream(filepath);
			/*Workbook wis = new WorkbookFactory().create(fis);
			Sheet s1 = wis.getSheet(sheetName);
			Row r1 = s1.getRow(rowNo);
			value = r1.getCell(cellNo).getStringCellValue();
			System.out.println(value);*/
			Workbook wis = new WorkbookFactory().create(fis);
			value = wis.getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	
	public static int getrowCount(String filepath,String sheetName)
	{
		int value = 0;
		
		try
		{
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wis = new WorkbookFactory().create(fis);
			value = wis.getSheet(sheetName).getLastRowNum();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return value;
	}
	
	public static int getCellCount(String filepath,String sheetName,int rowNo)
	{
		int value =0;
		try
		{
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wis = new WorkbookFactory().create(fis);
			value = wis.getSheet(sheetName).getRow(rowNo).getLastCellNum();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return value;
	}

	public static void setCellValue(String filepath,String sheetName,int rowNo, int cellNo, String value)
	{
		try
		{
			FileInputStream fis = new FileInputStream(filepath);

			Workbook wis = new WorkbookFactory().create(fis);
			wis.getSheet(sheetName).getRow(rowNo).createCell(cellNo).setAsActiveCell();
			wis.getSheet(sheetName).getRow(rowNo).getCell(cellNo).setCellValue(value);
			
			FileOutputStream fos = new FileOutputStream(filepath);
			wis.write(fos);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}
