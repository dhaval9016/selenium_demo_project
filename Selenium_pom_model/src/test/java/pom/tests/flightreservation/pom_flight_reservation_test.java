package pom.tests.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pom.pages.flightreservation.pom_flight_reservation_page;

public class pom_flight_reservation_test {
	
	@Test
	public void flight_reservation() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\src\\test\\java\\Drivers\\chromedriver.exe"));
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orbitz.com/");
		pom_flight_reservation_page pom_page_object = new pom_flight_reservation_page(driver);	
		
		pom_page_object.final_flight_reservation();		
	}

}