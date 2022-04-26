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
        DBUtils.createConnection(); // bu hazır metod
    }

    @Then("Kullanici select {string} from {string} sorgusu yapar")
    public void kullaniciSelectFromSorgusuYapar(String sutun, String table) {
    String expectedQuery="Select " + sutun + "from" + table;
    DBUtils.executeQuery(expectedQuery);

    }

    @And("Kullanici {string} sutununu okur")
    public void kullaniciSutununuOkur(String id) {


    }

    @Then("kullanici {string} table {string} sutunundaki {string} dogrular")
    public void kullaniciTableSutunundakiDogrular(String table, String sutun , String id) {
        List<Object> sutundakiTumDatalar=DBUtils.getColumnData("select * from appointment","id");
        System.out.println("sutundakiTumDatalar = " + sutundakiTumDatalar);

        List<Object> expectedData=new ArrayList<>();
        expectedData.add(id);

        Assert.assertTrue(sutundakiTumDatalar.containsAll(expectedData));


    }

    @Then("sayfayi kapatir")
    public void sayfayiKapatir() {
      //  DBUtils.closeConnection();
    }
}
