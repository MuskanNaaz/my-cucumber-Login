package LoginCucumberPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements( driver, this);
		
	}
	
	@FindBy(name = "uid")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(name = "btnLogin")
	WebElement submitButton;
	
	public void provideLoginDetails(String userId, String password) {
		userName.sendKeys(userId);
		passwordInput.sendKeys(password);
	}
	
	
	public void clickOnSubmit() {
		submitButton.click();
	}
	
	public String getAlertOnWrongCreds() {
		String alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		System.out.println("Alert Message : "+ alertMessage);
		return alertMessage;
	}

}
