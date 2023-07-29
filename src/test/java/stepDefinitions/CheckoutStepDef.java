package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.Cart;
import screens.Checkout;
import screens.Login;
import screens.Product;
import utils.DriverManager;
import utils.LogUtil;

import static org.junit.Assert.assertTrue;

public class CheckoutStepDef {

    WebDriver driver = DriverManager.getDriver();
    Login loginPage = new Login(driver);
    Checkout checkoutPage = new Checkout(driver);
    Product prodPage = new Product(driver);
    Cart cartPage = new Cart(driver);


    @Given("I am on the checkout page with items in my cart")
    public void i_am_on_the_checkout_page_with_items_in_my_cart() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        cartPage.goToCart();
        cartPage.proceedToCheckout();
        LogUtil.log("Navigated to the checkout page.");
    }

    @When("I provide valid checkout details")
    public void i_provide_valid_checkout_details() {
        try {
            checkoutPage.enterCheckoutDetails("John", "Doe", "12345");
            LogUtil.log("Entered valid checkout details.");
        } catch (Exception e) {
            LogUtil.log("Error while entering checkout details: " + e.getMessage());
            throw e;
        }
    }

    @When("I provide checkout details without a first name")
    public void i_provide_checkout_details_without_a_first_name() {
        try {
            checkoutPage.enterCheckoutDetails("", "Doe", "12345");
            LogUtil.log("Entered checkout details without a first name.");
        } catch (Exception e) {
            LogUtil.log("Error while entering checkout details: " + e.getMessage());
            throw e;
        }
    }

    @And("I try to continue to finalize")
    public void i_try_to_continue(){
        checkoutPage.continueCheckout();
        LogUtil.log("Attempted to continue the checkout.");
    }


    @And("I attempt to finalize the checkout")
    public void i_attempt_to_finalize_the_checkout() {
        checkoutPage.finalizeCheckout();
        LogUtil.log("Attempted to finalize the checkout.");
    }

    @Then("I should see the checkout success message")
    public void i_should_see_the_checkout_success_message() {
        assertTrue(checkoutPage.isCheckoutSuccessDisplayed());
        LogUtil.log("Verified checkout success message.");
    }

    @Then("I should see an error message for missing first name")
    public void i_should_see_an_error_message_for_missing_first_name() {
        assertTrue(checkoutPage.isFirstNameErrorDisplayed());
        LogUtil.log("Verified error message for missing first name.");
    }


}