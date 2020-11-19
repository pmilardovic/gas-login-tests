package functional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontendActions extends TestBase {

    /**
     * This method is used for pausing the process for given seconds
     */
    public void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is for navigating to a specific page via url
     */
    public void navigateToPage(String pageUrl) {
        driver.get(pageUrl);
    }

    /**
     * This method is used for entering text in fields located by id
     */
    public void fillInputFieldBySendKeys(String id, String text) {
        WebElement element = driver.findElement(By.id(id));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.sendKeys(text);
    }

    /**
     * This method is used for clicking an element located by id
     */
    public void clickElementById(String id) {
        WebElement element = driver.findElement(By.id(id));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
        element.click();
    }

    /**
     * This method is used for clicking an element located by xpath
     */
    public void clickElementByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        element.click();
    }


    /**
     * This method is used to fetch the value of the frontend element
     */
    public String fetchValueFromFrontend(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element.getAttribute("value").trim();
    }

    /**
     * This method is used to simulate keyboard key pressing
     */
    public void pressKeyboard(String xpath, String key) {
        WebElement element = driver.findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        Keys selectedKey = Keys.valueOf(key);
        element.sendKeys(selectedKey);
    }

    /**
     * This method is used to focus(hover) on a specific element
     * Actions class -> for handling keyboard and mouse events
     */
    public void elementFocus(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        new Actions(driver).moveToElement(element).perform();
    }

}
