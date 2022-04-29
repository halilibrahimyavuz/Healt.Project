package stepdefinitions.dbStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US16_DB_stepdefinitions
{
    @Given("TY Kullanici Database Ile Baglanti Kurar")
    public void ty_kullanici_database_ıle_baglanti_kurar()
    {
        DBUtils.createConnection();
    }
    @Then("TY Kullanici {string} Tablosundan {string} Satirlarini Getirir")
    public void ty_kullanici_tablosundan_satirlarini_getirir(String table, String selectRow)
    {
        String myDynamicQuery = "Select " + selectRow + " from " + table;
        DBUtils.executeQuery(myDynamicQuery);

    }
    @Then("TY Kullanici {string} Tablosunun {string} Sutununun {string} Icerdigini Dogrular")
    public void ty_kullanici_tablosunun_sutununun_ıcerdigini_dogrular(String room, String column, String columnData)
    {
        List<Object> allColumnData = DBUtils.getColumnData("Select * from "+room, column);
        //System.out.println(allColumnData);

        List<Object> expectedData = new ArrayList<>();
        expectedData.add(columnData);

        Assert.assertTrue(allColumnData.containsAll(expectedData));
    }

    @Then("TY Kullanici {string} ye Sahip Datanin {string} Tablosundaki Bilgilerini Kaydeder Ve Dogrular")
    public void tyKullaniciYeSahipDataninTablosundakiBilgileriniKaydederVeDogrular(String id, String room)
    {
        String myDynamicQuery = "Select * from room Where id = " + id;
        String query = "Select * from room Where id = " +  "\'"+ id +"\'";

        DBUtils.executeQuery(myDynamicQuery);

        //List<Object> actualVeri=DBUtils.getRowList("Select * from room where id='1451'");
        List<Object> actualData=DBUtils.getRowList(query);
        actualData.stream().forEach(System.out::println);


        List<Object> expectedData = new ArrayList<>();

        expectedData.add(0,"89576");
        expectedData.add(1,"3000152");
        expectedData.add(2,"PREMIUM_DELUXE");
        expectedData.add(3,"true");
        expectedData.add(4,"175.00");
        expectedData.add(5,"Cardiology");
        expectedData.add(6,"2022-04-26 14:18:36.37262");
        expectedData.add(7,"admindiana");
        expectedData.add(8,"admindiana");
        expectedData.add(9,"2022-04-26 14:18:54.657084");

        System.out.println(actualData);
        System.out.println(expectedData);

        //Assert.assertEquals(expectedData,actualData);

        for (int i=0; i <expectedData.size() ; i++)
        {
            System.out.println("i = " + i);
            Assert.assertEquals(expectedData.get(i),actualData.get(i).toString());
            // data type uyusmazligindan dolayi assertion fail olmasin diye toString kullaniyoruz
        }

    }

    @Then("TY Kullanici {string} ye Sahip Datanin {string} Tablosundaki {string} Sutunundaki Bilgilerini Kaydeder Ve Dogrular")
    public void tyKullaniciYeSahipDataninTablosundakiSutunundakiBilgileriniKaydederVeDogrular(String id, String table, String column)
    {
        String myDynamicQuery = "Select " + column + " from " + table + "Where id = " + id; // example tale'da " varsa
        String query = "Select " + column + " from " + table + "Where id = " + "\""+ id +"\""; // example tale'da " yoksa
        DBUtils.executeQuery(myDynamicQuery);

        //List<Object> actualVeri=DBUtils.getRowList("Select * from room where id='1451'");
        List<Object> actualData=DBUtils.getRowList(query);
        actualData.stream().forEach(System.out::println);


        List<Object> expectedData = new ArrayList<>();

       expectedData.add(1,id);
       expectedData.add(2,"3000152");
       expectedData.add(3,"PREMIUM_DELUXE");
       expectedData.add(4,true);
       expectedData.add(5,"175.00");
       expectedData.add(6,"Cardiology");
       expectedData.add(7,"2022-04-26 14:18:36.37262");
       expectedData.add(8,"admindiana");
       expectedData.add(9,"admindiana");
       expectedData.add(10,"2022-04-26 14:18:54.657084");

        System.out.println(actualData);
        System.out.println(expectedData);

        Assert.assertEquals(expectedData,actualData);



    }


    //------------------------------------------------------
    // int olan
    @Then("TY Kullanici \"\"{int}\"\" ye Sahip Datanin {string} Tablosundaki Bilgilerini Kaydeder Ve Dogrular")
    public void ty_kullanici_ye_sahip_datanin_tablosundaki_bilgilerini_kaydeder_ve_dogrular(Integer id, String table) {
        System.out.println("int parametreli method calisti");
    }
    // int olan
    @Then("TY Kullanici \"\"{int}\"\" ye Sahip Datanin {string} Tablosundaki {string} Sutunundaki Bilgilerini Kaydeder Ve Dogrular")
    public void ty_kullanici_ye_sahip_datanin_tablosundaki_sutunundaki_bilgilerini_kaydeder_ve_dogrular(Integer id, String table, String column) {
        System.out.println("int parametreli method calisti");
    }
    //------------------------------------------------------

    @Then("TY Kullanici Database Baglantisini Kapatir")
    public void ty_kullanici_database_baglantisini_kapatir()
    {
        DBUtils.closeConnection();
    }



}

