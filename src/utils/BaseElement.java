package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BaseElement {
    WebElement webElement;
    WebDriver driver;
    WebDriverWait wait;
    By locator;

    public BaseElement (WebDriver webDriver, By webLocator) {
        driver = webDriver;
        locator = webLocator;
        wait = new WebDriverWait(driver, 10);
        webElement = find();
    }

    private WebElement find() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public String getText() {
        return webElement.getText();
    }

    public String getAttribute(String attributeName) {
        return webElement.getAttribute(attributeName);
    }

    public String getCssValue(String cssValueName) {
        return webElement.getCssValue(cssValueName);
    }
}
