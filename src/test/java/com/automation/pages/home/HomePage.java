package com.automation.pages.home;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.pages.base.BasePage;

public class HomePage extends BasePage {

	@FindBy(xpath="//*[@id=\"userNav-arrow\"]") WebElement userMenu;
	String expectedText="Home Page ~ Salesforce - Developer Edition";
	public HomePage(WebDriver driver) {
		super(driver);
		
	}

	public void HomePage() {
		PageFactory.initElements(driver, this);
		log=(Logger) logObject.getLogger();
	}
	public void getHomePageTitle() {
		getPageTitle();
	}
	public void clickOnUserMenu() {
		System.out.println("from HOME PAGE BEFORE CLICK");
		clickOnButton(userMenu,"userMenuDropdown");
		System.out.println("from HOME PAGE AFTER CLICK");
		
	}
	
	
 }	
	

