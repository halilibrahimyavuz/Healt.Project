package stepdefinitions.apiStepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US27_Pojos.MessagesPojo;
import utilities.Authentication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US27_API_stepdefinitions
{
    Response response;


    @Given("TY Kullanici {string} Medunna Api Endpointine, {string}, {string}, {string}, {string} Datalarini Kullanarak Yeni Mesaj Olusturur")
    public void tyKullaniciMedunnaApiEndpointineDatalariniKullanarakYeniMesajOlusturur(String endpoint, String name, String email, String subject, String message)
    {
        MessagesPojo messageBody = new MessagesPojo(name,email,subject,message);
        //System.out.println("body.toString() = " + body.toString());

        response = given().
                        headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                    when().
                        body(messageBody).
                        post(endpoint).
                    then().
                        contentType(ContentType.JSON).
                        extract().
                        response();

        response.prettyPrint();

    }


    @Then("TY Kullanici {string} Medunna Api Endpointine, {string}, {string}, {string}, {string} Datalarini Kullanarak Olusturdugu Mesajin Status Codeunun {int} Oldugunu Dogrular")
    public void tyKullaniciMedunnaApiEndpointineDatalariniKullanarakOlusturduguMesajinStatusCodeununOldugunuDogrular(String endpoint, String name, String email, String subject, String message, int statusCode)
    {
        response.then().statusCode(statusCode);
    }

    @Then("TY Kullanici {string} Medunna Api Endpointine, {string}, {string}, {string}, {string} Datalarini Kullanarak Olusturdugu Mesajin Olustugunu Dogrular")
    public void tyKullaniciMedunnaApiEndpointineDatalariniKullanarakOlusturduguMesajinOlustugunuDogrular(String endpoint, String name, String email, String subject, String message)
    {
        MessagesPojo expectedData = new MessagesPojo(name,email,subject,message);
        MessagesPojo actualData = response.as(MessagesPojo.class);
        String ID = actualData.getId();
        //System.out.println("ID = " + ID);

        response = given().
                headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                get(endpoint +"/"+ ID).
                then().
                extract().
                response();

        Assert.assertEquals(expectedData.getName(),actualData.getName());
        Assert.assertEquals(expectedData.getEmail(),actualData.getEmail());
        Assert.assertEquals(expectedData.getSubject(),actualData.getSubject());
        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());
    }

    @Given("TY Kullanici {string} Medunna Api Endpointinden Mesajlari Okur")
    public void tyKullaniciMedunnaApiEndpointindenMesajlariOkur(String endpoint)
    {
        response = given().
                        headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                   when().
                        get(endpoint).
                   then().
                        extract().
                        response();


        //response.prettyPrint();
    }

    @Then("TY Kullanici {string} Medunna Api Endpointinden Mesajlari Okuma Isleminin Status Codeunun {int} Oldugunu Dogrular")
    public void tyKullaniciMedunnaApiEndpointindenMesajlariOkumaIslemininStatusCodeununOldugunuDogrular(String endpoint, int statusCode)
    {
        // response.then().statusCode(statusCode);
        Assert.assertEquals(statusCode,response.statusCode());
    }


    @Then("TY Kullanici {string} Medunna Api Endpointinden id Numarali Mesaji Okur Ve Mesajin name, email, subject, message Datalarina Sahip Oldugunu Dogrular")
    public void ty_kullanici_medunna_api_endpointinden_id_numarali_mesaji_okur_ve_mesajin_name_email_subject_message_datalarina_sahip_oldugunu_dogrular(String endpoint, io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String, String>> expectedMapList = dataTable.asMaps(String.class, String.class);

        for(int i=0; i<expectedMapList.size(); i++)
        {
            String ID = expectedMapList.get(i).get("id");
            //System.out.println("ID = " + ID);

            response = given().
                    headers(
                            "Authorization",
                            "Bearer " + Authentication.generateToken(),
                            "Content-Type",
                            ContentType.JSON,
                            "Accept",
                            ContentType.JSON).
                    when().
                    get(endpoint +"/"+ ID).
                    then().
                    extract().
                    response();

            //response.prettyPrint();

            HashMap<String,String > actualMap = response.as(HashMap.class);

                    for(int j=0; j<expectedMapList.get(i).size(); j++)
                    {
                        Assert.assertEquals(expectedMapList.get(i).get(j),actualMap.get(j));
                    }
                    break;


        }

    }


/*
    // deneme
    @Given("TY Kullanici {string} Medunna Api Endpointinden {string} Numarali Mesaji Okur Ve Mesajin {string}, {string}, {string}, {string} Datalarina Sahip Oldugunu Dogrular.")
    public void ty_kullanici_medunna_api_endpointinden_numarali_mesaji_okur_ve_mesajin_datalarina_sahip_oldugunu_dogrular(String endpoint, String id, String name, String email, String subject, String message)
    {
        response = given().
                headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                get(endpoint +"/"+ id).
                then().
                extract().
                response();

        response.prettyPrint();

        MessagesPojo expectedData = new MessagesPojo(id,name,email,subject,message);
        MessagesPojo actualData = response.as(MessagesPojo.class);

        Assert.assertEquals(expectedData.getId(),actualData.getId());
        Assert.assertEquals(expectedData.getName(),actualData.getName());
        Assert.assertEquals(expectedData.getEmail(),actualData.getEmail());
        Assert.assertEquals(expectedData.getSubject(),actualData.getSubject());
        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());


    }

 */
}
