package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.US23_pages;
import utilities.ConfigReader;
import utilities.Driver;

public class US23_stepdefinitions {
    US23_pages us23_pages =new US23_pages();
    Faker faker = new Faker();


    @Given("FK url e gider")
    public void fkUrlEGider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }




    @When("FK Kullanici First Name textbox'a  gecerli bir firstname girer")
    public void fk_kullanici_first_name_textbox_a_gecerli_bir_firstname_girer() {
    us23_pages.firstnameTextBox.sendKeys(faker.name().firstName()+ Keys.TAB);


    }



    @When("FK Kullanici lastname kismini doldurur")
    public void fk_kullanici_lastname_kismini_doldurur() {
us23_pages.lastnameTextBox.sendKeys(faker.name().lastName()+Keys.TAB);
    }

    @Then("FK Kullanici ssn kismini doldurur")
    public void fk_kullanici_ssn_kismini_doldurur() {
        us23_pages.sSNTextBox.sendKeys("111-14-1474"+Keys.TAB);

    }
    @Then("FK Kullanici email kismina gecerli bir email girer")
    public void fk_kullanici_email_kismina_gecerli_bir_email_girer() {
        us23_pages.emailTextBox.sendKeys(faker.internet().emailAddress()+Keys.TAB);

    }
    @Then("FK Kullanici phone kismini doldurur")
    public void fk_kullanici_phone_kismini_doldurur() {
        us23_pages.phoneTextBox.sendKeys("111-111-4545"+Keys.TAB);

    }
    @Then("FK Kullanici Send an appoitment Request kismina tiklar")
    public void fk_kullanici_send_an_appoitment_request_kismina_tiklar() throws InterruptedException {
Thread.sleep(1000);
        Driver.waitAndClick(us23_pages.sendAnAppointmentRequestButton);
Thread.sleep(2000);
    }

    @Given("FK kullanici admin olarak {string} ve {string} ile giris yapar")
    public void fk_kullanici_admin_olarak_staffayse_ve_ile_giris_yapar(String username,String pasword) throws InterruptedException {
        Thread.sleep(2000);
us23_pages.usernameTextbox.sendKeys(username+Keys.TAB);
Thread.sleep(1000);
us23_pages.passwordTextbox.sendKeys(pasword+Keys.TAB);
    }
    @Given("FK SigninEnterTusu butonuna tiklar")
    public void fk_signin_enter_tusu_butonuna_tiklar() {
        us23_pages.signInButtonu.click();

    }
    @Then("FK Kullanici My Pages menu butonuna tiklar")
    public void fk_kullanici_my_pages_menu_butonuna_tiklar() {
        Driver.waitAndClick(us23_pages.myPagesButtonu,2);

    }
    @Then("FK Kullanici Search Patient butonuna tiklar")
    public void fk_kullanici_search_patient_butonuna_tiklar() {
       Driver.waitAndClick(us23_pages.searchPatientButton);

    }
    @Then("FK Kullanici patient ssn kutusuna gecerli bir {string} numara girer")
    public void fk_kullanici_patient_ssn_kutusuna_gecerli_bir_numara_girer(String SSN) {
        us23_pages.sSNTextBox.sendKeys(SSN+Keys.ENTER);

    }
    @Then("FK ShowAppointmentsButton a tiklar")
    public void fk_show_appointments_button_a_tiklar() {
        Driver.waitAndClick(us23_pages.showAppointmentButton);

    }
    @Then("FK Kullanici Edit butonuna tiklar")
    public void fk_kullanici_edit_butonuna_tiklar() {
        us23_pages.editButton.click();

    }
    @Then("FK Kullanici Status dropdown elementini PENDING, COMPLETED veya CANCELLED seklinde secer")
    public void fk_kullanici_status_dropdown_elementini_pending_completed_veya_cancelled_seklinde_secer() {
        Select select =new Select(us23_pages.statusDropDownButton);
        Driver.waitAndClick(us23_pages.statusDropDownButton);
        select.selectByVisibleText("PENDING");
        us23_pages.statusDropDownButton.click();
    }
    @Then("FK Kullanici Physician bolumunden dr atamasi yapar")
    public void fk_kullanici_physician_bolumunden_dr_atamasi_yapar() throws InterruptedException {

    Select select=new Select(us23_pages.physicianDropDown);
    Driver.waitAndClick(us23_pages.physicianDropDown);
    select.selectByVisibleText("78724:zurkan karataşlıoğlu:SURGERY");
        Driver.waitAndClick(us23_pages.physicianDropDown);
    Thread.sleep(5000);
    }
    @Then("FK Kullanici save butonuna ile tiklar")
    public void fk_kullanici_save_butonuna_ile_tiklar() {
        Driver.waitAndClick(us23_pages.saveButton);

    }

    @Then("FK Kullanici paymantinvoiceproces tiklar")
    public void fk_kullanici_paymantinvoiceproces_tiklar() {
        us23_pages.paymentInvoiceProcessButton.click();

    }
    @Then("FK Kullanici ShowInvoiceButton tiklar")
    public void fk_kullanici_show_invoice_button_tiklar() {
        Driver.waitAndClick(us23_pages.showInvoiceButton);

    }

    @Then("FK Kullanici menuden My Appointment secenegini secer")
    public void fk_kullanici_menuden_my_appointment_secenegini_secer() {
us23_pages.loginPageMyAppointmentsButtonu.click();
    }
    @Then("FK Kullanici Edite butonuna tiklar")
    public void fkKullaniciEditeButonunaTiklar() {
        Driver.waitAndClick(us23_pages.editeButonu);
    }
    @Then("FK Kullanici Request a test butonuna tiklar")
    public void fk_kullanici_request_a_test_butonuna_tiklar() throws InterruptedException {
Thread.sleep(4000);
        Driver.waitAndClick(us23_pages.requestAtestButton);

    }
    @Then("FK Kullanici urea,sodium ve glucose butonlarina tiklar")
    public void fk_kullanici_urea_sodium_ve_glucose_butonlarina_tiklar() {
        Driver.waitAndClick(us23_pages.ureRadioButton);
        Driver.waitAndClick(us23_pages.sodiumRadioButton);
        Driver.waitAndClick(us23_pages.glucoseRadioButton);

    }

    @Then("FK Kullanici  Anamnesis textbox a tiklar")
    public void fk_kullanici_anamnesis_textbox_a_tiklar() {
        Driver.waitAndClick(us23_pages.anamnesisTextBox);

    }
    @Then("FK Kullanici  Anamnesis  textbox a bilgi girer")
    public void fk_kullanici_anamnesis_textbox_a_bilgi_girer() {
        us23_pages.anamnesisTextBox.clear();
        us23_pages.anamnesisTextBox.sendKeys("2 kez kalp krizi geçirmiş"+Keys.TAB);

    }
    @Then("FK Kullanici  Treatment   textbox a tiklar")
    public void fk_kullanici_treatment_textbox_a_tiklar() {
        us23_pages.treatmentTextBox.click();

    }
    @Then("FK Kullanici  Treatment  textbox a bilgi girer")
    public void fk_kullanici_treatment_textbox_a_bilgi_girer() {
        us23_pages.treatmentTextBox.clear();
        us23_pages.treatmentTextBox.sendKeys("Tedavi yatmadan ayakta devam eder");

    }
    @Then("FK Kullanici  Diagnosis  textbox a tiklar")
    public void fk_kullanici_diagnosis_textbox_a_tiklar() {
       Driver.waitAndClick(us23_pages.diagnosisTextBox,2);

    }
    @Then("FK Kullanici  Diagnosis  textbox a bilgi girer")
    public void fk_kullanici_diagnosis_textbox_a_bilgi_girer() {
        us23_pages.diagnosisTextBox.clear();
        us23_pages.diagnosisTextBox.sendKeys("vertigo");

    }


    @Then("FK Kullanici sayfayi kapatir")
    public void fkKullaniciSayfayiKapatir() {

        Driver.closeDriver();
    }

    @And("FK Kullanici logine tiklar")
    public void fkKullaniciLogineTiklar() {
        Driver.waitAndClick(us23_pages.loginIkon);
    }

    @And("FK Kullanici SignIn olur")
    public void fkKullaniciSignInOlur() {
        Driver.waitAndClick(us23_pages.signInElementi);
    }


    @Then("FK Kullanici signOut olur")
    public void fkKullaniciSignOutOlur() throws InterruptedException {
Thread.sleep(1000);
        Driver.waitAndClick(us23_pages.loginIkon);
        Thread.sleep(2000);
        Driver.waitAndClick(us23_pages.signOutButton);

    }

    @And("ucsaniye bekle")
    public void ucsaniyeBekle() throws InterruptedException {
        Thread.sleep(3000);
    }
}
