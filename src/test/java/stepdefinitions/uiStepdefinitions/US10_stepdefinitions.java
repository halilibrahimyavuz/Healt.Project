package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.plugin.event.Node;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.US10_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US10_stepdefinitions {

    US10_page us10Pages=new US10_page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    String fakerPassword;

    @Given("HY {string} adresine gidilir")
    public void hy_adresine_gidilir(String url) {
        Driver.getDriver().get(ConfigReader.getProperty(url));
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        String expectedTitle="MEDUNNA";
        Assert.assertEquals("MEDUNNA sayfasına gidilemedi",expectedTitle,actualTitle);
    }


    @Given("HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na Tıklanır.")
    public void hy_sayfanın_en_üst_sağ_kısmındaki_profile_ıkonu_na_tıklanır() {
    us10Pages.profilIkonuButonu.click();
    ReusableMethods.waitFor(1);

    }

    @Given("HY Açılan sekmeden Register seçecegi seçilmelidir.")
    public void hy_açılan_sekmeden_register_seçecegi_seçilmelidir() {

         ReusableMethods.hooverByJS(us10Pages.registerDropDownButonu);
         ReusableMethods.waitFor(2);
         System.out.println(us10Pages.registrationSayfasıText.getText());
         Assert.assertTrue(us10Pages.registrationSayfasıText.isDisplayed());
    }

    @Given("HY Kullanıcı şifre olarak {string} kutusu doldurulmaldır.")
    public void hy_kullanıcı_şifre_olarak_kutusu_doldurulmaldır(String ssnTürü) {
        String fakerssn=faker.idNumber().ssnValid();
         us10Pages.ssnTextBox.sendKeys(fakerssn);
        Assert.assertEquals(fakerssn,us10Pages.ssnTextBox.getAttribute("value"));
    }

    @Given("HY Kullanıcı isim olarak {string} kutusu doldurulmalıdır.")
    public void hy_kullanıcı_isim_olarak_kutusu_doldurulmalıdır(String isimTürü) {
      String fakerFirstName=faker.name().firstName();
        us10Pages.firstnameTextBox.sendKeys(fakerFirstName);
        Assert.assertEquals(fakerFirstName,us10Pages.firstnameTextBox.getAttribute("value"));
    }


    @Given("HY Kullanıcı soyisim olarak {string} kutusu doldurulmaldır.")
    public void hy_kullanıcı_soyisim_olarak_kutusu_doldurulmaldır(String soyisimTürü) {
      String fakerLastName=faker.name().lastName();
        us10Pages.lastnameTextBox.sendKeys(fakerLastName);
        Assert.assertEquals(fakerLastName,us10Pages.lastnameTextBox.getAttribute("value"));
        ReusableMethods.waitFor(2);
    }

    @Given("HY Kullanıcı username olarak  {string} kutusu doldurulmalıdır.")
    public void hy_kullanıcı_username_olarak_kutusu_doldurulmalıdır(String usernameTürü) {
        String fakerUSerName=faker.name().username();
        actions.click(us10Pages.usernameTextBox)
                .sendKeys(Keys.TAB)
                .perform();
        us10Pages.usernameTextBox.sendKeys(fakerUSerName);
        Assert.assertEquals(fakerUSerName,us10Pages.usernameTextBox.getAttribute("value"));
        ReusableMethods.waitFor(2);
    }


    @Given("HY Kullanıcı email olarak  {string} kutusu doldurulmalıdır.")
    public void hy_kullanıcı_email_olarak_kutusu_doldurulmalıdır(String email) {
      // hata verdı---> ReusableMethods.hover(us10Page.secondpasswordTextBox);

        String fakerEmail=faker.internet().emailAddress();
        us10Pages.emailTextBox.sendKeys(fakerEmail);
        Assert.assertEquals(fakerEmail,us10Pages.emailTextBox.getAttribute("value"));
        ReusableMethods.waitFor(2);

        actions.click(us10Pages.emailTextBox)
                .sendKeys(Keys.TAB)
                .perform();


    }



    @Given("HY  {string} istenildigi gibi doldurulmalıdır.")
    public void hy_istenildigi_gibi_doldurulmalıdır(String newpassword) {

        fakerPassword=faker.internet().password();
        us10Pages.firstpasswordTextBox.sendKeys(fakerPassword);
        Assert.assertEquals(fakerPassword,us10Pages.firstpasswordTextBox.getAttribute("value"));
        actions.sendKeys(Keys.TAB).perform();

    }
    @Given("HY  {string} Confirmation butonuna belirlenen password girilmelidir.")
    public void hy_confirmation_butonuna_belirlenen_password_girilmelidir(String secondPassword) {

        ReusableMethods.waitFor(2);
        us10Pages.secondpasswordTextBox.sendKeys(fakerPassword);
        Assert.assertEquals(fakerPassword,us10Pages.secondpasswordTextBox.getAttribute("value"));

    }

    @Given("HY  Register butonuna tıklanmalıdır.")
    public void hy_register_butonuna_tıklanmalıdır() {
        Assert.assertTrue(us10Pages.registerOnayButonu.isDisplayed());
       us10Pages.registerOnayButonu.click();
    }


    @Given("HY  Başarılı kayıt yapıldı yazısı görülmelidir.")
    public void hy_başarılı_kayıt_yapıldı_yazısı_görülmelidir() {
    ReusableMethods.waitFor(2);
       //String actualAlertText=us10Pages.toastContainerMassage.getText();
       String expectedAlertText="Registration Saved";
       // System.out.println(actualAlertText);
        System.out.println(us10Pages.toastContainerMassage.getText());
        Assert.assertTrue(us10Pages.toastContainerMassage.getText().contains(expectedAlertText));
        Assert.assertTrue(us10Pages.toastContainerMassage.isDisplayed());
    }


    @Given("HY Sayfa kapatılır.")
    public void hySayfaKapatılır() {
        ReusableMethods.waitFor(2);
        Driver.closeDriver();
    }

    //------------------------------SCENARIO2--------------------------


    @Then("HY Açılan sekmeden Sing in seçecegi seçilmelidir.")
    public void hy_açılan_sekmeden_sing_in_seçecegi_seçilmelidir() {
      //  Assert.assertTrue(us10Pages.singInButonu.isDisplayed());
        us10Pages.singInButonu.click();
    }

    @Then("HY Kullanıcı kayıtlı olduğu {string} i girmelidir.")
    public void hyKullanıcıKayıtlıOlduğuIGirmelidir(String username) {
        us10Pages.singInUsernameTextBox.sendKeys(ConfigReader.getProperty(username));
    }

    @Then("HY Kullanıcı kayıtlı olduğu {string} u girmelidir.")
    public void hyKullanıcıKayıtlıOlduğuUGirmelidir(String password) {
        us10Pages.singInPasswordTextBox.sendKeys(ConfigReader.getProperty(password));
    }


    @Given("HY kullanıcı Sing in butonuna basar.")
    public void hy_kullanıcı_sing_in_butonuna_basar() {
        ReusableMethods.waitFor(2);
      //  Assert.assertTrue(us10Pages.singInSingInButonu.isDisplayed());
        // ReusableMethods.waitFor(1);
        us10Pages.singInSingInButonu.click();
    }

    @Then("HY Sayfanın üstündeki menüden MY PAGES\\(PATİENT) seçeneğine tıklar.")
    public void hy_sayfanın_üstündeki_menüden_my_pages_patient_seçeneğine_tıklar() {
        ReusableMethods.waitFor(1);
        String actualText=us10Pages.myPagesButonu.getText();
        String expectedText="MY PAGES";
        Assert.assertEquals(expectedText,actualText);
        us10Pages.myPagesButonu.click();
    }

    @Given("HY Açılan dropdowndan MY Appointments seçeneği seçilmelidir.")
    public void hy_açılan_dropdowndan_my_appointments_seçeneği_seçilmelidir() {
        ReusableMethods.waitFor(2);
      //  String actualText=us10Pages.myAppointmentsButonu.getAttribute("value");
       // String expectedText="My Appointments";
      //  Assert.assertEquals(expectedText,actualText);
        us10Pages.myAppointmentsButonu.click();

    }

    @Then("HY Kontrol etmek istediği zaman aralığını girer.")
    public void hy_kontrol_etmek_istediği_zaman_aralığını_girer() {
        String actualText=us10Pages.apppointmentsPagesText.getText();
        String expectedText="Appointments";
        Assert.assertEquals(expectedText,actualText);

    }

    @Then("HY Oluşturulan randevular görünür olduğu test edilir.")
    public void hy_oluşturulan_randevular_görünür_olduğu_test_edilir() {
       //webtable olarak almak ıstedım??????? Assert.assertTrue(us10Pages.alınanRandevular.is);
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us10Pages.ilkRandevuID.isDisplayed());
    }
