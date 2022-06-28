Feature: Login

#  Scenario: Valid user can sign in and sign out
#    Given Go to the home page
#    When User login with username "standard_user" and password as "secret_sauce"
#    And The user should login successfully and is on the inventory page
#    And User logouts
#    Then User is back on the home page


#  Scenario: Invalid user cannot sign in
#    Given Go to the home page
#    When User login with username "abcde" and password as "efgh"
#    Then The error should appear

  @ignore
  Scenario: Valid user can sign in and there are 4 options in the menu bar
    Given Go to the home page
    When User login with username "standard_user" and password as "secret_sauce"
    And The user should login successfully and is on the inventory page
    Then Menu bar contains '4' options

