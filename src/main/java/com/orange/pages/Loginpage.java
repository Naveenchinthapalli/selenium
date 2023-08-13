package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.Base.Basetest;

public class Loginpage  {
	
	public WebDriver driver;
	
	public Loginpage(WebDriver driver) {
      this.driver =driver;
	PageFactory.initElements(driver,this);
	
	}
	
	
	
    @FindBy(id = "txtUsername")
	private WebElement username;
	
    @FindBy(name = "txtPassword")
	private WebElement password;

	@FindBy(className = "button")
	private WebElement loginButton;
	
	@FindBy(id = "welcome")
	private WebElement welcomeadmin;
	
	@FindBy(xpath="//*[text()='Logout']")
	private WebElement logout;
	
	
	public void  username(String user) {
		username.sendKeys(user);
	}
	
	public void password(String pass) {
		password.sendKeys(pass);
	}
	
	public Dashboardpage loginbutton() {
		loginButton.click();
		return new Dashboardpage(driver);
		
	}
	public void logout() {
		WebDriverWait wait =new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Logout']")));
		logout.click();
	}
	
	
	

}
