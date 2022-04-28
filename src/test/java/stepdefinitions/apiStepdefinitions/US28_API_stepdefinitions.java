package stepdefinitions.apiStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import pages.US09_pages;
import pojos.US28_Pojos.Country;
import pojos.US28_Pojos.State;
import utilities.Authentication;

import static io.restassured.RestAssured.given;

public class US28_API_stepdefinitions {

    US09_pages us09pages;
    Response response;


    // API


    @Given("TG Kullanici {string} den {string},{string} bilgilerini girdigi ulkenin olusturuldugunu dogrular")
    public void tgKullaniciDenBilgileriniGirdigiUlkeninOlusturuldugunuDogrular(String endpoint, String countryId, String countryName) {
        Country country = new Country(countryId,countryName);

        response = given().
                headers("Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                get(endpoint + countryId).
                then().
                extract().
                response();
        response.prettyPrint();

        Country expectedData = new Country(countryId, countryName);
        Country actualData = response.as(Country.class);
        Assert.assertEquals(expectedData.getName(), actualData.getName());
    }

    @Then("TG Kullanici {string} den {string},{string} ve {string},{string} bilgilerini girdigi State olusturuldugunu dogrular")
    public void tgKullaniciDenVeBilgileriniGirdigiStateOlusturuldugunuDogrular(String endpoint, String countryId, String countryName, String stateId, String stateName) {
        Country country = new Country(countryId,countryName);
        State state = new State(country,stateId,stateName);

        response = given().
                headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                get(endpoint + stateId).
                then().
                extract().
                response();

        State expectedData = new State(country,stateId,stateName);
        State actualData = response.as(State.class);

        Assert.assertEquals(expectedData.getCountry().getName(), actualData.getCountry().getName());


    }

    @Given("TG Kullanici {string} den {string},{string} bilgilerini girdigi ulkenin bilgilerini guncelleyebildigini dogrular")
    public void tgKullaniciDenBilgileriniGirdigiUlkeninBilgileriniGuncelleyebildiginiDogrular(String endpoint, String countryId, String countryName) {
        Country country = new Country(countryId,countryName);
        response = given().
                headers("Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept", ContentType.JSON).
                when().
                body(country).
                put(endpoint).
                then().
                extract().
                response();
        response.prettyPrint();

        Country expectedData = new Country(countryId, countryName);
        Country actualData = response.as(Country.class);
        Assert.assertEquals(expectedData.getName(), actualData.getName());
    }

    @Then("TG Kullanici {string} den {string},{string} ve {string},{string} bilgilerini girdigi State guncelleyebildigini dogrular")
    public void tgKullaniciDenVeBilgileriniGirdigiStateGuncelleyebildiginiDogrular(String endpoint, String countryId, String countryName, String stateId, String stateName) {
        Country country = new Country(countryId,countryName);
        State state = new State(country,stateId,stateName);

        response = given().
                headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken(),
                        "Content-Type",
                        ContentType.JSON,
                        "Accept",
                        ContentType.JSON).
                when().
                //body(country+"{\"id\": "+stateId+",\"name\": \""+stateName+"\"}").
                        body(state).
                put(endpoint).
                then().
                extract().
                response();

        State expectedData = new State(country,stateId,stateName);
        State actualData = response.as(State.class);

        Assert.assertEquals(expectedData.getCountry().getName(), actualData.getCountry().getName());

        Assert.assertEquals(expectedData.getName(), actualData.getName());
    }
}
