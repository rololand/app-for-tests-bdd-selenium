import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ToDoListPage;

import static org.junit.Assert.*;

public class toDoListSteps {
    WebDriver driver;
    ToDoListPage toDoListPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        String url = "https://rololand.github.io/app-for-tests/";

        toDoListPage = new ToDoListPage(driver, url);
        toDoListPage.go();
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

    @Given("I am on to do list page")
    public void iAmOnToDoListPage() {
        toDoListPage.menuToDoListButton().click();
        assertEquals("To do list:", toDoListPage.legend().getText());
    }

    @When("I add new task {string}")
    public void iAddNewTask(String taskName) {
        toDoListPage.addNewTask(taskName);
    }


    @Then("I got list of tasks")
    public void iGotListOfTasks(DataTable table) {
        String[] result = toDoListPage.getListOfTasks();

        for(int i=0; i < result.length; i++) {
            assertEquals(table.cell(0, i), result[i]);
        }
    }

    @When("I mark as done task {string}")
    public void iMarkAsDoneTask(String taskName) {
        toDoListPage.markAsDone(taskName);
    }

    @And("Task {string} is marked as done")
    public void taskIsMarkedAsDone(String taskName) {
        assertTrue(toDoListPage.isMarkAsDone(taskName));
    }

    @When("I delete task {string}")
    public void iDeleteTask(String taskName) {
        toDoListPage.deleteTask(taskName);
    }

    @When("I delete marked as done task {string}")
    public void iDeleteMarkedAsDoneTask(String taskName) {
        toDoListPage.deleteFinishedTask(taskName);
    }
}
