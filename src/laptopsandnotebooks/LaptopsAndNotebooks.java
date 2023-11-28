package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utility.Utilities;

import java.util.ArrayList;
import java.util.List;

public class LaptopsAndNotebooks extends Utilities {
    String baseUrl= "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup(){
        openBrowser(baseUrl);
    }

    @After
    public void tearDoem(){
        driver.close();
    }

    public void selectMenu(String menu){
        clickOnElement(By.xpath("//nav[@id='menu']//a[normalize-space()=' + menu + ']"));
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() throws InterruptedException {
        String menuName = "Show AllLaptops & Notebooks";
        // Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // Click on “Show All Laptops & Notebooks”
        selectMenu(menuName);
        Thread.sleep(1000);
        // Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        int i = 1;
        int j = 1;
        // Value before shorting
        List<WebElement> beforeShortValue = driver.findElements(By.xpath("//*[contains(@class, 'price') and not(contains(@class,'price-tax'))]"));
        List<String> beforeShortDesktopValue = new ArrayList<>();
        for (WebElement value : beforeShortValue) {

            String beforeShortValue1 = getTextFromElement(By.xpath("(//p[@class='price'])[" + i + "]"));
            String[] list = beforeShortValue1.split("E");
            beforeShortDesktopValue.add((list[0].replace("$", "")));
            i++;
        }

        // Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");

        Thread.sleep(1000);
        // After shorting value
        List<WebElement> afterShortValue = driver.findElements(By.xpath("//*[contains(@class, 'price') and not(contains(@class,'price-tax'))]"));
        List<String> afterShortDesktopValue = new ArrayList<>();
        Thread.sleep(1000);
        for (WebElement value1 : afterShortValue) {
            String beforeShortValue1 = getTextFromElement(By.xpath("(//p[@class='price'])[" + j + "]"));
            String[] list = beforeShortValue1.split("E");
            afterShortDesktopValue.add((list[0].replace("$", "")));
            j++;
        }

        // Verify the Product price will arrange in High to Low order.
        Assert.assertEquals(beforeShortDesktopValue, afterShortDesktopValue);

    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {

        String menuName = "Show AllLaptops & Notebooks";
        // Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        // Click on “Show All Laptops & Notebooks”
        selectMenu(menuName);
        Thread.sleep(1000);
        // Select Sort By "Price (High > Low)"
        selectByValueFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        // 2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
        // Verify the text “MacBook”
        String expectedMessage = "MacBook";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='MacBook']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        // Verify the message “Success: You have added MacBook to your shopping cart!”
        expectedMessage = "Success: You have added MacBook to your shopping cart!\n";
        actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String[] actualmsg = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg[0]);
        // Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
        // Verify the text "Shopping Cart"
        expectedMessage = "Shopping Cart  (0.00kg)";
        actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping Cart')]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Verify the Product name "MacBook"
        expectedMessage = "MacBook";
        actualMessage = getTextFromElement(By.xpath("(//a[contains(text(),'MacBook')])[2]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Change Quantity "2"
        Assert.assertEquals(By.xpath("//input[contains(@name,'quantity')]"), "2");
        //  Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
        // Verify the message “Success: You have modified your shopping cart!”
        expectedMessage = "Success: You have modified your shopping cart!\n";
        actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        String[] actualmsg1 = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg1[0]);
        // Verify the Total "$1,204.00"
        expectedMessage = "$1,204.00";
        actualMessage = getTextFromElement(By.xpath("(//td[@class='text-right'][normalize-space()='$1,204.00'])[3]"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
        Thread.sleep(1000);
        // Verify the text “Checkout”
        expectedMessage = "Checkout";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Checkout']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Verify the Text “New Customer”
        expectedMessage = "New Customer";
        actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='New Customer']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
        // Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        // fill registration form
        sentTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Prime");
        sentTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Testing");
        sentTextToElement(By.xpath("//input[@id='input-payment-email']"), "primetesting@gmail.com");
        sentTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "9898989898");
        sentTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "Mehsana");
        sentTextToElement(By.xpath("//input[@id='input-payment-city']"), "Tintodan");
        sentTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "382865");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-country']"), "Australia");
        selectByValueFromDropDown(By.xpath("//select[@id='input-payment-zone']"), "New South Wales");
        // Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
        Thread.sleep(1000);
        //  Add Comments About your order into text area
        sentTextToElement(By.xpath("//textarea[@name='comment']"), "My mackBook");
        // Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
        // Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
        // Verify the message “Warning: Payment method required!”
        Thread.sleep(1000);
        expectedMessage = "Warning: Payment method required!\n";
        actualMessage = getTextFromElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']"));
        String[] actualmsg2 = actualMessage.split("×");
        Assert.assertEquals(expectedMessage, actualmsg2[0]);


    }
}


