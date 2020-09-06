$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/demoHR.feature");
formatter.feature({
  "name": "Query database demoHR",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "postgres test demoHR departments",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@demoHR"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user establish connection to database \"demoHR\"",
  "keyword": "Given "
});
formatter.match({
  "location": "step_definitions.demoHR.user_establish_connection_to_database(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user executes query \"select * from departments\" and verifies result \"Finance\"",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.demoHR.user_executes_query_and_verifies_result(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user executes query \"select * from departments\" and verifies result \"dept_name\" and result value \"Finance\"",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.demoHR.user_executes_query_and_verifies_result_and_result_value(java.lang.String,java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user gets total row count for query \"select * from departments\"",
  "keyword": "Then "
});
formatter.match({
  "location": "step_definitions.demoHR.user_gets_total_row_count_for_query(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user closes connection to database",
  "keyword": "And "
});
formatter.match({
  "location": "step_definitions.demoHR.user_closes_connection_to_database()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});