package pom.pages.flightreservation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FR_Price_listing_page {
	
	WebDriver driver;
	By price = By.xpath("//div[2]/div/div[2]/div/div/div[1]/span[contains(@class, 'visuallyhidden')]");
	
	public FR_Price_listing_page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getPrice()
	{
		driver.findElement(price);
		return getPrice(); 
	}

}
