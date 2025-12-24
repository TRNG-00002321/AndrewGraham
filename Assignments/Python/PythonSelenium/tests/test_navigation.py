from selenium.webdriver.common.by import By
import sys

sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver


def test_navigate_to_login_page():
    """
    Test: Navigate from home to login page


    Steps:
    1. Go to the-internet homepage
    2. Find and click "Form Authentication" link
    3. Assert URL contains "/login"
    4. Assert page contains "Login Page" heading
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com")
        login_page = driver.find_element(By.XPATH, "//a[normalize-space()='Form Authentication']")
        login_page.click()
        assert driver.current_url.__contains__("/login")
        heading = driver.find_element(By.XPATH,"//h2[normalize-space()='Login Page']").text
        assert heading.__contains__("Login Page")



    pass


def test_back_forward_navigation():
    """
    Test: Browser navigation (back/forward)

    Steps:
    1. Navigate to homepage
    2. Click a link to go to another page
    3. Use driver.back() to return
    4. Assert you're on homepage
    5. Use driver.forward() to go forward
    6. Assert you're on the second page again
    """
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com")
        login_page = driver.find_element(By.XPATH, "//a[normalize-space()='Form Authentication']")
        login_page.click()
        driver.back()
        driver.forward()
        assert driver.current_url.__contains__("/login")

    pass


def test_capture_screenshot():
    """
    Test: Screenshot capture

    Steps:
    1. Navigate to any page
    2. Take a full page screenshot
    3. Save it to screenshots/homepage.png
    """
    # YOUR CODE HERE
    pass