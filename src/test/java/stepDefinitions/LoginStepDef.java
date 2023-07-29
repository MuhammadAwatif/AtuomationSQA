package stepDefinitions;

import io.cucumber.java.After;
import screens.Login;
import utils.DriverManager;
import utils.LogUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class LoginStepDef {
    WebDriver driver;
    Login loginPage;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_the_SauceDemo_login_page() {
        driver = DriverManager.getDriver();
        driver.get("https://www.saucedemo.com/");
        LogUtil.log("Opened SauceDemo login page.");
        loginPage = new Login(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        LogUtil.log("Entering username: " + username);
        loginPage.enterUsername(username);

        LogUtil.log("Entering password: " + password);
        loginPage.enterPassword(password);

        LogUtil.log("Clicking login button.");
        loginPage.clickLogin();
    }

    @Then("I should see {string}")
    public void i_should_see(String outcome) {
        switch (outcome) {
            case "the inventory page":
                assertTrue(driver.getCurrentUrl().contains("inventory.html"));
                LogUtil.log("Successfully navigated to the inventory page.");
                break;
            case "an error message":
                assertTrue(loginPage.isErrorMessageDisplayed());
                LogUtil.log("Error message displayed as expected.");
                break;
            default:
                LogUtil.log("Unknown outcome: " + outcome);
        }
    }

}
