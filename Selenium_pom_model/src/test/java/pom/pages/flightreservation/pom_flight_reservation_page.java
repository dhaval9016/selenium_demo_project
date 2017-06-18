package pom.pages.flightreservation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pom_flight_reservation_page 
{
	WebDriver driver;
	WebDriverWait wait = null;
	
	
	By selectFlight		=	By.xpath("//*[@id='tab-flight-tab']");
	
	By 	autoselect		=	By.xpath(".//*[@id='aria-option-0']");
	By 	selectDeparture	=	By.xpath("//*[@id='flight-origin']");
	By 	selectDest		=	By.xpath("//*[@id='flight-destination']");
	By 	selectFromdate	=	By.xpath("//*[@id='flight-departing']");
	By	selectTodate	=	By.xpath("//*[@id='flight-returning']");
	
	By	selectSearch	=	By.xpath("//*[@id='search-button']");
	
	public pom_flight_reservation_page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setFlight()
	{
		try {
			WebElement flight_elem = driver.findElement(selectFlight);
			flight_elem.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setAutoselect()
	{
		try {
			WebElement autoselect_elem = driver.findElement(autoselect);
			autoselect_elem.click();
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setDeparture(String strdepart)
	{
		WebElement departure_elem =  driver.findElement(selectDeparture);
		departure_elem.clear();
		departure_elem.sendKeys(strdepart);
	}
	public void setDest(String strdest)
	{
		WebElement dest_elem =  driver.findElement(selectDest);
		dest_elem.clear();
		dest_elem.sendKeys(strdest);
	}
	public void setFromdate(String strfromdate)
	{
		WebElement fromdate_elem =  driver.findElement(selectFromdate);
		fromdate_elem.clear();
		fromdate_elem.sendKeys(strfromdate);
	}
	public void setTodate(String strtodate) 
	{
		WebElement todate_elem =  driver.findElement(selectTodate);
		todate_elem.clear();
		todate_elem.sendKeys(strtodate);
	}
	public void setSelectsearch()
	{
		WebElement search_elem = driver.findElement(selectSearch);
		search_elem.click();
	}
	
	public void final_flight_reservation()
	{
		setFlight();
		setDeparture("goa");
		setAutoselect();
		setDest("ahmedabad");
		setAutoselect();
		setFromdate("06/20/2017");
		setTodate("06/22/2017");
		setSelectsearch();
	}
}
