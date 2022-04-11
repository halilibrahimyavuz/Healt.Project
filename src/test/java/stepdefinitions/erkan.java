package stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class erkan
{
    Actions actions = new Actions(Driver.getDriver());
/*

    @Then("kullanici giris yapar")
    public void kullaniciGirisYapar() throws InterruptedException {
        us07.accountmenu.click();
        us07.Signin.click();
        us07.username.sendKeys("gulcan");
        us07.password.sendKeys("ed145321");
        us07.Submit.click();
        ReusableMethods.waitFor(3);
    }

    @Then("phone linkine gecerli numara girer")
    public void phone_linkine_gecerli_numara_girer() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();

        ReusableMethods.waitFor(3);
        us07.phone.sendKeys("505-444-5555");

    }

    @Then("kullanici guncel tarihi girer")
    public void kullaniciGuncelTarihiGirer() {
        //   String günceltarih = us07.appoDate.getAttribute("value");
        Date date = new Date();

        DateFormat df = new SimpleDateFormat("yyyy");
        DateFormat df2 = new SimpleDateFormat("dd");

        DateFormat df1 = new SimpleDateFormat("MM");
        String gucelTarihYil = df.format(date);
        String gucelTarihAy = df1.format(date);
        String gucelTarihgun = df2.format(date);

        String guncelgun = gucelTarihgun + "-" + gucelTarihAy + "-" + gucelTarihYil;


        ReusableMethods.waitFor(3);
        us07.appoDate.sendKeys(guncelgun);

    }

    @Then("kullanici Send an Appointment Request e kayit linkini tiklar")
    public void kullanici_send_an_appointment_request_e_kayit_linkini_tiklar() {

        JSUtils.scrollIntoVIewJS(us07.SendanAppointmentRequest);
        JSUtils.clickElementByJS(us07.SendanAppointmentRequest);
        //  us07.SendanAppointmentRequest.click();
    }

    @Then("Appointment registration saved! We will call you as soon as possible. yazildigini dogrular")
    public void appointment_registration_saved_we_will_call_you_as_soon_as_possible_yazıldigini_dogrular() {

        ReusableMethods.waitForVisibility(us07.Appointmentregistrationsaved, 3);
        Assert.assertTrue(us07.Appointmentregistrationsaved.isDisplayed());
    }

    @Then("İleri bir tarih girer")
    public void ileriBirTarihGirer() {
        us07.appoDate.clear();
        us07.appoDate.sendKeys("01012022");

    }

    @Then("kullanici \"Send an Appointment Request e kayit linkini tiklar")
    public void kullanıcıSendAnAppointmentRequestEKayıtLinkiniTıklar() {

        //ReusableMethods.scrollToElement(us07.lastName);
        JSUtils.clickElementByJS(us07.Appointmentregistrationsaved);
        us07.Appointmentregistrationsaved.click();
    }

    @Given("Tarih sirasi gun-ay-yil ya da ay-gun-yil seklinde oldugunu dorular")
    public void tarihSirasiGunAyYilYaDaAyGunYilSeklindeOldugunuDorular() {

        us07.appoDate.sendKeys("30052022");
        String tarih = us07.appoDate.getAttribute("value");
        System.out.println("tarih = " + tarih);
        Assert.assertTrue(tarih.contains("2022-05-30"));

    }

 */


}

