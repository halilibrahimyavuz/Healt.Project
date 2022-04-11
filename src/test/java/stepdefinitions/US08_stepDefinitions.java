package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US08_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import javax.swing.*;


public class US08_stepDefinitions {
    US08_pages us08_pages=new US08_pages();

    @When("URL adresine gidilir.")
    public void url_adresine_gidilir() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Then("{string} olarak giris yapilir.")
    public void olarak_giris_yapilir(String string) {
        us08_pages.kullaniciGirisBolumu.click();
        us08_pages.signinGiris.click();
        us08_pages.username.sendKeys("Team84Admin");
        us08_pages.password.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.signinButton.click();
    }
    @Then("Giris yapilan dropdown icerisinde ki password sekmesine tiklanilir.")
    public void giris_yapilan_dropdown_icerisinde_ki_password_sekmesine_tiklanilir() {
        us08_pages.accountMenu.click();
        us08_pages.passwordButonu.click();


    }
    @Then("New password confirmation onaylanabilmelidir.")
    public void new_password_confirmation_onaylanabilmelidir() throws InterruptedException {
        us08_pages.currentPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.newPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.confirmPassword.sendKeys("1234");
        us08_pages.newPassword.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us08_pages.notConfirmationText.isDisplayed());
        us08_pages.confirmPassword.click();
        us08_pages.confirmPassword.clear();
        us08_pages.confirmPassword.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us08_pages.notConfirmationText.isDisplayed());
    }
    @Then("{string} olarak cikis yapilir")
    public void olarak_cikis_yapilir(String string) {
        us08_pages.accountMenu.click();
        us08_pages.signoutButonu.click();
    }
    @Then("Daha guclu sifre icin en az {int} kucuk harf olmali,toplam  en az {int} karekter olmali ve {string} seviyesinin degistigi gorulebilmelidir.")
    public void daha_guclu_sifre_icin_en_az_kucuk_harf_olmali_toplam_en_az_karekter_olmali_ve_seviyesinin_degistigi_gorulebilmelidir(Integer int1, Integer int2, String string) {
        us08_pages.currentPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.newPassword.sendKeys("a123456");
        Assert.assertTrue(us08_pages.ikinciBar.isDisplayed());


    }
    @Then("Sifre en az {int} buyuk harf icermeli,toplam  en az {int} karekter olmali ve {string} seviyesinin degistigi gorulebilmelidir.")
    public void sifre_en_az_buyuk_harf_icermeli_toplam_en_az_karekter_olmali_ve_seviyesinin_degistigi_gorulebilmelidir(Integer int1, Integer int2, String string) {
        us08_pages.newPassword.clear();
        us08_pages.newPassword.sendKeys("A123456");
        Assert.assertTrue(us08_pages.ikinciBar.isDisplayed());
    }
    @Then("Sifre en az {int} rakam icermeli,toplam  en az {int} karekter olmali ve {string} seviyesinin degistigi gorulebilmelidir.")
    public void sifre_en_az_rakam_icermeli_toplam_en_az_karekter_olmali_ve_seviyesinin_degistigi_gorulebilmelidir(Integer int1, Integer int2, String string) {
        us08_pages.newPassword.clear();
        us08_pages.newPassword.sendKeys("abcdef6");
        Assert.assertTrue(us08_pages.ikinciBar.isDisplayed());
    }
    @Then("Sifre en az {int} ozel karakter icermeli,toplam  en az {int} karekter olmali ve\"Password strength:\" seviyesinin degistigi gorulebilmelidir.")
    public void sifre_en_az_ozel_karakter_icermeli_toplam_en_az_karekter_olmali_ve_password_strength_seviyesinin_degistigi_gorulebilmelidir(Integer int1, Integer int2) {
        us08_pages.newPassword.clear();
        us08_pages.newPassword.sendKeys("abcdef6");
        Assert.assertTrue(us08_pages.ikinciBar.isDisplayed());
    }
    @Then("Guclu bir parola icin sifre en az {int} karakterden olusmalidir.")
    public void guclu_bir_parola_icin_sifre_en_az_karakterden_olusmalidir(Integer int1) {
        us08_pages.newPassword.clear();
        us08_pages.newPassword.sendKeys("abcdE+1");
        Assert.assertTrue(us08_pages.besinciBar.isDisplayed());
        us08_pages.newPassword.clear();
        us08_pages.newPassword.sendKeys("abcD+1");
        Assert.assertTrue(us08_pages.birinciBar.isDisplayed());
    }
    @Then("Eski sifre kullanilmamalidir.")
    public void eski_sifre_kullanilmamalidir() throws InterruptedException {
        us08_pages.currentPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.newPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.confirmPassword.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse(us08_pages.passwordChangedText.isDisplayed());

    }
    @Then("Patient olarak giriş yapılır.")
    public void patient_olarak_giriş_yapılır() {
        us08_pages.kullaniciGirisBolumu.click();
        us08_pages.signinGiris.click();
        us08_pages.username.sendKeys("PatientNafiz");
        us08_pages.password.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.signinButton.click();
    }
    @Then("Doctor olarak giriş yapılır.")
    public void doctor_olarak_giriş_yapılır() {
        us08_pages.kullaniciGirisBolumu.click();
        us08_pages.signinGiris.click();
        us08_pages.username.sendKeys("DoctorNafiz");
        us08_pages.password.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.signinButton.click();

    }

    @Then("Staff olarak giriş yapılır.")
    public void staff_olarak_giriş_yapılır() {
        us08_pages.kullaniciGirisBolumu.click();
        us08_pages.signinGiris.click();
        us08_pages.username.sendKeys("StaffNafiz");
        us08_pages.password.sendKeys(ConfigReader.getProperty("adminPassword"));
        us08_pages.signinButton.click();
    }


}
