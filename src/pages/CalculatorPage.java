package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.InputElement;
import utils.SelectElement;

public class CalculatorPage extends BasePage {
    private By xValueInputLocator = By.id("x_value");
    private By yValueInputLocator = By.id("y_value");
    private By resultInputLocator = By.id("result");
    private By calculationSelectLocator = By.id("operation");

    public CalculatorPage(WebDriver webDriver, String webUrl) {
        super(webDriver, webUrl);
    }

    public InputElement xValueInputElement() {
        return new InputElement(driver, xValueInputLocator);
    }

    public InputElement yValueInputElement() {
        return new InputElement(driver, yValueInputLocator);
    }

    public InputElement resultInputElement() {
        return new InputElement(driver, resultInputLocator);
    }

    public SelectElement calculationSelect() {
        return new SelectElement(driver, calculationSelectLocator);
    }
}
