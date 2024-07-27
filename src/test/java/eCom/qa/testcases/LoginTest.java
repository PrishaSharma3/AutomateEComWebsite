package eCom.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCom.qa.base.Base;
import eCom.qa.pageObjects.HomePage;
import eCom.qa.pageObjects.LoginPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;	


public class LoginTest extends Base {
	
	public LoginTest() {
		super();
	}
	public WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	@BeforeMethod
	public void setup() {
		
		//set brower
		driver = SetBrowserAndOpenURL(prop.getProperty("browserName"));
	}
	
	@Test
	public void verifyLoginWithValidCreds() throws InterruptedException {
		
		homePage = new HomePage(driver);
		loginPage = new LoginPage(driver);
		//Navigate to signin screen
		
		homePage.ClickOnSignInButton();		
		
		//Upon redirection enter mobile number and continue 	
		
		loginPage.enterId.sendKeys(prop.getProperty("validID"));
		loginPage.hitContinueBtn();
		
		//Upon redirection enter password and signin
		loginPage.enterPass.sendKeys(prop.getProperty("validPass"));
		loginPage.hitSubmitBtn();
		
		//Check if login is correct and successful: if the username is displayed
		Assert.assertTrue(driver.findElement(By.xpath("(//span[@id='nav-link-accountList-nav-line-1' and (//span[@id='nav-link-accountList-nav-line-1'])[1]])[1]")).isDisplayed());
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
