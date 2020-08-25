$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/homePage.feature");
formatter.feature({
  "name": "Home Page tests",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@home_Page_Regression_test"
    }
  ]
});
formatter.scenario({
  "name": "Search Restaurants button test",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@home_Page_Regression_test"
    },
    {
      "name": "@search_Restaurants_test"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am opening a home page",
  "keyword": "Given "
});
formatter.match({
  "location": "step_definitions.HomePageTest.i_am_opening_a_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am clicking the Search Restaurant Button",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmClickingTheSearchRestaurantButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am verifying that the Search Label is \"SEARCH RESTAURANTS\"",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmVerifyingThatTheSearchLabelIs(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});