package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	private WebDriverWait wait = new WebDriverWait(driver,10);
	//Page factory or object repository
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginButton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signupButton;
	
	@FindBy(xpath="//img[contains(@alt,'free crm logo')]")
	WebElement logo;	
	
	//Initializing OR(object repository)
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions on page
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLogo() {
		return logo.isDisplayed();
	}
	
	public HomePage login(String uname,String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		By preloader=By.id("preloader");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(preloader));
		loginButton.click();
		
		return new HomePage();
	}
}
