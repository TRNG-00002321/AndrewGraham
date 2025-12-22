package com.bookhaven.ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

class FormInteractionsTest extends BaseTest {

    @Test
    @DisplayName("Text field - basic interactions")
    void testTextFieldBasics() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));

        // Check initial state
        assertTrue(usernameField.isEnabled());
        assertTrue(usernameField.isDisplayed());
        assertEquals("", usernameField.getAttribute("value"));

        // Type text
        usernameField.sendKeys("testuser");
        assertEquals("testuser", usernameField.getAttribute("value"));

        // Clear and retype
        usernameField.clear();
        assertEquals("", usernameField.getAttribute("value"));

        usernameField.sendKeys("newuser");
        assertEquals("newuser", usernameField.getAttribute("value"));
    }

    @Test
    @DisplayName("Text field - keyboard interactions")
    void testTextFieldKeyboard() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));

        // Type and tab to next field
        usernameField.sendKeys("testuser");
        usernameField.sendKeys(Keys.TAB);

        // Password should now be focused - verify by typing
        passwordField.sendKeys("password123");
        assertEquals("password123", passwordField.getAttribute("value"));

        // Submit with Enter key
        passwordField.sendKeys(Keys.ENTER);

        // Verify form submitted (error message appears)
        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.isDisplayed());
    }

    @Test
    @DisplayName("Text field - special characters")
    void testSpecialCharacters() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));

        // Special characters
        usernameField.sendKeys("user@email.com");
        assertEquals("user@email.com", usernameField.getAttribute("value"));

        usernameField.clear();

        // Unicode characters
        usernameField.sendKeys("用户名");
        assertEquals("用户名", usernameField.getAttribute("value"));
    }

    @Test
    @DisplayName("Text field - select all and delete")
    void testSelectAllDelete() {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));

        usernameField.sendKeys("existing text");

        // Select all and replace
        usernameField.sendKeys(Keys.chord(Keys.COMMAND, "a"));
        usernameField.sendKeys("replaced");

        assertEquals("replaced", usernameField.getAttribute("value"));
    }

    @Test
    @DisplayName("Checkbox - basic interactions")
    void testCheckboxBasics() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        java.util.List<WebElement> checkboxes = driver.findElements(
                By.cssSelector("input[type='checkbox']")
        );

        WebElement checkbox1 = checkboxes.get(0);
        WebElement checkbox2 = checkboxes.get(1);

        // Check initial states
        assertFalse(checkbox1.isSelected(), "First checkbox should be unchecked");
        assertTrue(checkbox2.isSelected(), "Second checkbox should be checked");

        // Toggle first checkbox
        checkbox1.click();
        assertTrue(checkbox1.isSelected(), "First checkbox should now be checked");

        // Toggle second checkbox
        checkbox2.click();
        assertFalse(checkbox2.isSelected(), "Second checkbox should now be unchecked");
    }

    @Test
    @DisplayName("Checkbox - ensure checked state")
    void testEnsureChecked() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox = driver.findElement(
                By.cssSelector("input[type='checkbox']")
        );

        // Method to ensure checkbox is checked
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        assertTrue(checkbox.isSelected());

        // Method to ensure checkbox is unchecked
        if (checkbox.isSelected()) {
            checkbox.click();
        }
        assertFalse(checkbox.isSelected());
    }

    @Test
    @DisplayName("Checkbox - verify enabled state")
    void testCheckboxEnabled() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox = driver.findElement(
                By.cssSelector("input[type='checkbox']")
        );

        // Verify checkbox is enabled
        assertTrue(checkbox.isEnabled());
        assertTrue(checkbox.isDisplayed());
    }



    @Test
    @DisplayName("Dropdown - basic Select class usage")
    void testDropdownBasics() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        WebElement dropdownElement = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(dropdownElement);

        // Check default selected
        WebElement defaultOption = dropdown.getFirstSelectedOption();
        assertEquals("Please select an option", defaultOption.getText());

        // Select by visible text
        dropdown.selectByVisibleText("Option 1");
        assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());

        // Select by value
        dropdown.selectByValue("2");
        assertEquals("Option 2", dropdown.getFirstSelectedOption().getText());

        // Select by index
        dropdown.selectByIndex(1); // Index 0 is "Please select..."
        assertEquals("Option 1", dropdown.getFirstSelectedOption().getText());
    }

    @Test
    @DisplayName("Dropdown - get all options")
    void testGetAllOptions() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        // Get all options
        java.util.List<WebElement> options = dropdown.getOptions();

        assertEquals(3, options.size());
        assertEquals("Please select an option", options.get(0).getText());
        assertEquals("Option 1", options.get(1).getText());
        assertEquals("Option 2", options.get(2).getText());
    }

    @Test
    @DisplayName("Dropdown - verify not multi-select")
    void testSingleSelect() {
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select dropdown = new Select(driver.findElement(By.id("dropdown")));

        assertFalse(dropdown.isMultiple(), "Should be single select");
    }

    @Test
    @DisplayName("Radio buttons - selection")
    void testRadioButtons() {
        // Navigate to a page with radio buttons
        driver.get("https://demoqa.com/radio-button");

        // Find radio buttons
        WebElement yesRadio = driver.findElement(By.id("yesRadio"));
        WebElement impressiveRadio = driver.findElement(By.id("impressiveRadio"));

        // Note: These might need clicking on labels due to styling
        WebElement yesLabel = driver.findElement(By.cssSelector("label[for='yesRadio']"));
        WebElement impressiveLabel = driver.findElement(By.cssSelector("label[for='impressiveRadio']"));

        // Initially none selected (or check actual state)

        // Select "Yes"
        yesLabel.click();
        assertTrue(yesRadio.isSelected());
        assertFalse(impressiveRadio.isSelected());

        // Select "Impressive" - "Yes" should be deselected
        impressiveLabel.click();
        assertFalse(yesRadio.isSelected());
        assertTrue(impressiveRadio.isSelected());
    }

    @Test
    @DisplayName("Radio buttons - verify only one selected")
    void testRadioOnlyOneSelected() {
        driver.get("https://demoqa.com/radio-button");

        java.util.List<WebElement> radios = driver.findElements(
                By.cssSelector("input[type='radio'][name='like']")
        );

        // Select each and verify only one is selected at a time
        for (int i = 0; i < radios.size(); i++) {
            WebElement radio = radios.get(i);
            if (radio.isEnabled()) {
                // Click the label instead of radio (for styled elements)
                String id = radio.getAttribute("id");
                driver.findElement(By.cssSelector("label[for='" + id + "']")).click();

                // Count selected
                long selectedCount = radios.stream()
                        .filter(WebElement::isSelected)
                        .count();

                assertEquals(1, selectedCount,
                        "Only one radio should be selected at a time");
            }
        }
    }

    @Test
    @DisplayName("Complete form submission")
    void testCompleteFormSubmission() {
        driver.get("https://the-internet.herokuapp.com/login");

        // Fill all fields
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        // Submit form
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Verify success
        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.getText().contains("You logged into"));

        // Verify we're on secure area
        assertTrue(driver.getCurrentUrl().contains("secure"));
    }

    @Test
    @DisplayName("Form validation - required fields")
    void testFormValidation() {
        driver.get("https://the-internet.herokuapp.com/login");

        // Submit without filling fields
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // Should show error
        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.getText().contains("invalid"));
    }
}