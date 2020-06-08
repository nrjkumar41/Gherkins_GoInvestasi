package stepDefinations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import Base.Base;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Buy_Gold_HomeScreen_stepDefination extends Base {


	@Given("^User Is On Buy_Page$")
	public void user_Is_On_Buy_Page()  {
	    driver.findElement(By.xpath("//h2[contains(text(),'Buy Gold')]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Buy Now')]")));
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("currency-input")));
	    driver.findElement(By.id("currency-input")).sendKeys("10000000");
	    
	}

	@When("^Title is GoInvestasi - Gold Transaction$")
	public void title_is_GoInvestasi_Gold_Transaction() {
		String Buy_Gold_Title=driver.getTitle();
		Assert.assertEquals("GoInvestasi - Gold Transaction", Buy_Gold_Title);
	    
	}

	@Then("^Validate The Page$")
	public void validate_The_Page()  {
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Buy Now')]")));
	    String buy_page_price= driver.findElement(By.xpath("//span[@id='mod-currency-formatter-1']")).getText().replaceAll("\\D+","");
	}

	@Then("^Enter Gold Gram to Purchase$")
	public void enter_Gold_Gram_to_Purchase() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Assert The Amount Pay$")
	public void assert_The_Amount_Pay() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Assert The Review Transaction$")
	public void assert_The_Review_Transaction() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Approve GoPay$")
	public void approve_GoPay() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Assert Transaction Details$")
	public void assert_Transaction_Details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
