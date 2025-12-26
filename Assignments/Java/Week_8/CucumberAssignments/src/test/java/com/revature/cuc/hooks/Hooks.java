package com.revature.cuc.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    private static WebDriver driver;

    /**
     * Runs before each scenario.
     * Sets up the WebDriver and navigates to base URL if needed.
     */
    @Before(order = 1)
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());

        // TODO: Implement WebDriver setup
        // 1. Set up WebDriverManager
        // 2. Configure ChromeOptions (implicit wait, window size)
        // 3. Create ChromeDriver instance

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        // Add your options here

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * Runs before scenarios tagged with @headless.
     * Configures headless browser mode.
     */
    @Before(value = "@headless", order = 0)
    public void setUpHeadless() {
        // TODO: Implement headless setup
        // This should run BEFORE the regular setup
        System.out.println("Configuring headless mode...");
    }

    /**
     * Runs before scenarios tagged with @slow.
     * Increases timeout values.
     */
    @Before("@slow")
    public void configureSlowTest() {
        // TODO: Implement slow test configuration
        // Set longer implicit wait, page load timeout
    }

    /**
     * Runs after each scenario.
     * Cleans up WebDriver and captures screenshot on failure.
     */
    @After
    public void tearDown(Scenario scenario) {
        // TODO: Implement teardown
        // 1. Check if scenario failed
        // 2. If failed, capture screenshot
        // 3. Attach screenshot to report
        // 4. Quit WebDriver

        if (scenario.isFailed()) {
            captureScreenshot(scenario);
        }

        if (driver != null) {
            driver.quit();
        }

        System.out.println("Finished scenario: " + scenario.getName() +
                " - Status: " + scenario.getStatus());
    }

    /**
     * Captures screenshot and attaches to Cucumber report.
     */
    private void captureScreenshot(Scenario scenario) {
        // TODO: Implement screenshot capture
        // 1. Take screenshot as byte array
        // 2. Attach to scenario with name

        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }

    /**
     * Optional: Runs after each step.
     * Useful for debugging or capturing step-level screenshots.
     */
    @AfterStep
    public void afterStep(Scenario scenario) {
        // TODO: Optional - implement step-level logging
        // Be careful: this can slow down tests significantly
    }

    /**
     * Provides access to WebDriver for step definitions.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Runs only for scenarios tagged with @database.
     * Sets up database connection and test data.
     */
    @Before("@database")
    public void setUpDatabase(Scenario scenario) {
        System.out.println("Setting up database for: " + scenario.getName());
        // TODO: Implement database setup
        // 1. Connect to test database
        // 2. Clear test data
        // 3. Insert required fixtures
    }

    /**
     * Runs only for scenarios tagged with @database.
     * Cleans up database after test.
     */
    @After("@database")
    public void tearDownDatabase(Scenario scenario) {
        System.out.println("Cleaning up database after: " + scenario.getName());
        // TODO: Implement database cleanup
        // 1. Delete test data
        // 2. Close connection
    }

    /**
     * Runs for scenarios tagged with @api.
     * Sets up API test configuration.
     */
    @Before("@api")
    public void setUpApi() {
        // TODO: Implement API setup
        // 1. Configure base URL
        // 2. Set up authentication
        // 3. Initialize REST client
    }

    /**
     * Runs for scenarios tagged with both @login AND @admin.
     * Sets up admin user context.
     */
    @Before("@login and @admin")
    public void setUpAdminLogin() {
        System.out.println("Setting up admin login context");
        // TODO: Implement admin login setup
    }

    /**
     * Runs for scenarios tagged with @login but NOT @admin.
     * Sets up regular user context.
     */
    @Before("@login and not @admin")
    public void setUpRegularLogin() {
        System.out.println("Setting up regular user login context");
        // TODO: Implement regular user login setup
    }
}