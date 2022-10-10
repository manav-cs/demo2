Feature: CarSaver eCommerce (CSE) My Garage Address functionality

  Background:
    Given the CSE user navigates to the home page
    And the CSE user creates a profile
    When the CSE user clicks on the "My Address" link from the left nav

  @CSE @CSE_garage @CSE_address @regression
  Scenario: Ensure the CSE user's address entered during registration shows up in My Garage Update Address
    Then the CSE user should be on Update Address page
    And the CSE user should see the address they entered during registration

  @CSE @CSE_garage @CSE_address @regression @smoke
  Scenario: Ensure the CSE user is able to update the existing address from My Garage Update Address
    And the CSE user enters a valid address to update
    When the CSE user clicks on the Update button under My Address
    Then the CSE user should see the newly updated address

  @CSE @CSE_garage @CSE_address @regression @smoke
  Scenario: Ensure the CSE user is not able to update address with invalid address line 1
    And the CSE user enters an invalid address to update
    When the CSE user clicks on the Update button under My Address
    Then the CSE user should see the "Address is required" error message