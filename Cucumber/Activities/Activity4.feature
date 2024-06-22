@activity4
Feature: Activity to test the login

  @loginTest@LoginSuccess
  Scenario:Successful login with valid details
    Given the user is on the login page
    When the use enters the "admin" and "password"
    And the user clicks on submit button
    Then Verify the login message as "Welcome Back, admin"

  @LoginTest@LoginFail
  Scenario:Login failed with invalid details
    Given the user is on the login page
    When the use enters the "admin12" and "password1"
    And the user clicks on submit button
    Then Verify the login message as "Invalid Credentials"