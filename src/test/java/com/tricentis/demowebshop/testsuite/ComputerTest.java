package com.tricentis.demowebshop.testsuite;

import com.tricentis.demowebshop.pages.ComputerPage;
import com.tricentis.demowebshop.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ComputerTest extends BaseTest {
    ComputerPage computerPage = new ComputerPage();


    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() {

        computerPage.navigateToDesktops();

        computerPage.sortProductsByName("Name: Z to A");

        // Verify product should display in decending order


    }

    @Test
    public void verifyProductAddedToShoppingCartSuccessfully() throws InterruptedException {

        // Click on the the Desktop.
        computerPage.navigateToDesktops();

        // Select Sort By option "Name: A to Z"
        computerPage.sortProductsByName("Name: A to Z");

        //  Click on the "Add To Cart" button of the product name ‘Build your own computer’
        computerPage.clickOnBuildYourOwnComputer();

        //  Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = computerPage.verifyProductTitle();
        Assert.assertEquals(actualText, expectedText, "Product text does not match.");


        //  Select "2.2 GHz Intel Pentium Dual-Core E2200" using the Select class
        computerPage.selectProcessor(2);

        //  Select HDD radio button "400 GB [+$100.00]"
        computerPage.selectHDD();

        //  Select the OS radio button "Windows 10 [+$60.00]"
        computerPage.selectOS();

        // Check Two Checkboxes "Microsoft Office [+$50.00]" and "Total Commander [+$5.00]"
        computerPage.selectMicrosoftOffice();

        //  Verify the price "1200.00"
        String expectedPrice = "1200.00";
        String actualPrice = computerPage.verifyPrice();
        Assert.assertEquals(actualPrice, expectedPrice);


        //  Click on the "Add to card" Button
        computerPage.addToCart();

        //  Verify the Message "The product has been added to your shopping cart" on the Top green Bar
        // computerPage.verifyGreenBarMessage("The product has been added to your shopping cart");


        //  After that close the bar by clicking on the cross button.
        computerPage.closeGreenBar();


        // Then MouseHover on "Shopping cart" and click on the "Go to cart" button.
        computerPage.proceedToShoppingCart();


        // Verify the message "Shopping cart"
        // computerPage.verifycomputerPage("Shopping cart");
        //Assert.assertEquals(computerPage.getShoppingCartTitle(),
         //       "Shopping cart", "Cart title mismatch!");

        //  Change the Qty to "2" and Click on "Update shopping cart"
        computerPage.updateCartQuantity("2");

        //   click on the checkbox “I agree with the terms of service”
        computerPage.agreeToTermsAndCheckout();
        Thread.sleep(2000);

        computerPage.checkOutAsGuest();

        computerPage.fillBillingDetails("Hardik", "Patel", "shreepatel9612@gmail.com", "United Kingdom", "London", "20 Kenton Street", "KN2 DG3", "07123456677");
        computerPage.proceedToShippingMethod();


        computerPage.selectPaymentMethod();
        computerPage.enterPaymentDetails("Master card", "Hardik P", "098765123487651",
                "01", "2029", "786");


        // computerPage.verifyOrderSummary("Credit Card", "Next Day Air", "2980.00");

        // Confirm the order
        computerPage.confirmOrder();

        // Verify order confirmation
        // computerPage.verifyOrderConfirmation("Thank you", "Your order has been successfully processed!");

        // Finalize order and verify welcome message
        computerPage.finalizeOrder();
        // computerPage.verifyWelcomeMessage("Welcome to our store");
//        Assert.assertEquals(computerPage.getMessageOfWelcomeOurStore(), "Welcome to our store",
//               "Welcome message mismatch!");

    }
}
