package assignmentcucumber;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {
    WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");

    }
    @When("I fill in the registration form with valid information")
    public void i_fill_in_the_registration_form_with_valid_information() {
        driver.findElement(By.name("firstname")).sendKeys("Razan");
        driver.findElement(By.name("lastname")).sendKeys("Aw");
        driver.findElement(By.name("email")).sendKeys("Razan.Aw@example.com");
        driver.findElement(By.name("telephone")).sendKeys("1234567890");
        driver.findElement(By.name("password")).sendKeys("Razan123");
        driver.findElement(By.name("confirm")).sendKeys("Razan123");

    }
    @When("I select Newsletter Subscribe and Privacy Policy")
    public void iSelectNewsletterSubscribeAndPrivacyPolicy() {
        WebElement newsletterCheckbox = driver.findElement(By.name("newsletter"));
        if (!newsletterCheckbox.isSelected()) {
            newsletterCheckbox.click();
        }

        WebElement privacyPolicyCheckbox = driver.findElement(By.name("agree"));
        if (!privacyPolicyCheckbox.isSelected()) {
            privacyPolicyCheckbox.click();
        }
    }
    @When("I submit the registration form")
    public void i_submit_the_registration_form() {
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }
    @Then("I should see a confirmation message")
    public void i_should_see_a_confirmation_message() {
        WebElement confirmationMessage = driver.findElement(By.xpath("//div[@id='content']/h1"));
        assertEquals("Congratulations! Your new account has been successfully created!", confirmationMessage.getText());

    }
    @Then("I should be logged into my new account")
    public void iShouldBeLoggedInToMyNewAccount() {
        WebElement myAccountLink = driver.findElement(By.linkText("My Account"));
        assertTrue("My Account link is not present, user may not be logged in", myAccountLink.isDisplayed());
    }

    @After
    public void after() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}
