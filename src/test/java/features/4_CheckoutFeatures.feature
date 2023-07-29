Feature: Checkout operations on SauceDemo

  @Checkout
  Scenario: Fail to complete checkout due to missing first name
    Given I am on the checkout page with items in my cart
    When I provide checkout details without a first name
    And I try to continue to finalize
    Then I should see an error message for missing first name

  @Checkout
  Scenario: Successfully complete checkout
    Given I am on the checkout page with items in my cart
    When I provide valid checkout details
    And I try to continue to finalize
    And I attempt to finalize the checkout
    Then I should see the checkout success message

