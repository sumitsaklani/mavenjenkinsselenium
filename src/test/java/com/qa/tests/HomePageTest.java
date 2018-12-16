package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.*;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		Assert.assertEquals(homePage.verifyHomePageTitle(),"CRMPRO","Title not matched");
	}
	
	@Test(priority=2)
	public void userNameTest() {
		Assert.assertTrue(homePage.verifyUserName());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
