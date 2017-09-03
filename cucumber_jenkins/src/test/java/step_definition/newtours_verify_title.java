package step_definition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class newtours_verify_title {
	
	WebDriver driver;
	
	@Given("^user is in Newtours login page$")
	public void user_is_in_Newtours_login_page() throws Throwable {
	   
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\src\\test\\java\\Drivers\\chromedriver.exe"));
		driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");		
	}

	@When("^user enters Username and password$")
	public void user_enters_Username_and_password() throws Throwable {
		WebElement UserName = driver.findElement(By.name("userName"));
		UserName.sendKeys("demo");
		
		WebElement Password = driver.findElement(By.name("password"));
		Password.sendKeys("demo");
	    
	}

	@When("^user click on Sign-in button$")
	public void user_click_on_Sign_in_button() throws Throwable {
		
		WebElement Signin = driver.findElement(By.name("login"));
		Signin.click();
	}

	@Then("^user shows the title find flight$")
	public void user_shows_the_title_find_flight() throws Throwable {
		
//		String expecttitle = driver.getTitle();
//		String actualtitle = "Find a Flight: Mercury Tours: ";
		
		 Assert.assertEquals("Find a Flight: Mercury Tours:",driver.getTitle());

		driver.close();
	    
	}
}
