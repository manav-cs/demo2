Feature: The Upgrade users can verify all hamburger icon functionality

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user login to the account
    And the Upgrade user clicks the Hamburger icon

  @UP @UP_hamburger @regression @smoke
  Scenario: Ensure the hamburger icon displays appropriate links when clicked
    And the "Home" link is present in the hamburger menu
    And the "My Garage" link is present in the hamburger menu
    And the "Shop New" link is present in the hamburger menu
    And the "Value Trade" link is present in the hamburger menu
    And the "Sign Out" link is present in the hamburger menu
    When the Upgrade user clicks the close button in the Hamburger menu
    Then the hamburger menu closes

  @UP @UP_hamburger @regression @smoke
  Scenario: Ensure the Close icon closes the hamburger display
    When the Upgrade user clicks the close button in the Hamburger menu
    Then the hamburger menu closes

  @UP @UP_hamburger @regression @smoke
  Scenario: Ensure the Home link takes the Upgrade user to the Home page
    When the Upgrade user clicks the "Home" link
    Then the Upgrade user should see the home page
    When the Upgrade user clicks the Hamburger icon
    Then the Upgrade user sees all the hamburger links