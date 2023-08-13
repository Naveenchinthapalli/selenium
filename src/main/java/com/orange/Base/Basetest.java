package com.orange.Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.orange.pages.Dashboardpage;
import com.orange.pages.Loginpage;
import com.orange.util.Logutility;

public class Basetest {
	
	public WebDriver driver;
	public Loginpage lp;
	public Dashboardpage dp;
   
	
	@BeforeClass
	public void launchbrowser() throws IOException {
		
		FileInputStream fis1=new FileInputStream("D:\\eclipse IDE 2021\\AptsolFirstPractice\\src\\main\\java\\com\\orange\\testdata\\Aptsolpractice.xlsx");
		
		FileInputStream fis =new FileInputStream("D:\\eclipse IDE 2021\\AptsolFirstPractice\\url.properties");
		Properties prop=new Properties();
          prop.load(fis);
          String Browser=prop.getProperty("browser");
       
          if(Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\Drivers\\chromedriver_win32\\chromedriver.exe");	
			driver=new ChromeDriver();
			
		}else if(Browser.equalsIgnoreCase("firefox")){
			driver=new FirefoxDriver();
		}else {
			driver=new EdgeDriver();
			
		}
		
		driver.get("http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login");
		driver.manage().window().maximize();
		Logutility.info("Browser is launched");
	
		lp=new Loginpage(driver);
		dp=new Dashboardpage(driver);
		
		
		
	}
	

	
	
	
	@AfterClass
	public void teardown() {

		driver.close();
	}
	
	
	
	
	

}
