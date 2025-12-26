package com.revature.cuc.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {

    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";


    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        // TODO: Implement this step
        // 1. Set up WebDriverManager for Chrome
        // 2. Initialize ChromeDriver
        // 3. Navigate to login page

        driver.get(BASE_URL + "/login");

    }

    @When("the user enters username {string}")
    public void theUserEntersUsername(String username) {
        // TODO: Implement this step
        // Find username field and enter the provided username

        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);
    }

    @When("the user enters password {string}")
    public void theUserEntersPassword(String password) {
        // TODO: Implement this step
        // Find password field and enter the provided password

        // YOUR CODE HERE
        WebElement usernameField = driver.findElement(By.id("password"));
        usernameField.sendKeys(password);
    }

    @When("the user clicks the login button")
    public void theUserClicksTheLoginButton() {
        // TODO: Implement this step
        // Find and click the login button

        // YOUR CODE HERE
        WebElement loginButton = driver.findElement(By.className("radius"));
        loginButton.click();
    }

    @Then("the user should be redirected to the secure area")
    public void theUserShouldBeRedirectedToTheSecureArea() {
        // TODO: Implement this step
        // Verify the URL contains "/secure"

        assertTrue(driver.getCurrentUrl().contains("/secure"),
                "User was not redirected to secure area");
    }

    @Then("the user should see a success message containing {string}")
    public void theUserShouldSeeSuccessMessageContaining(String expectedMessage) {
        // TODO: Implement this step
        // Find the flash message element and verify it contains expected text

        // YOUR CODE HERE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flashMessage = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("flash"))));
        String messageText = flashMessage.getText();
        assertTrue(messageText.contains(expectedMessage));
    }

    @Then("the user should remain on the login page")
    public void theUserShouldRemainOnTheLoginPage() {
        // TODO: Implement this step
        // Verify URL still contains "/login"

        // YOUR CODE HERE
        assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Then("the user should see an error message containing {string}")
    public void theUserShouldSeeErrorMessageContaining(String expectedMessage) {
        // TODO: Implement this step
        // Find the flash message element and verify it contains expected error

        // YOUR CODE HERE
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flashMessage = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("flash"))));
        String messageText = flashMessage.getText();
        assertTrue(messageText.contains(expectedMessage));
    }
}
