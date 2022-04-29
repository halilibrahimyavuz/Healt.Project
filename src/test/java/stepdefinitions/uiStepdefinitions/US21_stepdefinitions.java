package stepdefinitions.uiStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US21_pages;
import utilities.ConfigReader;
import utilities.Driver;

public class US21_stepdefinitions {
    US21_pages us21_pages=new US21_pages();
    Actions actions=new Actions(Driver.getDriver());
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Given("URL adresine gidilir")
    public void url_adresine_gidilir() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Then("Staff olarak giris yapilir.")
    public void staff_olarak_giris_yapilir() {
        us21_pages.kullaniciGirisBolumu.click();
        us21_pages.signinGiris.click();
        us21_pages.username.sendKeys("StaffNafiz");
        us21_pages.password.sendKeys(ConfigReader.getProperty("adminPassword"));
        us21_pages.signinButton.click();
    }
    @Then("My Pages dropdown'u click yapilir")
    public void my_pages_dropdown_u_click_yapilir() {
        us21_pages.myPages.click();
    }
    @Then("Search Patient click yapilir.")
    public void search_patient_click_yapilir() {
        us21_pages.searchPatient.click();
    }
    @Then("Patient SSN: kismina patient SSN yazilir")
    public void patient_ssn_kismina_patient_ssn_yazilir() throws InterruptedException {
        us21_pages.patientSSN.sendKeys("123-66-1234");
        Thread.sleep(3000);
    }
    @Then("Editclick yapilir")
    public void editclick_yapilir() {
        us21_pages.editButonu.click();
    }
    @Then("Hasta bilgilerinde degisiklik yapilip,SAVE yapilir")
    public void hasta_bilgilerinde_degisiklik_yapilip_save_yapilir() throws InterruptedException {
        us21_pages.lastnameButonu.clear();
        us21_pages.lastnameButonu.sendKeys("abc");
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        us21_pages.saveButonu.click();
        Thread.sleep(5000);


    }
    @Then("Hasta bilgilerinde degisiklik olmadigi gorulur")
    public void hasta_bilgilerinde_degisiklik_olmadigi_gorulur() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        us21_pages.editButonu.click();
        System.out.println(us21_pages.lastnameButonu.getText());

    }
    @Then("Show Appointments click yapilir")
    public void show_appointments_click_yapilir() throws InterruptedException {
        us21_pages.myPages.click();
        us21_pages.searchPatient.click();
        Thread.sleep(3000);
        actions.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
        us21_pages.showAppointments.click();

    }
    @Then("Edit click yapilir")
    public void edit_click_yapilir() {
        us21_pages.editButonuRandevu.click();
    }
    @Then("Randevu bilgilerinde degisiklik yapilip SAVE yapilir")
    public void randevu_bilgilerinde_degisiklik_yapilip_save_yapilir() throws InterruptedException {
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        us21_pages.treatment.click();
        us21_pages.treatment.clear();
        us21_pages.treatment.sendKeys("randevu degistirildi");

    }
    @Then("Randevu bilgilerinde degisikliklerin oldugu gorulur")
    public void randevu_bilgilerinde_degisikliklerin_oldugu_gorulur() throws InterruptedException {

    }
    @Then("Sayfa kapatilir")
    public void sayfa_kapatilir() {
        Driver.closeDriver();
    }

    @Then("Status seceneginin UNAPPROVED oldugu gorulmelidir")
    public void status_seceneginin_unapproved_oldugu_gorulmelidir() {


    }
    @Then("Status seceneginin PENDİNG  secilmelidir ve  doktor ataması yapilip SAVE yapilmalidir.Status seceneginin PENDİNG oldugu gorulmelidir")
    public void status_seceneginin_pending_secilmelidir_ve_doktor_ataması_yapilip_save_yapilmalidir_status_seceneginin_pending_oldugu_gorulmelidir() throws InterruptedException {
        Select select=new Select(us21_pages.statusDropdown);
        select.selectByValue("PENDING");
        Thread.sleep(3000);


    }
    @Then("Status seceneginin COMPLETED  secilmemelidir ve SAVE yapilmalidir. Status seceneginin COMPLETED olmadigi gorulmelidir")
    public void status_seceneginin_completed_secilmemelidir_ve_save_yapilmalidir_status_seceneginin_completed_olmadigi_gorulmelidir() {

    }
    @Then("Status seceneginin CANCELLED  secilmelidir ve SAVE yapilmalidir.Status seceneginin CANCELLED oldugu gorulmelidir")
    public void status_seceneginin_cancelled_secilmelidir_ve_save_yapilmalidir_status_seceneginin_cancelled_oldugu_gorulmelidir() {
        Select select=new Select(us21_pages.statusDropdown);
        select.selectByValue("CANCELLED");
    }

    @Then("Anamnesis,Treatment,Diagnosis kisimlarina bilgi girilip,\"SAVE\"yapilmalidir.")
    public void anamnesis_treatment_diagnosis_kisimlarina_bilgi_girilip_save_yapilmalidir() throws InterruptedException {
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        us21_pages.anamnesis.clear();
        us21_pages.anamnesis.sendKeys("randevu degistirildi");
        us21_pages.treatment.clear();
        us21_pages.treatment.sendKeys("randevu degistirildi");
        us21_pages.diagnosis.clear();
        us21_pages.diagnosis.sendKeys("randevu degistirildi");
        Thread.sleep(2000);
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

    }
    @Then("Anamnesis,Treatment,Diagnosis kisimlarina bilgi girilmedigi gorulmelidir")
    public void anamnesis_treatment_diagnosis_kisimlarina_bilgi_girilmedigi_gorulmelidir() {

    }
    @Then("{string} kismindan doktor secilmelidir ve {string} yapilmalidir")
    public void kismindan_doktor_secilmelidir_ve_yapilmalidir(String string, String string2) throws InterruptedException {
        js.executeScript("arguments[0].scrollIntoView ();",us21_pages.doctorList);
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        Select select=new Select(us21_pages.doctorList);
        select.selectByValue("10520");

    }
    @Then("Randevunun olustugu  gorulmelidir")
    public void randevunun_olustugu_gorulmelidir() {

    }


}
