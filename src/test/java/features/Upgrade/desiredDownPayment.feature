Feature: The Upgrade users can save and change desired down payment

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user clicks on shop new cars to navigate to the offer details page

  @UP @down_Payment @regression @smoke
  Scenario: Ensure the Upgrade user can save and change finance down payment on Financial Tab
    And the Upgrade user switches to the Finance tab
    And the Upgrade user notes the current finance information
    And the Upgrade user changes the down payment for finance to "1000"
    Then the Upgrade user verifies the finance information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user goes to My Garage
    And the Upgrade user clicks the View Deal button
    Then the deal page still has the updated information

  @UP @down_Payment @regression
  Scenario: Ensure the Upgrade user can set finance down payment to $0 on Financial Tab
    And the Upgrade user switches to the Finance tab
    And the Upgrade user notes the current finance information
    And the Upgrade user changes the down payment for finance to "0"
    Then the Upgrade user verifies the finance information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user clicks on my garage from the hamburger menu
    And the Upgrade user clicks the View Deal button
    Then the deal page still has the updated information

  @UP @down_Payment @regression @smoke
  Scenario: Ensure the Upgrade user can see adjusted financing down payment after refreshing the page
    And the Upgrade user switches to the Finance tab
    And the Upgrade user notes the current finance information
    And the Upgrade user changes the down payment for finance to "1500"
    Then the Upgrade user verifies the finance information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user refreshes the page
    Then the deal page still has the updated information

  @UP @down_Payment @regression @smoke
  Scenario: Ensure the Upgrade user can see adjusted financing down payment after switching tabs
    And the Upgrade user switches to the Finance tab
    And the Upgrade user notes the current finance information
    And the Upgrade user changes the down payment for finance to "1200"
    Then the Upgrade user verifies the finance information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user switches to the Lease tab
    And the Upgrade user switches to the Finance tab
    Then the deal page still has the updated information
    When the Upgrade user switches to the Cash tab
    And the Upgrade user switches to the Finance tab
    Then the deal page still has the updated information

  @UP @down_Payment @regression @smoke
  Scenario: Ensure the Upgrade user can save altered down payment on Lease Tab
    And the Upgrade user switches to the Lease tab
    And the Upgrade user notes the current lease information
    And the Upgrade user changes the down payment for lease to "1200"
    Then the Upgrade user verifies the lease information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user goes to My Garage
    And the Upgrade user clicks the View Deal button
    Then the deal page still has the updated information

  @UP @down_Payment @regression
  Scenario: Ensure the Upgrade user can set down payment to $0 on Lease Tab
    And the Upgrade user switches to the Lease tab
    And the Upgrade user notes the current lease information
    And the Upgrade user changes the down payment for lease to "1200"
    Then the Upgrade user verifies the lease information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user goes to My Garage
    And the Upgrade user clicks the View Deal button
    Then the deal page still has the updated information

  @UP @down_Payment @regression
  Scenario: Ensure the Upgrade user can see adjusted lease down payment after refreshing the page
    And the Upgrade user switches to the Lease tab
    And the Upgrade user notes the current lease information
    And the Upgrade user changes the down payment for lease to "1300"
    Then the Upgrade user verifies the lease information has updated
    When the Upgrade user clicks save and confirms the save
    And the Upgrade user refreshes the page
    Then the deal page still has the updated information