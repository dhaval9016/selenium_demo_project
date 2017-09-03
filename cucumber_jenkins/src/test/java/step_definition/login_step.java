package step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login_step {

	WebDriver driver;

	@Given("^user is in LogIn Page$")
	public void user_is_in_LogIn_Page() throws Throwable {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+("\\src\\test\\java\\Drivers\\chromedriver.exe"));
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		WebElement email = driver.findElement(By.id("email"));
		email.sendKeys("dhaval.mahajan.9016");
		
		WebElement pwd = driver.findElement(By.id("pass"));
		pwd.sendKeys("dhaval@9712581911");
	}

	@When("^User click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		WebElement login = driver.findElement(By.id("u_0_2"));
		login.click();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		
		System.out.println("user loggedin successfully but make an assertion for that");
		driver.close();
	   
	}




}