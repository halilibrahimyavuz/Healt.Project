package stepdefinitions.dbStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class US18_DB_stepdefinitions {


    @Given("Admin B_A connects to the database")
    public void admin_b_a_connects_to_the_database() {
        DBUtils.createConnection();

    }
    @Given("Admin B_A gets the {string} from {string} table")
    public void admin_b_a_gets_the_from_table(String column, String table) {
        String physicianQuery= "Select " + column + " from " + table;
        DBUtils.executeQuery(physicianQuery);
        System.out.println("physicianQuery = " + physicianQuery);


    }
    @Given("Admin B_A reads all of the {string} column data")
    public void admin_b_a_reads_all_of_the_column_data(String column) throws SQLException {
        DBUtils.getResultset().next();
        Object columnData=DBUtils.getResultset().getObject(column);
        System.out.println("Tablodaki 1.kullanici = " + columnData);

        DBUtils.getResultset().next();
        Object columnData2=DBUtils.getResultset().getObject(column);
        System.out.println("Tablodaki 2.kullanici = " + columnData2);

        DBUtils.getResultset().next();
        Object columnData3=DBUtils.getResultset().getObject(column);
        System.out.println("Tablodaki 3.kullanici = " + columnData3);

        while (DBUtils.getResultset().next()){
            Object eachColumnData=DBUtils.getResultset().getObject(column);
            System.out.println("eachColumnData = " + eachColumnData);
        }


    }
    @Given("Admin B_A verify {string} table {string} column contains {string}")
    public void admin_b_a_verify_table_column_contains(String column, String table, String data) {
        List<Object> allExpectedPhyQuery=DBUtils.getColumnData("Select * from physician","first_name");
        System.out.println("allExpectedPhyQuery :  " + allExpectedPhyQuery);

        List<Object> eachOnePhyQuery=new ArrayList<>();
        eachOnePhyQuery.add(data);
        System.out.println("eachOnePhyQuery = " + eachOnePhyQuery);

        Assert.assertTrue(allExpectedPhyQuery.containsAll(eachOnePhyQuery));




    }
    @Given("Admin B_A close the database connection")
    public void admin_b_a_close_the_database_connection() {
        DBUtils.closeConnection();
    }



    }
