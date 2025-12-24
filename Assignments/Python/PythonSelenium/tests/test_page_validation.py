"""
Test page content validation using Python Selenium.

Implement tests that:
1. Validate page title
2. Check for specific text content
3. Verify element presence
4. Check element attributes
"""

from selenium.webdriver.common.by import By
import sys
sys.path.insert(0, '..')
from utils.driver_factory import create_chrome_driver

def test_page_title():
    """Verify the page title matches expected value."""
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com")
        title = driver.title
        assert title == "The Internet"


def test_heading_text():
    """Verify the main heading contains expected text."""
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com")
        heading = driver.find_element(By.XPATH, "//h1").text
        assert heading == "Welcome to the-internet"


def test_links_present():
    """Verify that all example links are present on the page."""
    # YOUR CODE HERE
    # Use find_elements to get all links
    # Use list comprehension to extract link texts
    with create_chrome_driver(headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com")
        links = driver.find_elements(By.XPATH, "//li")
        for link in links:
            print(link.text)


def test_link_attributes():
    """Verify that links have correct href attributes."""
    # YOUR CODE HERE
    with create_chrome_driver(headless=True) as driver:
        driver.get("https://the-internet.herokuapp.com")
        links = driver.find_elements(By.XPATH, "//li")
        for link in links:
            print(link.get_attribute("href"))
