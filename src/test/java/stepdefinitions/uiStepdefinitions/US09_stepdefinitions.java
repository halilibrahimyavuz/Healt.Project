package stepdefinitions.uiStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US09_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US09_stepdefinitions {
    US09_pages us09pages;

    // US26

    //US26 TC02

    @And("TG Header bolumundeki CONTACT secenegine tiklar")
    public void tgHeaderBolumundekiCONTACTSecenegineTiklar() {
        us09pages = new US09_pages();
        ReusableMethods.waitFor(4);
        us09pages.anasayfaContactMenu.click();
    }

    @Then("TG Sayfada yer alan {string}, {string}, {string}, {string} kisimlarini doldurabildigini test eder")
    public void tgSayfadaYerAlanKisimlariniDoldurabildiginiTestEder(String name, String email, String subject, String message) {
        us09pages = new US09_pages();

        Assert.assertTrue(us09pages.contactSayfasiNameTextBox.isEnabled());
        Assert.assertTrue(us09pages.contactSayfasiEmailTextBox.isEnabled());
        Assert.assertTrue(us09pages.contactSayfasiSubjectTextBox.isEnabled());
        Assert.assertTrue(us09pages.contactSayfasiMessageTextBox.isEnabled());

        us09pages.contactSayfasiNameTextBox.sendKeys(name);
        us09pages.contactSayfasiEmailTextBox.sendKeys(email);
        us09pages.contactSayfasiSubjectTextBox.sendKeys(subject);
        us09pages.contactSayfasiMessageTextBox.sendKeys(message+ Keys.PAGE_DOWN);
    }

    @And("TG Bilgileri girdikten sonra mesajı gonderebildigini test eder")
    public void tgBilgileriGirdiktenSonraMesajıGonderebildiginiTestEder() {
        us09pages = new US09_pages();

        ReusableMethods.waitFor(2);
        us09pages.contactSayfasiSendButton.click();

    }


    // US28

    @And("TG sayfanin sag ust kosesinde yeralan insan ikonuna tıklar")
    public void tgSayfaninSagUstKosesindeYeralanInsanIkonunaTıklar() {
        us09pages = new US09_pages();
        us09pages.anasayfaInsanIkonu.click();
    }

    @And("TG Admin username olarak {string} girer")
    public void tgAdminUsernameOlarakGirer(String arg0) {
        us09pages = new US09_pages();
        us09pages.loginUsernameTextBox.sendKeys(ConfigReader.getProperty("AdminUsernameTG"));
    }

    @And("TG Admin password olarak {string} girer")
    public void tgAdminPasswordOlarakGirer(String arg0) {
        us09pages = new US09_pages();
        us09pages.loginPasswordTextBox.sendKeys(ConfigReader.getProperty("AdminPasswordTG"));
    }

    @Then("TG Items&Titles dropdown menusune tıklar")
    public void tgItemsTitlesDropdownMenusuneTıklar() {
        us09pages = new US09_pages();
        us09pages.itemTitlesDropdownMenu.click();
    }

    @Then("TG Acilan menude Country secenegine tiklar\"")
    public void tg_acilan_menude_country_secenegine_tiklar() {
        us09pages = new US09_pages();
        us09pages.itemTitlesDropdownMenuCountryElementi.click();
    }

    @Then("TG Create a new Country butonuna tıklar")
    public void tg_create_a_new_country_butonuna_tıklar() {
        us09pages = new US09_pages();
        us09pages.countriesTableCreateANewCountryButton.click();
    }

    @Then("TG Eklemek istedigi ülke ismini girer")
    public void tg_eklemek_istedigi_ülke_ismini_girer() {
        us09pages = new US09_pages();
        us09pages.createOraEditCountryTableCountryNameTextBox.sendKeys("kambocya11");
    }

    @Then("TG Tarihi girer")
    public void tg_tarihi_girer() {
        us09pages = new US09_pages();
        us09pages.createOrEditaStateCityTableDateTextBox.sendKeys("25052022");
    }

    @Then("TG Save butonuna basar")
    public void tg_save_butonuna_basar() {
        us09pages = new US09_pages();
        us09pages.createOrEditaStateCityTableSaveButton.click();
    }

    @Then("TG Ulke olusturulup olusturulmadıgını kontrol eder")
    public void tg_ulke_olusturulup_olusturulmadıgını_kontrol_eder() {
        us09pages = new US09_pages();
        Assert.assertTrue(us09pages.basariliCountryEklemeAlertBox.isDisplayed());
    }


    @And("TG Acilan menude State City secenegine tiklar")
    public void tgAcilanMenudeStateCitySecenegineTiklar() {
        us09pages = new US09_pages();
        us09pages.itemTitlesDropdownMenuStateCityElementi.click();
    }


    @Then("TG Create a new State City butonuna tıklar")
    public void tgCreateANewStateCityButonunaTıklar() {
        us09pages = new US09_pages();
        us09pages.statesCitiesTableCreateANewStateButton.click();
    }

    @And("TG Eklemek istedigi State City ismini girer")
    public void tgEklemekIstedigiStateCityIsminiGirer() {
        us09pages = new US09_pages();
        us09pages.createOrEditaStateCityTableNameTextBox.sendKeys("kambocyastate1234");
    }


    // DELETE ULKE TC 06
    @And("TG Silmek istedigi Ulkenin yanindaki DELETE butonuna basar")
    public void tgSilmekIstedigiUlkeninYanindakiDELETEButonunaBasar() {
        us09pages = new US09_pages();

        ReusableMethods.waitFor(3);
        us09pages.countrySayfasiIlkDeleteButonu.click();
        ReusableMethods.waitFor(3);

    }

    @And("TG Silme istegini onaylar")
    public void tgSilmeIsteginiOnaylar() {
        // us09pages.countrySayfasiDeleteOnayIkinciDeleteButonu.click();
    }




    // GENEL
    @Given("TG kullanici {string} sayfasina gider")
    public void tg_kullanici_sayfasina_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("MedunnaUrl"));
    }

    @And("TG sayfanin sag üst köşesinde yeralan insan ikonuna tıklar")
    public void tg_sayfanin_sag_üst_köşesinde_yeralan_insan_ikonuna_tıklar() {
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
        Thread.sleep(saniye * 1000);
    }



}
