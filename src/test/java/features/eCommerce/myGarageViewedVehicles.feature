Feature: CarSaver eCommerce (CSE) user can view recently viewed vehicles

  Background:
    Given the CSE user navigates to the home page
    And the CSE user goes to the deal page for a vehicle
    And the CSE user creates a new account
    And the CSE user copies the deal information
    And the offers ready modal appears
    Then the deal page is present

  @CSE @CSE_garage @CSE_recentlyViewed @regression @smoke
  Scenario: Ensure user see a recent vehicle under recently viewed vehicles
    When the CSE user clicks the Hamburger menu
    And the Save Deal confirmation modal appears
    And the CSE user clicks "No, thanks"
    Then the Save Deal confirmation modal vanishes
    When the CSE user clicks "My Garage"
    Then the recently viewed vehicles page is present
    And the CSE user can see the most recently viewed vehicle

  @CSE @CSE_garage @CSE_recentlyViewed @regression @BUG_NE-689
  Scenario: Ensure user's previously viewed vehicle moves to the saved vehicle section
    When the CSE user stores a vehicle under Recently Viewed Vehicles
    Then the CSE user can see the most recently viewed vehicle
    When the CSE user signs out
    And the CSE user goes to the deal page for a vehicle
    And the CSE user signs in from deal page
    And the CSE user copies the second deal information
    And the CSE user stores a second vehicle under Recently Viewed Vehicles
    Then the CSE user is on the Saved Deals page in My Garage
    And the CSE user sees the previous viewed vehicle saved
    When the CSE user clicks on the "Recently Viewed Vehicles" link from the left nav
    Then the recently viewed vehicles page is present
    And the CSE user can see both recently viewed vehicle

  @CSE @CSE_garage @CSE_recentlyViewed @regression
  Scenario: Ensure user can remove viewed vehicles form recently viewed vehicles
    When the CSE user stores a vehicle under Recently Viewed Vehicles
    Then the CSE user can see the most recently viewed vehicle
    When the user deletes the first vehicle from recently viewed vehicles
    Then the first vehicle is no longer present
    And no vehicles are present under Recently Viewed Vehicles