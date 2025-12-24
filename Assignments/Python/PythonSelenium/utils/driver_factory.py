from contextlib import contextmanager
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager

@contextmanager
def create_chrome_driver(headless: bool = False):
    # 1. Create ChromeOptions and configure headless if needed
    options = Options()
    if headless:
        # "new" headless mode is recommended for modern Chrome
        options.add_argument("--headless=new")
        options.add_argument("--disable-gpu")
        options.add_argument("--window-size=1920,1080")

    # 2. Set up Service with ChromeDriverManager
    service = Service(ChromeDriverManager().install())

    driver = None
    try:
        # 3. Create driver
        driver = webdriver.Chrome(service=service, options=options)
        yield driver
    finally:
        # Ensure browser cleanup
        if driver is not None:
            driver.quit()
    pass