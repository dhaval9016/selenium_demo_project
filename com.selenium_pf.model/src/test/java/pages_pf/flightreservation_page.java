package pages_pf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class flightreservation_page {
	
	WebDriver driver;
	WebDriverWait wait = null;

	@FindBy(xpath = ".//*[@id='tab-flight-tab']")
	WebElement flight_btn_elem;
	
	@FindBy(xpath = ".//*[@id='aria-option-0']/div")
	WebElement city_auto_elem;
	
	@FindBy(id = "flight-origin")
	WebElement flyingfrom_elem;
	
	@FindBy(id = "flight-destination")
	WebElement flyingto_elem;

	@FindBy(id = "flight-departing")
	WebElement departing_elem;
	
	@FindBy(id = "flight-returning")
	WebElement returning_elem;

	@FindBy(id = "search-button")
	WebElement submit_elem;
	
	public flightreservation_page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setautoselect()
	{
		try
		{
			new WebDriverWait(driver, 20).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(city_auto_elem));
			city_auto_elem.click();
		}
		catch(NoSuchElementException e)
		{
			e.printStackTrace();
		}
	}
	
	public void setflighttab()
	{
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(flight_btn_elem));
		flight_btn_elem.click();
	}
	public void setflyingfrom(String strflyingfrom)
	{
		new WebDriverWait(driver, 20).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(flyingfrom_elem));
		flyingfrom_elem.clear();
		flyingfrom_elem.sendKeys(strflyingfrom);
	}
	public void setflyingto(String strflyingto)
	{
		flyingto_elem.clear();
		flyingto_elem.sendKeys(strflyingto);
	}
	public void setflyingdeparting(String strflyingdeparting)
	{
		departing_elem.clear();
		departing_elem.sendKeys(strflyingdeparting);
	}
	public void setflyingreturning(String strflyingreturning)
	{
		returning_elem.clear();
		returning_elem.sendKeys(strflyingreturning);
	}
	public void setflyingsearch()
	{
		submit_elem.click();
	}
	
	public void getPrice()
	{
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='acol-interstitial']/div")));
			String price = driver.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[1]/span[contains(@class, 'visuallyhidden')]")).getText().replace("$", "").replaceAll(",", "");
			double dprice=Double.parseDouble(price);
			System.out.println("flight price is" +dprice);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void flight_reservation_final()
	{
		setflighttab();
		setflyingfrom("new york");
		setautoselect();
		setflyingto("sfo");
		setautoselect();
		setflyingdeparting("07/04/2017");
		setflyingreturning("07/29/2017");
		setflyingsearch();
		getPrice();
	}

}
