package tests;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.CommonFunction;

public class blablacar extends CommonFunction
{
	public static void main(String args[]) throws InterruptedException, IOException
	{
		String data[][] = fetchExcelData(System.getProperty("user.dir") +"\\src\\test\\java\\Excelfiles\\KDblablacar.xlsx"); 
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\src\\test\\java\\Drivers\\chromedriver.exe"));
		WebDriver driver = new ChromeDriver();
		
		/*
		navigateto(driver,data[1][7]);
		sendKeys(driver, data[2][5], data[2][6], data[2][7]);
		sendKeys(driver, data[3][5], data[3][6], data[3][7]);
		click_element(driver, data[4][5],data[4][6]);
		click_element(driver, data[5][5], data[5][6]);
		click_element(driver, data[6][5],data[6][6]);
		click_element(driver, data[7][5],data[7][6]);
		click_element(driver, data[8][5], data[8][6]);
		quit_driver(driver);
		*/
		
		
		for(int i = 1 ; i < data.length; i++)
		{
			switch (data[i][4])
			{
				case "navigateto":
					navigateto(driver,data[i][7]);
					break;
					
				case "send_keys":
					sendKeys(driver, data[i][5], data[i][6], data[i][7]);
					break;
					
				case "click_element":
					WebDriverWait wait = null;
					try
					{
						click_element(driver, data[i][5], data[i][6]);	
					}
					catch(StaleElementReferenceException s)
					{
						wait.until( ExpectedConditions.elementToBeClickable(click_element(driver, data[i][5], data[i][6])));
					}
					break;
				
				default:
					break;
			}
		}
		
	}

}
