Feature: The Upgrade users can use their PIN to access the website

  Background:
    Given the Upgrade user navigates to the homepage

  @UP @UP_pin @regression @smoke
  Scenario: Ensure a valid PIN passed on the URL loads the prospect
    When a valid prospect's PIN is passed on the URL
    Then the Upgrade user's information is present on the home page
    When the "View Your Offers" button is clicked
    Then the verify identity page is present
    When the Upgrade user selects a contact method of "EMAIL"
    And the "Send verification code" button is clicked
    And the mfa is submitted
    Then the Upgrade user is on the PIN welcome page
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure a valid PIN reaches the verify page via the Get Started button
    When a valid prospect's PIN is passed on the URL
    Then the Upgrade user's information is present on the home page
    When the "Get Started" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression
  Scenario: Ensure a valid PIN reaches the verify page via the See Upgrade Offers button
    When a valid prospect's PIN is passed on the URL
    Then the Upgrade user's information is present on the home page
    When the "See your upgrade offers." button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression
  Scenario: Ensure a valid PIN reaches the verify page via the Learn How button
    When a valid prospect's PIN is passed on the URL
    Then the Upgrade user's information is present on the home page
    When the "Learn How to Upgrade" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression
  Scenario: Ensure a valid PIN reaches the verify page via the Start Shopping button
    When a valid prospect's PIN is passed on the URL
    Then the Upgrade user's information is present on the home page
    When the "Start Shopping" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure an invalid PIN Shows the verify page via the See Upgrade Offers button
    When an invalid prospect's PIN is passed on the URL
    Then the PIN error elements appear
    When the "Get Started" button is clicked
    Then the wrong PIN length error message appears
    When the "See your upgrade offers." button is clicked
    Then the wrong PIN length error message appears
    When the "Learn How to Upgrade" button is clicked
    Then the wrong PIN length error message appears
    When the "Start Shopping" button is clicked
    Then the wrong PIN length error message appears

  @UP @UP_pin @regression @smoke
  Scenario: Ensure the user, after entering an invalid PIN, can enter a valid PIN.
    When an invalid prospect's PIN is passed on the URL
    Then the PIN error elements appear
    When a valid PIN is entered into the PIN field
    And the "Get Started" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure the PIN field is present when noPinProspect is set to null
    When the no PIN prospect parameter is passed on the URL as null
    And the user sees the No Pin Available page
    Then the Upgrade user can submit a valid PIN in the PIN field
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure when the noPinProspect is null and Get Started offers is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as null
    And a valid PIN is entered into the PIN field
    And the "Get Started" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure when noPinProspect is null and See your upgrade offers is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as null
    And a valid PIN is entered into the PIN field
    And the "See your upgrade offers." button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure when the noPinProspect is null and Learn How to Upgrade is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as null
    And a valid PIN is entered into the PIN field
    And the "Learn How to Upgrade" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure when the noPinProspect is null and Start Shopping is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as null
    And a valid PIN is entered into the PIN field
    And the "Start Shopping" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure the PIN field is present when the noPinProspect is set to false
    When the no PIN prospect parameter is passed on the URL as false
    Then the user sees the No Pin Available page
    And the Upgrade user can submit a valid PIN in the PIN field
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure when the noPinProspect is false and Get Started offers is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as false
    And a valid PIN is entered into the PIN field
    And the "Get Started" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression
  Scenario: Ensure when the noPinProspect is false and See your upgrade offers is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as false
    And a valid PIN is entered into the PIN field
    And the "See your upgrade offers." button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression
  Scenario: Ensure when the noPinProspect is false and Learn Howw to Upgrade is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as false
    And a valid PIN is entered into the PIN field
    And the "Learn How to Upgrade" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression
  Scenario: Ensure when the noPinProspect is false and Start Shopping is clicked then the user is sent to PIN confirmation
    When the no PIN prospect parameter is passed on the URL as false
    And a valid PIN is entered into the PIN field
    And the "Start Shopping" button is clicked
    Then the verify identity page is present
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure the user is not logged out when the noProspect is set to true on the URL
    When the Upgrade user login to the account
    And the no PIN prospect parameter is passed on the URL as true
    Then the user is not logged off

  @UP @UP_pin @regression @smoke
  Scenario: Ensure the user is not logged out when the noProspect is set to false on the URL
    When the Upgrade user login to the account
    And the no PIN prospect parameter is passed on the URL as false
    Then the user is not logged off

  @UP @UP_pin @regression @smoke
  Scenario: Ensure the user is not logged out when the noProspect is set to null on the URL
    When the Upgrade user login to the account
    And the no PIN prospect parameter is passed on the URL as null
    Then the user is not logged off

  @UP @UP_pin @regression @smoke
  Scenario: Ensure the user is not logged out when the PIN is passed on the URL
    When the Upgrade user login to the account
    And a valid prospect's PIN is passed on the URL
    Then the user is not logged off
    And the PIN is reset for future use

  @UP @UP_pin @regression @smoke
  Scenario: Ensure on the No Prospect PIN page that clicking the Get Started button takes the user to the create login page
    When the no PIN prospect parameter is passed on the URL as true
    Then the no PIN prospect page is present without a PIN field
    When the "Get Started" button is clicked
    Then the user is on the create login page

  @UP @UP_pin @regression @BUG
  Scenario: Ensure on the No Prospect PIN page that clicking the Upgrade Offers button takes the user to the create login page
    When the no PIN prospect parameter is passed on the URL as true
    Then the no PIN prospect page is present without a PIN field
    When the "See your upgrade offers." button is clicked
    Then the user is on the create login page

  @UP @UP_pin @regression @BUG
  Scenario: Ensure on the No Prospect PIN page that clicking the Learn How button takes the user to the create login page
    When the no PIN prospect parameter is passed on the URL as true
    Then the no PIN prospect page is present without a PIN field
    When the "Learn How to Upgrade" button is clicked
    Then the user is on the create login page

  @UP @UP_pin @regression @BUG
  Scenario: Ensure on the No Prospect PIN page that clicking the Start Shopping button takes the user to the create login page
    When the no PIN prospect parameter is passed on the URL as true
    Then the no PIN prospect page is present without a PIN field
    When the "Start Shopping" button is clicked
    Then the user is on the create login page