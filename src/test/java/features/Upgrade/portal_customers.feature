Feature: The Upgrade user verifies name & email information matches in Portal

  Background:
    Given the Upgrade user creates a new profile

  @UP @UP_portal @regression @smoke
  Scenario: Ensure portal admin user able to pull the newly created upgrade user using email address
    And the portal admin user logs into the portal after the upgrade account creation is done
    And the portal admin user clicks on the "Customers" link
    And the portal admin user enters the newly created email address into the email search box
    When the portal admin user clicks on the "Search" button
    Then the portal admin user should be able to verify the newly created customer info

  @UP @UP_portal @regression @smoke
  Scenario: Ensure portal admin user able to pull the newly created upgrade user using the full name
    And the portal admin user logs into the portal after the upgrade account creation is done
    And the portal admin user clicks on the "Customers" link
    And the portal admin user enters the newly created customer's full name into the name search box
    When the portal admin user clicks on the "Search" button
    Then the portal admin user should be able to verify the newly created customer info

  @UP @UP_portal @regression @smoke
  Scenario: Ensure portal admin user able to pull the newly created upgrade user using the full name and email
    And the portal admin user logs into the portal after the upgrade account creation is done
    And the portal admin user clicks on the "Customers" link
    And the portal admin user enters the newly created customer's full name into the name search box
    And the portal admin user enters the newly created email address into the email search box
    When the portal admin user clicks on the "Search" button
    Then the portal admin user should be able to verify the newly created customer info




