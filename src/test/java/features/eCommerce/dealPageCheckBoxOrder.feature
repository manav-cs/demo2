Feature: CarSaver eCommerce (CSE) user verifies check box presence and sorting on deal page

  Background:
    Given the CSE user navigates to the home page
    And the CSE user goes to the deal page for a vehicle

  @CSE @CSE_garage @CSE_checkBox @regression @smoke
  Scenario: Ensure check boxes for a no-profile financing deal are in order and do not repeat
    When the CSE user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat

  @CSE @CSE_garage @CSE_checkBox @regression
  Scenario: Ensure for a no-profile deal the financing tab check box order does not change when changing down payment
    When the CSE user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user updates the desired down payment with the same value
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression
  Scenario: Ensure for a no-profile deal the financing tab check box order does not change when switching tabs
    When the CSE user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user switches to the Lease tab
    And the CSE user switches to the Finance tab
    Then the check box order does not change
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Finance tab
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression @smoke
  Scenario: Ensure check boxes for a logged-in profile financing deal are in order and do not repeat
    When the CSE user logs in from the deal page
    And the CSE user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat

  @CSE @CSE_garage @CSE_checkBox @regression
  Scenario: Ensure for a logged-in profile deal the financing tab check box order does not change when changing down payment
    When the CSE user logs in from the deal page
    And the CSE user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user updates the desired down payment with the same value
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression
  Scenario: Ensure for a logged-in profile deal the financing tab check box order does not change when switching tabs
    When the CSE user logs in from the deal page
    And the CSE user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user switches to the Lease tab
    And the CSE user switches to the Finance tab
    Then the check box order does not change
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Finance tab
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression @smoke @BUG @NE-688
  Scenario: Ensure check boxes for a no-profile lease deal are in order and do not repeat
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat

  @CSE @CSE_garage @CSE_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a no-profile deal the lease tab check box order does not change when miles per year changes
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user selects "12,000 miles per year" in the Miles Per Year drop down
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a no-profile deal the lease tab check box order does not change when changing down payment
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user updates the desired down payment with the same value
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a no-profile deal the lease tab check box order does not change when switching tabs
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    And the CSE user switches to the Finance tab
    And the CSE user switches to the Lease tab
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Lease tab
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression @smoke @BUG @NE-688
  Scenario: Ensure check boxes for a logged-in profile lease deal are in order and do not repeat
    When the CSE user logs in from the deal page
    And the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat

  @CSE @CSE_garage @CSE_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a logged-in profile deal the lease tab check box order does not change when miles per year changes
    When the CSE user logs in from the deal page
    And the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user selects "12,000 miles per year" in the Miles Per Year drop down
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a logged-in profile deal the lease tab check box order does not change when changing down payment
    When the CSE user logs in from the deal page
    And the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user updates the desired down payment with the same value
    Then the check box order does not change

  @CSE @CSE_garage @CSE_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a logged-in profile deal the lease tab check box order does not change when switching tabs
    When the CSE user logs in from the deal page
    And the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user switches to the Finance tab
    And the CSE user switches to the Lease tab
    Then the check box order does not change
    When the CSE user switches to the Cash tab
    And the CSE user switches to the Lease tab
    Then the check box order does not change