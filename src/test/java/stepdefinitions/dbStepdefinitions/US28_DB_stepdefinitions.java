package stepdefinitions.dbStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US28_DB_stepdefinitions {

    @Given("TG Kullanici Medunna Database e baglanir")
    public void tgKullaniciMedunnaDatabaseEBaglanir() {
        DBUtils.createConnection();
    }


    @And("TG Kullanici {string} tablosundan {string} idli Countryi sorgular ve olustugunu dogrular")
    public void tgKullaniciTablosundanLiCountryiSorgular(String tabloAdi, String countryId) {
        String countryQuery = "Select * from " + tabloAdi + " where id =" + countryId;
        DBUtils.executeQuery(countryQuery);

        List<Object> actualData=DBUtils.getRowList(countryQuery);
        actualData.stream().forEach(System.out::println);

        List<Object> expectedData = new ArrayList<>();

        expectedData.add(0,"80075");
        expectedData.add(1,"kambocya1");

        System.out.println(actualData);
        System.out.println(expectedData);

        for (int i=0; i <expectedData.size() ; i++)
        {
            System.out.println("i = " + i);
            Assert.assertEquals(expectedData.get(i),actualData.get(i).toString());
        }
    }

    @And("TG Kullanici {string} tablosundan {string} idli State Cityi sorgular ve olustugunu dogrular")
    public void tgKullaniciTablosundanLiStateCityiSorgular(String tabloAdi, String stateId) {
        String stateQuery = "Select * from " + tabloAdi + " where id =" + stateId;
        DBUtils.executeQuery(stateQuery);

        List<Object> actualData=DBUtils.getRowList(stateQuery);
        actualData.stream().forEach(System.out::println);

        List<Object> expectedData = new ArrayList<>();

        expectedData.add(0,"89256");
        expectedData.add(1,"KambocyaState");

        System.out.println(actualData);
        System.out.println(expectedData);


        for (int i=0; i <expectedData.size() ; i++)
        {
            System.out.println("i = " + i);
            Assert.assertEquals(expectedData.get(i),actualData.get(i).toString());
        }
    }
}
