package eCom.qa.utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGE_WAIT_TIME=5;
	
	public static String getScreenshot(WebDriver driver, String testName) {
		File srcSS = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationSSPath = System.getProperty("user.dir"+"\\Screenshots"+testName+".png");
		try {
			FileHandler.copy(srcSS, new File (destinationSSPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationSSPath;
	}
}
