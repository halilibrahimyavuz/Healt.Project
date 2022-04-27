package utilities;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;


import static hooks.Hooks.spec;
import static io.restassured.RestAssured.given;

public class Authentication {
    public static void main(String[] args) {
        System.out.println(generateToken());
    }


    public static String generateToken(){

        //Set the base url
        //api/authenticate
        //spec.pathParams("first", "api", "second", "authenticate");

        //Set the expected data

        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("username", "Team83Admin");
        expectedData.put("password", "Batch44+");
        expectedData.put("rememberMe","true" );
        String endPoint = "https://www.medunna.com/api/authenticate";
        //Send the Post request and get the data
        Response response = given().contentType(ContentType.JSON).
                body(expectedData).when().post(endPoint);

        response.prettyPrint();
        JsonPath json = response.jsonPath();



        return json.getString("id_token");

    }



}