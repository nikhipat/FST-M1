@activity2
Feature: Activity to test the login

  @loginTest
  Scenario:Successful login
    Given the user is on the login page
    When the use enters the username and password
    And the user clicks on submit button
    Then Verify the login message

