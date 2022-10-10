Feature: The Upgrade users can view recently viewed vehicles

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile

  @UP @UP_garage @recently_Viewed_Vehicles @regression
  Scenario: Ensure the Upgrade user doesn't see any vehicle in the recently viewed vehicles after creating a new account
    When the Upgrade user clicks on my garage from the hamburger menu
    Then the Upgrade user doesn't see any vehicle in the recently viewed vehicles

  @UP @UP_garage @recently_Viewed_Vehicles @regression @smoke
  Scenario: Ensure the Upgrade user sees a vehicle in the recently viewed vehicles
    And the Upgrade user clicks on shop new cars
    When the Upgrade user returns to recently viewed vehicles
    Then the Upgrade user can see the most recently viewed vehicle

  @UP @UP_garage @recently_Viewed_Vehicles @regression
  Scenario: Ensure the Upgrade user can move recently viewed vehicle moves to the saved vehicle section
    And the Upgrade user clicks on shop new cars
    When the Upgrade user returns to recently viewed vehicles to save vehicle
    Then the Upgrade user verifies vehicle is saved to the saved vehicle section
    And the Upgrade user doesn't see any vehicle in the recently viewed vehicles

  @UP @UP_garage @recently_Viewed_Vehicles @regression @smoke
  Scenario: Ensure Upgrade user can delete a recently viewed vehicle
    And the Upgrade user clicks on shop new cars
    And the Upgrade user returns to recently viewed vehicles
    When the Upgrade user deletes the recently viewed vehicle
    Then the Upgrade user doesn't see any vehicle in the recently viewed vehicles