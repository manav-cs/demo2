Feature: CarSaver eCommerce (CSE) sign out takes user to home page

  Background:
    Given the CSE user navigates to the home page
    And the CSE user clicks on the "Sign in here" link from the top nav
    And the CSE user signs in with a valid credentials

  @CSE @CSE_garage @CSE_signOut @regression @smoke
  Scenario: Ensure when the CSE user clicks the Sign Out link in the left nav it takes them to the home page
    When the CSE user clicks on the "Sign Out" link from the left nav
    Then the CSE user should see the home page

  @CSE @CSE_garage @CSE_signOut @regression
  Scenario: Ensure when the CSE user clicks the Sign Out link in the hamburger menu it takes them to the home page
    When the CSE user clicks Sign Out in the hamburger menu
    Then the CSE user should see the home page