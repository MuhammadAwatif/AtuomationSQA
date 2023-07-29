package screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.LogUtil;

import java.util.List;
import java.util.stream.Collectors;

public class Product {
    WebDriver driver;
    @FindBy(className = "product_sort_container")
    WebElement sortDropdown;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeFromCartButtons;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addProductButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement SecondProductAddButton;


    public Product(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void sortProductsByName() {
        Select sorter = new Select(sortDropdown);
        sorter.selectByVisibleText("Name (A to Z)");  // This text might change, ensure it matches the option you want.
        LogUtil.log("Products sorted by name.");
    }

    public void addFirstProductToCart() {
        addProductButton.click();
    }

    public void addSecondProductToCart(){
        SecondProductAddButton.click();
    }

    public void removeFirstProductFromCart() {
        removeFromCartButtons.click();
    }

    @FindBy(className = "inventory_item_name")
    List<WebElement> productNames;

    public boolean isProductsSortedByName() {
        List<String> actualNames = productNames.stream().map(WebElement::getText).collect(Collectors.toList());

        List<String> sortedNames = actualNames.stream().sorted().collect(Collectors.toList());
        return actualNames.equals(sortedNames);
    }

    @FindBy(id = "react-burger-menu-btn")
    static
    WebElement sidebarIcon;

    @FindBy(id = "logout_sidebar_link")
    static
    WebElement logoutButton;

    public static void clickSidebarIcon() {
        sidebarIcon.click();
    }

    public static void clickLogout() {
        logoutButton.click();
    }

    public static boolean isOnProductPage() {
        return sidebarIcon.isDisplayed();
    }



}
