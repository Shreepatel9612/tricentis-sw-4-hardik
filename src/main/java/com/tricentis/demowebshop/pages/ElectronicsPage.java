package com.tricentis.demowebshop.pages;

import com.tricentis.demowebshop.utilities.Utility;
import dev.failsafe.internal.util.Assert;
import org.checkerframework.dataflow.qual.AssertMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ElectronicsPage extends Utility {
    private By electronicsTab = By.xpath("//ul[@class='top-menu']//a[normalize-space()='Electronics']");
    private By cellPhonesLink = By.partialLinkText("Cell");
    private By cellPhonesHeaderText = By.xpath("//h1[normalize-space()='Cell phones']");
    private By viewAsDropdown = By.xpath("//select[@id='products-viewmode']");
    private By smartphoneLink = By.xpath("//a[normalize-space()='Smartphone']");
    private By smartphoneHeaderText = By.xpath("//h1[normalize-space()='Smartphone']");
    private By priceText = By.xpath("(//span[@class='price-value-43'])[1]");
    private By quantityInput = By.xpath("(//input[@id='addtocart_43_EnteredQuantity'])[1]");
    private By addToCartButton = By.xpath("(//input[@id='add-to-cart-button-43'])[1]");
    private By greenBarMessage = By.xpath("(//p[@class='content'])[1]");
    private By closeBarButton = By.xpath("//span[@title='Close']");
    private By shoppingCartIcon = By.xpath("//li[@id='topcartlink']//a[@class='ico-cart']");
    private By shoppingCartHeader = By.xpath("//span[normalize-space()='Shopping cart']");
    private By agreeTermsCheckbox = By.xpath("//input[@id='termsofservice']");
    private By checkoutButton = By.xpath("//button[@id='checkout']");
    private By registerButton = By.xpath("//input[@value='Register']");
    private By registerHeader = By.tagName("h1");
    private By genderMaleRadio = By.xpath("//input[@id='gender-male']");
    private By firstNameInput = By.xpath("//input[@id='FirstName']");
    private By lastNameInput = By.xpath("//input[@id='LastName']");
    private By emailInput = By.xpath("//input[@id='Email']");
    private By passwordInput = By.xpath("//input[@id='Password']");
    private By confirmPasswordInput = By.xpath("//input[@id='ConfirmPassword']");
    private By registerSubmitButton = By.xpath("//input[@id='register-button']");
    private By billingContinueButton = By.xpath("//input[@onclick='Billing.save()']");
    private By shippingContinueButton = By.xpath("//input[@onclick='Shipping.save()']");
    private By shippingMethodRadio = By.xpath("(//input[@id='shippingoption_2'])[1]");
    private By shippingMethodContinueButton = By.xpath("(//input[@class='button-1 shipping-method-next-step-button'])[1]");
    private By paymentMethodRadio = By.xpath("(//input[@id='paymentmethod_2'])[1]");
    private By paymentMethodContinueButton = By.xpath("(//input[@class='button-1 payment-method-next-step-button'])[1]");
    private By creditCardTypeDropdown = By.xpath("//select[@id='CreditCardType']");
    private By cardholderNameInput = By.xpath("//input[@id='CardholderName']");
    private By cardNumberInput = By.xpath("//input[@id='CardNumber']");
    private By expireMonthDropdown = By.xpath("//select[@id='ExpireMonth']");
    private By expireYearDropdown = By.xpath("//select[@id='ExpireYear']");
    private By cardCodeInput = By.xpath("//input[@id='CardCode']");
    private By paymentInfoContinueButton = By.xpath("(//input[@class='button-1 payment-info-next-step-button'])[1]");
    private By confirmOrderButton = By.xpath("//input[@value='Confirm']");
    private By thankYouHeader = By.xpath("//h1[contains(text(),'Thank you')]");
    private By orderSuccessMessage = By.tagName("strong");
    private By logoutLink = By.xpath("//a[normalize-space()='Log out']");


    public void hoverOnElectronicsTab() {
        mouseToElement(electronicsTab);
    }

    public void clickOnCellPhones() {
        mouseHoverAndClick(cellPhonesLink);
    }

    public String getCellPhonesHeaderText() {
        return getTextFromElement(cellPhonesHeaderText);
    }

    public void navigateToCellPhones() {
        mouseToElement(electronicsTab);
        mouseHoverAndClick(cellPhonesLink);
    }

//    public void verifyCellPhonesPage(String expectedText) {
//        assertMethod(expectedText, cellPhonesHeaderText);
//    }

    public void selectViewAsList() {
        selectFromDropDown(viewAsDropdown, "List");
    }

    public void selectSmartphone() {
        clickOnElement(smartphoneLink);
    }

    public void verifySmartphoneDetails(String expectedName, String expectedPrice) {
        AssertMethod(expectedName, smartphoneHeaderText);
        AssertMethod(expectedPrice, priceText);
    }

    public void addToCart(String quantity) {
        WebElement qtyInput = driver.findElement(quantityInput);
        qtyInput.clear();
        qtyInput.sendKeys(quantity);
        clickOnElement(addToCartButton);
    }

    public void proceedToCheckout() {
        clickOnElement(agreeTermsCheckbox);
        clickOnElement(checkoutButton);
    }

    public void registerUser(String firstName, String lastName, String email, String password) {
        clickOnElement(registerButton);
        clickOnElement(genderMaleRadio);
        driver.findElement(firstNameInput).sendKeys(firstName);
        driver.findElement(lastNameInput).sendKeys(lastName);
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(password);
        clickOnElement(registerSubmitButton);
    }

    public void completeOrder(String cardHolderName, String cardNumber, String month, String year, String code) {
        clickOnElement(paymentMethodRadio);
        clickOnElement(paymentMethodContinueButton);
        selectFromDropDown(creditCardTypeDropdown, "Visa");
        driver.findElement(cardholderNameInput).sendKeys(cardHolderName);
        driver.findElement(cardNumberInput).sendKeys(cardNumber);
        selectFromDropDown(expireMonthDropdown, month);
        selectFromDropDown(expireYearDropdown, year);
        driver.findElement(cardCodeInput).sendKeys(code);
        clickOnElement(paymentInfoContinueButton);
        clickOnElement(confirmOrderButton);
    }

//    public void verifyOrderCompletion() {
//        assertMethod("Thank you", thankYouHeader);
//        assertMethod("Your order has been successfully processed!", orderSuccessMessage);
//    }

}
