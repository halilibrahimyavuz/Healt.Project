package stepdefinitions.uiStepdefinitions;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.CommonWebElements;
import pages.US01_pages;
import pojos.Registrant;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_001_StepDef {


    Registrant registrant = new Registrant();
    Faker faker = new Faker();
    US01_pages us01_pages = new US01_pages();
    Actions actions = new Actions(Driver.getDriver());

    @Given("Giris sayfasina gidilir.")
    public void giris_sayfasina_gidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));

    }
    @Given("Account menu butonu tiklanir.")
    public void account_menu_butonu_tiklanir() {
        us01_pages.accountMenu.click();
    }
    @Given("Register butonuna tiklar.")
    public void register_butonuna_tiklar() {
        us01_pages.register2.click();

    }
    @Given("Registration sayfasi gorulur.")
    public void registration_sayfasi_gorulur() {
        Assert.assertTrue(us01_pages.registrationYaziElementi.isDisplayed());
    }
    @Then("Geceli {string} ssn girilir.")
    public void geceli_ssn_girilir(String ssn) throws InterruptedException {

        us01_pages.ssnTextBox.sendKeys(ssn);
        Thread.sleep(2000);
        Driver.closeDriver();

    }
    //*********************************************
    @Given("Gecesiz {string} girilir.")
    public void gecesiz_girilir(String ssn) {

        us01_pages.ssnTextBox.sendKeys(ssn);


    }
    @Then("Gecersiz ssn mesaji gorulur.")
    public void gecersiz_ssn_mesaji_gorulur() {
        us01_pages.ssnTextBox.click();

        actions.sendKeys(Keys.TAB).perform();
        Assert.assertTrue(us01_pages.ssnGecersizYazisi.isDisplayed());
    }


}