package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigReader;
import utilities.Driver;

public class Hooks {
<<<<<<< HEAD
   //@Before
   //public void setUp(){


   //}


   ////
   //public static RequestSpecification spec;

   //@Before( value = "@DeleteUser")
   //public void setup(){

   //    spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
=======

    @Before
    public void setUp(){}

    public static RequestSpecification spec;

    @Before
    public void setup()
    {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
    }
>>>>>>> master


   //}


   //@Before(order = 1, value = "@UIRegistration")
   //public void navigateToRegistrationPage(){

   //    Driver.getDriver().get(ConfigReader.getProperty("medunna_registration_url"));

   //}

// //  @Before( value = "@DBUsers")
// //  public void createNewDBConnection(){
//
// //      createConnection(ConfigurationReader.getProperty("db_credentials_url"),
// //              ConfigurationReader.getProperty("db_username"),
// //              ConfigurationReader.getProperty("db_password"));
//
// //  }


   //@Before(order = 1, value = "@Appointment")
   //public void navigateToLandingPage(){

<<<<<<< HEAD
   //   // Driver.getDriver().get(ConfigReader.getProperty("medunna_registration_url"));
=======
        Driver.getDriver().get(ConfigReader.getProperty("medunna_registration_url"));
>>>>>>> master

   //}



   //@After
   //public void tearDown(Scenario scenario){

   //    if (scenario.isFailed()) {
   //        final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

   //        scenario.attach(screenshot, "image/png","screenshots");
   //    }

<<<<<<< HEAD
   //    //
=======
        Driver.closeDriver();

>>>>>>> master

   //}

}