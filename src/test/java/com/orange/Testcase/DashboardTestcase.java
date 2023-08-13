package com.orange.Testcase;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.orange.Base.Basetest;

public class DashboardTestcase extends Basetest{
	
	public static ExtentTest test;
	
	@Test(priority=2)
	public void nav() {
		

		// test=	extent.createTest("loginpage is opened");
			test.log(Status.INFO, "user launched website");
		 lp.username("admin");
		 lp.password("Naveen@1995");
		 lp.loginbutton();	
	      dp.pim();
	//test.log(Status.INFO, "user clicked on pim");
	

}
}