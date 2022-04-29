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

    @Before
    public void setUp(){

    }




    //
    public static RequestSpecification spec;
    public static RequestSpecification spec01;

    @Before
    public void setup()
    {
        spec = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("base_url")).build();
    }


  /*  @Before( order = 2 , value = "@us25api")
    public void setUP(){

        spec01 = new RequestSpecBuilder().setBaseUri(ConfigReader.getProperty("url25")).build();

    }

   */


    @Before(order = 1, value = "@UIRegistration")
    public void navigateToRegistrationPage(){

        Driver.getDriver().get(ConfigReader.getProperty("medunna_registration_url"));

    }

//    @Before( value = "@DBUsers")
//    public void createNewDBConnection(){
//
//        createConnection(ConfigurationReader.getProperty("db_credentials_url"),
//                ConfigurationReader.getProperty("db_username"),
//                ConfigurationReader.getProperty("db_password"));
//
//    }


    @Before(order = 1, value = "@Appointment")
    public void navigateToLandingPage(){

        Driver.getDriver().get(ConfigReader.getProperty("medunna_registration_url"));

    }


    @After
    public void tearDown(Scenario scenario){

        if (scenario.isFailed()) {
            final byte[] screenshot=((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png","screenshots");
        }


        Driver.closeDriver();



    }

}