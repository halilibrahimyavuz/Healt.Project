package stepdefinitions.dbStepdefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class US27_DB_stepdefinitions
{
    @Then("TY Kullanici {string} ye Sahip Datanin {string} cmessage Tablosundaki Bilgilerini Kaydeder Ve Dogrular")
    public void ty_kullanici_ye_sahip_datanin_cmessage_tablosundaki_bilgilerini_kaydeder_ve_dogrular(String id, String cmessage)
    {
        String myDynamicQuery = "Select * from cmessage Where id = " + id;
        String query = "Select * from cmessage Where id = " +  "\'"+ id +"\'";
        DBUtils.executeQuery(myDynamicQuery);

        //List<Object> actualVeri=DBUtils.getRowList("Select * from room where id='1451'");
        List<Object> actualData=DBUtils.getRowList(query);
        actualData.stream().forEach(System.out::println);


        List<Object> expectedData = new ArrayList<>();

        expectedData.add(0,"88966");
        expectedData.add(1,"Test Datasi-Name");
        expectedData.add(2,"test@test.com");
        expectedData.add(3,"Test Datasi-Subject");
        expectedData.add(4,"Test Datasi-Message");

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
}
