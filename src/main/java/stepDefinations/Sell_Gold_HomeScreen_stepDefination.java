package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.Base;
import DataBase.DB_METHODS_gold_transactions;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Sell_Gold_HomeScreen_stepDefination extends Base{
	public static long Entred_Gold_Sell;
	public static long Sell_Transaction_ID;
	@Given("^User Is On Buy_Page$")
	public void user_Is_On_Buy_Page()  {
		driver.findElement(By.xpath("//h2[contains(text(),'Sell Gold')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sell Now')]")));

	}

	@When("^Title is GoInvestasi - Gold Transaction$")
	public void title_is_GoInvestasi_Gold_Transaction() {
		String Sell_Gold_Title = driver.getTitle();
		Assert.assertEquals("GoInvestasi - Gold Transaction", Sell_Gold_Title);
	}

	@Then("^Validate The Page$")
	public void validate_The_Page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Sell Now')]")));
		String sell_page_price = driver.findElement(By.xpath("//span[@id='mod-currency-formatter-1']")).getText()
				.replaceAll("\\D+", "");
		System.out.println("Sell Price on Sell transaction Page : " + sell_page_price);
//	    Assert.assertEquals(Long.parseLong(DB_METHODS_gold_transactions.Db_Sell_Price), Long.parseLong(sell_page_price));
		String Total_amount_sell_page = driver.findElement(By.xpath("//span[@id='mod-currency-formatter-2']")).getText()
				.replaceAll("\\D+", "");
		System.out.println("Total Amount on Sell transaction Page : " + Total_amount_sell_page);
//	    Assert.assertEquals(OpenBrowser_stepDefination.web_Amount, Long.parseLong(Total_amount_sell_page));
	
	}

	@Then("^Enter Gold Gram to Purchase$")
	public void enter_Gold_Gram_to_Purchase() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("currency-input")));
		driver.findElement(By.id("currency-input")).sendKeys("5000000");
		String Temp_Entred_Gold_Sell = driver.findElement(By.xpath("//input[@name='quantity']")).getText().replace(",",
				".");
		Entred_Gold_Sell = Long.parseLong(Temp_Entred_Gold_Sell);
		System.out.println("Gold Amount mentioned on Sell Gold Page: " + Entred_Gold_Sell);
		driver.findElement(By.xpath("//button[contains(text(),'Sell Now')]")).click();
		return;
	}

	@Then("^Assert The Amount Sell_Cashout$")
	public void assert_The_Amount_Sell_Cashout() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Review transaction')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Confirm')]")));
		String Review_Amount_Gold_Sell = driver.findElement(By.xpath("//span[@id='mod-currency-formatter-1']")).getText()
				.replaceAll("\\D+", "").replace(",", ".");
		System.out.println("Review Amount Gold Sell" + Review_Amount_Gold_Sell);
		Assert.assertEquals(Long.parseLong(Review_Amount_Gold_Sell) / (OpenBrowser_stepDefination.web_sellPrice),
				Entred_Gold_Sell);
	}

	@Then("^Assert Transaction Details$")
	public void assert_Transaction_Details() throws Throwable{
		System.out.println("Review Sell Transaction Done");
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Transaction detail')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Back To Home')]")));
		
		String Total_Earnings_Top=driver.findElement(By.xpath("//h2[@id='mod-currency-formatter-1']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Total Earnings value to TopSection"+Total_Earnings_Top);
		
		String Gold_Amount_Top = driver.findElement(By.xpath("//label[@class='width-100']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Gold Amount to TopSection"+Gold_Amount_Top);
		
		String Total_Earnings_DetailInvoice=driver.findElement(By.xpath("//label[@id='mod-currency-formatter-4']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Total Earnings value to TopSection"+Total_Earnings_DetailInvoice);
		
		String Gold_Amount_DetailInvoice = driver.findElement(By.xpath("//label[@id='mod-currency-formatter-2']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Gold Amount to TopSection"+Gold_Amount_DetailInvoice);
		
		Assert.assertEquals(Long.parseLong(Total_Earnings_Top),Long.parseLong(Total_Earnings_DetailInvoice));
		Assert.assertEquals(Long.parseLong(Gold_Amount_Top),Long.parseLong(Gold_Amount_DetailInvoice));
		String Transaction_Url=driver.getCurrentUrl().replaceAll("\\D+","");
		Sell_Transaction_ID=Long.parseLong(Transaction_Url);
		driver.findElement(By.xpath("//button[contains(text(),'Back To Home')]")).click();
		return;
	}

	@Then("^Open Admin Panel$")
	public void open_Admin_Panel() {
		driver.navigate().to("staging-admin.pluang.com/");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='adminLogo']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("formBasicEmail")));
		driver.findElement(By.id("formBasicEmail")).sendKeys("neeraj.kumar@pluang.com");
		driver.findElement(By.id("formBasicPassword")).sendKeys("12345678");
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click(); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Super Admin')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Finance')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cashout')]")));
		driver.findElement(By.xpath("//a[contains(text(),'Cashout')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'CashOut List')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Cashout')]")));
		
		
	}

	@Then("^Navigate To CashOut$")
	public void navigate_To_CashOut() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Assert Casshout Status$")
	public void assert_Casshout_Status() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Change Cashout_Status via API$")
	public void change_Cashout_Status_via_API() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^Close the Admin_Panel$")
	public void close_the_Admin_Panel() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

}
