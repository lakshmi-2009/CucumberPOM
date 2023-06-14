package com.automation.pages.base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4JUtility;

public class BasePage {
	protected  static WebDriver driver;
	protected  WebDriverWait wait;
	protected Logger log;
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	protected Log4JUtility logObject = Log4JUtility.getInstance();
	
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		log=(Logger) logObject.getLogger();
	}
	

	
	public void enterUserName(WebElement element,String data, String objectName) {
		System.out.println("***Enter BasePage.enterUserName");
		//driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		  if(element.isDisplayed()) {
			     element.clear();
			     element.sendKeys(data);
			    
			     
			 // log.info(objectName + " is entered to the text filed"); 
			  // report.logTestInfo("pass "+objectName+" is entered into field");
		    } else 
		   log.error(objectName+" element is not displayed");
		  
		  System.out.println("***Exit BasePage.enterUserName function");
		}

	public void enterPasswordName(WebElement element1,String data, String objectName) {
		//WaitUntilElementVisible(element);
		 System.out.println("***Enter BasePage.enterPasswordName function");
		  if(element1.isDisplayed()) {
			     element1.clear();
			     element1.sendKeys(data);
			   log.info(objectName + " is entered to the text filed"); 
			   //report.logTestInfo("pass "+objectName+" is entered into field");
		    } else 
		   log.error(objectName+" element is not displayed");
		  System.out.println("***Exit BasePage.enterPasswordName function");
		}
	
	
	
	public  void loginButton(WebElement LoginButton) {
		         //WaitUntilElementVisible(LoginButton);
	             LoginButton.click();
	             log.info("login button is clicked");
	             System.out.println("I am fron Base page login button");
	             
	   }
	
	public void implicitWait() {
	   driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
	}
	
	public void clearTextfromWebElement(WebElement element) {
		
		element.clear();
	}
	
   public String ActualErrorMessage(WebElement element) {
		
		String text = element.getText();
		System.out.println("From base page ActualErrorMessage");
		return text;	
	}
	
   
   
	public void getHomePageTitle() {
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);	
		}
	
	
	public void clickOnElement(WebElement element) {
		elementToBeClickable(element);
		element.click();	
	}
	
	public void enterText(WebElement element,String text) {
		element.sendKeys(text);
	}
	
	public void clickOn(WebElement element) {
		String s = element.getText();
		System.out.println("  *******from base page");	
	}
	

	public  String getPageTitle() {
		log.info(" got the title of page ");
		return driver.getTitle();	
	}

	public void WaitUntilElementVisible(WebElement ele){	
		WebDriverWait wait = new WebDriverWait(driver,30);
	    wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void elementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	
	public void refreshPage() {
		driver.navigate().refresh();
		log.info(" refreshed the page ");
	}
	
	
	public Alert switchToAlert() {
		
		Alert alert = driver.switchTo().alert();
		log.info(" switched to alert box ");
		return alert;
	}
	
	
   public String getTextFromWebElement(WebElement element, String HomeButtonText){
	   By text = By.xpath("//*[@id=\"home_Tab\"]/a");
	   WebElement HomeButton = driver.findElement(text);
	   String expectedText = HomeButton.getText();
	   return expectedText;	
}































	
	
}
