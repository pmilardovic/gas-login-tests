package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Validation {

    WebDriver driver;

    public Validation(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * This method is used to validate whether the text of the element and expected text are equal
     */
    public void elementTextIsEqualByXpath(String xpath, String expectedText) {
        WebElement element = driver.findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String text = element.getText();
        Assert.assertEquals(text, expectedText);
    }

    /**
     * This method is used to validate whether the value of the element and expected text are equal
     */
    public void elementValueIsEqual(String xpath, String expectedText) {
        WebElement element = driver.findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        String text = element.getAttribute("value");
        Assert.assertEquals(text, expectedText);
    }

    /**
     * This method is used as a workaround to validate whether the page source contains text that is equal to the expected
     */
    public boolean isTextPresent(String text) {
        try {
            return driver.getPageSource().contains(text);
        } catch (Exception e) {
            return false;
        }
    }
}