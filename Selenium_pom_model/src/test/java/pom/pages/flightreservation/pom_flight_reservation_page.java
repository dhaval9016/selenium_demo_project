package pom.pages.flightreservation;

import java.util.concurrent.TimeUnit;

import org.omg.CORBA.TIMEOUT;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
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
	By 	autosearchcomp	=	By.xpath(".//*[@id='acol-interstitial']/div");
	
	public pom_flight_reservation_page(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void setFlight()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			WebElement flight_elem = driver.findElement(selectFlight);
			flight_elem.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void setAutoselect()
	{
		try {
			WebElement autoselect_elem = driver.findElement(autoselect);
			autoselect_elem.click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
	public void setDeparture(String strdepart)
	{	
		new WebDriverWait(driver, 10).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(selectDeparture));
	
		WebElement departure_elem = driver.findElement(selectDeparture);
		departure_elem.sendKeys(strdepart);
	}
	public void setDest(String strdest)
	{
		try {
			WebElement dest_elem =  driver.findElement(selectDest);
			dest_elem.clear();
			dest_elem.sendKeys(strdest);
		} catch (StaleElementReferenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public void getPrice()
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(autosearchcomp));
		
		String price=driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[1]/span[contains(@class, 'visuallyhidden')]")).getText().replace("$", "").replaceAll(",", "");;
		double dprice=Double.parseDouble(price);
		System.out.println(dprice);
	}

	
	public void final_flight_reservation()
	{
		setFlight();
		setDeparture("sfo");
		setAutoselect();
		setDest("canada");
		setAutoselect();
		setFromdate("06/25/2017");
		setTodate("06/26/2017");
		setSelectsearch();
		getPrice();
	}
}
