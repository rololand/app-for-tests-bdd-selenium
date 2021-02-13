package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectElement extends BaseElement {
    Select selectObj;

    public SelectElement(WebDriver webDriver, By webLocator) {
        super(webDriver, webLocator);
        selectObj = new Select(webElement);
    }

    public void selectByText(String txtToSelect) {
        selectObj.selectByVisibleText(txtToSelect);
    }

    public String getSelectedText() {
        return selectObj.getFirstSelectedOption().getText();
    }

    public String getSelectedValue() {
        return selectObj.getFirstSelectedOption().getAttribute("value");
    }
}
