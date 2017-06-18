package pom.tests.flightreservation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pom.pages.flightreservation.FR_Price_listing_page;
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
		
		
		/*
		FR_Price_listing_page fr_obj = new FR_Price_listing_page(driver);
		fr_obj.getPrice();
		*/		
		
		/*
		try {
			
			wd.get("https://www.orbitz.com/");
			Thread.sleep(20);
			
			WebElement selectFlight = wd.findElement(By.xpath("//*[@id='tab-flight-tab']"));
			selectFlight.click();
	
			wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebElement selectDeparture = wd.findElement(By.xpath("//*[@id='flight-origin']"));
			selectDeparture.clear();
			selectDeparture.sendKeys("goa");
			
			new WebDriverWait(wd, 20).until(
			        ExpectedConditions.elementToBeClickable(
			            By.xpath(".//*[@id='aria-option-0']")))
							.click();
			
			wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			WebElement selectDest = wd.findElement(By.xpath("//*[@id='flight-destination']"));
			selectDest.clear();
			selectDest.sendKeys("ahmedabad");
			
			new WebDriverWait(wd, 20).until(
			        ExpectedConditions.elementToBeClickable(
			            By.xpath(".//*[@id='aria-option-0']")))
			                .click();
			
			WebElement selectFromdate = wd.findElement(By.xpath("//*[@id='flight-departing']"));
			selectFromdate.clear();
			selectFromdate.sendKeys("06/20/2017");
			
			WebElement selectTodate = wd.findElement(By.xpath("//*[@id='flight-returning']"));
			selectTodate.clear();
			selectTodate.sendKeys("06/22/2017");
			
			WebElement selectSearch = wd.findElement(By.xpath("//*[@id='search-button']"));
			selectSearch.click();

			new WebDriverWait(wd, 20).until(
					ExpectedConditions.invisibilityOfElementLocated(
							By.xpath(".//*[@id='acol-interstitial']/div")));
			
			
			//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(".//*[@id='acol-interstitial']/div")));

			String price = wd.findElement(By.xpath("//div[2]/div/div[2]/div/div/div[1]/span[contains(@class, 'visuallyhidden')]")).getText().replace("$", "").replace(",","");
			double dprice = Double.parseDouble(price);
			System.out.println(dprice);
			wd.close() ;
		}catch (NoSuchElementException e){
			e.printStackTrace();
		}catch(StaleElementReferenceException e){
			e.printStackTrace();
		}*/
		
	}

}