//--------------------3------------------------------------------


    @Given("HY Secilen zaman dilimindeki randevularda Patient ID görünür olmalıdır.")
    public void hy_secilen_zaman_dilimindeki_randevularda_patient_ıd_görünür_olmalıdır() {
        Assert.assertTrue(us10Pages.ilkRandevuID.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @Then("HY Secilen zaman dilimindeki randevularda Start Date Time görünür olmaldır.")
    public void hy_secilen_zaman_dilimindeki_randevularda_start_date_time_görünür_olmaldır() {
        Assert.assertTrue(us10Pages.startDateTime.isDisplayed());
        ReusableMethods.waitFor(2);
    }


    @Then("HY Secilen zaman dilimindeki randevularda End Date Time  görünür olmalıdır.")
    public void hy_secilen_zaman_dilimindeki_randevularda_end_date_time_görünür_olmalıdır() {
        Assert.assertTrue(us10Pages.endDateTime.isDisplayed());
        ReusableMethods.waitFor(2);
    }

    @Then("HY Secilen zaman dilimindeki randevularda Status durumu görünür olmalıdır.")
    public void hy_secilen_zaman_dilimindeki_randevularda_status_durumu_görünür_olmalıdır() {
        Assert.assertTrue(us10Pages.status.isDisplayed());
        ReusableMethods.waitFor(2);


    }


}
