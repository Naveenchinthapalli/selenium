package com.orange.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.orange.Base.Basetest;

public class Dashboardpage extends Basetest{
	public WebDriver driver;
	
	public Dashboardpage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "welcome")
	private WebElement welcomeadmin;
	
	@FindBy(linkText = "PIM")
	private WebElement pim;
	
	@FindBy(xpath="//*[text()='Logout']")
	private WebElement logout;
	
	public void welcomeadmin() {
		
		welcomeadmin.click();
		
	}
	
	public void logout() {
		WebDriverWait wait =new WebDriverWait(driver,20);
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[text()='Logout']")));
		logout.click();
	}
	public void pim() {
		pim.click();
	}
	
	

}
