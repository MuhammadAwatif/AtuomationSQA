Feature: Cart operations on SauceDemo

  Scenario: Verify products in the cart
    Given I have added a product to my cart on SauceDemo
    When I go to the cart screen
    Then I should see the product in the cart

  Scenario: Proceed to checkout from the cart
    Given I have products in my cart on SauceDemo
    When I proceed to checkout
    Then I should be on the checkout screen