@cross-browser
Feature: Cross-Browser Compatibility
  As a QA engineer
  I want to verify the application works across browsers
  So that all users have a consistent experience

  @smoke
  Scenario Outline: Homepage loads correctly in different browsers
    Given the user opens "<browser>" browser
    When the user navigates to the homepage
    Then the page title should be "The Internet"
    And the main heading should be visible
    And the navigation links should be functional

    Examples: Desktop Browsers
      | browser  |
      | chrome   |
      | firefox  |
      | edge     |

    Examples: Mobile Emulation
      | browser         |
      | chrome-mobile   |
      | safari-mobile   |

  Scenario Outline: Login works across browsers and screen sizes
    Given the user opens "<browser>" browser
    And the viewport is set to "<width>" x "<height>"
    When the user logs in with valid credentials
    Then the login should be successful

    # TODO: Create Examples with browser/viewport combinations
    Examples: Desktop Viewports
      | browser | width | height |
      | chrome  | 1920  | 1080   |
      |         |       |        |
      |         |       |        |

    Examples: Tablet Viewports
      | browser | width | height |
      |         |       |        |
      |         |       |        |

    Examples: Mobile Viewports
      | browser | width | height |
      |         |       |        |
      |         |       |        |