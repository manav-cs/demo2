Feature: Nissan eCommerce (NE) Registration

  Background:
    Given the NE user navigates to the home page

  @NE @NE_sso @NE_registration @regression
  Scenario: Ensure NE user able to register for a profile via SSO
    And the NE user clicks on the "Sign in here" link from the top nav
    And the NE user clicks on "Click here to register." link
    And the NE user enters valid information and accepts the terms under the Registration Form
    When the NE user clicks on the Submit button
    Then the NE user should see the SUCCESS message

  @NE @NE_sso @NE_registration @regression @smoke
  Scenario: Ensure the NE profile user can sign in after registering via SSO
    Given the NE user creates an sso profile
    And the NE user can enter their credentials
    When the NE user clicks on the "LOGIN" button
    Then the NE user should see the My Garage message