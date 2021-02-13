import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CalculatorPage;

public class calculatorSteps {
    WebDriver driver;
    CalculatorPage calculatorPage;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        String url = "https://rololand.github.io/app-for-tests/";

        calculatorPage = new CalculatorPage(driver, url);
        calculatorPage.go();
    }

    @After
    public void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
        driver = null;
    }

    @Given("I am on calculator app page")
    public void iAmOnCalculatorAppPage() {
        calculatorPage.menuCalculatorButton().click();
        assertEquals("Calculator:", calculatorPage.legend().getText());
    }

    @When("I add {string} and {string}")
    public void iAddAnd(String xValue, String yValue) {
        calculatorPage.calculationSelect().selectByText("X+Y");
        calculatorPage.xValueInputElement().sendKeys(xValue);
        calculatorPage.yValueInputElement().sendKeys(yValue);
        String xExpected = xValue.replace(',', '.');
        String yExpected = yValue.replace(',', '.');
        assertEquals(xExpected, calculatorPage.xValueInputElement().getValue());
        assertEquals(yExpected, calculatorPage.yValueInputElement().getValue());
        assertEquals("X+Y", calculatorPage.calculationSelect().getSelectedText());
    }

    @Then("I got result {string}")
    public void iGotResult(String result) {
        assertEquals(result, calculatorPage.resultInputElement().getValue());
    }

    @When("I subtract {string} and {string}")
    public void iSubtractAnd(String xValue, String yValue) {
        calculatorPage.calculationSelect().selectByText("X-Y");
        calculatorPage.xValueInputElement().sendKeys(xValue);
        calculatorPage.yValueInputElement().sendKeys(yValue);
        String xExpected = xValue.replace(',', '.');
        String yExpected = yValue.replace(',', '.');
        assertEquals(xExpected, calculatorPage.xValueInputElement().getValue());
        assertEquals(yExpected, calculatorPage.yValueInputElement().getValue());
        assertEquals("X-Y", calculatorPage.calculationSelect().getSelectedText());
    }

    @When("I multiple {string} and {string}")
    public void iMultipleAnd(String xValue, String yValue) {
        calculatorPage.calculationSelect().selectByText("X*Y");
        calculatorPage.xValueInputElement().sendKeys(xValue);
        calculatorPage.yValueInputElement().sendKeys(yValue);
        String xExpected = xValue.replace(',', '.');
        String yExpected = yValue.replace(',', '.');
        assertEquals(xExpected, calculatorPage.xValueInputElement().getValue());
        assertEquals(yExpected, calculatorPage.yValueInputElement().getValue());
        assertEquals("X*Y", calculatorPage.calculationSelect().getSelectedText());
    }

    @When("I divide {string} and {string}")
    public void iDivideAnd(String xValue, String yValue) {
        calculatorPage.calculationSelect().selectByText("X/Y");
        calculatorPage.xValueInputElement().sendKeys(xValue);
        calculatorPage.yValueInputElement().sendKeys(yValue);
        String xExpected = xValue.replace(',', '.');
        String yExpected = yValue.replace(',', '.');
        assertEquals(xExpected, calculatorPage.xValueInputElement().getValue());
        assertEquals(yExpected, calculatorPage.yValueInputElement().getValue());
        assertEquals("X/Y", calculatorPage.calculationSelect().getSelectedText());
    }

    @When("I change operations to {string}")
    public void iChangeOperationsTo(String calculationText) {
        calculatorPage.calculationSelect().selectByText(calculationText);
        assertEquals(calculationText, calculatorPage.calculationSelect().getSelectedText());
    }
}
