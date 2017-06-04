package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hybrid_frmwork_FR_page
{	
	public static WebDriver open_browser(String browserType)
	{
		WebDriver driver = null;	
		
		System.out.println("browser started");
		
		if(browserType.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
			
			DesiredCapabilities dc = DesiredCapabilities.firefox();
			dc.setCapability("marionette", true);
			driver =  new FirefoxDriver(dc);
		}
		else if (browserType.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}
		else if (browserType.equalsIgnoreCase("chrome")) 
		{
			driver = new ChromeDriver();
		}
		return driver;
	}
	
	public static void navigate_to(WebDriver driver , String url)
	{
		driver.get(url);
		System.out.println("url get");
	}
	
	public static void click_element(WebDriver driver,String locator,String locString)
	{
		switch (locator)
		{
		case "xpath":
			driver.findElement(By.xpath(locString)).click();
			break;
			
		case "id":
			driver.findElement(By.id(locString)).click();
			break;
			
		case "name":
			driver.findElement(By.name(locString)).click();
			break;

		default:
			break;
		}
	}
	
	/*
	public static void verify_element(WebDriver driver,String locator,String locString)
	{
		WebDriverWait wait = null;
		
		switch (locator) 
		{
		case "xpath":
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locString)));
			break;

		case "id":
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id(locString)));
			break;
			
		case "name":
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.name(locString)));
			break;
			
		default:
			break;
		}
	}
	*/
	
	public static void send_keys(WebDriver driver,String locator,String locString,String data)
	{
		switch (locator)
		{
		case "xpath":
			
			driver.findElement(By.xpath(locString)).sendKeys(data);
			break;
			
		case "id":

			driver.findElement(By.id(locString)).sendKeys(data);
			break;

		case "name":
			
			driver.findElement(By.name(locString)).sendKeys(data);
			break;
			
		default:
			break;
		}
	}
	/*
	public static String store_text(WebDriver driver , String locator ,String locString)
	{
		String S_txt = null;
		
		switch (locator)
		{
		case "xpath":
			S_txt =	driver.findElement(By.xpath(locString)).getText();
			break;

		case "id":
			S_txt =	driver.findElement(By.id(locString)).getText();
			break;
	
		case "name":
			S_txt =	driver.findElement(By.name(locString)).getText();
			break;
			
		default:
			break;
		}
		return S_txt;
	}
	*/
	
	public static void close_browser(WebDriver driver)
	{
		driver.close();
	}
	
	public static String[][] excelread(String path) throws IOException
	{
		//File excel_file = new File(System.getProperty("user.dir")+ "\\src\\test\\java\\Excelfiles\\Keyword_flight_reservation.xls");
		
		File excel_file = new File(path);
		FileInputStream fis = new FileInputStream(excel_file);
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int rowNum = sheet.getLastRowNum() + 1;
		int columnNum = sheet.getRow(0).getLastCellNum();
		
		String[][] data = new String[rowNum][columnNum];
		
		for(int i = 0 ; i < rowNum ; i++)
		{
			XSSFRow row = sheet.getRow(i);
			
			for(int j = 0 ; j < columnNum ; j++)
			{
				
				XSSFCell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String value = formatter.formatCellValue(cell);
				data[i][j] = value;
		
			}
		}
		return data;
	}
}
