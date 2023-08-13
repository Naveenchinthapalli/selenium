package com.orange.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutility {
	

	public static void screenshot(WebDriver driver,String username) throws IOException {
		TakesScreenshot sc= ((TakesScreenshot)driver);
	File src=	sc.getScreenshotAs(OutputType.FILE);
	File dest=new File("./Screenshots/"+username+".png");
			FileUtils.copyFile(src, dest);
	}

}
