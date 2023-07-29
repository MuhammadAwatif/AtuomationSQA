Feature: Product Screen Test Cases on SauceDemo

  Scenario: Filter products by name
    Given I am logged in on SauceDemo
    When I filter products by name
    Then the products should be sorted by name

  Scenario: Remove a product from the cart from the product screen
    Given I have a product in my cart on SauceDemo
    When I remove the product from the cart
    Then the shopping cart should be empty

  Scenario: Logout the user from the SauceDemo Website
    Given I am logged in on SauceDemo
    Then user clicks on sidebar button
    And User clicks on Logout button
    Then user should be redirected to login screen