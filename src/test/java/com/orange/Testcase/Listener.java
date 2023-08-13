package com.orange.Testcase;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Listener extends TestListenerAdapter{
	
	 public static ExtentReports extent;
		public ExtentHtmlReporter htmlreport;
		public ExtentTest test;
		
	    public void onStart(ITestContext tr) {					
	    	extent=new ExtentReports();
	    		htmlreport=new ExtentHtmlReporter("./Reports/spark.html");
	    		extent.attachReporter(htmlreport);
	        		
	    }		

	   	

			
	    public void onTestFailure(ITestResult tr) {					
	        // TODO Auto-generated method stub				
	    	 test=	extent.createTest(tr.getName());
		 		test.log(Status.FAIL, "user login failed");	
	    }		

	 	
	    public void onTestSkipped(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		

			
	    public void onTestStart(ITestResult tr) {					
	        // TODO Auto-generated method stub
	    	 test=	extent.createTest(tr.getName());
	 		test.log(Status.INFO, "user launched website");
	        		
	    }		

	 		
	    public void onTestSuccess(ITestResult arg0) {					
	        // TODO Auto-generated method stub				
	        		
	    }		
	    public void onFinish(ITestContext arg0) {					
	        // TODO Auto-generated method stub	
			extent.flush();
	        		
	    }
}
