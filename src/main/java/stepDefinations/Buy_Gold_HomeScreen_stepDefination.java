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

public class Buy_Gold_HomeScreen_stepDefination extends Base {
	public static long Entred_Gold_Buy;

	@Given("^User Is On Buy_Page$")
	public void user_Is_On_Buy_Page() {
		driver.findElement(By.xpath("//h2[contains(text(),'Buy Gold')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Buy Now')]")));

	}

	@When("^Title is GoInvestasi - Gold Transaction$")
	public void title_is_GoInvestasi_Gold_Transaction() {
		String Buy_Gold_Title = driver.getTitle();
		Assert.assertEquals("GoInvestasi - Gold Transaction", Buy_Gold_Title);

	}

	@Then("^Validate The Page$")
	public void validate_The_Page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Buy Now')]")));
		String buy_page_price = driver.findElement(By.xpath("//span[@id='mod-currency-formatter-1']")).getText()
				.replaceAll("\\D+", "");
		System.out.println("Buy Price on Buy transaction Page : " + buy_page_price);
//	    Assert.assertEquals(Long.parseLong(DB_METHODS_gold_transactions.Db_Buy_Price), Long.parseLong(buy_page_price));
		String Total_amount_buy_page = driver.findElement(By.xpath("//span[@id='mod-currency-formatter-2']")).getText()
				.replaceAll("\\D+", "");
		System.out.println("Total Amount on Buy transaction Page : " + Total_amount_buy_page);
//	    Assert.assertEquals(OpenBrowser_stepDefination.web_Amount, Long.parseLong(buy_page_price));
	}

	@Then("^Enter Gold Gram to Purchase$")
	public void enter_Gold_Gram_to_Purchase() {
		wait.until(ExpectedConditions.elementToBeClickable(By.id("currency-input")));
		driver.findElement(By.id("currency-input")).sendKeys("10000000");
		String Temp_Entred_Gold_Buy = driver.findElement(By.xpath("//input[@id='gram-input']")).getText().replace(",",
				".");
		Entred_Gold_Buy = Long.parseLong(Temp_Entred_Gold_Buy);
		System.out.println("Gold Amount mentioned on Buy Gold Page: " + Entred_Gold_Buy);
		driver.findElement(By.xpath("//button[contains(text(),'Buy Now')]")).click();
		return;
	}

	@Then("^Assert The Amount Pay$")
	public void assert_The_Amount_Pay() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'Review transaction')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Confirm')]")));
		String Review_Amount_Gold_Buy = driver.findElement(By.xpath("//span[@id='mod-currency-formatter-1']")).getText()
				.replaceAll("\\D+", "").replace(",", ".");
		System.out.println("Review Amount Gold Buy" + Review_Amount_Gold_Buy);
		Assert.assertEquals(Long.parseLong(Review_Amount_Gold_Buy) / (OpenBrowser_stepDefination.web_buyPrice),
				Entred_Gold_Buy);

	}

	@Then("^Assert The Review Transaction$")
	public void assert_The_Review_Transaction() {

		System.out.println("Review Transaction Done");
	}

	@Then("^Approve GoPay$")
	public void approve_GoPay() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'GoPay')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Pay')]")));

		driver.findElement(By.xpath("//button[contains(text(),'Pay')]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'GoPay')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Click here to redirect to merchant")));
		driver.findElement(By.linkText("Click here to redirect to merchant")).click();

	}

	@Then("^Assert Transaction Details$")
	public void assert_Transaction_Details() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Transaction detail')]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Back To Home')]")));
		
		String Total_Investment_Top=driver.findElement(By.xpath("//h2[@id='mod-currency-formatter-1']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Total Investment value to TopSection"+Total_Investment_Top);
		
		String Gold_Amount_Top = driver.findElement(By.xpath("//label[@class='width-100']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Gold Amount to TopSection"+Gold_Amount_Top);
		
		String Total_Investment_DetailInvoice=driver.findElement(By.xpath("//label[@id='mod-currency-formatter-4']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Total Investment value to TopSection"+Total_Investment_DetailInvoice);
		
		String Gold_Amount_DetailInvoice = driver.findElement(By.xpath("//label[@id='mod-currency-formatter-2']")).getText().replaceAll("\\D+","").replace(",", ".");
		System.out.println("Gold Amount to TopSection"+Gold_Amount_DetailInvoice);
		
		Assert.assertEquals(Long.parseLong(Total_Investment_Top),Long.parseLong(Total_Investment_DetailInvoice));
		Assert.assertEquals(Long.parseLong(Gold_Amount_Top),Long.parseLong(Gold_Amount_DetailInvoice));
		
		driver.findElement(By.xpath("//button[contains(text(),'Back To Home')]")).click();
	}

}
