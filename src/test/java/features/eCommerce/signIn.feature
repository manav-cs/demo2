Feature: CarSaver eCommerce (CSE) Non SSO Sign In

  Background:
    Given the CSE user navigates to the home page
    And the CSE user clicks on the "Sign in here" link from the top nav

  @CSE @CSE_sso @CSE_signIn @regression @smoke
  Scenario: Ensure CSE profile users able to sign in to their account
    When the CSE user signs in with a valid credentials
    Then the CSE user should see the My Garage message

  @CSE @CSE_sso @CSE_signIn @regression
  Scenario: Ensure CSE profile users are not able to sign in to their account with invalid email
    And the CSE user enters an invalid email address
    And the CSE user enters a valid password
    When the CSE user clicks on the "Sign In" button
    Then the CSE user should see the "The email address or password are not correct" message

  @CSE @CSE_sso @CSE_signIn @regression
  Scenario: Ensure CSE profile users are not able to sign in to their account with an invalid password
    And the CSE user enters a valid email address
    And the CSE user enters an invalid password
    When the CSE user clicks on the "Sign In" button
    Then the CSE user should see the "The email address or password are not correct" message

  @CSE @CSE_sso @CSE_signIn @regression
  Scenario: Ensure the CSE user should not able to update the account with an email that already exists
    And a new CSE user creates a non-sso profile
    And the CSE user remembers the old email
    And the CSE user clicks the Hamburger icon
    And the CSE user clicks the "Sign Out" link in the My Garage menu
    And the CSE user logs in and goes to my account
    And the CSE user updates account info with an email that already exists
    And the CSE user clicks on the Update button under My Account
    Then the CSE user "email" field should see "Email already in use."