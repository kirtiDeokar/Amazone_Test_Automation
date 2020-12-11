
Feature: User is able to use search feature

Scenario: User is able to filter the result based on Prices
       Given User navigated to the home application url
       And User Search for product "laptop"
       When User enters minimum price as "30000" and maximum price as "40000"
       Then Verify that Search results gets filtered with price range between 30000 and 40000
      
  @scn    
Scenario: User is able to search for various products and add each type of products with different prices
      Given User navigated to the home application url
      When User add the products with defined price range and quantity listed below
      | ITEM     | PRICE_LESS_THAN | QUANTITY |
      | laptop   | 40000           | 1        |
      | earphone | 1000            | 2        |
      | mouse    | 2000            | 1        |
      Then User cart is updated with the products and quantity