Feature: CarSaver eCommerce (CSE) user can save deals with altered down payments

  Background:
    Given the CSE user navigates to the home page
    And the CSE user goes to the deal page for a vehicle
    And the CSE user creates a new account
    And the offers ready modal appears
    Then the deal page is present

  @CSE @CSE_garage @CSE_downPayment @regression @smoke
  Scenario: Ensure user can save altered finance down payment on Financial Tab
    When the CSE user switches to the Finance tab
    And the CSE user notes the current finance information
    And the CSE user changes the down payment for finance to "1000"
    Then the CSE user verifies the finance information has updated
    When the CSE user clicks save and confirms the save
    And the CSE user goes to My Garage
    And the CSE user clicks the View Deal button
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_downPayment @regression
  Scenario: Ensure user can set finance down payment to $0 on Financial Tab
    When the CSE user switches to the Finance tab
    And the CSE user notes the current finance information
    And the CSE user changes the down payment for finance to "0"
    Then the CSE user verifies the finance information has updated
    When the CSE user clicks save and confirms the save
    And the CSE user goes to My Garage
    And the CSE user clicks the View Deal button
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_downPayment @regression
  Scenario: Ensure user can see adjusted financing down payment after refreshing the page
    When the CSE user switches to the Finance tab
    And the CSE user notes the current finance information
    And the CSE user changes the down payment for finance to "1500"
    Then the CSE user verifies the finance information has updated
    When the CSE user clicks save and confirms the save
    And the CSE user refreshes the page
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_downPayment @regression
  Scenario: Ensure user can see adjusted financing down payment after switching tabs
    When the CSE user switches to the Finance tab
    And the CSE user notes the current finance information
    And the CSE user changes the down payment for finance to "1200"
    Then the CSE user verifies the finance information has updated
    When the CSE user clicks save and confirms the save
    And the CSE user switches to the Lease tab
    And the CSE user switches to the Finance tab
    Then the deal page still has the updated information
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Finance tab
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_downPayment @regression @smoke
  Scenario: Ensure user can save altered down payment on Lease Tab
    When the CSE user switches to the Lease tab
    And the CSE user notes the current lease information
    And the CSE user changes the down payment for lease to "1200"
    Then the CSE user verifies the lease information has updated
    When the CSE user clicks save and confirms the save
    And the CSE user goes to My Garage
    And the CSE user clicks the View Deal button
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_downPayment @regression
  Scenario: Ensure user can set down payment to $0 on Lease Tab
    When the CSE user switches to the Lease tab
    And the CSE user notes the current lease information
    And the CSE user changes the down payment for lease to "1200"
    Then the CSE user verifies the lease information has updated
    When the CSE user clicks save and confirms the save
    And the CSE user goes to My Garage
    And the CSE user clicks the View Deal button
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_downPayment @regression
  Scenario: Ensure user can see adjusted lease down payment after refreshing the page
    When the CSE user switches to the Lease tab
    And the CSE user notes the current lease information
    And the CSE user changes the down payment for lease to "1300"
    When the CSE user verifies the lease information has updated
    Then the CSE user clicks save and confirms the save
    And the CSE user refreshes the page
    Then the deal page still has the updated information

  @CSE @CSE_garage @CSE_downPayment @regression @smoke
  Scenario: Ensure user can see adjusted lease down payment after switching tabs
    When the CSE user switches to the Lease tab
    And the CSE user notes the current lease information
    And the CSE user changes the down payment for lease to "1100"
    Then the CSE user verifies the lease information has updated
    When the CSE user clicks save and confirms the save
    And the CSE user switches to the Finance tab
    And the CSE user switches to the Lease tab
    Then the deal page still has the updated information
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Lease tab
    Then the deal page still has the updated information