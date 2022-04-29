package stepdefinitions;

import Pojos.TestItems;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import utilities.Authentication;

import java.io.IOException;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class US17_APIStep {
    public static RequestSpecification spec;
    Response response;
    TestItems testItem = new TestItems();
    //https://www.medunna.com/api/c-test-items

    @Given("YE gerekli path paramsları oluşturur")
    public void yeGerekliPathParamslarıOluşturur() {

        spec = new RequestSpecBuilder().setBaseUri("https://medunna.com").build();
        spec.pathParams("first", "api", "second", "c-test-items");
    }

    @Then("YE expected {string}, {string}, {int}, {string}, {string} dataları girer")
    public void yeExpectedDatalarıGirer(String name, String description, Integer price, String defaultValMin, String defaultValMax) {

        testItem.setName(name);
        testItem.setDescription(description);
        testItem.setPrice(price);
        testItem.setDefaultValMin(defaultValMin);
        testItem.setDefaultValMax(defaultValMax);
    }

    @Then("YE request gonderir ve respons alir")
    public void yeRequestGonderirVeResponsAlir() {

        response = given().headers("Authorization","Bearer "+ Authentication.generateToken())
                .given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(testItem)
                .when()
                .post("/{first}/{second}");
        response.prettyPrint();

    }


    @And("YE API ile test adimini dogrular")
    public void yeAPIIleTestAdiminiDogrular() throws NullPointerException, JsonProcessingException {

     /* ObjectMapper obj=new ObjectMapper();
      TestItems actTestItem=obj.readValue(response.asString(),TestItems.class);
      System.out.println(actTestItem);*/
        HashMap actualTestData=response.as(HashMap.class);
        System.out.println("actualTestData = " + actualTestData);

        Assert.assertEquals(testItem.getName(),actualTestData.get("name"));
        Assert.assertEquals(testItem.getDescription(),actualTestData.get("description"));
        Assert.assertEquals(testItem.getPrice(),actualTestData.get("price"));
        Assert.assertEquals(testItem.getDefaultValMin(),actualTestData.get("defaultValMin"));
        Assert.assertEquals(testItem.getDefaultValMax(),actualTestData.get("defaultValMax"));


    }


}