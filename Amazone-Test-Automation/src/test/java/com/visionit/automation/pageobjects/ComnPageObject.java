package com.visionit.automation.pageobjects;

/**
 * Author: Kirti Deokar
 * Company: VisionIT
 * Date: 10-Dec-2020
 * Description: Test Automation FW development
 */


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComnPageObject {
	
	
	private static final Logger logger = LogManager.getLogger(ComnPageObject.class);
	
	  private WebDriver driver;
	  
	  //locators
	  private By search_text_box = By.id("twotabsearchtextbox");
	  private By search_button = By.xpath("//input[@value='Go']");
	  
	  //constructor
	  public ComnPageObject(WebDriver driver) {
		  this.driver = driver;
	  }
	  
       //Methods
	  
	  public void SetSearchTextBox(String text) {
	    	
	    	WebElement elementSearchBox = driver.findElement(search_text_box);  
	    	elementSearchBox.clear();
	    	elementSearchBox.sendKeys(text);
	    	logger.info("Value Entered in Search Text Box" + text);
	    	 }
	    
	    public void clickOnSearchButton() {
	    	driver.findElement(search_button);
	    	logger.info("Clicked on Searched button");
	    }
}
