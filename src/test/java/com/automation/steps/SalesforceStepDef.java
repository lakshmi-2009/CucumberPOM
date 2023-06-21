package com.automation.steps;

import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import com.automation.pages.home.HomePage;
import com.automation.pages.login.LoginPage;
import com.automation.utility.Log4JUtility;
import com.automation.utility.PropertiesUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceStepDef {
	protected static Logger log;
	public  static WebDriver driver;
	protected static Log4JUtility logObject=Log4JUtility.getInstance();
	LoginPage login;
	HomePage home;

	public  void launchBrowser(String browserName)	{
		   
		 switch(browserName) {
		
		   case "firefox":  
			   browserName.equalsIgnoreCase("firefox");
			   WebDriverManager.firefoxdriver().setup();
	    	   driver = new FirefoxDriver();
			   driver.manage().window().maximize();
			   driver.get("https://www.firefox.com/");
		   break;
			
		    case "chrome":  
		    	browserName.equalsIgnoreCase("chrome");
		    	WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://www.google.com/");
			   
		    break;
		    case "salesforce":  
		    	browserName.equalsIgnoreCase("salesforce");
		    	WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://login.salesforce.com/");
			   
		    break;
		    case "firebase":  
		    	browserName.equalsIgnoreCase("firebase");
		    	WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://qa-tekarch.firebaseapp.com/");
			   
		    break;
		    }
	       }
	
	
	public  void	goToUrl(String url) {
		driver.get(url);
		log.info(url+"went to url and fetched url");
	} 
	
	public void closeBrowser() {
		driver.close();
		log.info("closed the driver ");
	}
	
	@BeforeAll
	public static void setUpBeforeAllScenarios() {
		log=logObject.getLogger();
	}
	@Before
	public void setUpEachScenario() {
		
		launchBrowser("chrome");
		
	}
	@After
	public void tearDown() {
		closeBrowser();
	}
	
	
	@Given("user opens salesforce application")
	public void user_open_salesforce_application() {
		PropertiesUtility pro=new PropertiesUtility();
		Properties appProp= pro.loadFile("applicationDataProperties");
		String url= appProp.getProperty("url");
		goToUrl(url);
		System.out.println("driver in baseTest="+driver);
	}

	@When("user on {string}")
	public void user_on(String page) {
		 if(page.equalsIgnoreCase("Login Page"))
		    	login=new LoginPage(driver);
		    else if(page.equalsIgnoreCase("homepage"))
		    	home=new HomePage(driver);
	}

	@When("user enters correct username into text box as {string}")
	public void user_enters_value_into_text_box_username_as(String userId) {
		login.enterUserNameLoginPage(userId);
	}

	@When("user enters correct password into text box as {string}")
	public void user_enters_value_into_text_box_password_as(String password) {
	    login.enterPasswordLoginPage(password);
	}

	@When("user clicks on Login button")
	public void click_on_login_button() {
		driver= login.clcikButton();
	}

	@Then("verify home page title as {string}")
	public void verify_page_title_as(String expectedText) {
		String actualText= home.getPageTitle();
		Assert.assertEquals(actualText, expectedText);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
