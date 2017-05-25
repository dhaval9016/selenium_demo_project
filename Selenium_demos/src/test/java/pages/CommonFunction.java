package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunction
{
	public static String navigateto(WebDriver driver , String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.manage().deleteAllCookies();
		return null;
	}
	
	public static String sendKeys(WebDriver driver,String strLocatorType,String strLocationvalue,String param1) throws InterruptedException
	{
		switch (strLocatorType)
		{
		case "id":
			driver.findElement(By.id(strLocationvalue)).sendKeys(param1);	
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocationvalue)).sendKeys(param1);	
			break;
		}
		Thread.sleep(1000);
		return null;
	}
	
	public static By click_element(WebDriver driver,String strLocatorType,String strLocationvalue)
	{
		switch (strLocatorType)
		{
		case "id":
			driver.findElement(By.id(strLocationvalue)).click();
			break;
		case "xpath":
			driver.findElement(By.xpath(strLocationvalue)).click();
			break;		
		case "linkText":
			driver.findElement(By.linkText(strLocationvalue)).click();
			break;
		}
		return null;
	}
	
	public static String[][] fetchExcelData(String path) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		XSSFSheet ws = wb.getSheetAt(0);
		
		int rowNum = ws.getLastRowNum()+1;
		
		int columnNum = ws.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowNum][columnNum];
		
		for(int i = 0;i<rowNum; i++)
		{
			XSSFRow row = ws.getRow(i);
			for(int j = 0;j<columnNum;j++)
			{
				DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
				XSSFCell cell = row.getCell(j);
				String value = formatter.formatCellValue(cell);
				data[i][j] = value;
				System.out.println("data : " + data[i][j]);
			}
		}
		return data;
	}

	public static void quit_driver(WebDriver driver)
	{
		driver.quit();
	}
}
