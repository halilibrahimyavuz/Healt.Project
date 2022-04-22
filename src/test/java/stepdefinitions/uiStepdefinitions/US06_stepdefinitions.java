package stepdefinitions.uiStepdefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import utilities.ConfigReader;
import utilities.Driver;
import pages.US06_pages;
import utilities.ReusableMethods;

public class US06_stepdefinitions {
    US06_pages us06_pages = new US06_pages();
    //SoftAssert softAssert=new SoftAssert();

    @Given("FK Kullanıcı ana sayfaya gider")
    public void fk_kullanıcı_ana_sayfaya_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Given("FK Kullanıcı sign in butonuna basar")
    public void fk_kullanıcı_sign_in_butonuna_basar() {

        us06_pages.accountMenu.click();
        us06_pages.loginButonu.click();

    }
    @Given("FK Kullanıcı username kutusuna {string} bilgilerini girer")
    public void fk_kullanıcı_username_kutusuna_bilgilerini_girer(String username) {
        us06_pages.usernameKutusu.sendKeys(username+ Keys.ENTER);
    }
    @Given("FK Kullanıcı password kutusuna {string} bilgilerini girer")
    public void fk_kullanıcı_password_kutusuna_bilgilerini_girer(String password) {
        us06_pages.passwordKutusu.sendKeys(password+ Keys.ENTER);
    }

