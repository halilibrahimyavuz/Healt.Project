package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US13_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US13_stepdefinitions {

    US13_pages us013_page = new US13_pages();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Given("YT Doktor url gider")
    public void yt_doktor_url_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaURL"));

    }


    @Then("YT Sing in tiklar")
    public void yt_sing_in_tiklar() {
        ReusableMethods.waitFor(2);
        us013_page.loginIkon.click();
        ReusableMethods.waitFor(1);
        us013_page.singInButton.click();

    }


    @Then("YT Username ve Password ile giris yapar")
    public void yt_username_ve_password_ile_giris_yapar() {
        us013_page.username.sendKeys(ConfigReader.getProperty("TC_drUsername"));
        us013_page.password.sendKeys(ConfigReader.getProperty("TC_drpassword"));
        ReusableMethods.waitFor(1);
        us013_page.singInEnter.click();

    }


    @Then("YT My Pages Butonunu tiklar")
    public void yt_my_pages_butonunu_tiklar() {
        ReusableMethods.waitFor(2);
        us013_page.myPagesButonu.click();

    }


    @Then("YT My Appointments tiklar")
    public void yt_my_appointments_tiklar() {
        ReusableMethods.waitFor(2);
        us013_page.myAppoinButonu.click();

    }


    @Then("YT Hasta bilgileri icin edit tiklar")
    public void yt_hasta_bilgileri_icin_edit_tiklar() {
        ReusableMethods.waitFor(2);
        us013_page.editButonu.click();

    }

    @Then("YT Guncellenen test sonuc icin Show Test Results tiklar")
    public void yt_guncellenen_test_sonuc_icin_show_test_results_tiklar() {

        ReusableMethods.waitFor(3);
        us013_page.testSonucGoster.click();

    }



    @Then("YT Gelen sonuc icin View Results tiklar")
    public void yt_gelen_sonuc_icin_view_results_tiklar() {
        ReusableMethods.waitFor(3);
        us013_page.viewResults.click();

    }
    @Then("YT ilgili alanlar kontrol edilir")
    public void yt_ilgili_alanlar_kontrol_edilir() {

        ReusableMethods.waitFor(1);
        Assert.assertTrue(us013_page.idBaslik.isEnabled());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us013_page.nameBaslik.isEnabled());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us013_page.defaultMinBaslik.isEnabled());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us013_page.defaultMaxBaslik.isEnabled());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us013_page.testBaslik.isEnabled());
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us013_page.tarihBaslik.isEnabled());
        Driver.closeDriver();

    }

    @Then("YT Yatili hasta icin ilgili alanlar doldurulur")
    public void yt_yatili_hasta_icin_ilgili_alanlar_doldurulur() {
        ReusableMethods.waitFor(3);
        us013_page.anamnesisAlani.clear();
        us013_page.anamnesisAlani.sendKeys(faker.medical().diseaseName());
        ReusableMethods.waitFor(1);
        us013_page.tedaviAlani.clear();
        ReusableMethods.waitFor(1);
        us013_page.tedaviAlani.sendKeys(faker.medical().medicineName());
        us013_page.teshisAlani.clear();
        ReusableMethods.waitFor(1);
        us013_page.teshisAlani.sendKeys(faker.medical().symptoms());
        ReusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        us013_page.receteAlani.clear();
        ReusableMethods.waitFor(1);
        us013_page.receteAlani.sendKeys(faker.food().vegetable());
        us013_page.taniAlani.clear();
        ReusableMethods.waitFor(1);
        us013_page.taniAlani.sendKeys(faker.medical().diseaseName().toUpperCase().toLowerCase());


    }

    @Then("YT Request Impatient tiklar")
    public void yt_request_impatient_tiklar() {

        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        actions.sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(3);
        us013_page.requestImpatientButonu.click();
        ReusableMethods.waitFor(1);
        String text = us013_page.toastify.getText().toString();
        System.out.println("toastify" + text);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us013_page.toastify.isDisplayed());


    }
    @Then("YT Sayfayi kapatir")
    public void yt_sayfayi_kapatir() {
        Driver.closeDriver();
    }


}
