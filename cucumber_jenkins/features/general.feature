@login
Feature: Login Action

  Scenario: Successful Login with Valid Credentials
    Given user is in LogIn Page
    When User enters UserName and Password
    And User click on Login button
    Then Message displayed Login Successfully

@verifytitle
  Scenario: verify newtours title after login
    Given user is in Newtours login page
    When user enters Username and password
    And user click on Sign-in button
    Then user shows the title find flight
