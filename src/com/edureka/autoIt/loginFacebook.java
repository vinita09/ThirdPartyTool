package com.edureka.autoIt;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.BeforeMethod;

public class loginFacebook

{
	public static WebDriver driver=null;
	public static WebDriverWait wait=null;
	public static String chromeKey="webdriver.firefox.marionette";
	public static String chromevalue="D:\\SeleniumFiles\\Selenium\\Drivers\\geckodriver.exe";
	
	@BeforeMethod
	public void precondition()
	{
		
		System.setProperty(chromeKey, chromevalue);
		driver= new FirefoxDriver();
		driver.get("https://www.facebook.com");
		wait=new WebDriverWait(driver,40);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void loginToFacebook()throws FindFailed
	{
		
		Screen screen= new Screen();
		Pattern username= new Pattern("D:\\SeleniumFiles\\username.png");
		Pattern password= new Pattern("D:\\SeleniumFiles\\password.png");
		Pattern login= new Pattern("D:\\SeleniumFiles\\login.png");
		
		screen.wait(username, 10);
		screen.type(username,"vinitasinghi93@gmail.com" );
		screen.type(password,"tobecontinued@22");
		screen.click(login);
	}

}
