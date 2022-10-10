Feature: The Upgrade users can sign out of account under the my garage & hamburger menu

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user login to the account

  @UP @UP_garage @UP_signOut @regression
  Scenario: Ensure when the Upgrade user clicks the Sign Out link in the left nav it takes them to the home page
    And the Upgrade user clicks on my garage from the hamburger menu
    When the Upgrade user clicks on the "Sign Out" link from the left nav
    Then the Upgrade user should successfully return to the homepage

  @UP @UP_garage @UP_signOut @regression @smoke
  Scenario: Ensure when the Upgrade user clicks the Sign Out link in the hamburger menu it takes them to the home page
    When the Upgrade user signs out via the hamburger menu
    Then the Upgrade user should successfully return to the homepage