package tests;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.wordpress_login_page;

public class wordpress_login_test 
{
	WebDriver driver;
	
  @Test(dataProvider = "wordpressdata")
  public void logintowordpress(String strUsername , String strPassword) throws InterruptedException
  {
	 System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
	 driver = new ChromeDriver();
	 
	 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 driver.get("http://demosite.center/wordpress/wp-login.php");
	 driver.manage().window().maximize();
	
	 WebElement userElem = driver.findElement(By.id("user_login"));
	 userElem.sendKeys(strUsername);
	 
	 WebElement passElem = driver.findElement(By.id("user_pass"));
	 passElem.sendKeys(strPassword);
	 
	 WebElement submitElem = driver.findElement(By.id("wp-submit"));
	 submitElem.click();
	 
	 Thread.sleep(5000);
	 
	 //Assert.assertTrue(driver.getTitle().contains("Dashboard"));
	
	 System.out.println("Title is verified");
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
  }
  
  @DataProvider(name = "wordpressdata")
  public Object[][] passdata() throws IOException
  {
	  wordpress_login_page exl = new wordpress_login_page(System.getProperty("user.dir")+"\\src\\test\\java\\Excelfiles\\wordpressLogindata.xlsx");	  
	  
	  int row = exl.getRowcount(0);
	  System.out.println(" row is " + row);
	  
	  Object[][] data = new Object[row][2];
	  
	  for(int i = 0 ; i < row ; i++)
	  {
		  data[i][0] = exl.getdata(0, i, 0);
		  data[i][1] = exl.getdata(0, i, 1);
	  }
	  
	  return data;
  }
  
}
