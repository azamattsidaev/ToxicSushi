Feature: Query database demoHR

  @demoHR
  Scenario: postgres test demoHR departments
    Given user establish connection to database "demoHR"
    Then user executes query "select * from departments" and verifies result "Finance"
    Then user executes query "select * from departments" and verifies result "dept_name" and result value "Finance"
    Then user gets total row count for query "select * from departments"
    And user closes connection to database