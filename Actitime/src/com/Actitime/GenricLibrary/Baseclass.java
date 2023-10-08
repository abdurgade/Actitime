package com.Actitime.GenricLibrary;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.Actitime.Pom.Login;

public class Baseclass {
	FileLibrary f = new FileLibrary();
	public static WebDriver driver;
	@BeforeSuite
	public void DataBaseConnection() {
		Reporter.log("database connected",true);
	}
	
	@BeforeClass
	public void lauchBrowser() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.actitime.com/login.do");
		Reporter.log("Browser Launch",true);
		
	}
	
	@BeforeMethod
	public void login() throws IOException {
//		driver.findElement(By.id("username")).sendKeys("admin");
//		driver.findElement(By.name("pwd")).sendKeys("manager");
//		driver.findElement(By.xpath("//div[.='Login ']")).click();
		Login lp = new Login(driver);
		String un = f.readDataFromPropertyfile("username");
		String pw = f.readDataFromPropertyfile("password");
		lp.getUntbx().sendKeys(un);
		lp.getPwtbx().sendKeys(pw);
		lp.getLgbtn().click();
		
		Reporter.log("Logged in successfully",true);
	}
	
	@AfterMethod
	public void logout() {
		driver.findElement(By.id("logoutLink")).click();
		Reporter.log("logged out successfully",true);
		
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
	
	@AfterSuite
		public void databaseDisconnetion() {
			Reporter.log("data base disconnected",true);
			
		}
	
}
