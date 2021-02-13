package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputElement extends BaseElement {
    public InputElement(WebDriver webDriver, By webLocator) {
        super(webDriver, webLocator);
    }

    public void sendKeys(String keys) {
        webElement.clear();
        webElement.sendKeys(keys);
    }

    public String getValue() {
        return webElement.getAttribute("value");
    }
}
