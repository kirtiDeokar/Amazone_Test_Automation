package com.visionit.automation.pageobjects;

/***
 * Author: Kirti Deokar
 * Company: VisionIT
 * Date: 10-Dec-2020
 * Description: Test Automation FW development
 */

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPageObject {
	
	private static final Logger logger = LogManager.getLogger(SearchPageObject.class);
	
	//Section1:  Declare a driver object
	private WebDriver driver;
	
    //Section 2 : Define the locators
	
	private By search_refinement_categories_segment  = By.id("s-refinements");
	private By min_price_filter = By.xpath("//input[@name='low-price']");
	private By max_price_filter = By.id("high-price");
	private By go_btn_price_filter = By.xpath("//input[@aria-labelledby='a-autoid-1-announce']");
	private By product_price_list = By.xpath("//span[@class='a-price-whole']");
   
	//Section 3: Paratmerize the constuctor
	 public SearchPageObject(WebDriver driver) {
        this.driver = driver;
    }
	
    //Section 4 : Write Business Methods (methods to be exposed) agent
    
   
	 public void ValidateProductSearchIsSuccessfull(){
	     if (driver.findElement(search_refinement_categories_segment).isDisplayed()){
	          Assert.assertTrue(true);
	          logger.info("Search Page is displayed because refinement category is displayed");
	         }
	     else{
	          logger.fatal("Search Page is not displayed because refinement category is not displayed");
	          Assert.fail("Search Page is not displayed because refinement category is not displayed");
	          }
	    }
	 
    public void FilterSearchResultByPrice(String min,String max) {
        driver.findElement(min_price_filter).sendKeys(min);
        logger.info("Entered min price:" + min);
        
        driver.findElement(max_price_filter).sendKeys(max);
        logger.info("Entered max price:" + max);  
        
        driver.findElement(go_btn_price_filter).click();
        logger.info("filter applied on price - Go button clicked");
        
        }
    
    public void verifyThatSearchedProductsAreInPriceRange(int min, int max) {
    	List <WebElement> products_prices = driver.findElements(product_price_list);
    	logger.info("Got all the produts prices");
    	boolean result = false;
    	int price_temp=0;
    	
    	for(int i=0; i<products_prices.size(); i++){
    		price_temp = Integer.parseInt(products_prices.get(i).getText().replace("," , ""));
    		if(price_temp>= min && price_temp<=max) {
    		  result = true;
    		  logger.info("For index:" + i + "product price is in the range:" + products_prices.get(i).getText());
    		}
    		else {
    			logger.error("Product list is not within the price range");
    			break;
    			}
    	   }
    	
    	if(result) {
    	 Assert.assertTrue("Searched products are within the price range i.e Min price:"+ min + "Max Price:"+ max, true);
         logger.info("All products are searched with applied price filter i.e Min:" + min + "Max:" + max);
    	}
    	else {
    		Assert.fail("Searched products are within the price range i.e Min price:"+ min + "Max Price:" + max);
    		logger.info("All products are not searched with applied price filter i.e Min:" + min + "Max:" + max);
    	}  	
    	
    }
}   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

