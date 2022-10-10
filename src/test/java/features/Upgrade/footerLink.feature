Feature: The Upgrade users verify all footer link exists on all pages

  Background:
    Given the Upgrade user navigates to the homepage

  @UP @footer_Links @regression @smoke
  Scenario: Ensure the Upgrade user verifies all footer links on the homepage
    And the Upgrade user clicks on the Terms of Use link
    And the Upgrade user clicks on the Privacy Policy link
    And the Upgrade user clicks on the California Privacy Policy link
    And the Upgrade user clicks on the Do Not Sell My Info link
    When the Upgrade user clicks on the back button
    Then the Upgrade user should successfully return to the homepage

  @UP @footer_Links @regression
  Scenario: Ensure the Upgrade user verifies all footer links on the login page
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user clicks on the Terms link page
    When the Upgrade user clicks on the Privacy Policy link page
    Then the Upgrade user verifies all footer links on the login page

  @UP @footer_Links @regression @smoke
  Scenario: Ensure the Upgrade user verifies all footer links on the create an account page
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user clicks on "Create an Account" link
    And the Upgrade user clicks on the Terms of Service Privacy Policy link page
    Then the Upgrade user verifies all footer links
    When the Upgrade user fills out the Get Started form in UP and clicks Next
    Then the Upgrade user verifies all footer links

  @UP @footer_Links @regression @smoke
  Scenario: Ensure the Upgrade user verifies all footer links on my garage, shop now, vehicle detail & offer details page
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    When the Upgrade user creates a new profile
    Then the Upgrade user verifies all footer links
    And the Upgrade user clicks on my garage from the hamburger menu
    Then the Upgrade user verifies all footer links
    And the Upgrade user clicks on the shop new button
    Then the Upgrade user verifies all footer links
    And the Upgrade user selects a vehicle to navigate to the vehicle details page
    Then the Upgrade user verifies all footer links
    When the Upgrade user clicks on the offer details button
    Then the Upgrade user verifies all footer links