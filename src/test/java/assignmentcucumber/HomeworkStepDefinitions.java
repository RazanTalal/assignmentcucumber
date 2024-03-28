package assignmentcucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class HomeworkStepDefinitions {
    private WebDriver driver;

    @Given("user goes to the {string}")
    public void user_goes_to_the(String pageUrl) {
        driver = new ChromeDriver();


        // Navigate to the page
        driver.get(pageUrl);
    }

    @Then("user waits for 5 seconds")
    public void user_waits_for_5_seconds() throws InterruptedException {
        Thread.sleep(5000); // Wait for 5 seconds
    }

    @And("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertTrue("Page title does not contain the expected word: " + expectedTitle,
                actualTitle.contains(expectedTitle));
    }

    @And("closes the page")
    public void closes_the_page() {
        driver.quit(); // Close the browser
    }
}
