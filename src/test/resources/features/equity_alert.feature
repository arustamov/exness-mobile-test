@equity_alert
Feature: Equity alert

  As a user
  I want to turn ON/OFF equity alert
  In order to ...

  Scenario: User turn equity alert ON

    Given there are users
    And there is a random "user" among the "users"

    When I open the application
    And I dismiss app guide
    And I go to sign in
    And I sign in
    And I skip set a passcode
    And I close crypto introduction
    And I skip onboarding
    And I go to wallet
    And I go to settings
    And I turn equity alert OFF
    And I turn equity alert ON

    Then I should see equity alert turned ON

    When I go back
    And I go to profile
    And I sign out
    And I go to sign in
    And I sign in
    And I skip set a passcode
    And I close crypto introduction
    And I go to wallet
    And I go to settings

    Then I should see equity alert turned ON

  Scenario: User turn equity alert OFF

    Given there are users
    And there is a random "user" among the "users"

    When I open the application
    And I dismiss app guide
    And I go to sign in
    And I sign in
    And I skip set a passcode
    And I close crypto introduction
    And I skip onboarding
    And I go to wallet
    And I go to settings
    And I turn equity alert ON
    And I turn equity alert OFF

    Then I should see equity alert turned OFF

    When I go back
    And I go to profile
    And I sign out
    And I go to sign in
    And I sign in
    And I skip set a passcode
    And I close crypto introduction
    And I go to wallet
    And I go to settings

    Then I should see equity alert turned OFF

  Scenario: User cancel turn equity alert OFF

    Given there are users
    And there is a random "user" among the "users"

    When I open the application
    And I dismiss app guide
    And I go to sign in
    And I sign in
    And I skip set a passcode
    And I close crypto introduction
    And I skip onboarding
    And I go to wallet
    And I go to settings
    And I turn equity alert ON
    And I try to turn equity alert OFF
    And I cancel turn equity alert OFF

    Then I should see equity alert turned ON
