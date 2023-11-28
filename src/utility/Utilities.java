package utility;

import browsefactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utilities extends BaseTest {

    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public void sentTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }


    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }

    public void selectByValueFromDropDown(By by, String value) {
        WebElement dropDown = driver.findElement(by);
        // Create the object of Select Class
        Select select = new Select(dropDown);
        select.selectByValue(value);

    }

    public void mouseHoverToElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).build().perform();
    }

}

