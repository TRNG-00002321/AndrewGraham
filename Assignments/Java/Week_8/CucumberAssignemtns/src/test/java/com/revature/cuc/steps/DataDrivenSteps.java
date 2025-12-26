package com.revature.cuc.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DataDrivenSteps {


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
    @When("the user enters email {string}")
    public void enterEmail(String email) {
        // TODO: Implement
        // Handle empty string case
        if (email != null && !email.isEmpty()) {
            driver.findElement(By.id("email")).sendKeys(email);
        }
    }

    @Then("the email validation result should be {string}")
    public void validateEmailResult(String expectedValid) {
        // TODO: Implement
        boolean isValid = expectedValid.equalsIgnoreCase("yes");
        // Assert based on expected validation
    }

    @Given("the user opens {string} browser")
    public void openBrowser(String browserName) {
        // TODO: Implement browser factory
        switch (browserName.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            // Add more browsers
        }
    }

    @Given("the viewport is set to {string} x {string}")
    public void setViewport(String width, String height) {
        // TODO: Implement viewport setting
        driver.manage().window().setSize(
                new Dimension(Integer.parseInt(width), Integer.parseInt(height))
        );
    }
}