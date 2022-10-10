Feature: eCommerce (CSE) users can see that all deal information is saved properly after altering the deal

  Background:
    Given the CSE user navigates to the home page
    When the CSE user goes to the deal page to buy a vehicle
    And the CSE user creates a new account to save the deal
    And the CSE user switches to the Finance tab
    And the CSE user clicks save and confirms the save

  @CSE @CSE_deals @CSE_savingDeals @regression
  Scenario: Verify saving deal page on lease tab is remembered
    And the CSE user switches to the Lease tab
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Lease" tab

  @CSE @CSE_deals @CSE_savingDeals @regression
  Scenario: Verify saving deal page on finance tab is remembered
    And the CSE user switches to the Lease tab
    And the CSE user switches to the Finance tab
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Finance" tab

  @CSE @CSE_deals @CSE_savingDeals @regression
  Scenario: Verify saving deal page on cash tab is remembered
    And the CSE user switches to the Cash tab
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Cash" tab

  @CSE @CSE_deals @CSE_savingDeals @regression @BUG @NE-688
  Scenario: Verify saving deal page after changing monthly rate check box on the lease tab
    And the CSE user switches to the Lease tab
    And the second monthly check box is selected
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Lease" tab
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_savingDeals @regression
  Scenario: Verify saving deal page after changing monthly rate check box on the finance tab
    And the second monthly check box is selected
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Finance" tab
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_savingDeals @regression
  Scenario: Verify saving deal page after changing down payment on the lease tab
    And the CSE user switches to the Lease tab
    And the CSE user changes the down payment for finance to "1000"
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Lease" tab
    And the down payment field reads "$ 1,000"

  @CSE @CSE_deals @CSE_savingDeals @regression
  Scenario: Verify saving deal page after changing down payment on the finance tab
    And the CSE user changes the down payment for finance to "1000"
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Finance" tab
    And the down payment field reads "$ 1,000"

  @CSE @CSE_deals @CSE_savingDeals @regression
  Scenario: Verify saving deal page after changing miles per year on lease tab
    And the CSE user switches to the Lease tab
    And the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    Then the save button requests user to save changes
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Lease" tab
    And Miles Per Year still shows "15,000 miles per year"

  @CSE @CSE_deals @CSE_savingDeals @regression @smoke @BUG @NE-688
  Scenario: Verify refreshing the page does not alter selections on lease tab
    And the CSE user switches to the Lease tab
    And the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user changes the down payment for finance to "1000"
    And the second monthly check box is selected
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user refreshes the page
    Then the active tab is the "Lease" tab
    And Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    When the CSE user refreshes the page
    Then the active tab is the "Lease" tab
    And Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_savingDeals @regression @smoke
  Scenario: Verify refreshing the page before and after saving does not alter selections on finance tab
    And the CSE user changes the down payment for finance to "1000"
    And the second monthly check box is selected
    And the CSE user clicks save and confirms the save
    And the CSE user refreshes the page
    Then the deal is marked as saved
    And the active tab is the "Finance" tab
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    When the CSE user refreshes the page
    Then the active tab is the "Finance" tab
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_savingDeals @regression @smoke @BUG @NE-688
  Scenario: Verify selections made on the lease tab are not altered after changing tabs and returning to the lease tab
    And the CSE user switches to the Lease tab
    And the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user changes the down payment for finance to "1000"
    And the second monthly check box is selected
    And the CSE user switches to the Finance tab
    And the CSE user switches to the Lease tab
    Then Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Lease tab
    Then Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Lease" tab
    And Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user switches to the Finance tab
    And the CSE user switches to the Lease tab
    Then Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Lease tab
    Then Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_savingDeals @regression @smoke
  Scenario: Verify selections made on the finance tab are not altered after changing tabs and returning to the finance tab
    And the CSE user changes the down payment for finance to "1000"
    And the second monthly check box is selected
    And the CSE user switches to the Lease tab
    And the CSE user switches to the Finance tab
    Then the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Finance tab
    Then the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user clicks "My Garage" in the hamburger menu
    Then the CSE user sees the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the deal page is present with the saved button
    And the active tab is the "Finance" tab
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user switches to the Lease tab
    Then the CSE user switches to the Finance tab
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected
    When the CSE user switches to the Cash tab
    Then the CSE user switches to the Finance tab
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected

  @CSE @CSE_deals @CSE_savingDeals @regression @smoke @BUG @NE-688
  Scenario: Verify saving a lease deal, changing tabs, going to the user's garage without saving, and returning to the deal shows the lease deal tab and changes
    And the CSE user switches to the Lease tab
    And the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user changes the down payment for finance to "1000"
    And the second monthly check box is selected
    And the CSE user clicks save and confirms the save
    Then the deal is marked as saved
    When the CSE user switches to the Cash tab
    Then the user returns to My Garage without saving
    And the CSE user is on the Saved Deals page in My Garage
    When the CSE user returns to deal page
    Then the active tab is the "Lease" tab
    And Miles Per Year still shows "15,000 miles per year"
    And the down payment field reads "$ 1,000"
    And the second monthly check box is still selected