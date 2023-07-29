Feature: Login Test Cases on SauceDemo

  Scenario Outline: Login scenarios
    Given I am on the SauceDemo login page
    When I enter username "<username>" and password "<password>"
    Then I should see "<outcome>"

    Examples:
      | username         | password      | outcome                  |
      | standard_user    | secret_sauce  | the inventory page       |
      | locked_out_user  | secret_sauce  | an error message         |
      | standard_user    | wrong_password| an error message         |
      |                  | secret_sauce  | an error message         |
      | standard_user    |               | an error message         |