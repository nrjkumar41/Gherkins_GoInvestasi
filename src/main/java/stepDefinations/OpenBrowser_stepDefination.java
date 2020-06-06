package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import DataBase.DB_METHODS;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenBrowser_stepDefination {

	WebDriver driver;
	public static double web_sellPrice;
	

	@Given("^User is already GoInvestasi user$")
	public void user_is_already_GoInvestasi_user() throws Throwable {
		DB_METHODS.db_connect();

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nrjku\\eclipse-workspace\\Sample_Gherkins\\Drivers\\Windows\\chromedriver.exe");
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
//		driver = new ChromeDriver(chromeOptions);
		driver = new ChromeDriver();
		driver.get("https://goinvestasi-staging.pluang.com/?accessToken=MTU5MTQzMDAwODg0NDEwNzY5MDZvWXZsZGdrZVlI");
		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
		driver.manage().window().fullscreen();

	}

	@When("^Title is GoInvestasi$")
	public void title_is_GoInvestasi() throws Throwable {

		driver.getTitle();
		System.out.println(driver.getTitle());

	}

	@Then("^User fetch the BuySell price$")
	public void user_fetch_the_Buy_Sell_price() throws Throwable {
		System.out.println("Then");
		System.out.println(DB_METHODS.Db_Buy_Price);
		String sellPrice=driver.findElement(By.id("mod-currency-formatter-6")).getText().replaceAll("\\D+","");
		double web_sellPrice=Double.parseDouble(sellPrice);
		System.out.println("Website Sell Price: "+ web_sellPrice);
		
		Assert.assertEquals(DB_METHODS.Db_Sell_Price, web_sellPrice);
		return;
	}

	@Then("^User clicks on the Buy Gold$")
	public void user_clicks_on_the_Buy_Gold() throws Throwable {
		System.out.println("Then");
	}

}