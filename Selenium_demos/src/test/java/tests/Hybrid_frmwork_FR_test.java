package tests;

import java.io.IOException;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Hybrid_frmwork_FR_page;

public class Hybrid_frmwork_FR_test extends Hybrid_frmwork_FR_page
{
	public static void main(String args[]) throws InterruptedException, IOException
	{	
		//String steps[][] = excelread("D:\\excelConfig\\test_keyword.xlsx");
		//String data[][] = excelread("D:\\excelConfig\\test_data.xlsx");
		
		String steps[][] = excelread(System.getProperty("user.dir")+("\\src\\test\\java\\Excelfiles\\test_keyword.xlsx"));
		String data[][] = excelread(System.getProperty("user.dir")+("\\src\\test\\java\\Excelfiles\\test_data.xlsx"));
		
		//System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\src\\test\\java\\Drivers\\chromedriver.exe"));
		
		WebDriver driver = new ChromeDriver();
		
		/*
		navigate_to(driver, steps[2][7]);
		click_element(driver, steps[3][5], steps[3][6]);	
		send_keys(driver, steps[5][5], steps[5][6], steps[5][7]);
		verify_element(driver, steps[4][5], steps[4][6]);
		send_keys(driver, steps[6][5], steps[6][6], steps[6][7]);
		verify_element(driver, steps[4][5], steps[4][6]);
		send_keys(driver, steps[7][5], steps[7][6], steps[7][7]);
		send_keys(driver, steps[8][5], steps[8][6], steps[8][7]);
		click_element(driver, steps[9][5], steps[9][6]);
		String price = store_text(driver, steps[10][5], steps[10][6]);
		System.out.println("lowest price is :"+price);
		close_browser(driver);
		*/
	
		String itin;
		String para = null;
		WebDriverWait wait = null;
		double price;
		
			for(int j = 1; j < data.length; j++)
			{
				for(int i = 2; i < steps.length; i++)
				{
					switch(steps[i][4])
					{
							case "navigate_to":
								navigateto(driver, steps[i][7]);
								break;
		
							case "click_element":	
								click_element(driver, steps[i][5], steps[i][6]);	
								break;
								
							case "send_keys":
								
								if(steps[i][3].contains("From"))
									para = data[j][0];
									
								if(steps[i][3].contains("To"))
									para = data[j][1];
								
								if(steps[i][3].contains("Leave"))
									para = data[j][2];
								
								if(steps[i][3].contains("Return"))
									para = data[j][3];
	
								send_keys(driver, steps[i][5], steps[i][6], para);
							
							break;
							
							case "verify_element":
								
								verify_element(driver, steps[i][5], steps[i][6]);
								break;
							
							case "Store_text":
								
								try{
								
								String str_price = store_text(driver, steps[i][5], steps[i][6]);
								price = Double.parseDouble(str_price.replaceAll("total", "").replaceAll("\\n", "").replace("per person", "").replace("$", "").replace("," ,  "")) ;
								System.out.println(str_price);
								}catch(StaleElementReferenceException e){
									e.printStackTrace();
								}catch(TimeoutException e){
									e.printStackTrace();
								}
							//itin = "Using" + steps[i][2] + " From " + data[j][0] + " To " + data[j][1] + " Leave Date " + data[j][2] + " Return Date " + data[j][3] ;
							
								default:
								break;
					}
				}
			}
			
	}	
}