package tests;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostGres {
      //path fot Postgresql database : url link to setUp a connection
      String demoHR = "jdbc:postgresql://localhost:5432/demoHR";
       // create a userName
      String dbUserName = "postgres";
    // create a password

    String dbPassword = "";

    @Test
    public void countTest() throws SQLException {
        //Stablish a Database connection
        //for JDBC connection we use interface Connections
        Connection connection = DriverManager.getConnection(demoHR, dbUserName, dbPassword);
        //Establish an interface called Statement to read from databae
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY);
        //ResultSet interface allow us to query and execute the command
        ResultSet resultSet = statement.executeQuery("select * from departments");
        //last row of the data
        resultSet.last();

        //Verify that the query contains more than  0 records(rows)
        int rowsCount = resultSet.getRow(); //9
        System.out.println(rowsCount);
        Assert.assertTrue(rowsCount > 0);

        resultSet.close();
        statement.close();
        connection.close();
    }
      @Test
      public void testDatabaseConnection() throws SQLException {
            Connection connection = DriverManager.getConnection(demoHR, dbUserName, dbPassword);
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                                                    ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery("select * from departments");
          //resultSet.f
           while(resultSet.next()){
               System.out.println(resultSet.getString(1)  + " | " +
                               resultSet.getString("dept_no") + " | " +
                                       resultSet.getString("dept_name"));
           }

        }

    @Test
    public void metaData() throws SQLException {
        Connection connection = DriverManager.getConnection(demoHR, dbUserName, dbPassword);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select * from departments";
        ResultSet resultSet = statement.executeQuery(sql);
        // Metadata
        // Metadata is the data describing the data that is being stored in your Data source
        // Metadata generally includes the name, size and number of rows for each table present
        // in the database
        DatabaseMetaData dbMetadata = connection.getMetaData();
        // Return username of the database
        System.out.println("Database User: " + dbMetadata.getUserName());
        // Return database type
        System.out.println("Database type: " + dbMetadata.getDatabaseProductName());
        // Resultset Metadata will query the results
        ResultSetMetaData rsMetadata = resultSet.getMetaData();
        System.out.println("Column count: " + rsMetadata.getColumnCount());
        for (int i = 1; i <= rsMetadata.getColumnCount(); i++) {
            System.out.println(i + " --> " + rsMetadata.getColumnName(i));
        }
        // Throw resultset into a list of MAPS
        // Create a list of Maps
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData rsMetadata2 = resultSet.getMetaData();
        int colCount = rsMetadata2.getColumnCount();// numberical value from database
        while (resultSet.next()) {
            Map<String, Object> rowMap = new HashMap<>();
            for (int col = 1; col <= colCount; col++) {
                rowMap.put(rsMetadata2.getColumnName(col), resultSet.getObject(col));
            }
            list.add(rowMap);
        }
        for (Map<String, Object> emp : list) {
            System.out.println(emp.get("dept_no"));
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
    }



