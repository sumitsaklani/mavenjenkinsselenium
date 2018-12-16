package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.testng.annotations.Test;

import com.qa.util.TestUtil;

import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {

	public static WebDriver driver;
	public static Properties  prop;

	public TestBase(){
		prop = new Properties();
		try {
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\config\\config.properties");
			prop.load(fin);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}	
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize() {
		if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Sumit\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			}
		/*else if(prop.getProperty("browser").equalsIgnoreCase("FF")){
			System.setProperty("webdriver.firefox.driver","C:\\Users\\Sumit\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new FirefoxDriver();
			}*/
		
		driver.manage().window().maximize();
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicitWaitTime, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

/*	@Test
	public void printuserdir() {
		initialize();		
	}*/

}
