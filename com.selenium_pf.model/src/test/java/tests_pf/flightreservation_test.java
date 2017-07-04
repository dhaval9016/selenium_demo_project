package tests_pf;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pages_pf.flightreservation_page;

public class flightreservation_test {
	
	@Test
	public void flightreservation_call()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+("\\src\\test\\java\\Drivers\\chromedriver.exe"));
		WebDriver driver = new ChromeDriver();
		flightreservation_page fr = new flightreservation_page(driver);
		driver.get("https://www.orbitz.com/");
		fr.flight_reservation_final();
	}

}
