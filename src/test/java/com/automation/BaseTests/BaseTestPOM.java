package com.automation.BaseTests;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.automation.utility.Constants;
import com.automation.utility.ExtentReportsUtility;
import com.automation.utility.Log4JUtility;
//import com.automation.utility.Log4JUtility;
import com.automation.utility.PropertiesUtility;
import io.github.bonigarcia.wdm.WebDriverManager;




public class BaseTestPOM {

	protected static WebDriver driver;
	protected  WebDriverWait wait;
	protected Logger log;
	protected ExtentReportsUtility report = ExtentReportsUtility.getInstance();
	protected Log4JUtility logObject = Log4JUtility.getInstance();
	
	@BeforeTest
	public void BeforeTest() {
		log=LogManager.getLogger(BaseTestPOM.class.getName());
		
	}
	
	@BeforeMethod
	@Parameters("browserName")
	public void BeforeMethod(@Optional("chrome")String browseName) {
		PropertiesUtility pro = new PropertiesUtility();
		Properties appProp = pro.loadFile("applicationDataProperties");
		 String url = appProp.getProperty("url");
		launchBrowser(browseName);
		 goToUrl(url);	
		log.info("url entered successfully");
	}
	
	/*@AfterMethod 
	public void tearDownAfterTestMethod()   {
		System.out.println("inside AfterMethod");
		driver.close();
		System.out.println("*************** end of AfterMethod");
		log.info("driver is closed");
	}*/
	//=================================================================//
	public  void	goToUrl(String url) {
		driver.get(url);
		log.info(url+"went to url and fetched url");
	} 
	
	//=================================================================//
	
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
	
	//=================================================================//
	public void closeBrowser() {
		driver.close();
		log.info("closed the driver ");
	}
	//=================================================================//
	
	public void closeAllBrowsers() {
	    driver.quit();
	}
	
	//=================================================================//
	public  String getPageTitle() {
		log.info(" got the title of page ");
		return driver.getTitle();	
	}
	
	//=================================================================//
    public void WaitUntilElementVisible(WebElement ele, String objName){	
		System.out.println("wait until element"+objName +"visible");
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(ele));
				
	}
	//=================================================================//	
			
	public void refreshPage() {
		driver.navigate().refresh();
		log.info(" refreshed the page ");
	}	
	//=================================================================//
			
	public Alert switchToAlert() {
		Alert alert = driver.switchTo().alert();
		log.info(" switched to alert box ");
		return alert;
	}	
	//=================================================================//	
	
	public void enterText(WebElement element,String data, String objectName) {
		  if(element.isDisplayed()) {
	   	     element.clear();
	   	     element.sendKeys(data);
	   	   log.info(objectName + " is entered to the text filed"); 
	   	   report.logTestInfo("pass "+objectName+" is entered into field");
	        } else 
	       log.error(objectName+" element is not displayed");
	}
	
	//=================================================================//
	
	public  void clickButton(WebElement LoginButton) {
		  LoginButton= driver.findElement(By.id("Login"));
		  LoginButton.click();
		  log.info("login button is clicked");
	 }
	//=================================================================//
	
	public File getScreenShot() {
		String date = new SimpleDateFormat("yyyy_mm__dd_hh_mm_ss").format(new Date());
		TakesScreenshot screenShot = (TakesScreenshot)driver;
		File imgFile = screenShot.getScreenshotAs(OutputType.FILE);
		File destinationFile = new File(Constants.SCREENSHOTS_DIRECTORY_PATH+date+"  .png");
		
		try {
			FileUtils.copyFile(imgFile, destinationFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screenShot captured at "+destinationFile.getAbsolutePath());
		return destinationFile;
	}
	//=================================================================//
	public String getTextFromWebElement(WebElement element,String obj){
	
           if(element.isDisplayed()) {
	            return element.getText();
                }
           else {
	             log.info("element is not displayed");
	             return null;
                 }
	 }
	//=================================================================//
	
	public void fluentWaitForWebElement(WebElement element) {
	Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofSeconds(5))
			.ignoring(NoSuchElementException.class);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	//=================================================================//
	
	
}	
	


	
	

