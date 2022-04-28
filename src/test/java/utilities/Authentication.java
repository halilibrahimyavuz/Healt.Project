package utilities;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.Map;



import static io.restassured.RestAssured.given;

public class Authentication {

    public static void main(String[] args) {
        String guncelToken = generateToken();
        System.out.println(guncelToken);
    }

    public static String generateToken() {

        String username = "Team84Admin";
        String password = "Batch44+";


        Map<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);

        map.put("rememberme", true);

        String endPoint = "https://www.medunna.com/api/authenticate";
        Response response1 = given().contentType(ContentType.JSON).body(map).when().post(endPoint);
        JsonPath token = response1.jsonPath();
        return token.getString("id_token");
    }

    public static RequestSpecification spec;

    public static String generateToken(String username, String password) {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();

        //Set the base url
        //api/authenticate

        spec.pathParams("first", "api", "second", "authenticate");

        //Set the expected data

        Map<String, Object> expectedData = new HashMap<>();
        // expectedData.put("username", "admin79");
        expectedData.put("username", username);
        expectedData.put("password", password);
        //  expectedData.put("password", "admin");
        expectedData.put("rememberMe", "true");

        //Send the Post request and get the data
        Response response = given().spec(spec).contentType(ContentType.JSON).
                body(expectedData).when().post("/{first}/{second}");

        response.prettyPrint();
        JsonPath json = response.jsonPath();


        return json.getString("id_token");

    }


}