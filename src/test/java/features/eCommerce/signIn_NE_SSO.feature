Feature: Nissan eCommerce (NE) Sign In

  Background:
    Given the NE user navigates to the home page

  @NE @NE_sso @NE_signIn @regression @smoke
  Scenario: Ensure profile users able to sign in to their account
    And the NE user clicks on the "Sign in here" link from the top nav
    And the NE user enters a valid email address
    And the NE user enters a valid password
    When the NE user clicks on the "LOGIN" button
    Then the NE user should see the My Garage message

  @NE @NE_sso @NE_signIn @regression
  Scenario: Ensure profile users are not able to sign in to their account with invalid email
    And the NE user clicks on the "Sign in here" link from the top nav
    And the NE user enters an invalid email address
    And the NE user enters a valid password
    When the NE user clicks on the "LOGIN" button
    Then the NE user should see the "Email Address or Password is incorrect" message

  @NE @NE_sso @NE_signIn @regression
  Scenario: Ensure profile users are not able to sign in to their account with an invalid password
    And the NE user clicks on the "Sign in here" link from the top nav
    And the NE user enters a valid email address
    And the NE user enters an invalid password
    When the NE user clicks on the "LOGIN" button
    Then the NE user should see the "Email Address or Password is incorrect" message