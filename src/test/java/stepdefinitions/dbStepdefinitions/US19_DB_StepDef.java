package stepdefinitions.dbStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import runners.basicRunners.DB_Runner;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US19_DB_StepDef {
    @Given("Kullanici  db ye baglanir")
    public void kullanici_db_ye_baglanir() {
        DBUtils.createConnection();

    }
    @Then("Kullanici select {string} from {string} sorgusu yapar")
    public void kullanici_select_from_sorgusu_yapar(String satır, String table) {
        String expectedQuery = " select "+satır+" from "+table;
        DBUtils.executeQuery(expectedQuery);
    }
    @Then("Kullanici {string} sutunu okur")
    public void kullanici_sutunu_okur(String string) {


    }
    @Then("kullanici {string} table {string} sutunundaki {string} dogrular")
    public void kullanici_table_sutunundaki_dogrular(String table, String satır, String data) {
        List<Object> expectedDatalarim = DBUtils.getColumnData("select*from staff","first_name");
        System.out.println("expectedDatalarim = " + expectedDatalarim);
        List<Object> actualData = new ArrayList<>();
        actualData.add(data);
        System.out.println("actualData = " + actualData);
        Assert.assertTrue(expectedDatalarim.containsAll(actualData));
    }

}
