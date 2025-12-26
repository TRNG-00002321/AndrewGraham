@login @data-driven
Feature: Data-Driven Login Testing
  As a QA engineer
  I want to test login with multiple credentials
  So that I can verify the authentication system works for all users

  Background:
    Given the user is on the login page

  @positive
  Scenario Outline: Successful login with valid credentials
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks the login button
    Then the login should be "<result>"
    And the user should see message "<message>"

    # TODO: Create Examples table with at least 3 valid users
    Examples: Valid Users
      | username | password             | result  | message                          |
      | tomsmith | SuperSecretPassword! | success | You logged into a secure area!   |
      |          |                      |         |                                  |
      |          |                      |         |                                  |

  @negative
  Scenario Outline: Failed login with invalid credentials
    When the user enters username "<username>"
    And the user enters password "<password>"
    And the user clicks the login button
    Then the login should be "<result>"
    And the user should see message "<message>"

    # TODO: Create Examples table with various failure cases
    Examples: Invalid Credentials
      | username    | password    | result | message                    |
      | tomsmith    | wrongpass   | failed | Your password is invalid!  |
      |             |             |        |                            |
      |             |             |        |                            |
      |             |             |        |                            |

    Examples: Empty Credentials
      | username | password | result | message                    |
      |          |          | failed | Your username is invalid!  |
      |          |          |        |                            |