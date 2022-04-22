package stepdefinitions.uiStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US09_pages;
import utilities.ConfigReader;
import utilities.Driver;

public class US09_stepdefinitions {
    US09_pages us09pages;


    @Given("TG kullanici {string} sayfasina gider")
    public void tg_kullanici_sayfasina_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }

    @Given("TG sayfanin sağ üst köşesinde yeralan insan ikonuna tıklar")
    public void tg_sayfanin_sağ_üst_köşesinde_yeralan_insan_ikonuna_tıklar() {
        us09pages = new US09_pages();
        us09pages.anasayfaInsanIkonu.click();
    }

    @Then("TG acilan dropdown menude Sign in butonuna tıklar")
    public void tg_acilan_dropdown_menude_sign_in_butonuna_tıklar() {
        us09pages = new US09_pages();
        us09pages.anasayfaInsanIkonuSignInElementi.click();
    }

    @Then("TG username olarak {string} girer")
    public void tg_username_olarak_girer(String string) {
        us09pages = new US09_pages();
        us09pages.loginUsernameTextBox.sendKeys(ConfigReader.getProperty("StaffUsernameTG"));
    }

    @Then("TG password olarak {string} girer")
    public void tg_password_olarak_girer(String string) {
        us09pages = new US09_pages();
        us09pages.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("StaffPasswordTG"));
    }

    @Then("TG Sign in butonuna basar")
    public void tg_sign_in_butonuna_basar() {
        us09pages = new US09_pages();
        us09pages.loginSignInButonu.click();
    }

    @Then("TG MYPAGES dropdown menusune tıklar")
    public void tg_mypages_dropdown_menusune_tıklar() {
        us09pages = new US09_pages();
        us09pages.myPagesDropdownMenuElementi.click();
    }

    @Then("TG Search Patient butonuna tıklar")
    public void tg_search_patient_butonuna_tıklar() {
        us09pages = new US09_pages();
        us09pages.myPagesDropdownMenuSearchPatientElementi.click();
    }

    @Then("TG Patients tablosunun ve hasta bilgilerinin gorunur oldugunu test eder")
    public void tg_patients_tablosunun_ve_hasta_bilgilerinin_gorunur_oldugunu_test_eder() {
        us09pages = new US09_pages();
        Assert.assertTrue(us09pages.patientsTableElementi.isDisplayed());
    }

    @Then("TG sayfayi kapatir")
    public void tg_sayfayi_kapatir() {
        Driver.closeDriver();
    }


    @Then("TG Tabloda bilgilerini düzenlenmek istedigi hastanın yanındaki edit butonuna tıklar")
    public void tgTablodaBilgileriniDüzenlenmekIstedigiHastanınYanındakiEditButonunaTıklar() {
        us09pages = new US09_pages();
        us09pages.patientsTableHastaEditElementi.click();
    }

    @And("TG Hasta bilgilerinin düzenlenebilir oldugunu test eder")
    public void tgHastaBilgilerininDüzenlenebilirOldugunuTestEder() {
        us09pages = new US09_pages();
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeFirstNameTextBoxElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeLastNameTextBoxElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeBirthDateTextBoxElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeEmailTextBoxElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemePhoneTextBoxElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeGenderSelectMenuElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeBloodGroupSelectMenuElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeAdressTextBoxElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeDescriptionTextBoxElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeUserSelectMenuElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeCountrySelectMenuElementi.isEnabled());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeStateSelectMenuElementi.isEnabled());

    }

    @And("TG Patient SSN kısmına hastanın SSN bilgisini girer")
    public void tgPatientSSNKısmınaHastanınSSNBilgisiniGirer() {
        us09pages = new US09_pages();
        us09pages.patientsTableSSNsearchTextBox.sendKeys("123-45-6799");
    }

    @Then("TG Ilgili hastanın yanındaki view butonuna tıklar")
    public void tgIlgiliHastanınYanındakiViewButonunaTıklar() {
        us09pages = new US09_pages();
        us09pages.patientsTableHastaViewElementi.click();
    }

    @And("TG kayit bilgilerinin gorunur oldugunu test eder")
    public void tgKayitBilgilerininGorunurOldugunuTestEder() {
        us09pages = new US09_pages();
        Assert.assertTrue(us09pages.hastaBilgisiGoruntulemeSSNElementi.isDisplayed());
    }


    @And("TG kayit bilgilerini siler ve Save butonuna tıklar")
    public void tgKayitBilgileriniSilerVeSaveButonunaTıklar() throws InterruptedException {
        us09pages = new US09_pages();
        Actions actions = new Actions(Driver.getDriver());
        Assert.assertTrue(us09pages.hastaBilgileriGuncellemeAdressTextBoxElementi.isEnabled());
        //WebElement saveButonu = us009Pages.hastaBilgileriGuncellemeSaveButonuElementi;
        //actions.moveToElement(saveButonu).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        us09pages.hastaBilgileriGuncellemeSaveButonuElementi.click();

    }

    @And("TG bilgilerin silinip silinmedigini test eder")
    public void tgBilgilerinSilinipSilinmediginiTestEder() {
        us09pages = new US09_pages();
        Assert.assertTrue(us09pages.alertButton.isDisplayed());
    }

    @And("TG Arama yapabildigini ve istenilen hastanın gorunur oldugunu test eder")
    public void tgAramaYapabildiginiVeIstenilenHastanınGorunurOldugunuTestEder() {
        us09pages = new US09_pages();
        Assert.assertTrue(us09pages.arananHastaId.isDisplayed());
    }

    @And("TG Hasta idsini silemedigini test eder")
    public void tgHastaIdsiniSilemediginiTestEder() {
        //  Assert.assertTrue(us009Pages.hastaBilgileriGuncellemeIdTextBoxElementi.isEnabled());

    }


    @And("TG {int} saniye bekler")
    public void tgSaniyeBekler(int saniye) throws InterruptedException {
        Thread.sleep(saniye*1000);
    }
}
