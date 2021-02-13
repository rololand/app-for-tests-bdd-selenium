package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseElement;

public class BasePage {
    WebDriver driver;
    String url;

    private By menuCalculatorButtonLocator = By.id("menuButtonCalculator");
    private By menuToDoListButtonLocator = By.id("menuButtonTaskList");
    private By legendLocator = By.xpath("//legend");

    public BasePage (WebDriver webDriver, String webUrl) {
        driver = webDriver;
        url = webUrl;
    }

    public void go() {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public BaseElement menuCalculatorButton() {
        return new BaseElement(driver, menuCalculatorButtonLocator);
    }

    public BaseElement menuToDoListButton() {
        return new BaseElement(driver, menuToDoListButtonLocator);
    }

    public BaseElement legend() {
        return new BaseElement(driver, legendLocator);
    }


}
