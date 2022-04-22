package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.US24_Pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US24_Stepdefinitions {

    US24_Pages us24_pages = new US24_Pages();
    Actions actions = new Actions(Driver.getDriver());


    @Given("Patient URL 'e  gider")
    public void patient_url_e_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Given("Ptaient insan ikonuna tiklar")
    public void ptaient_insan_ikonuna_tiklar() {

        us24_pages.insanIkonuElementi.click();


    }
    @Given("Patient sign in sekmesine tiklar")
    public void patient_sign_in_sekmesine_tiklar() throws InterruptedException {

        Thread.sleep(1000);
        us24_pages.signinSekmesiElementi.click();

    }
    @Then("Patient username girer")
    public void patient_username_girer() {
    us24_pages.usernameTextbox.click();
    actions.sendKeys(ConfigReader.getProperty("us24username")).perform();

    }
    @Then("Patient password girer.")
    public void patient_password_girer() {
    us24_pages.passwordTextBox.click();
     actions.sendKeys(ConfigReader.getProperty("us24password")).perform();
    }
    @Then("Patient  sign in butonuna tiklar")
    public void patient_sign_in_butonuna_tiklar() {
    us24_pages.signinBotunuElementi.click();
    }
    @Then("Patient giris yapildigini dogrular")
    public void patient_giris_yapildigini_dogrular() {
    us24_pages.girisYapildi.isDisplayed();

    }
    @Then("Patient my pages'e tiklar")
    public void patient_my_pages_e_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        us24_pages.mypagesSekmesiElementi.click();

    }
    @Then("Patient My Appointments tiklar")
    public void patient_my_appointments_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        us24_pages.myappointmentsElementi.click();
    }
    @Then("Patient randevu listesini gorur")
    public void patient_randevu_listesini_gorur() {

   us24_pages.appointmentsRandevuSayfasi.isDisplayed();

    }
    @Then("Patient from kismina tarih girer")
    public void patient_from_kismina_tarih_girer() throws InterruptedException {
        Thread.sleep(1000);
    us24_pages.fromDateTextBox.click();
    actions.sendKeys("11.04.2022").perform();
        Thread.sleep(3000);

    }
    @Then("Patient to kismina tarih girer")
    public void patient_to_kismina_tarih_girer() {
        us24_pages.toDateTextBox.click();
        actions.sendKeys("25.04.2022").perform();

    }
    @Then("Patient Show Tests 'e tiklar")
    public void patient_show_tests_e_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        us24_pages.showTestSekmesi.click();

    }
    @Then("Patient view  Results'a tiklar")
    public void patient_view_results_a_tiklar() throws InterruptedException {
        Thread.sleep(5000);
        us24_pages.viewResultsElementi.click();

    }
    @Then("Patient Test sonuclarinda id,name,test,default max ve min value,date and description bolumlerini gorur")
    public void patient_test_sonuclarinda_id_name_test_default_max_ve_min_value_date_and_description_bolumlerini_gorur() throws InterruptedException {


        Thread.sleep(5000);
        Assert.assertTrue("75136",us24_pages.idDegeri.isDisplayed());
        Assert.assertTrue("Jc Hettinger",us24_pages.nameDegeri.isDisplayed());
        Assert.assertTrue("40",us24_pages.defaultMinValueDegeri.isDisplayed());
        Assert.assertTrue("57",us24_pages.defaultMaxValueDegeri.isDisplayed());
        Assert.assertTrue("75203",us24_pages.testDegeri.isDisplayed());
        Assert.assertTrue("18/04/22 14:02",us24_pages.dateDegeri.isDisplayed());

        Driver.closeDriver();

    }


    @And("Patient Show  Invoice 'e tiklar")
    public void patientShowInvoiceETiklar() throws InterruptedException {

        Thread.sleep(2000);
        us24_pages.ShowInvoiceSekmesi.click();
    }

    @Then("Patient faturayi gordugunu dogrular")
    public void patientFaturayiGordugunuDogrular() throws InterruptedException, IOException {

        Thread.sleep(6000);


       ReusableMethods.hooverByJS(us24_pages.faturaResmi);
        Thread.sleep(30);
       ReusableMethods.getScreenshot("FATURA CASH MANİ");
       Assert.assertTrue(us24_pages.faturaYazisiElementi.isDisplayed());
    }

    @And("Sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }
}
