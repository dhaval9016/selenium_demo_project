package pack_jenkins;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class guru99_jenkins {
	private WebDriver driver;		
	@Test				
	public void testEasy() {	
		driver.get("http://demo.guru99.com/selenium/guru99home/");  
		String title = driver.getTitle();
		String geturl = driver.getCurrentUrl();
		System.out.println("guru99 title is verified with" + title); 
		Assert.assertTrue(title.contains("Demo Guru99 Page")); 		
	}
	
	@BeforeTest
	public void beforeTest() {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\src\\test\\java\\Drivers\\chromedriver.exe"));
	    driver = new ChromeDriver();  
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();			
	}	

}
