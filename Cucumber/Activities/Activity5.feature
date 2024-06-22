@activity5
Feature: Activity to test the login

  @loginTest@LoginSuccess
  Scenario:Successful login with valid details
    Given the user is on the login page
    When the use enters the "<username>" and "<password>"
    And the user clicks on submit button
    Then Verify the login message as "<msg>"

    Examples:
    |username|password|msg                    |
    |   admin     |  password      |      Welcome Back, admin                 |
    |     admin12   | password12       |      Invalid Credentials                 |

