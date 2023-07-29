package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import screens.Cart;
import screens.Login;
import screens.Product;
import utils.DriverManager;
import io.cucumber.java.en.When;
import utils.LogUtil;
import static org.junit.Assert.assertTrue;

public class ProductStepDef {
    WebDriver driver = DriverManager.getDriver();
    Login loginPage = new Login(driver);
    Product productPage = new Product(driver);
    Cart cartPage = new Cart(driver);

    @Given("I am logged in on SauceDemo")
    public void i_am_logged_in_on_SauceDemo() {
        LogUtil.log("Navigating to SauceDemo website...");
        driver.get("https://www.saucedemo.com/");

        LogUtil.log("Entering login credentials...");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        LogUtil.log("Logged in successfully.");
    }

    @When("I filter products by name")
    public void i_filter_products_by_name() {
        LogUtil.log("Filtering products by name...");
        productPage.sortProductsByName();
    }

    @Then("the products should be sorted by name")
    public void the_products_should_be_sorted_by_name() {
        assertTrue(productPage.isProductsSortedByName());
        LogUtil.log("Verified products are sorted by name.");
    }

    public void i_add_the_first_product_to_the_cart() {
        LogUtil.log("Adding the first product to the cart...");
        productPage.addFirstProductToCart();
    }

    @Given("I have a product in my cart on SauceDemo")
    public void i_have_a_product_in_my_cart_on_SauceDemo() {
        LogUtil.log("Ensuring a product is added to the cart...");
        i_am_logged_in_on_SauceDemo();
        i_add_the_first_product_to_the_cart();
    }

    @When("I remove the product from the cart")
    public void i_remove_the_product_from_the_cart() {
        LogUtil.log("Removing the first product from the cart...");
        productPage.removeFirstProductFromCart();
    }

    @Then("the shopping cart should be empty")
    public void the_shopping_cart_should_be_empty() {
        assertTrue(cartPage.isCartEmpty());
        LogUtil.log("Verified cart is empty.");
    }

    @Then("user clicks on sidebar button")
    public void user_clicks_on_sidebar_icon() {
        LogUtil.log("Clicking on sidebar icon...");
        Product.clickSidebarIcon();
    }

    @And("User clicks on Logout button")
    public void user_clicks_on_Logout_button() {
        LogUtil.log("Clicking on Logout button...");
        Product.clickLogout();
    }

    @Then("user should be redirected to login screen")
    public void user_is_redirected_to_login_screen() {
        assertTrue(loginPage.isOnLoginPage());
        LogUtil.log("Verified user is on login page.");
    }
}
