package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: Sumit Saklani')]")
	WebElement userNameLabel;

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;

	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	public HomePage() {
		PageFactory.initElements(driver,this);
	}

	public boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	public ContactsPage clickOnContactsLink() {
		contactLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}

}
