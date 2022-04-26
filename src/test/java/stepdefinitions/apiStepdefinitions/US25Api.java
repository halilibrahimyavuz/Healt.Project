package stepdefinitions.apiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojos.US25_appointment;
import utilities.AuthenticationYeni;
import utilities.ConfigReader;


import static io.restassured.RestAssured.given;
import static utilities.WriteToTxt.saveAppointmentApiDatalar;


public class US25Api  {

  US25_appointment us25appointment=new US25_appointment();
  Faker faker=new Faker();
  Response response;
 public static RequestSpecification spec1;

    @Given("kullanici gerekli path params ayarlari yapar")
    public void kullanici_gerekli_path_params_ayarlari_yapar() {
       spec1 = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("url25")).build();
       spec1.pathParams("bir","api","iki","appointments");

       //https://www.medunna.com/api/appointments/
    }

    @Given("kullanici expected datalari girer {string} {string} {string} {string} {string} {string}")
    public void kullanici_expected_datalari_girer(String firstname, String lastname, String Ssn, String email, String phone, String DateTime) {

      firstname=faker.name().firstName();
      lastname=faker.name().lastName();
      Ssn=faker.idNumber().ssnValid();
      email=faker.internet().emailAddress();
     // phone=faker.phoneNumber().phoneNumber();
    //  Datete=


      us25appointment.setFirstname(firstname);
      us25appointment.setLastname(lastname);
      us25appointment.setSsn(Ssn);
      us25appointment.setEmail(email);
      us25appointment.setPhone(phone);
      us25appointment.setDateTime(DateTime);


    }
    @Given("kullanici reguest gonderir ve response alir")
    public void kullanici_reguest_gonderir_ve_response_alir() {

  //.headers("Authorization","Bearer "+ AuthenticationYeni.generateToken())

                response=given().spec(spec1)
                .headers("Authorization","Bearer "+ AuthenticationYeni.generateToken()).given()
                .contentType(ContentType.JSON).body(us25appointment)
                .when().post("/{bir}/{iki}");




    }
    @Given("kullanici Api kayitlarini dosyaya kaydeder")
    public void kullanici_api_kayitlarini_dosyaya_kaydeder() {

      saveAppointmentApiDatalar(us25appointment);

    }
    @Given("kullanici Api kayitlari dogrular")
    public void kullanici_api_kayitlari_dogrular() {

        response.then().statusCode(200);
          response.prettyPrint();

    }


}
