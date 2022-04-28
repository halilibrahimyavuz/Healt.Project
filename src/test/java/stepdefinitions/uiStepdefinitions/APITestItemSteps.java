package stepdefinitions.uiStepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import pojos.TestItem;
import utilities.Authentication;
import utilities.ConfigReader;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class APITestItemSteps {

    TestItem testItem =new TestItem();
    Response response;
    public static RequestSpecification spec;

    @Given("user gerekli path parametreleri ayarlar")
    public void user_gerekli_path_parametreleri_ayarlar() {
        spec =new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
        spec.pathParams("first","api","second","c-test-items");



    }
    @Given("user expected datalari ayarlar {string}, {string}, {string}, {string}, {string}")
    public void user_expected_datalari_ayarlar(String name, String description, String price, String defMaxVal, String defMinVal) {


        testItem.setName(name);
        testItem.setDescription(description);
        testItem.setPrice(Integer.parseInt(price));
        testItem.setDefaultValMax(defMaxVal);
        testItem.setDefaultValMin(defMinVal);


    }
    @Given("user the post request and gets the response gonderir")
    public void user_the_post_request_and_gets_the_response_gonderir() {

        response = given().headers(
                        "Authorization",
                        "Bearer " + Authentication.generateToken())
                .given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(testItem).when()
                .post("/{first}/{second}");
        response.prettyPrint();
    }

    @Given("user all api records dogrular")
    public void user_all_api_records_dogrular()  throws IOException  {
        ObjectMapper obj = new ObjectMapper();

        TestItem actualTestItem = obj.readValue(response.asString(), TestItem.class);

        System.out.println(actualTestItem);
        //TestItem{name='H1bAc2', description='3 AYLIK SEKER', price=599, defaultValMin='1', defaultValMax='15'}

        assertEquals(testItem.getName(), actualTestItem.getName());
        assertEquals(testItem.getDescription(), actualTestItem.getDescription());
        assertEquals(testItem.getPrice(), actualTestItem.getPrice());
        assertEquals(testItem.getDefaultValMin(), actualTestItem.getDefaultValMin());
        assertEquals(testItem.getDefaultValMax(), actualTestItem.getDefaultValMax());


    }


}
