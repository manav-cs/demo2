Feature: CarSaver eCommerce (CSE) user has a deal auto-saved when adding or updating accessories

  Background:
    Given the CSE user navigates to the home page
    When the CSE user pulls up an accessories vehicle page
    And the CSE user creates a new account to save the deal
    And the CSE user switches to the Finance tab
    And the CSE user clicks save and confirms the save

  @CSE @CSE_deals @CSE_autoSave @regression @smoke
  Scenario: Ensure deal is auto-saved when switching tabs and Add Accessories is selected
    And the CSE user switches to the Lease tab
    And the CSE user clicks the Add Accessories link under Buy @ Home
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Lease" tab
    When the CSE user switches to the Finance tab
    Then the save button requests user to save changes
    When the CSE user clicks the Add Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Finance" tab
    When the CSE user switches to the Cash tab
    Then the save button requests user to save changes
    When the CSE user clicks the Add Accessories link under Offer Details
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Cash" tab

  @CSE @CSE_deals @CSE_autoSave @regression
  Scenario: Ensure deal is auto-saved when on the lease tab and Edit Accessories is selected
    And the CSE user adds an accessory
    Then the deal is saved
    When the CSE user switches to the Lease tab
    And the CSE user clicks the Edit Accessories link under Buy @ Home
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Lease" tab
    When the CSE user switches to the Finance tab
    Then the save button requests user to save changes
    When the CSE user clicks the Edit Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Finance" tab
    When the CSE user switches to the Cash tab
    Then the save button requests user to save changes
    When the CSE user clicks the Edit Accessories link under Buy @ Home
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Cash" tab

  @CSE @CSE_deals @CSE_autoSave @regression @BUG @NE-688
  Scenario: Ensure deal is auto-saved when different monthly rate is selected and add accessories is selected on Lease tab
    And the CSE user switches to the Lease tab
    And the CSE user clicks save and confirms the save
    And the second monthly check box is selected
    Then the save button requests user to save changes
    When the CSE user clicks the Add Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Lease" tab
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_autoSave @regression @smoke
  Scenario: Ensure deal is auto-saved when different monthly rate is selected and edit accessories is selected on Lease tab
    And the CSE user adds an accessory
    Then the deal is saved
    When the CSE user switches to the Lease tab
    And the CSE user clicks save and confirms the save
    And the second monthly check box is selected
    Then the save button requests user to save changes
    When the CSE user clicks the Edit Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Lease" tab
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_autoSave @regression
  Scenario: Ensure deal is auto-saved when different monthly rate is selected and add accessories is selected on Finance tab
    And the second monthly check box is selected
    Then the save button requests user to save changes
    When the second monthly check box is selected
    And the CSE user clicks the Add Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Finance" tab
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_autoSave @regression @smoke
  Scenario: Ensure deal is auto-saved when different monthly rate is selected and edit accessories is selected on Finance tab
    And the CSE user adds an accessory
    Then the deal is saved
    When the second monthly check box is selected
    Then the save button requests user to save changes
    When the CSE user clicks the Edit Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Finance" tab
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_autoSave @regression @smoke
  Scenario: Ensure deal is auto-saved when miles-per-year is altered and add accessories is selected
    And the CSE user switches to the Lease tab
    And the CSE user clicks save and confirms the save
    And the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user clicks the Add Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And Miles Per Year still shows "15,000 miles per year"
    And the active tab is the "Lease" tab

  @CSE @CSE_deals @CSE_autoSave @regression
  Scenario: Ensure deal is auto-saved when miles-per-year is altered and edit accessories is selected
    And the CSE user adds an accessory
    Then the deal is saved
    When the CSE user switches to the Lease tab
    And the CSE user clicks save and confirms the save
    And the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user clicks the Edit Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And Miles Per Year still shows "15,000 miles per year"
    And the active tab is the "Lease" tab

  @CSE @CSE_deals @CSE_autoSave @regression
  Scenario: Ensure deal is auto-saved when Lease down payment is altered and add accessories is selected
    And the CSE user switches to the Lease tab
    And the CSE user clicks save and confirms the save
    And the CSE user changes the down payment for finance to "1000"
    When the CSE user clicks the Add Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the down payment field reads "$ 1,000"
    And the active tab is the "Lease" tab

  @CSE @CSE_deals @CSE_autoSave @regression
  Scenario: Ensure deal is auto-saved when Lease down payment is altered and edit accessories is selected
    And the CSE user adds an accessory
    Then the deal is saved
    When the CSE user switches to the Lease tab
    And the CSE user clicks save and confirms the save
    And the CSE user changes the down payment for finance to "1000"
    And the CSE user clicks the Edit Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the down payment field reads "$ 1,000"
    And the active tab is the "Lease" tab

  @CSE @CSE_deals @CSE_autoSave @regression @smoke
  Scenario: Ensure deal is auto-saved when Finance down payment is altered and add accessories is selected
    And the CSE user changes the down payment for finance to "1000"
    And the CSE user clicks the Add Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the down payment field reads "$ 1,000"
    And the active tab is the "Finance" tab

  @CSE @CSE_deals @CSE_autoSave @regression
  Scenario: Ensure deal is auto-saved when Finance down payment is altered and edit accessories is selected
    And the CSE user adds an accessory
    Then the deal is saved
    When the CSE user changes the down payment for finance to "1000"
    And the CSE user clicks the Edit Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the down payment field reads "$ 1,000"
    And the active tab is the "Finance" tab

  @CSE @CSE_deals @CSE_autoSave @regression @smoke
  Scenario: Ensure deal is auto-saved when rebates and incentives is selected and add accessories is selected
    And a rebate of Active Military is selected
    And the CSE user clicks the Add Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Finance" tab
    And the Active Military rebate is still selected

  @CSE @CSE_deals @CSE_autoSave @regression
  Scenario: Ensure deal is auto-saved when rebates and incentives is selected and edit accessories is selected
    And the CSE user adds an accessory
    Then the deal is saved
    When a rebate of Active Military is selected
    And the CSE user clicks the Edit Accessories button
    And the CSE user clicks Back to Vehicle
    Then the deal is saved
    And the active tab is the "Finance" tab
    And the Active Military rebate is still selected