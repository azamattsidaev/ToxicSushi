package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.DBUtility;
import utils.Database;

import java.sql.Date;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;

public class dbValidation {


    @Before
    public void setUp() {
        DBUtility.establishConnection(Database.POSTGRESQL, "demoHR");
    }

    @After
    public void closeDB() {
        DBUtility.closeConnections();
    }


    @Test
    public void assertDB() throws SQLException {

        DBUtility.getRowsCount("select * from employees");
        DBUtility.getRowsCount("select first_name from employees");
    }

    @Test
    public void assertDB2() {
        List<Map<String, Object>> empData = DBUtility.getQueryResults("select title from titles");
        System.out.println(empData.get(0));
        System.out.println(empData.get(4));

        Assert.assertEquals(empData.get(1).get("title"), "Staff");
    }

    @Test
    public void test1() {
        //TODO
        // query all the records from departments table and assert "Sales" from dept_name column
        // and their respective dept_no "d007"
        List<Map<String, Object>> departments = DBUtility.getQueryResults("select * from departments");

        Assert.assertEquals(departments.get(6).get("dept_name"), "Sales");
        Assert.assertEquals(departments.get(6).get("dept_no"), "d007");

    }

    @Test
    public void test2() {
        //TODO
        // query first_name from employees and assert "Anneke" and "Berni" from their column
        List<Map<String, Object>> names = DBUtility.getQueryResults("select first_name from employees limit 20");

        Assert.assertEquals(names.get(5).get("first_name"), "Anneke");
        Assert.assertEquals(names.get(13).get("first_name"), "Berni");

    }

    @Test
    public void test3() {
        //TODO
        //query all results from employees table and assert emp_no "1005" birth_date "1955-01-21"
        // and first name "Kyoichi"
        List<Map<String, Object>> emp = DBUtility.getQueryResults("select * from employees");

        Assert.assertEquals(emp.get(4).get("emp_no"), 10005);
        Assert.assertEquals(emp.get(4).get("first_name"), "Kyoichi");
        Assert.assertEquals(String.valueOf(emp.get(4).get("birth_date")), "1955-01-21");

        //second way to pvalidate a DATE
//        Date date = Date.valueOf("1955-01-21");
//        Assert.assertEquals(String.valueOf(emp.get(4).get("birth_date")), date);


    }

    @Test
    public void test4() throws SQLException {
        //TODO
        // query the total count from employees table and assert results = 300024
        int count = DBUtility.getRowsCount("select * from employees");
        Assert.assertEquals(count, 300024);




    }


    @Test
    public void test5() {
        //TODO
        // query a list of emp_no whose minimun salary is 40000 or less limit 1
        List<Map<String, Object>> salary =
                DBUtility.getQueryResults("select emp_no,min(salary) from salaries group by emp_no having min (salary) <=40000 limit 1 ");
        Assert.assertEquals(salary.get(0).get("min"), 40000);

    }

    @Test
    public void test6() {
        //TODO
        //  query emp_no and salary form the second highets salary table alias salary => as secondHighestSalary
        List<Map<String, Object>> secondHighest =
                DBUtility.getQueryResults("select emp_no, salary as secondHighestSalary from salaries order by salary desc offset 2 limit 1");
        Assert.assertEquals(secondHighest.get(0).get("salary"), 156286);

    }

}
