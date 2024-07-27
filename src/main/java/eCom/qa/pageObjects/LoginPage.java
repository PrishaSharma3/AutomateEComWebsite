package eCom.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Objects
	@FindBy (xpath="//input[@id='ap_email']")
	public WebElement enterId;
	
	@FindBy (xpath="//input[@id='continue']")
	private WebElement continueBtn;
	
	@FindBy (xpath="//input[@id='ap_password']")
	public WebElement enterPass;
	
	@FindBy (xpath="//input[@id='signInSubmit']")
	private WebElement submitBtn;
	
	//Actions
	public void hitContinueBtn() {
		continueBtn.click();
	}
	
	public void hitSubmitBtn() {
		submitBtn.click();
	}
}
