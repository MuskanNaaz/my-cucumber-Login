package StepDefiniations;

import java.time.Duration;

import org.testng.Assert;

import LoginCucumberPages.HomePage;
import baseClass.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinationImpl extends BaseClass {
	

	@Given("I landed on Login Page")
	public void i_landed_on_login_page() {
	    loginPage = launchApplication();
	    System.out.println("Landed on Login Page!!!");
	    
	}

	@When("^Logged my valid (.*) and (.*)$")
	public void logged_my_valid_and(String userName, String password) {
	    loginPage.provideLoginDetails(userName, password);
	    System.out.println("Provide the valid user and password details to login ");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@When("click on the Login Button")
	public void click_on_the_login_button() {
	   loginPage.clickOnSubmit();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	@Then("User should see the DashBoard page with {string}")
	public void user_should_see_the_dash_board_page_with_success(String message) {
		
			if(message.equalsIgnoreCase("success")) {
				homePage = new HomePage(driver);
				String confirmationMessage = homePage.confirmMessage();
				Assert.assertEquals(confirmationMessage, "Welcome To Manager's Page of Guru99 Bank");
			}else if(message.equalsIgnoreCase("error alert!")) {
				String alertMessage = loginPage.getAlertOnWrongCreds();
				Assert.assertTrue(alertMessage.contains("User or Password is not valid"), "Alert message mismatched");
			}
	}

}
	
