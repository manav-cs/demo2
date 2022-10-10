Feature: CarSaver eCommerce (CSE) Non SSO Registration

  Background:
    Given the CSE user navigates to the home page

  @CSE @CSE_non_sso @CSE_registration @regression
  Scenario: Ensure a newly created CSE user can able to register for a non-sso profile
    And the CSE user clicks on the "Sign in here" link from the top nav
    And the CSE user clicks on the "Create an Account" link
    And the CSE user fills out the Get Started form and clicks Next
    When the CSE user fills out the Home Address and clicks Next
    Then the CSE user should see the My Garage message

  @CSE @CSE_non_sso @CSE_registration @regression @smoke
  Scenario: Ensure a newly created CSE user can sign in after registering
    Given a new CSE user creates a non-sso profile
    And the CSE user signs out
    And the CSE user clicks on the "Sign in here" link from the top nav
    And the CSE user can enter their credentials
    When the CSE user clicks on the "Sign In" button
    Then the CSE user should see the My Garage message

  @CSE @CSE_non_sso @CSE_registration @regression @smoke
  Scenario: Ensure a newly created CSE user can sign in after changing email
    Given a new CSE user creates a non-sso profile
    When the CSE user clicks on the "My Account" link from the left nav
    And the CSE user enters valid account information to update
    And the CSE user clicks on the Update button under My Account
    And the CSE user signs out
    And the CSE user clicks on the "Sign in here" link from the top nav
    And the CSE user can enter their credentials
    When the CSE user clicks on the "Sign In" button
    Then the CSE user should see the My Garage message

  @CSE @CSE_non_sso @CSE_registration @regression
  Scenario: Ensure a newly created CSE user can submit vague address
    And the CSE user clicks on the "Sign in here" link from the top nav
    And the CSE user clicks on the "Create an Account" link
    And the CSE user fills out the Get Started form and clicks Next
    When the CSE user fills out the Home Address with a vague street
    Then the CSE Confirm Address modal appears
    When the CSE user selects the suggested address
    Then the CSE user should see the My Garage message
    And the CSE user address matches the selected address