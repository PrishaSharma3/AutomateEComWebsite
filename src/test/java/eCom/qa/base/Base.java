package eCom.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import eCom.qa.utilities.Utilities;

public class Base {
	
	WebDriver driver;
	public Properties prop;
	
	public Base() {
		
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\eCom\\qa\\config\\config.properties");
		try {
		    // Instantiate a FileInputStream object
		    FileInputStream fis = new FileInputStream(propFile); 
		    prop.load(fis);
		} catch (Throwable e) {
		    e.printStackTrace();
		}
	}

	public WebDriver SetBrowserAndOpenURL(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		}
		
		//open the website
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("URL"));
		
		return driver;
	}
	
}
