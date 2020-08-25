@home_Page_Regression_test

Feature: Home Page tests

@title_verify
 Scenario: Verify Home Page title
 Given I am opening a home page
 Then  I am verifying that the title is Toxic Sushi

 @logIn_test
  Scenario: Log in credentials test
  Given I am opening a home page
   And I am clicking the Toggle Button
   And I am clicking the Sign in Button
   And I am providing "userName" as username
   And I am providing "password" as password
   And I am clicking the Submit Button
   Then I am validating a "message" as message

 @signOut_test
 Scenario: Sign out test
  Given I am opening a home page
  And I am clicking the Toggle Button
  And I am clicking the Sign in Button
  And I am providing "userName" as username
  And I am providing "password" as password
  And I am clicking the Submit Button
  And I am clicking the Toggle Button
  And I am clicking the Sign Out Button
  Then I am verifying "Hi, Azamat"message is not displayed

 @nav_Bar_test
  Scenario: Navigation Bar test
  Given I am opening a home page
   And verifying Navigation Buttons displayed

@hungry_button_test
Scenario: Hungry Button test
 Given I am opening a home page
 And I am clicking the Hungry Button
 Then I am verifying that the Search Label is "SEARCH RESTAURANTS"

@show_More_Button_test
Scenario: Show me more button test
 Given I am opening a home page
 And I am clicking the Show me more Button
 Then I am verifying that the Contacts Label is "WE'RE HAPPY TO HEAR FROM YOU"

@search_Restaurants_test
Scenario: Search Restaurants button test
 Given I am opening a home page
 And I am clicking the Search Restaurant Button
 Then I am verifying that the Search Label is "SEARCH RESTAURANTS"



