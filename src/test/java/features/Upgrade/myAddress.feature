Feature: The Upgrade users can update my address information under my garage

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user accesses My Address via the hamburger link

  @UP @UP_garage @myAddress @regression
  Scenario: Ensure the Upgrade user's address entered during registration shows up in My Garage Update Address
    When the Upgrade user lands on Update Address page
    Then the Upgrade user should see the address they entered during registration

  @UP @UP_garage @myAddress @regression @smoke
  Scenario: Ensure the Upgrade user can update the existing address from My Garage Update Address
    And the Upgrade user enters a valid address to update
    When the Upgrade user clicks on the Update button under My Address
    Then the Upgrade user should see the newly updated address

  @UP @UP_garage @myAddress @regression @smoke
  Scenario: Ensure the Upgrade user is not able to update the address with invalid address line 1
    And the Upgrade user enters an invalid address to update
    When the Upgrade user clicks on the Update button under My Address
    Then the Upgrade user should see the "Address is required" error message