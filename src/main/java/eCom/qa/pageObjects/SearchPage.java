package eCom.qa.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	public WebElement searchBox;
	
	@FindBy (xpath="//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']")
	public List<WebElement> productName;
	
	@FindBy (xpath="//div[@data-component-type='s-search-result']//span[@class='a-price-whole']")
	public List<WebElement> productPrice;
}
