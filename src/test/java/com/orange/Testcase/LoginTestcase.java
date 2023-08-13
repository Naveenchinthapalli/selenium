package com.orange.Testcase;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orange.Base.Basetest;
import com.orange.pages.Dashboardpage;
import com.orange.pages.Loginpage;
import com.orange.util.Excelutilities;
import com.orange.util.Logutility;
import com.orange.util.Screenshotutility;

public class LoginTestcase extends Basetest  {
public Loginpage lp;
public Dashboardpage dp;
public static ExtentTest test;



	
@Test(priority=1,dataProvider="login")
 public void loginValidation(String username,String password) throws IOException {
	
	lp=new Loginpage(driver); 

	try {

	 lp.username(username);
	 lp.password(password);
	 lp.loginbutton();
	 Logutility.info("user clicked login button");
	lp.logout();
	}catch(Exception e) {
		Screenshotutility.screenshot(driver, username);
		 Logutility.info("user taken screenshot");
	
	}
 }
 
 

 
@DataProvider(name="login")
 public String[][] multipletestData() throws IOException {
	 String filepath="D:\\eclipse IDE 2021\\AptsolFirstPractice\\src\\main\\java\\com\\orange\\testdata\\Aptsolpractice.xlsx";
	int rowcount= Excelutilities.getLastRowNum(filepath, "Sam");
	 int colcount=Excelutilities.getLastcellNum(filepath, "Sam", 1);
	 String [][] data=new String[rowcount][colcount]; //2 , 2
	// System.out.println(colcount);
	 for(int i=1;i<=rowcount;i++) {
		 for(int j=0;j<colcount;j++) {
	data[i-1][j]	= Excelutilities.getCellValue(filepath, "Sam", i, j);
		 }
	 }
	return data; 
 }
		
	
}
