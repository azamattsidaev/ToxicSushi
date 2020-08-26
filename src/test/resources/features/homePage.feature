@home_Page_Regression_test

Feature: Home Page tests
Background:
 Given I am opening a home page
 And   I login the page

@title_verify
 Scenario: Verify Home Page title
 Then  I am verifying that the title is Toxic Sushi

 @logIn_test
 Scenario: Log in credentials test
  And I am verifying "Hi message" as "Hi,Azamat"
  And I am clicking the "Sign out" Button
  When I login with invalid credentials
  Then I am verifying "Error message" as "Your email or password is incorrect! Please try again!"


 @signOut_test
 Scenario: Sign out test
  And I am clicking the "Sign out" Button
  Then I am verifying "Hi, Azamat"message is not displayed

 @nav_Bar_test
  Scenario: Navigation Bar test
   And verifying Navigation Buttons displayed

@hungry_button_test
Scenario: Hungry Button test
 And I am clicking the "Hungry" Button
 Then I am verifying that the Search Label is "SEARCH RESTAURANTS"

@show_More_Button_test
Scenario: Show me more button test
 Given I am opening a home page
 And I am clicking the "Show me more" Button
 Then I am verifying that the Contacts Label is "WE'RE HAPPY TO HEAR FROM YOU"

@search_Restaurants_test
Scenario: Search Restaurants button test
 And I am clicking the "Search Restaurant" Button
 Then I am verifying that the Search Label is "SEARCH RESTAURANTS"



