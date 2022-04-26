package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.US05_pages;
import utilities.ConfigReader;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.time.LocalDate;

public class US07_stepdefinitions
{
    US05_pages us05_pages = new US05_pages();
    public static Faker faker = new Faker();

    @Then("TY kullanici phone textbox'ini valid bir deger ile doldurur")
    public void ty_kullanici_phone_textbox_ini_valid_bir_deger_ile_doldurur()
    {
        us05_pages.loginPagePhoneTextBox.sendKeys(ConfigReader.getProperty("TYValidPhoneNumber"));
    }

    @Then("TY kullanici date textbox'inda yer alan tarihin sistem tarihi ile ayni oldugunu dogrular")
    public void ty_kullanici_date_textbox_inda_yer_alan_tarihin_sistem_tarihi_ile_ayni_oldugunu_dogrular()
    {

        String dateTextboxValue = us05_pages.loginPageDateTextBox.getAttribute("value");
        LocalDate tarih = LocalDate.now();
        String sistemDateValue = "" + tarih ;
        Assert.assertTrue(dateTextboxValue.equals(sistemDateValue));

    }

    @Then("TY kullanici Send an Appointment Request butonunu tiklar")
    public void ty_kullanici_send_an_appointment_request_butonunu_tiklar()
    {
        JSUtils.clickElementByJS(us05_pages.loginPageSendAnAppointmentRequestButton);
    }

    @And("TY kullanici date textbox'ini gecmis bir tarih ile doldurur")
    public void tyKullaniciDateTextboxIniGecmisBirTarihIleDoldurur()
    {

        String date = ReusableMethods.setTheDateByRandom("dd-MM-yyy",1,"past");
        us05_pages.loginPageDateTextBox.clear();
        us05_pages.loginPageDateTextBox.sendKeys(date);
    }

    @And("TY kullanici date textboxinin altinda Appointment date can not be past date! uyarisinin gorundugunu dogrular")
    public void tyKullaniciDateTextboxininAltindaAppointmentDateCanNotBePastDateUyarisininGorundugunuDogrular()
    {
        String expectedErrorText = ConfigReader.getProperty("TYDateExpectedError");
        Assert.assertEquals(expectedErrorText,us05_pages.loginPageDateErrorLine.getText());
    }


    @Then("TY kullanici randevunun basarili bir sekilde kaydedilemedigini cikan popup ile dogrular")
    public void ty_kullanici_randevunun_basarili_bir_sekilde_kaydedilemedigini_cikan_popup_ile_dogrular()
    {
        String expectedAlertYazısı = ConfigReader.getProperty("TYBasariliAlertYazisi");
        String kayitMesaji = us05_pages.alertText.getAttribute("innerText");
        Assert.assertFalse(kayitMesaji.contains(expectedAlertYazısı));
    }


    @Then("TY kullanici date textbox'ini valid bir deger ile doldurur ve Send An Appointment butonuna basar")
    public void tyKullaniciDateTextboxIniValidBirDegerIleDoldururVeSendAnAppointmentButonunaBasar()
    {
        String date = ReusableMethods.setTheDateByRandom("dd-MM-yyy",1,"feature");
        us05_pages.loginPageDateTextBox.clear();
        us05_pages.loginPageDateTextBox.sendKeys(date);
        JSUtils.clickElementByJS(us05_pages.loginPageSendAnAppointmentRequestButton);
    }



    @Then("TY kullanici date textbox'ini {string} ile doldurur ve date alaninda yazan tarihin ayni oldugunu dogrular")
    public void tyKullaniciDateTextboxIniIleDoldururVeDateAlanindaYazanTarihinAyniOldugunuDogrular(String date)
    {
        us05_pages.loginPageDateTextBox.sendKeys(date); // 01.01.2030
        date = ReusableMethods.stringDateFormat(date); // 2030-01-01  yıl ay gun
        System.out.println("date = " + date);
        System.out.println("us05_pages.loginPageDateTextBox.getAttribute(\"value\") = " + us05_pages.loginPageDateTextBox.getAttribute("value"));
        Assert.assertEquals(date,us05_pages.loginPageDateTextBox.getAttribute("value"));

    }


    @Then("TY kullanici date textbox'ini {string} ile doldurur ve date alaninda yazan tarihin ayni olmadigini dogrular")
    public void tyKullaniciDateTextboxIniIleDoldururVeDateAlanindaYazanTarihinAyniOlmadiginiDogrular(String date)
    {
        us05_pages.loginPageDateTextBox.sendKeys(date);
        date = ReusableMethods.stringDateFormat(date);
        Assert.assertFalse(date.contains(us05_pages.loginPageDateTextBox.getAttribute("value")));
    }

}
