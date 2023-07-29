package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

import java.util.List;


public class Cart {
    WebDriver driver;
    @FindBy(className = "cart_item")
    List<WebElement> cartItems;
    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(xpath = "//*[contains(text(), 'Checkout')]")
    WebElement informationHeader;


    public Cart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public boolean isProductInCart() {
        return !cartItems.isEmpty();
    }

    public void proceedToCheckout() {
        checkoutButton.click();
    }

    public String isOnCheckoutScreen() {
        return informationHeader.getText();
    }


    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }

    @FindBy(xpath = "//*[@id='shopping_cart_container']/a")
    WebElement cartIcon;

    public void goToCart() {
        cartIcon.click();
    }


}
