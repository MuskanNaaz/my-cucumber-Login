package baseClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LoginCucumberPages.HomePage;
import LoginCucumberPages.LoginPage;
import Utilities.configDetails;


import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public configDetails configData = new configDetails();
	public LoginPage loginPage;
	public Scenario scenario;
	public HomePage homePage;

	public WebDriver setUp(Scenario scenario) {
		String browserName = configData.getBrowser();

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		System.out.println("Test Environment setup");
		System.out.println("------------------------------------------");
		driver.get(configData.getBaseUrl());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//this.scenario = scenario;
		//System.out.println("Executing Scenario" + scenario.getName());
		
		return driver;
	}

	@BeforeMethod
	public LoginPage launchApplication() {
		driver = setUp(scenario);
		loginPage = new LoginPage(driver);
		return loginPage;
	}

	@AfterMethod
	public void tearDown(Scenario scenario) {
		
		
		
		if (scenario.isFailed()) {
			takeScreenShot(scenario.getName());
			
		
			
			System.out.println("Test Environment distroyed");
			System.out.println("-----------------------------------------");
			driver.close();
		}
	}
	
	public void takeScreenShot(String scenarioName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir" ) + "/screenShot/"+scenarioName +".png";
		File fileDestination = new File(destination);
		
		File screenShotDir = new File(System.getProperty("user.dir")+"/screenShot/");
		if(!screenShotDir.exists()) {
			screenShotDir.mkdir();
		}
		
		try {
			FileUtils.copyFile(source, fileDestination);
			System.out.println("ScreenShot saved: "+destination);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	

}
