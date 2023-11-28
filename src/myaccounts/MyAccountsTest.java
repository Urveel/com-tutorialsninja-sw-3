package myaccounts;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utility.Utilities;

import java.util.UUID;

public class MyAccountsTest extends Utilities {
    String baseUrl = "http://tutorialsninja.com/demo/index.php?";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @After
    public void tearDoem() {
        driver.close();
    }

    /**
     * This method is used to click on any tab of my account dropdown
     *
     * @param option
     */
    public void selectMyAccountOptions(String option) {
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
        clickOnElement(By.xpath("(//a[normalize-space()='" + option + "'])[1]"));
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() throws InterruptedException {
        String option = "Register";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Register Account”.
        String expectedMessage = "Register Account";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Register Account']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() throws InterruptedException {
        String option = "Login";
        // Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Verify the text “Returning Customer”.
        String expectedMessage = "Returning Customer";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='Returning Customer']"));
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        String name = UUID.randomUUID().toString();
        String email = name + "@gmail.com";
        String option = "Register";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Register”
        selectMyAccountOptions(option);
        Thread.sleep(1000);
        // Enter first name
        Assert.assertEquals(By.xpath("//input[@id='input-firstname']"), "Prime");
        // Enter Last name
        Assert.assertEquals(By.xpath("//input[@id='input-lastname']"), "Testing");
        // Enter email
        Assert.assertEquals(By.xpath("//input[@id='input-email']"), email);
        // Enter mobile number
        Assert.assertEquals(By.xpath("//input[@id='input-telephone']"), "9898989898");
        // Enter password
        Assert.assertEquals(By.xpath("//input[@id='input-password']"), "Admin@123");
        // Enter confirm password
        Assert.assertEquals(By.xpath("//input[@id='input-confirm']"), "Admin@123");
        // Select Subscribe Yes radio button


        // Verify the message “Your Account Has Been Created!”
        String expectedMessage = "Your Account Has Been Created!";
        String actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

        option = "Logout";
        // Call the method “selectMyAccountOptions” method and pass the parameter“Logout”
        selectMyAccountOptions(option);
        // Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));

    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() {
        String option = "Login";
        //  Call the method “selectMyAccountOptions” method and pass the parameter“Login”
        selectMyAccountOptions(option);
        // Enter Email address
        sentTextToElement(By.xpath("//input[@id='input-email']"), "admin123456@gmail.com");
        // Enter Password
        sentTextToElement(By.xpath("//input[@id='input-password']"), "Admin@123");
        // Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
        // Verify text “My Account”
        String expectedMessage = "My Account";
        String actualMessage = getTextFromElement(By.xpath("//h2[normalize-space()='My Account']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        option = "Logout";
        // Call the method “selectMyAccountOptions” method and pass the parameter Logout”
        selectMyAccountOptions(option);
        // Verify the text “Account Logout”
        expectedMessage = "Account Logout";
        actualMessage = getTextFromElement(By.xpath("//h1[normalize-space()='Account Logout']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // Click on Continue button
        clickOnElement(By.xpath("//a[normalize-space()='Continue']"));
    }
}

