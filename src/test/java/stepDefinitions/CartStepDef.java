package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import screens.Cart;
import screens.Login;
import screens.Product;
import utils.DriverManager;
import utils.LogUtil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartStepDef {

    WebDriver driver = DriverManager.getDriver();
    Cart cartPage = new Cart(driver);
    Product prodPage = new Product(driver);

    Login loginPage = new Login(driver);

    @Given("I have added a product to my cart on SauceDemo")
    public void i_have_added_a_product_to_my_cart_on_SauceDemo() {
        LogUtil.log("Navigating to SauceDemo website...");
        driver.get("https://www.saucedemo.com/");

        LogUtil.log("Logging into SauceDemo website...");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        LogUtil.log("Adding the first product to the cart...");
        prodPage.addFirstProductToCart();
    }

    @Then("I should see the product in the cart")
    public void i_should_see_the_product_in_the_cart() {
        assertTrue(cartPage.isProductInCart());
        LogUtil.log("Verified product is present in the cart.");
    }

    @Given("I have products in my cart on SauceDemo")
    public void i_have_products_in_my_cart_on_SauceDemo() {
        LogUtil.log("Checking products in the cart...");
        assertTrue(cartPage.isProductInCart());
    }

    @When("I proceed to checkout")
    public void i_proceed_to_checkout() {
        LogUtil.log("Proceeding to checkout...");
        cartPage.proceedToCheckout();
    }

    @Then("I should be on the checkout screen")
    public void i_should_be_on_the_Checkout_screen() {
        assertEquals(cartPage.isOnCheckoutScreen(), "Checkout: Your Information");
        LogUtil.log("Verified user is on the checkout screen.");
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        assertTrue(cartPage.isCartEmpty());
        LogUtil.log("Verified cart is empty.");
    }

    @When("I go to the cart screen")
    public void i_go_to_the_cart_screen() {
        LogUtil.log("Navigating to the cart screen...");
        cartPage.goToCart();
    }



}