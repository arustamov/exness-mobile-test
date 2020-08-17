@news_feed_updates
Feature: News feed updates

  As a user
  I want to turn ON/OFF news feed updates
  In order to ...

  Scenario: User turn news feed updates ON

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
    And I turn news feed updates OFF
    And I turn news feed updates ON

    Then I should see news feed updates ON

    When I go back
    And I go to profile
    And I sign out
    And I go to sign in
    And I sign in
    And I skip set a passcode
    And I close crypto introduction
    And I go to wallet
    And I go to settings

    Then I should see news feed updates ON

  Scenario: User turn news feed updates OFF

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
    And I turn news feed updates ON
    And I turn news feed updates OFF

    Then I should see news feed updates OFF

    When I go back
    And I go to profile
    And I sign out
    And I go to sign in
    And I sign in
    And I skip set a passcode
    And I close crypto introduction
    And I go to wallet
    And I go to settings

    Then I should see news feed updates OFF
