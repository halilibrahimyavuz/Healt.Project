package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US01_pages;
import pojos.Registrant;
import utilities.Driver;

public class US_002_StepDef {
    Registrant registrant = new Registrant();
    Faker faker = new Faker();
    US01_pages us01_pages = new US01_pages();
    Actions actions = new Actions(Driver.getDriver());
   // String mail= Faker.instance().internet().emailAddress();



    @And("Firstname uygun sekilde doldurulur {string}")
    public void firstnameUygunSekildeDoldurulur(String firstname) {
        us01_pages.firstNameTextBox.click();
        actions.sendKeys(faker.name().firstName()).perform();
    }

   // @Then("{string} uygun sekilde doldurulur")
    // public void username_uygun_sekilde_doldurulur(String firstname) {
    //   us01_pages.firstnameTextBox.click();
     //  us01_pages.firstNameTextBox.sendKeys(firstname);}


    @Then("Firstname bos birakilamayacagi gorulur")
    public void username_bos_birakilamayacagi_gorulur() {
       Assert.assertTrue(us01_pages.firstnameTextBox.isDisplayed());

    }
    @Then("{string} uygun doldurulur")
    public void lastname_uygun_doldurulur(String lastname) {
       us01_pages.lastNameTextBox.click();
       us01_pages.lastNameTextBox.sendKeys(lastname);

    }
    @Then("Lastname bos birakilamayacagini gorur.")
    public void bos_birakilamayacagini_gorur() {

        Assert.assertTrue(us01_pages.firstnameTextBox.isDisplayed());
    }


}