Feature: The Upgrade users verifies check box presence and sorting on deal page

  Background:
    Given the Upgrade user navigates to the homepage
    And the Upgrade user clicks on the "Sign in here" link from the top nav
    And the Upgrade user creates a new profile
    And the Upgrade user goes to the deal page for a new car

  @UP @UP_checkBox @regression @smoke
  Scenario: Ensure check boxes for a logged-in profile financing deal are in order and do not repeat
    When the Upgrade user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat

  @UP @UP_checkBox @regression
  Scenario: Ensure for a logged-in profile deal the financing tab check box order does not change when changing down payment
    When the Upgrade user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the Upgrade user updates the desired down payment with the same value
    Then the check box order does not change

  @UP @UP_checkBox @regression
  Scenario: Ensure for a logged-in profile deal the financing tab check box order does not change when switching tabs
    When the Upgrade user switches to the Finance tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the Upgrade user switches to the Lease tab
    And the Upgrade user switches to the Finance tab
    Then the check box order does not change

  @UP @UP_checkBox @regression @smoke @BUG @NE-688
  Scenario: Ensure check boxes for a logged-in profile lease deal are in order and do not repeat
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat

  @UP @UP_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a logged-in profile deal the lease tab check box order does not change when miles per year changes
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user selects "15,000 miles per year" in the Miles Per Year drop down
    And the CSE user selects "12,000 miles per year" in the Miles Per Year drop down
    Then the check box order does not change

  @UP @UP_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a logged-in profile deal the lease tab check box order does not change when changing down payment
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user updates the desired down payment with the same value
    Then the check box order does not change

  @UP @UP_checkBox @regression @BUG @NE-688
  Scenario: Ensure for a logged-in profile deal the lease tab check box order does not change when switching tabs
    When the CSE user switches to the Lease tab
    Then the list of deal options is ordered by month descending
    And the listed deal options do not repeat
    When the CSE user switches to the Finance tab
    And the CSE user switches to the Lease tab
    Then the check box order does not change