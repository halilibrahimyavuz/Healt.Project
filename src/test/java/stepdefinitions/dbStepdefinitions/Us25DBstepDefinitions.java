package stepdefinitions.dbStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class Us25DBstepDefinitions {


    @Given("Kullanici  db ye baglanir")
    public void kullaniciDbYeBaglanir() {

        DBUtils.createConnection();// bu hazır metod
    }

    @Then("Kullanici select {string} from {string} sorgusu yapar")
    public void kullaniciSelectFromSorgusuYapar(String column, String table) {
        String expectedQuery = "Select " + column + " from " + table;
        DBUtils.executeQuery(expectedQuery);

    }
    @And("Kullanici {string} sutunu okur")
    public void kullaniciSutunuOkur(String arg0) {
        //        DBUtils.getResultset().next();
//
//        Object columnData = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData); //anonymoususer tablodaki 1. kullanici
//
//        DBUtils.getResultset().next();
//        Object columnData2 = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData2); //bakalim tablodaki 2. kullanici
//
//        DBUtils.getResultset().next();
//        Object columnData3 = DBUtils.getResultset().getObject(column);
//        System.out.println(columnData3); //systema tablodaki 3. kullanici

//        while (DBUtils.getResultset().next()){
//            Object eachColumnData = DBUtils.getResultset().getObject(column);
//            System.out.println(eachColumnData);
//        }

    }


    @Then("kullanici {string} table {string} sutunundaki {string} dogrular")
    public void kullaniciTableSutunundakiDogrular(String table, String column, String data) {

        List<Object> sutundakiTumDatalar = DBUtils.getColumnData("Select * from appointment", "created_by");
        System.out.println("sutundakiTumDatalar = " + sutundakiTumDatalar);

        List<Object> expectedData = new ArrayList<>();
        expectedData.add(data);
        System.out.println("expectedData = " + expectedData);

        Assert.assertTrue(sutundakiTumDatalar.containsAll(expectedData));


    }

    @Then("sayfayi kapatir")
    public void sayfayiKapatir() {
         DBUtils.closeConnection();
    }



}