package com.visionit.automation.stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.visionit.automation.core.WebDriverFactory;
import com.visionit.automation.pageobjects.ComnPageObject;
import com.visionit.automation.pageobjects.SearchPageObject;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



       
public class StepdefsWithPageObject {
	
	private static final Logger logger = LogManager.getLogger(StepdefsWithPageObject.class);
	
	WebDriver driver;
    String base_url = "https://amazon.in";
    int implicit_wait_in_sec = 20;
    Scenario scn; // this is set in the @Before method

  //***********************Page Object Model Declaration*******************
    
    ComnPageObject comnPageObjects;
    SearchPageObject searchPageObjects;
	
    @Before
    public void setUp(Scenario scn) throws Exception{
    	this.scn= scn;
    	//Get the browser
    	String browserName= WebDriverFactory.getBrowserName();
    	driver= WebDriverFactory.getWebDriverForBrowser(browserName);
    	logger.info("Browser Invoked");
    	
    	//Initialize Page Object Model Objects
    	
        searchPageObjects = new SearchPageObject(driver);
         comnPageObjects = new ComnPageObject(driver);
    	 }
    
     @After
     public void tearDown() {
    	 WebDriverFactory.quitDriver();
    	 scn.log("Browser Closed");
    	}
    
       //Stepdefinition1
    
	@Given("User navigated to the home application url")
	public void user_navigated_to_the_home_application_url() {
		WebDriverFactory.navigateToTheUrl(base_url);
		}

	@Given("User Search for product {string}")
	public void user_search_for_product(String productName) {
		comnPageObjects.SetSearchTextBox(productName);
		}
	
	@When("User enters minimum price as {string} and maximum price as {string}")
	public void user_enters_minimum_price_as_and_maximum_price_as(String min_price, String max_price) {
		
		searchPageObjects.FilterSearchResultByPrice(min_price, max_price);
	  }
	
	@Then("Verify that Search results gets filtered with price range between {int} and {int}")
	public void verify_that_search_results_gets_filtered_with_price_range_between_and(Integer minPrice, Integer maxPrice) {
	    
		searchPageObjects.verifyThatSearchedProductsAreInPriceRange(minPrice, maxPrice);
	}
	
	
	//Stepdefinition2
	
	@When("User add the products with defined price range and quantity listed below")
	public void user_add_the_products_with_defined_price_range_and_quantity_listed_below(io.cucumber.datatable.DataTable dataTable) {
	    
	    
	}




	@Then("User cart is updated with the products and quantity")
	public void user_cart_is_updated_with_the_products_and_quantity() {
	   
	}


}
