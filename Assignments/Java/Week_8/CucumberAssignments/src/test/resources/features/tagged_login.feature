@login @authentication
Feature: User Login with Tags

  @smoke @critical @p1
  Scenario: Successful login is critical path
    Given the user is on the login page
    When the user logs in with valid credentials
    Then the user should see the dashboard

  @regression @p2
  Scenario: Login with remember me
    Given the user is on the login page
    When the user checks "Remember me"
    And the user logs in with valid credentials
    Then the session should persist

  @security @negative
  Scenario: Account lockout after failed attempts
    Given the user is on the login page
    When the user fails login 5 times
    Then the account should be locked
    And a security email should be sent

  @wip
  Scenario: Biometric login (work in progress)
    # This test is not yet implemented
    Given the user has biometric enabled
    When the user authenticates with fingerprint
    Then the login should succeed

  @slow @integration
  Scenario: Login syncs with external identity provider
    Given the external IDP is available
    When the user logs in via SSO
    Then the user profile should be synchronized