    @Then("FK01 Kullanıcı signin butonundan settings seçeneğini assert etmeli")
    public void fk01_kullanıcı_signin_butonundan_settings_seçeneğini_assert_etmeli() {
        us06_pages.accountMenu.click();
        Assert.assertTrue("Settings Butonu Bulunamadı",us06_pages.settingsButonu.isDisplayed());
        System.out.println("Settings Butonu vardır.");

    }
    @Then("FK Kullanıcı settings seçeneği varsa tıklamalı")
    public void fk_kullanıcı_settings_seçeneği_varsa_tıklamalı() {
        us06_pages.accountMenu.click();
        us06_pages.settingsButonu.click();
    }
    @Then("FK02 Kullanıcı FirstName kutucuğunu assert etmeli")
    public void fk02_kullanıcı_first_name_kutucuğunu_assert_etmeli() {
        Assert.assertTrue("firstname kutusu bulunamamıştır.",us06_pages.firstnameKutusu.isDisplayed());
        System.out.println("FirstName Kutusu mevcuttur.");
    }
    @Then("FK03 Kullanıcı LastName kutucuğunu assert etmeli")
    public void fk03_kullanıcı_last_name_kutucuğunu_assert_etmeli() {
        Assert.assertTrue("lastname kutusu bulunamamıştır.",us06_pages.lastnameKutusu.isDisplayed());
        System.out.println("LastName Kutusu mevcuttur.");

    }
    @Then("FK04 Kullanıcı Email kutucuğunu assert etmeli")
    public void fk04_kullanıcı_email_kutucuğunu_assert_etmeli() {
        Assert.assertTrue("email kutusu bulunamamıştır.",us06_pages.emailKutusu.isDisplayed());
        System.out.println("Email Kutusu mevcuttur.");

    }
    @Then("FK05 Kullanıcı Email kutusu varsa {string} olmadan güncelleme yapabiliyormu")
    public void fk05_kullanıcı_email_kutusu_varsa_olmadan_güncelleme_yapabiliyormu(String dotcom) {
        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(dotcom);
        Assert.assertTrue("ERROR .com olmadan email yazılıyor",us06_pages.invalisYazisi.isDisplayed());
        System.out.println("PASS .com olmadan email yazmaya izin vermiyor");
        ReusableMethods.waitFor(1);
    }
    @Then("FK06 Kullanıcı Email kutusu varsa {string} şeklinde güncelleme yapabiliyormu")
    public void fk06_kullanıcı_email_kutusu_varsa_şeklinde_güncelleme_yapabiliyormu(String atdotcom) {

        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(atdotcom);
        Assert.assertTrue("ERROR @.com email yazılıyor",us06_pages.invalisYazisi.isDisplayed());
        System.out.println("PASS @.com şeklinde email yazmaya izin vermiyor");
        ReusableMethods.waitFor(1);
    }
    @Then("FK07 Kullanıcı Email kutusu varsa {string} geçerek güncelleme yapabiliyormu")
    public void fk07_kullanıcı_email_kutusu_varsa_geçerek_güncelleme_yapabiliyormu(String bos) {

        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(bos);
        us06_pages.saveButonu.click();
        Assert.assertTrue("ERROR email kısmı boş geçilebiliyor",us06_pages.invalisYazisi.isDisplayed());
        System.out.println("PASS email kısmını boş geçmeye izin vermiyor");
        ReusableMethods.waitFor(1);
    }
    @Then("FK08 Kullanıcı Email kutusu varsa @ işaretinden önce {string} karakterle güncelleme yapabiliyormu")
    public void fk08_kullanıcı_email_kutusu_varsa_işaretinden_önce_karakterle_güncelleme_yapabiliyormu(String attenOnceBos) {

        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(attenOnceBos);
        Assert.assertTrue("ERROR email kısmı boş geçilebiliyor",us06_pages.invalisYazisi.isDisplayed());
        System.out.println("PASS email @ işaretinden önce boşluk olamaz");

    }
    @Then("FK19 Kullanıcı Email kutusu varsa @ işaretinden önce {string} karakterle güncelleme yapabiliyormu")
    public void fk19_kullanıcı_email_kutusu_varsa_işaretinden_önce_karakterle_güncelleme_yapabiliyormu(String attenOnceBir) {
        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(attenOnceBir);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse("FAILED",us06_pages.yesilSaveContainer.isDisplayed());
        //softAssert.assertFalse(us06_pages.yesilSaveContainer.isDisplayed(),"FAILED");
        us06_pages.yesilSaveContainer.click();

        us06_pages.accountMenu.click();
        us06_pages.signOut.click();
        Driver.closeDriver();
        // softAssert.assertAll();

    }
    @Then("FK09 Kullanıcı Email kutusu varsa email yazılırken {string} varsa güncelleme yapabiliyormu")
    public void fk09_kullanıcı_email_kutusu_varsa_email_yazılırken_varsa_güncelleme_yapabiliyormu(String bosluk) {
        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(bosluk);
        Assert.assertTrue("ERROR email kısmı boş geçilebiliyor",us06_pages.invalisYazisi.isDisplayed());

        System.out.println("PASS email arasında boşluk olamaz");
    }
    @Then("FK10 Kullanıcı Email kutusu varsa daha önce {string} yazılabilirmi")
    public void fk10_kullanıcı_email_kutusu_varsa_daha_önce_yazılabilirmi(String kullanilmis_email) {

        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(kullanilmis_email);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue("ERROR email kısmı boş geçilebiliyor",us06_pages.kirmiziSaveContainer.isDisplayed());
        us06_pages.kirmiziSaveContainer.click();
        System.out.println("PASS email arasında boşluk olamaz");
        ReusableMethods.waitFor(5);
    }
    @Then("FK11 Kullanıcı Email kutusu varsa {string} yazılabilirmi")
    public void fk11_kullanıcı_email_kutusu_varsa_yazılabilirmi(String buyuk_harf) {
        us06_pages.emailKutusu.clear();
        us06_pages.emailKutusu.sendKeys(buyuk_harf);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue("email büük harflerden oluşamaz",us06_pages.yesilSaveContainer.isDisplayed());
        us06_pages.yesilSaveContainer.click();
        System.out.println("PASS email büyük harflerden oluşabilir ");
        ReusableMethods.waitFor(5);
    }
    @Then("FK12 Kullanıcı FirstName kutusu varsa {string} geçerek güncelleme yapabiliyormu")
    public void fk12_kullanıcı_first_name_kutusu_varsa_geçerek_güncelleme_yapabiliyormu(String bos) {
        us06_pages.firstnameKutusu.clear();
        us06_pages.firstnameKutusu.sendKeys(bos);
        us06_pages.saveButonu.click();
        Assert.assertTrue("ERROR firstname kısmı boş geçilebiliyor",us06_pages.invalisYazisi.isDisplayed());
        System.out.println("PASS firstname kısmı boş geçilemez");
    }
    @Then("FK13 Kullanıcı FirstName kutusuna {string} yazarak güncelleme yapabiliyormu")
    public void fk13_kullanıcı_first_name_kutusuna_yazarak_güncelleme_yapabiliyormu(String rakam) {
        us06_pages.firstnameKutusu.clear();
        us06_pages.firstnameKutusu.sendKeys(rakam);
        ReusableMethods.waitFor(5);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse("FAILED",us06_pages.yesilSaveContainer.isDisplayed());
        //softAssert.assertFalse(us06_pages.yesilSaveContainer.isDisplayed(),"FAILED");
        us06_pages.yesilSaveContainer.click();
        us06_pages.saveButonu.click();

        us06_pages.accountMenu.click();
        us06_pages.signOut.click();
        Driver.closeDriver();
        //softAssert.assertAll();

    }
    @Then("FK14 Kullanıcı FirstName kutusuna {string} yazarak güncelleme yapabiliyormu")
    public void fk14_kullanıcı_first_name_kutusuna_yazarak_güncelleme_yapabiliyormu(String tek_harf) {
        us06_pages.firstnameKutusu.clear();
        us06_pages.firstnameKutusu.sendKeys(tek_harf);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse("FAILED",us06_pages.yesilSaveContainer.isDisplayed());
        //softAssert.assertFalse(us06_pages.yesilSaveContainer.isDisplayed(),"FAILED");
        us06_pages.yesilSaveContainer.click();
        us06_pages.accountMenu.click();
        us06_pages.signOut.click();
        Driver.closeDriver();
        // softAssert.assertAll();

    }
    @Then("FK15 Kullanıcı LastName kutusu varsa {string} geçerek güncelleme yapabiliyormu")
    public void fk15_kullanıcı_last_name_kutusu_varsa_geçerek_güncelleme_yapabiliyormu(String bos) {
        us06_pages.lastnameKutusu.clear();
        us06_pages.firstnameKutusu.sendKeys(bos);
        us06_pages.saveButonu.click();
        Assert.assertTrue("ERROR lastname kısmı boş geçilebiliyor",us06_pages.invalisYazisi.isDisplayed());
        System.out.println("PASS lastname kısmı boş geçilemez");
    }
    @Then("FK16 Kullanıcı LastName kutusuna {string} yazarak güncelleme yapabiliyormu")
    public void fk16_kullanıcı_last_name_kutusuna_yazarak_güncelleme_yapabiliyormu(String rakam) {
        us06_pages.lastnameKutusu.clear();
        us06_pages.lastnameKutusu.sendKeys(rakam);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse("FAILED",us06_pages.yesilSaveContainer.isDisplayed());
        //softAssert.assertFalse(us06_pages.yesilSaveContainer.isDisplayed(),"FAILED");
        us06_pages.yesilSaveContainer.click();
        us06_pages.accountMenu.click();
        us06_pages.signOut.click();
        Driver.closeDriver();
        //softAssert.assertAll();
    }
    @Then("FK17 Kullanıcı LastName kutusuna {string} yazarak güncelleme yapabiliyormu")
    public void fk17_kullanıcı_last_name_kutusuna_yazarak_güncelleme_yapabiliyormu(String ozel_karakter) {
        us06_pages.lastnameKutusu.clear();
        us06_pages.lastnameKutusu.sendKeys(ozel_karakter);
        ReusableMethods.waitFor(5);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        Assert.assertFalse("FAILED",us06_pages.yesilSaveContainer.isDisplayed());
        //Driver.closeDriver();
        // Assert.assertEquals(invKirmizi,us06_pages.invalidYazisi.getText());
        /*softAssert.assertFalse(us06_pages.yesilSaveContainer.isDisplayed(),"FAILED");
        us06_pages.yesilSaveContainer.click();
        us06_pages.accountMenu.click();
        us06_pages.signOut.click();
        Driver.closeDriver();
        softAssert.assertAll();

         */


    }
    @Then("FK18 Kullanıcı LastName kutusuna {string} yazarak güncelleme yapabiliyormu")
    public void fk18_kullanıcı_last_name_kutusuna_yazarak_güncelleme_yapabiliyormu(String tek_harf) throws Exception
    {

        us06_pages.lastnameKutusu.clear();
        us06_pages.lastnameKutusu.sendKeys(tek_harf);
        us06_pages.saveButonu.click();
        ReusableMethods.waitFor(1);
        /*
        softAssert.assertFalse(us06_pages.yesilSaveContainer.isDisplayed(),"FAILED");

        try {
            Assert.assertFalse("FAILED",us06_pages.yesilSaveContainer.isDisplayed());
        }
        catch (AssertionError e){
            System.out.println(e.getMessage());
        }*/
        Assert.assertFalse("FAILED",us06_pages.yesilSaveContainer.isDisplayed());
        // ReusableMethods.waitFor(5);
//        us06_pages.yesilSaveContainer.click();
        //       us06_pages.accountMenu.click();
        //     us06_pages.signOut.click();
        //   Driver.closeDriver();
        // softAssert.assertAll();
        //git

    }
    @Then("FK Kullanıcı signOut olur")
    public void fk_kullanıcı_sign_out_olur() {

        us06_pages.accountMenu.click();
        us06_pages.signOut.click();

    }

    @Then("Sayfa kapanır")
    public void sayfa_kapanır() {
        Driver.closeDriver();
    }
    @Then("Kullanıcı accountMenu tuşuna basar")
    public void kullanıcı_account_menu_tuşuna_basar() {
        us06_pages.accountMenu.click();
    }

}
