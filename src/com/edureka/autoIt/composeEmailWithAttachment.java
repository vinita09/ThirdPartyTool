package com.edureka.autoIt;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class composeEmailWithAttachment

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
		driver.get("https://accounts.google.com/ServiceLogin/identifier?flowName=GlifWebSignIn&flowEntry=AddSession");
		wait=new WebDriverWait(driver,40);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
	}
	
	public void RunAutoIt()
	{
		try
		{
			String strFilePath="D:\\SeleniumFiles\\autoit\\Sample.txt";
			String strPath="D:\\SeleniumFiles\\autoit\\attachment.exe";
			String strParameter= strPath + " " + strFilePath;
			Runtime.getRuntime().exec(strParameter);
		}
		catch(Exception e)
		{
			
			System.out.println("unable to upload the attachment");
		}
	}
	
	@Test
	public void emailTest()
	{
		
		WebElement username=driver.findElement(By.id("identifierId"));
		username.sendKeys("edurekavinita@gmail.com");
		
		WebElement gotoPassPage=driver.findElement(By.xpath("//span[@class='RveJvd snByac'][text()='Next']"));
		gotoPassPage.click();
		
		WebElement password=driver.findElement(By.name("password"));
		password.sendKeys("edureka@vinita");
		
		WebElement gotoEbox=driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span"));
		gotoEbox.click();
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.titleContains("My Account"));
		WebElement click2=driver.findElement(By.xpath("//a[@class='WaidBe']"));
		click2.click();
		
		wait.until(ExpectedConditions.titleContains("Inbox"));
		WebElement compose=driver.findElement(By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']"));
		compose.click();
		
		WebElement imgbtn=driver.findElement(By.id(":a6"));
		imgbtn.click();
	
		RunAutoIt();
	}
	
	
	/*@AfterMethod
	public void aftercondition()
	{
		driver.close();
	}*/
	
	
}
