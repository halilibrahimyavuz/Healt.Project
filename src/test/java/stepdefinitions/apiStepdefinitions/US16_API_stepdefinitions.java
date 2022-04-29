
package stepdefinitions.apiStepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pojos.US16_Pojos.RoomsPojo;
import pojos.US27_Pojos.MessagesPojo;
import utilities.Authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class US16_API_stepdefinitions
{
    Response response;
    String ID;

    @Given("TY Kullanici {string} Medunna Api Endpointinden Roomlari Goruntuler")
    public void tyKullaniciMedunnaApiEndpointindenRoomlariGoruntuler(String endpoint)
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


        response.prettyPrint();
    }

    @Then("TY Kullanici {string} Medunna Api Endpointinden Roomlari Goruntuleme Isleminin Status Codeunun {int} Oldugunu Dogrular")
    public void tyKullaniciMedunnaApiEndpointindenRoomlariGoruntulemeIslemininStatusCodeununOldugunuDogrular(String endpoint, int statusCode)
    {
        // response.then().statusCode(statusCode);
        Assert.assertEquals(statusCode,response.statusCode());
    }

    @And("TY Kullanici {string} Medunna Api Endpointinden id Numarali Mesaji Okur Ve Mesajin roomNumber, roomType, status, price, description Datalarina Sahip Oldugunu Dogrular")
    public void tyKullaniciMedunnaApiEndpointindenIdNumaraliMesajiOkurVeMesajinRoomNumberRoomTypeStatusPriceDescriptionDatalarinaSahipOldugunuDogrular(String endpoint,io.cucumber.datatable.DataTable dataTable)
    {
        List<Map<String, String>> expectedMapList = dataTable.asMaps(String.class, String.class);
       // expectedMapList.stream().forEach(System.out::println);
        for(int i=0; i<expectedMapList.size(); i++)
        {
            ID = expectedMapList.get(i).get("id");
            System.out.println("ID = " + ID);

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
                Assert.assertEquals(expectedMapList.get(i).get(j),actualMap.get(j+2));
            }
            break;
        }
    }

    @Given("TY Kullanici {string} Medunna Api Endpointine, {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Yeni Room Olusturur")
    public void ty_kullanici_medunna_api_endpointine_datalarini_kullanarak_yeni_room_olusturur(String endpoint, String roomNumber, String roomType, String status, String price, String description)
    {
        RoomsPojo roomsBody = new RoomsPojo(roomNumber,roomType,status,price,description);
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
                        body(roomsBody).
                        post(endpoint).
                   then().
                        contentType(ContentType.JSON).
                        extract().
                        response();

        response.prettyPrint();
    }
    @Then("TY Kullanici {string} Medunna Api Endpointine, {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Olusturdugu Mesajin Status Codeunun {int} Oldugunu Dogrular")
    public void ty_kullanici_medunna_api_endpointine_datalarini_kullanarak_olusturdugu_mesajin_status_codeunun_oldugunu_dogrular(String endpoint, String roomNumber, String roomType, String status, String price, String description, Integer statusCode)
    {
        response.then().statusCode(statusCode);
    }
    @Then("TY Kullanici {string} Medunna Api Endpointine, {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Roomun Olustugunu Dogrular")
    public void ty_kullanici_medunna_api_endpointine_datalarini_kullanarak_roomun_olustugunu_dogrular(String endpoint, String roomNumber, String roomType, String status, String price, String description)
    {
        RoomsPojo expectedData = new RoomsPojo(roomNumber,roomType,status,price,description);
        RoomsPojo actualData = response.as(RoomsPojo.class);
        ID = actualData.getId();
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

        Assert.assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        Assert.assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
        Assert.assertEquals(expectedData.getPrice(),actualData.getPrice());
        Assert.assertEquals(expectedData.getDescription(),actualData.getDescription());
    }
    @Then("TY Kullanici {string} Medunna Api Endpointine, {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Olusturdugu Roomun ID sini alir Ve Bu IDyi Kullanarak Roomu Siler")
    public void ty_kullanici_medunna_api_endpointine_datalarini_kullanarak_olusturdugu_roomun_ıd_sini_alir_ve_bu_ı_dyi_kullanarak_roomu_siler(String endpoint, String roomNumber, String roomType, String status, String price, String description)
    {
        RoomsPojo actualData = response.as(RoomsPojo.class);
        ID = actualData.getId();

        response = given().
                headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                delete(endpoint +"/"+ ID).
                then().
                extract().
                response();

    }


    @Given("TY Kullanici {string} Medunna Api Endpointindeki {string} Numarali Odayi Goruntuler")
    public void ty_kullanici_medunna_api_endpointindeki_numarali_odayi_goruntuler(String endpoint, String id)
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
                        get(endpoint + "/" + id).
                   then().
                        extract().
                        response();


        response.prettyPrint();
    }
    @Given("TY Kullanici {string} Medunna Api Endpointindeki {string} Numarali Odayi, {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Update Eder")
    public void ty_kullanici_medunna_api_endpointindeki_numarali_odayi_datalarini_kullanarak_update_eder(String endpoint, String id, String roomNumber, String roomType, String status, String price, String description)
    {
        RoomsPojo roomsBody = new RoomsPojo(id,roomNumber,roomType,status,price,description);

        response = given().
                        headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                   when().
                        body(roomsBody).
                        put(endpoint).
                   then().
                        contentType(ContentType.JSON).
                        extract().
                        response();
    }
    @Then("TY Kullanici {string} Medunna Api Endpointindeki {string} Numarali Oda Icin, {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Yaptigi Updatein Status Codeunun {int} Oldugunu Dogrular")
    public void ty_kullanici_medunna_api_endpointindeki_numarali_oda_ıcin_datalarini_kullanarak_yaptigi_updatein_status_codeunun_oldugunu_dogrular(String endpoint, String id, String roomNumber, String roomType, String status, String price, String description, Integer statusCode)
    {
        response.then().statusCode(statusCode);
    }
    @Then("TY Kullanici {string} Medunna Api Endpointindeki {string} Numarali Odayi,  {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Roomun Update Edildigini Dogrular")
    public void ty_kullanici_medunna_api_endpointindeki_numarali_odayi_datalarini_kullanarak_roomun_update_edildigini_dogrular(String endpoint, String id, String roomNumber, String roomType, String status, String price, String description)
    {
        RoomsPojo expectedData = new RoomsPojo(roomNumber,roomType,status,price,description);
        RoomsPojo actualData = response.as(RoomsPojo.class);
        System.out.println("expectedData = " + expectedData);
        System.out.println("actualData = " + actualData);
        ID = actualData.getId();
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

        Assert.assertEquals(expectedData.getRoomNumber(),actualData.getRoomNumber());
        Assert.assertEquals(expectedData.getRoomType(),actualData.getRoomType());
        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
        Assert.assertEquals(expectedData.getPrice(),actualData.getPrice());
        Assert.assertEquals(expectedData.getDescription(),actualData.getDescription());
    }


    @Given("TY Kullanici {string} Medunna Api Endpointindeki  {string}, {string}, {string}, {string}, {string} Datalarini Kullanarak Olusturulan Odanin id Numarasini Alir")
    public void ty_kullanici_medunna_api_endpointindeki_datalarini_kullanarak_olusturulan_odanin_id_numarasini_alir(String endpoint, String roomNumber, String roomType, String status, String price, String description)
    {
        //response.prettyPrint();
        RoomsPojo actualData = response.as(RoomsPojo.class);
        ID = actualData.getId();
        System.out.println("ID = " + ID);
    }
    @Then("TY Kullanici {string} Medunna Api Endpointindeki id Numarasini Aldigi Odayi Siler")
    public void ty_kullanici_medunna_api_endpointindeki_id_numarasini_aldigi_odayi_siler(String endpoint)
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
                        delete(endpoint +"/"+ ID).
                   then().
                        extract().
                        response();

    }
    @Then("TY Kullanici {string} Medunna Api Endpointindeki id Numarasini Aldigi Odayi Silme Islemi Icin Status Codeun {int} Oldugunu Dogrular")
    public void ty_kullanici_medunna_api_endpointindeki_id_numarasini_aldigi_odayi_silme_ıslemi_ıcin_status_codeun_oldugunu_dogrular(String endpoint, Integer statusCode)
    {
        response.then().statusCode(statusCode);
    }
    @Then("TY Kullanici {string} Medunna Api Endpointindeki id Numarasini Aldigi Odayi Yeniden Goruntulemek Istediginde Status Codeun {int} Oldugunu Dogrular")
    public void ty_kullanici_medunna_api_endpointindeki_id_numarasini_aldigi_odayi_yeniden_goruntulemek_ıstediginde_status_codeun_oldugunu_dogrular(String endpoint, Integer statusCode)
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
                get(endpoint + "/" + ID).
                then().
                extract().
                response();


        response.then().statusCode(statusCode);
    }

}


