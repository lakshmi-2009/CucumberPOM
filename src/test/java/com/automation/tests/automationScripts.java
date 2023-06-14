
package com.automation.tests;

		import org.testng.annotations.Test;
		import org.testng.annotations.Test;
        import org.testng.AssertJUnit;
		import org.testng.annotations.Test;
		import org.testng.annotations.Test;
        import org.testng.AssertJUnit;
		import org.testng.annotations.Test;
		import java.time.Duration;
		import java.util.Properties;
		import java.util.concurrent.TimeUnit;
		import org.openqa.selenium.Alert;
		import org.openqa.selenium.By;
		import org.openqa.selenium.ElementNotInteractableException;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.NoSuchElementException;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.FluentWait;
		import org.openqa.selenium.support.ui.Wait;
		import org.openqa.selenium.support.ui.WebDriverWait;
		import org.testng.Assert;
		import org.testng.annotations.Test;
        import com.automation.BaseTests.BaseTestPOM;
        import com.automation.pages.home.HomePage;
        import com.automation.pages.login.LoginPage;
        import com.automation.utility.PropertiesUtility;
		import io.github.bonigarcia.wdm.WebDriverManager;
		import org.apache.logging.log4j.core.Logger;
        import org.apache.logging.log4j.spi.AbstractLogger;
        //import org.junit.Assert.assertArrayEquals;
        //import org.junit.Assert;
        
        
		public class automationScripts extends BaseTestPOM{
			
			@Test
			public void TC_1_salesforce_testscript_1() throws InterruptedException {
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");
				
				String userId = appProp.getProperty("login.valid.userid");
				String password = appProp.getProperty("login.valid.password");
				
				LoginPage loginPage = new LoginPage(driver);
				loginPage.enterUserNameLoginPage(userId);
				loginPage.clearPasswordField();
				driver = loginPage.clcikButton();
				
				String actualError = loginPage.getLoginPageErrorText();
				String expectedError = appProp.getProperty("expected.login.errorMessage");
				AssertJUnit.assertEquals("loginErrorText matched with expected", expectedError, actualError);
				log.info("actualError is matched with expectedError");
				
				 }
			
			@Test
			public void TC_2_login_to_salesforce_testscript() throws InterruptedException {
				log.info("inside salesforce test method");
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");
				log.info("application data property file is loaded");
				
				String userId = appProp.getProperty("login.valid.userid");
				String password = appProp.getProperty("login.valid.password");
				
				LoginPage loginPage = new LoginPage(driver);
				loginPage.enterUserNameLoginPage(userId);
				loginPage.enterPasswordLoginPage(password);
				
				Thread.sleep(4000);
				driver = loginPage.clcikButton();
				 }
			
			
			@Test
			public void TC_3_rememberMe_checkbox() throws InterruptedException {
				log.info("inside salesforce login page");
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");
				log.info("application data property file is loaded");
				
				String userId = appProp.getProperty("login.valid.userid");
				String password = appProp.getProperty("login.valid.password");
				
				LoginPage loginPage = new LoginPage(driver);
				loginPage.enterUserNameLoginPage(userId);
				loginPage.enterPasswordLoginPage(password);
				loginPage.rememberMeCheckbox();
				Thread.sleep(4000);
				
				driver = loginPage.clcikButton();
				 }
			
			
			
			
			@Test
			public void TC_3_Home_page() throws InterruptedException {
				log.info("inside salesforce home page");
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");
				log.info("application data property file is loaded");
				
				String userId = appProp.getProperty("login.valid.userid");
				String password = appProp.getProperty("login.valid.password");
				LoginPage loginPage = new LoginPage(driver);
				loginPage.enterUserNameLoginPage(userId);
				loginPage.enterPasswordLoginPage(password);
				driver = loginPage.clcikButton();
				
				HomePage homePage = new HomePage(driver);
				homePage.clickOnUserMenu();
			}
			
			
			
		/*	
			@Test
			public void TC_4_rememberMe_checkbox() throws InterruptedException {
				log.info("inside salesforce Home Page method");
				PropertiesUtility pro=new PropertiesUtility();
				Properties appProp= pro.loadFile("applicationDataProperties");
				log.info("application data property file is loaded");
				
				String userId = appProp.getProperty("login.valid.userid");
				String password = appProp.getProperty("login.valid.password");
				
				HomePage HomePage = new HomePage(driver);
				loginPage.enterUserNameLoginPage(userId);
				loginPage.enterPasswordLoginPage(password);
				loginPage.rememberMeCheckbox();
				Thread.sleep(4000);
				
				
				driver = loginPage.clcikButton();
				 }*/
			
			
			
			
			}
			
		