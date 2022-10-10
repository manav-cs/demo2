Feature: The Upgrade users verifies the contact us button exist

  Background:
    Given the Upgrade user navigates to the homepage

  @UP @contact_Us @regression @smoke
  Scenario: Ensure the Upgrade user verifies contact us button on the homepage
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number

  @UP @contact_Us @regression
  Scenario: Ensure the Upgrade user verifies the contact us button on the login page
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number

  @UP @contact_Us @regression @smoke
  Scenario: Ensure the Upgrade user verifies the contact us button on the create an account page
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user clicks on "Create an Account" link
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number
    And the Upgrade user fills out the Get Started form in UP and clicks Next
    Then The Upgrade user verifies the contact us number

  @UP @contact_Us @regression
  Scenario: Ensure the Upgrade user verifies the contact us button on my garage, shop now, vehicle detail & offer details page
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number
    And the Upgrade user clicks on my garage from the hamburger menu
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number
    And the Upgrade user clicks on the shop new button
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number
    And the Upgrade user selects a vehicle to navigate to the vehicle details page
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number
    And the Upgrade user clicks on the offer details button
    When the Upgrade user clicks on the contact us button
    Then The Upgrade user verifies the contact us number