package screens;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverManager;

public class Checkout {

    WebDriver driver;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement postalCodeField;

    @FindBy(name = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    WebElement successMessage;

    @FindBy(xpath = "//h3[contains(text(),'Error')]")
    WebElement errorMessage;



    public Checkout(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterCheckoutDetails(String firstName, String lastName, String postalCode) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        postalCodeField.sendKeys(postalCode);
    }
    public void continueCheckout(){
        continueButton.click();
    }

    public void finalizeCheckout() {
        finishButton.click();
    }

    public boolean isCheckoutSuccessDisplayed() {
        return successMessage.getText().contains("Checkout: Complete!");
    }

    public boolean isFirstNameErrorDisplayed() {
        return errorMessage.getText().contains("Error: First Name is required");
    }

    @After
    public void quitDriver(){
        DriverManager.quitDriver();
    }
}