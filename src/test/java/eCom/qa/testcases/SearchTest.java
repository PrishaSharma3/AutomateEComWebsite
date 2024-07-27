package eCom.qa.testcases;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import eCom.qa.base.Base;
import eCom.qa.pageObjects.SearchPage;

public class SearchTest extends Base{
	
	public SearchTest() {
		super();
	}
	
	public WebDriver driver;
	SearchPage searchPage;

	@BeforeMethod
	public void setup() {
		driver = SetBrowserAndOpenURL(prop.getProperty("browserName"));
	}
	
	@Test
	public void VerifySearchValidProduct() {
	    
		searchPage = new SearchPage(driver);
		
	    searchPage.searchBox.sendKeys(prop.getProperty("productName"));
	    searchPage.searchBox.sendKeys(Keys.ENTER); 
	    
//	    List<WebElement> productName = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-size-medium a-color-base a-text-normal']"));
//	    List<WebElement> productPrice = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//span[@class='a-price-whole']"));
	    List<String> productNameText = new ArrayList<>();
	    List<String> productPriceText = new ArrayList<>();
	    
	    // Add product names to productNameText
	    for (WebElement nameElement : searchPage.productName) {
	        productNameText.add(nameElement.getText());
	    }
	    
	    // Add product prices to productPriceText
	    for (WebElement priceElement : searchPage.productPrice) {
	        productPriceText.add(priceElement.getText());
	    }
	    
	    // Print product name and price in pairs
	    for (int i = 0; i < productNameText.size() && i < productPriceText.size(); i++) { 
	        String title = productNameText.get(i);
	        String price = productPriceText.get(i); 
	        
	        System.out.println("Product Name: " + title);
	        System.out.println("Product Price: " + price);
	        System.out.println("--------"); // Optional: Add a separator between products
	    }
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
