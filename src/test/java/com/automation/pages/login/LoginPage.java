package com.automation.pages.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pages.base.BasePage;

public class LoginPage extends BasePage {

	//By userName = By.name("username");
	//WebElement userNameElement = driver.findElement(userName);
	
	
	@FindBy(name = "username") WebElement userNameElement;          
	@FindBy(xpath="//input[@name='pw']") WebElement passwordElement;  
	@FindBy(id="Login") WebElement LoginButton; 
	@FindBy(xpath="//*[@id=\"error\"]") WebElement loginErrorText;
	@FindBy(xpath="//*[@id=\"setupEnableLightningCallout\"]/div/input") WebElement GetStarted;
	@FindBy(xpath="//*[@id=\"rememberUn\"]") WebElement rememberCheckBox;
		
	public LoginPage(WebDriver driver) {
		super(driver);
		System.out.println("Loginpage called");
	}
	
	public void enterUserNameLoginPage(String usernamedata) {	
		enterUserName(userNameElement, usernamedata, "username");	
	}
	
	public void enterPasswordLoginPage(String passworddata) {
		enterPasswordName(passwordElement, passworddata, "password");	
	}
	
	public void clearPasswordField() {
		clearTextfromWebElement(passwordElement);
	}
	
	
	public WebDriver clcikButton() {
		System.out.println("I am fron Login page clickButton");
		loginButton(LoginButton);
		System.out.println("after Login page clickButton");
		return driver;
	}
	
	public String getLoginPageErrorText() {
		System.out.println("From login page getLoginPageErrorText");
		String text1 = ActualErrorMessage(loginErrorText);
		return text1;
	}
	
	//finding HomePageElement
	public void findElementOnWebPage() {
		getHomePageTitle();
	}
	
	public void rememberMeCheckbox() {
		clickOnButton(rememberCheckBox, "rememberCheckBox");
		System.out.println("rememberCheckBox is clicked");
	}
	

	public String getPageTitle() {
		
		return getPageTitle();
	}
	
	
	
	
}
