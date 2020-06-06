package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import DataBase.DB_METHODS_Users;
import DataBase.DB_METHODS_gold_transactions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OpenBrowser_stepDefination {

	WebDriver driver;
	public static long web_sellPrice;
	public static long web_goldAmount;
	

	@Given("^User is already GoInvestasi user$")
	public void user_is_already_GoInvestasi_user() throws Throwable {
		DB_METHODS_gold_transactions.db_connect();
		DB_METHODS_Users.db_connect();
		

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\nrjku\\eclipse-workspace\\Sample_Gherkins\\Drivers\\Windows\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--start-maximized");
		chromeOptions.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
		chromeOptions.addArguments("--disable-extensions");
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://goinvestasi-staging.pluang.com/?accessToken="+DB_METHODS_Users.Db_User_OAuth);
		driver.manage().deleteAllCookies();

	}

	@When("^Title is GoInvestasi$")
	public void title_is_GoInvestasi() throws Throwable {

		driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals("GoInvestasi - The Simplest Way To Invest", driver.getTitle());

	}

	@Then("^User fetch the BuySell price$")
	public void user_fetch_the_Buy_Sell_price() throws Throwable {
		System.out.println("Then");
		String price=driver.findElement(By.id("mod-currency-formatter-6")).getText().replaceAll("\\D+","");
		System.out.println(price);
		String sellPrice=price.replaceAll("[.][0-9]+$", "");
		System.out.println(sellPrice);
		web_sellPrice=Long.parseLong(sellPrice);
		
		System.out.println("Website Sell Price: "+ web_sellPrice);
		
		Assert.assertEquals(Long.parseLong(DB_METHODS_gold_transactions.Db_Sell_Price), web_sellPrice);
		return;
	}

	@Then("^User clicks on the Buy Gold$")
	public void user_clicks_on_the_Buy_Gold() throws Throwable {
		System.out.println("Then");
	}

}