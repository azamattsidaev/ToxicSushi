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
  "name": "Log in credentials test",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@home_Page_Regression_test"
    },
    {
      "name": "@logIn_test"
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
  "name": "I am clicking the Toggle Button",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmClickingTheToggleButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am clicking the Sign in Button",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmClickingTheSignInButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am providing \"userName\" as username",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmProvidingAsUsername(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am providing \"password\" as password",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmProvidingAsPassword(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am clicking the Submit Button",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmClickingTheSubmitButton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I am clicking the \"Submit\" Button",
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "I am validating a \"message\" as message",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.HomePageTest.iAmValidatingAAsMessage(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "passed"
});
});