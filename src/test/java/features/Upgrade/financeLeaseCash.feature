Feature: The Upgrade users can switch between finance lease and cash tabs

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on shop new cars to navigate to the offer details page

  @UP @finance_Lease_Cash @regression
  Scenario: Ensure the Upgrade user can switch to finance lease and cash tabs
    And the Upgrade user switches to the Cash tab
    And the Upgrade user switches to the Lease tab
    And the Upgrade user switches to the Finance tab
    And the Upgrade user notes the current finance information
    When the Upgrade user changes the down payment for finance to "5000"
    Then the Upgrade user verifies the finance information has updated

  @UP @finance_Lease_Cash @regression @smoke
  Scenario: Ensure the Upgrade user can see adjusted down payment after switching  between tabs
    And the Upgrade user switches to the Lease tab
    And the Upgrade user notes the current lease information
    And the Upgrade user changes the down payment for lease to "1100"
    Then the Upgrade user verifies the lease information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user switches to the Finance tab
    And the Upgrade user switches to the Lease tab
    Then the deal page still has the updated information
    And the Upgrade user switches to the Cash tab
    When the Upgrade user switches to the Lease tab
    Then the deal page still has the updated information