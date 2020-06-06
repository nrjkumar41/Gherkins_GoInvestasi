package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenBrowser_stepDefination {

	WebDriver driver;

	@Given("^User is already GoInvestasi user$")
	public void user_is_already_GoInvestasi_user() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nrjku\\eclipse-workspace\\Sample_Gherkins\\Drivers\\Windows\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		driver = new ChromeDriver(chromeOptions);
//		driver = new ChromeDriver();
		driver.get("https://goinvestasi-staging.pluang.com/?accessToken=MTU5MTMwMjkzNDE3MDEwNzY3NTFOTHhNc1VCQkdF");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

	}

	@When("^Title is GoInvestasi$")
	public void title_is_GoInvestasi() throws Throwable {

		driver.getTitle();
		System.out.println(driver.getTitle());

	}

	@Then("^User fetch the BuySell price$")
	public void user_fetch_the_Buy_Sell_price() throws Throwable {
		System.out.println("Then");

	}

	@Then("^User clicks on the Buy Gold$")
	public void user_clicks_on_the_Buy_Gold() throws Throwable {
		System.out.println("Then");
	}

}