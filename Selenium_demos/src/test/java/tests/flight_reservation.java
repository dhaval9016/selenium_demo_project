package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sun.security.x509.IssuingDistributionPointExtension;

public class flight_reservation {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		String data[][];
		data = excelRead();
		
		double price;
		for(int i = 1; i < data.length; i++)
		{
			price = findPriceByOrbitz(data[i][0], data[i][1]);
			System.out.println("price from flight from"+ data[i][0] + " to " + data[i][1] + price );
		}
	}
	
	public static double findPriceByOrbitz(String dep, String dest) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
		WebDriver wd = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(wd,60) ;	
		
		wd.get("http://www.orbitz.com") ;	
		
		try {
			WebElement selectFlight = wd.findElement(By.xpath("//*[@id='tab-flight-tab']"));
			selectFlight.click();
		
			
			wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebElement selectDeparture = wd.findElement(By.xpath("//*[@id='flight-origin']"));
			selectDeparture.clear();
			selectDeparture.sendKeys(dep);
			
			new WebDriverWait(wd, 20).until(
			        ExpectedConditions.elementToBeClickable(
			            By.xpath(".//*[@id='aria-option-0']")))
							.click();
			
			
			wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebElement selectDest = wd.findElement(By.xpath("//*[@id='flight-destination']"));
			selectDest.clear();
			selectDest.sendKeys(dest);
			
			new WebDriverWait(wd, 20).until(
			        ExpectedConditions.elementToBeClickable(
			            By.xpath(".//*[@id='aria-option-0']")))
			                .click();
			
			WebElement selectFromdate = wd.findElement(By.xpath("//*[@id='flight-departing']"));
			selectFromdate.clear();
			selectFromdate.sendKeys("05/20/2017");
			
			WebElement selectTodate = wd.findElement(By.xpath("//*[@id='flight-returning']"));
			selectTodate.clear();
			selectTodate.sendKeys("05/21/2017");
			
			WebElement selectSearch = wd.findElement(By.xpath("//*[@id='search-button']"));
			selectSearch.click();

			new WebDriverWait(wd, 20).until(
					ExpectedConditions.invisibilityOfElementLocated(
							By.xpath(".//*[@id='acol-interstitial']/div")));
			
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='acol-interstitial']/div")));
	
			String price = wd.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[1]/span[contains(@class, 'visuallyhidden')]")).getText().replace("$", "").replace(",","") ;
			
				wd.close() ;		
				double dprice = Double.parseDouble(price) ;
				return dprice ;
			
		}
		catch (StaleElementReferenceException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			e.getMessage();
			System.out.println("stale exception occured");
		}
		catch (TimeoutException e1)
		{
			e1.printStackTrace();
			e1.getMessage();
			System.out.println("timeout exception occured");
		}
		catch(NoSuchElementException e2)
		{
			e2.printStackTrace();
			e2.getMessage();
			System.out.println("Noelement exception occured");
		}
		
		return 0;
	}
		
		public static String[][] excelRead() throws IOException
		{
			FileInputStream fis = new FileInputStream("D:\\excelConfig\\orbitz_search.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			XSSFSheet ws = wb.getSheet("Sheet1");
			
			int rownum = ws.getLastRowNum() + 1;
			int colnum = ws.getRow(0).getLastCellNum();
			
			String data[][]=new String[rownum][colnum];
			
			for(int i = 1;i<rownum;i++)
			{
				XSSFRow row = ws.getRow(i);
				for(int j=0;j<colnum;j++)
				{
					XSSFCell cell = row.getCell(j);
					
					DataFormatter df = new DataFormatter();
					String value = df.formatCellValue(cell);
					data[i][j] = value;
					
					System.out.println(cell);
				}
			}
			return data;
		}
}
