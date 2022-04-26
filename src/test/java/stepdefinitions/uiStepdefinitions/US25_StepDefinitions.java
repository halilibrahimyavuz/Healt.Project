package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US25_Pages;

import pojos.US25_appointment;
import utilities.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class US25_StepDefinitions {

    US25_Pages us25_pages=new US25_Pages();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
  US25_appointment us25Appointment=new US25_appointment();

    LocalDate localDate;
    String guncelTarih;

    @Given("Patient URL sayfasina gider")
    public void patient_url_sayfasina_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Given("Patient insan ikonuna tiklar")
    public void patient_insan_ikonuna_tiklar() {

        us25_pages.insanIkonuElementi.click();

    }
    @Given("Patient   sign in sekmesine tiklar")
    public void patient_sign_in_sekmesine_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        us25_pages.signinSekmesiElementi.click();

    }
    @Then("Patient Username girer")
    public void patient_username_girer() {


        us25_pages.UsernameTextbox.click();
        actions.sendKeys(ConfigReader.getProperty("us24username")).perform();


    }
    @Then("Patient Password girer.")
    public void patient_password_girer() throws InterruptedException {
        Thread.sleep(1000);

        us25_pages.PasswordTextBox.click();
        actions.sendKeys(ConfigReader.getProperty("us24password")).perform();

    }
    @Then("Patient  signin butonuna tiklar")
    public void patient_signin_butonuna_tiklar() {
        us25_pages.signinBotunuElementi.click();

    }
    @Then("Patient giris yapilabiligini dogrular")
    public void patient_giris_yapilabiligini_dogrular() throws InterruptedException {

       Thread.sleep(100);
        Assert.assertTrue(us25_pages.girisYapilabildiYazisi.isDisplayed());

    }
    @Then("Patient My pages'e tiklar")
    public void patient_my_pages_e_tiklar() throws InterruptedException {
        Thread.sleep(1000);

        us25_pages.MypagesSekmesiElementi.click();

    }
    @And("Patient Make an Appointment tiklar")
    public void patientMakeAnAppointmentTiklar() throws InterruptedException {
        Thread.sleep(1000);

      us25_pages.makeanAppointmentElementi.click();
    }
    @Then("Patient acilan sayfada bilgileri doldurur")
    public void patient_acilan_sayfada_bilgileri_doldurur() throws InterruptedException {


        Thread.sleep(1000);
        us25_pages.firstnameTextbox.click();
        us25_pages.firstnameTextbox.clear();
        us25_pages.firstnameTextbox.click();
        actions.sendKeys(faker.name().firstName()+ Keys.TAB)
                .sendKeys(faker.internet().password()+Keys.TAB)
                .sendKeys(faker.idNumber().ssnValid()+Keys.TAB)
                .sendKeys(faker.internet().emailAddress()+Keys.TAB)
                .sendKeys("455-455-4555"+Keys.TAB)
                .sendKeys("27.04.2022"+Keys.TAB).perform();
         Thread.sleep(1000);    }
    @Then("Patient  Send an Appointment Request tiklar")
    public void patient_send_an_appointment_request_tiklar() {
      //  WriteToTxt.saveAppointmentDatalar(us25Appointment);
        us25_pages.SendanAppointmentRequestElementi.click();

    }
    @Then("Patient randevu aldigini dogrular")
    public void patient_randevu_aldigini_dogrular() throws InterruptedException, IOException {
        Thread.sleep(1000);
        ReusableMethods.getScreenshot("randevuAlindiYazisi");
        us25_pages.randevualindiYazisi.isDisplayed();

    }

    @Given("Patient acilan sayfada Make an Appointment tiklar")
    public void patient_acilan_sayfada_make_an_appointment_tiklar() {

        us25_pages.makeanappointmentElementi.click();

    }
              //TC02 İCİN

    @Then("Patient  firstname girer {string}")
    public void patientFirstnameGirer(String firstname) throws InterruptedException {
     //  firstname=faker.name().firstName();
       us25Appointment.setFirstname(firstname);
        Thread.sleep(1000);
        us25_pages.firstnameTextbox.click();
        actions.sendKeys(firstname+Keys.TAB).perform();

    }


    @Then("Patient  lastname girer  {string}")
    public void patientLastnameGirer(String lastname) {

       // lastname=faker.name().lastName();
        us25Appointment.setLastname(lastname);

        actions.sendKeys(lastname+Keys.TAB).perform();


    }

    @Then("Patient ssn girer  {string}")
    public void patientSsnGirer(String Ssn) {
     //  Ssn=faker.idNumber().ssnValid();
       us25Appointment.setSsn(Ssn);
       actions.sendKeys(Ssn+Keys.TAB).perform();


    }

    @Then("Patient  email girer  {string}")
    public void patientEmailGirer(String email) {
        email=faker.internet().emailAddress();
        us25Appointment.setEmail(email);
        actions.sendKeys(email+Keys.TAB).perform();


    }

    @Then("Patient phone girer {string}")
    public void patientPhoneGirer(String phone) {
       // phone=faker.phoneNumber().phoneNumber();burda yanlis giriyor
        us25Appointment.setPhone(phone);
        actions.sendKeys(phone+Keys.TAB).perform();

    }

    @Then("Patient Appointment DateTime girer {string}")
    public void patientAppointmentDateTimeGirer(String DateTime) throws InterruptedException {

        us25Appointment.setDateTime(DateTime);
    actions.sendKeys(DateTime+Keys.TAB).perform();




}


    @Then("Patient girilen tarihle sistem tarihi ayni olmali")
    public void patientGirilenTarihleSistemTarihiAyniOlmali() {

        String dateTimeText= us25_pages.DateTimeBox.getAttribute("value");
        localDate = LocalDate.now();
         guncelTarih = "" + localDate ;
      // Assert.assertTrue(dateTimeText.equals(guncelTarih));
 }






    @Then("Patient Tarih sirasi gun.ay.yil \\(ay.gun.yil) seklinde olmalidir")
    public void patientTarihSirasiGunAyYilAyGunYilSeklindeOlmalidir() throws InterruptedException {

     DateTimeFormatter duzenle = DateTimeFormatter.ofPattern("dd.MM.YYYY");
         localDate= LocalDate.now();
        guncelTarih=duzenle.format(localDate);
      //  System.out.println("guncelTarih = " + guncelTarih);
      //  us25Appointment.setDateTime(guncelTarih);

        actions.sendKeys(guncelTarih).perform();


    }

/*
       String actualFormatliTarih=us25_pages.DateTimeBox.getText();

        System.out.println("actualFormatliTarih = " + actualFormatliTarih);

       String expectedFormatliTarih="2022-04-26";

    // Assert.assertEquals(expectedFormatliTarih,actualFormatliTarih);



    */





    @And("Patient  Send an Appointment Request elementine tiklar")
    public void patientSendAnAppointmentRequestElementineTiklar() throws InterruptedException {


        WriteToTxt.saveAppointmentDatalar(us25Appointment);

       Driver.waitAndClick(us25_pages.SendanAppointmentRequestElementi);


    }


    @Then("Patient randevu alabildigini dogrular")
    public void patientRandevuAlabildiginiDogrular() throws InterruptedException, IOException {

      Thread.sleep(1000);
        ReusableMethods.getScreenshot("Kayit Yazisi elementi");
        Assert.assertTrue(us25_pages.kayitYapildiYazisi.isDisplayed());

    }
}
