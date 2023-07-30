package Login;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RegTest {
	WebDriver driver;
	String Url = "https://login.yahoo.com/account/create?.intl=us&specId=yidregsimplified&done=https%3A%2F%2Fwww.yahoo.com";
	@Given("User is on login page")
	public void user_is_on_login_page() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get(Url);
	    driver.manage().window().maximize();
	    
	}

	@When("User enters details as firstname and lastname")
	public void user_enters_details_as_firstname_and_lastname() {
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Jagadeesh");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Palavalasa");
	    
	}

	@When("User enters Newemail and domain")
	public void user_enters_newemail_and_domain() {
		driver.findElement(By.name("userId")).sendKeys("pavalasarecuit77");
		WebElement domainDropdown = driver.findElement(By.id("yid-domain-selector"));
		Select domainSelect = new Select(domainDropdown);
		domainSelect.selectByVisibleText("myyahoo.com");
	}

	@When("User enters password")
	public void user_enters_password() {
		driver.findElement(By.name("password")).sendKeys("Recruit77");
	}

	@When("User enter DOB as month day and year")
	public void user_enter_dob_as_month_day_and_year() {
		WebElement mnth =  driver.findElement(By.id("usernamereg-month"));
		Select m = new Select(mnth);
		m.selectByVisibleText("September");
		driver.findElement(By.id("usernamereg-day")).sendKeys("20");
		driver.findElement(By.id("usernamereg-year")).sendKeys("1998");
	}

	@When("User clicks on Countinue")
	public void user_clicks_on_countinue() {
		driver.findElement(By.id("reg-submit-button")).click();
	}

	@When("User enters mobile number")
	public void user_enters_mobile_number() {
	    driver.findElement(By.name("phone")).sendKeys("9390546688");
	    String t = driver.findElement(By.id("usernamereg-phone")).getAttribute("value");
	    char[] s = t.toCharArray();
	    int count = 0;
	    for (int i=0; i<s.length; i++) {
	    	count++;
	    }
	    
	    if(count == 10) {
	    	System.out.println("Entered phone number is valid");
	    	
	    }
	    else {
	    	System.out.println("Entered phone number is not valid");
	    }
	    
	}
	@Then("User clicks on send code")
	public void user_clicks_on_send_code() {
		driver.findElement(By.name("signup")).click();
		driver.quit();
	   
	}
	@Given("User is on home page")
	public void user_is_on_home_page() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get(Url);
	    driver.manage().window().maximize();
	    
	}

	@When("User clicks on terms")
	public void user_clicks_on_terms() {
		String parentWindowHandle = driver.getWindowHandle();
		driver.findElement(By.xpath("//a[text()='Terms']")).click();
		Set<String> allWindowHandles = driver.getWindowHandles();
		  for (String windowHandle : allWindowHandles) {
			  if (!windowHandle.equals(parentWindowHandle)) {
				  driver.switchTo().window(windowHandle);
				  break;
				  
			  }
		  }
		  
		  String termsPage = driver.getCurrentUrl();
		  System.out.println("Current URL: " + termsPage);
		  
		  String expUrl = "https://legal.yahoo.com/us/en/yahoo/terms/otos/index.html";
		  if (termsPage.equals(expUrl)) {
			  System.out.println("Terms and Conditions Page is displayed in a new tab");
		  }
		  else {
			  System.out.println("Terms and Conditions Page is not displayed in a new tab");
		  }
		  
	}
		

	@Then("terms page is displayed")
	public void terms_page_is_displayed() {
		

		driver.quit();
	   
	}
}
