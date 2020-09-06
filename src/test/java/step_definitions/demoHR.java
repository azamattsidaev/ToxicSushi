package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DBUtility;
import utils.Database;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class demoHR {

    @Given("user establish connection to database {string}")
    public void user_establish_connection_to_database(String string) {
        DBUtility.establishConnection(Database.POSTGRESQL, "demoHR");
    }



    @Then("user executes query {string} and verifies result {string}")
    public void user_executes_query_and_verifies_result(String query, String result) {
//        List<Map<String, Object>> departments = DBUtility.getQueryResults("select * from departments");
//        Assert.assertEquals(departments.get(1).get("dept_name"), "Finance");
        List<Map<String, Object>> results = DBUtility.getQueryResults(query);
        System.out.println("Query result : " + results);
        for(Map<String,Object> map : results){
            for(Map.Entry<String, Object> entry : map.entrySet()){
                if(entry.getKey().matches("dept_name") && entry.getValue().equals(result)){
                    System.out.println("Successful query :"+entry.getValue());
                    Assert.assertEquals(entry.getValue(), result);
                    break;
                }
                      System.out.println("Not Matching results: "+ result+ " <> "+entry.getKey() + " - "+ entry.getValue());
            }
        }

    }

    @Then("user executes query {string} and verifies result {string} and result value {string}")
    public void user_executes_query_and_verifies_result_and_result_value(String query, String columName, String value) {
        List<Map<String, Object>> results = DBUtility.getQueryResults(query);
        for (Map<String, Object> map : results) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry.getKey().matches(columName) && entry.getValue().equals(value)){
                    System.out.println("Column Name: "+entry.getKey());
                    System.out.println("Value: "+entry.getValue());
                    Assert.assertEquals(entry.getKey(),columName);
                    Assert.assertEquals(entry.getValue(),value);
                }
            }
        }

    }

    @Then("user gets total row count for query {string}")
    public void user_gets_total_row_count_for_query(String string) throws SQLException {
       int rowCount = DBUtility.getRowsCount("select * from departments");
        System.out.println(rowCount);
    }

    @Then("user closes connection to database")
    public void user_closes_connection_to_database() {
        DBUtility.closeConnections();

    }
}