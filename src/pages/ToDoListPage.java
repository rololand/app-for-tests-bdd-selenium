package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseElement;
import utils.InputElement;

public class ToDoListPage extends BasePage {
    private By newTaskInputLocator = By.id("newTask");
    private By addNewTaskButtonLocator = By.id("addTaskButton");
    private By taskListLocator = By.xpath("//div[@id='taskList']/fieldset/ul");

    public ToDoListPage(WebDriver webDriver, String webUrl) {
        super(webDriver, webUrl);
    }

    private InputElement newTaskInput() {
        return new InputElement(driver, newTaskInputLocator);
    }

    private BaseElement newTaskButton() {
        return new BaseElement(driver, addNewTaskButtonLocator);
    }

    private BaseElement taskListElement() {
        return new BaseElement(driver, taskListLocator);
    }

    public String[] getListOfTasks() {
        String tasks = taskListElement().getAttribute("textContent");
        String[] tasksList = tasks.split("X");
        return tasksList;
    }

    public void addNewTask(String taskName) {
        newTaskInput().sendKeys(taskName);
        newTaskButton().click();
    }

    public void markAsDone(String taskName) {
        String xpath = "//div[@class='taskElement' and text()='"+taskName+"']";
        By locator = By.xpath(xpath);
        BaseElement element = new BaseElement(driver, locator);
        element.click();
    }

    public boolean isMarkAsDone(String taskName) {
        String xpath = "//div[@class='taskElement taskDone' and text()='"+taskName+"']";
        By locator = By.xpath(xpath);
        BaseElement element = new BaseElement(driver, locator);
        String propertyValue = element.getCssValue("text-decoration");
        return propertyValue.contains("line-through");
    }

    public void deleteTask(String taskName) {
        String xpath = "//div[@class='taskElement' and text()='"+taskName+"']/../div[@class='deleteTaskButton']";
        By locator = By.xpath(xpath);
        BaseElement element = new BaseElement(driver, locator);
        element.click();
    }

    public void deleteFinishedTask(String taskName) {
        String xpath = "//div[@class='taskElement taskDone' and text()='"+taskName+"']/../div[@class='deleteTaskButton']";
        By locator = By.xpath(xpath);
        BaseElement element = new BaseElement(driver, locator);
        element.click();
    }
}
