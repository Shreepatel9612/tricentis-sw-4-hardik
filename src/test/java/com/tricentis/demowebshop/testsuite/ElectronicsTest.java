package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.pages.ElectronicsPage;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElectronicsTest extends BaseTest {
    ElectronicsPage electronicsPage = new ElectronicsPage();

    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully() {
        // Step 1: Mouse Hover on Electronics Tab
        electronicsPage.hoverOnElectronicsTab();

        // Step 2: Mouse Hover and Click on Cell Phones
        electronicsPage.clickOnCellPhones();

        // Step 3: Verify the text "Cell Phones
        String expectedText = "Cell phones";
        String actualText = electronicsPage.getCellPhonesHeaderText();
        Assert.assertEquals(actualText, expectedText, "Cell phones page is not displayed!");
    }

    @Test
    public void verifyProductAddedSuccessfullyAndPlaceOrderSuccessfully() {


        // Navigate to Cell Phones
        electronicsPage.navigateToCellPhones();
        //      electronicsPage.verifyCellPhonesPage("Cell phones");

        // Select Smartphone and verify details
        electronicsPage.selectViewAsList();
        electronicsPage.selectSmartphone();
//        electronicsPage.verifySmartphoneDetails("Smartphone", "100.00");

        // Add to cart
        electronicsPage.addToCart("2");

        // Proceed to Checkout
        electronicsPage.proceedToCheckout();


        // Register User
        electronicsPage.registerUser("Hardik", "Patel", "shreepatel9612@gmail.com", "345678");

        // Complete Order
        electronicsPage.completeOrder("Hardik P", "094516738923456", "01", "2030", "999");

        // Verify Order Completion
       //electronicsPage.verifyOrderCompletion();
    }

}
