package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.plugin.event.Node;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US10_page;
import pages.US11_page;
import utilities.Driver;
import utilities.ReusableMethods;

public class US11_stepdefinitions {


    US10_page us10Pages =new US10_page();
    US11_page us11Page=new US11_page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();


    @Then("HY Sayfanın en altındakı Make an Appointment bölümüne gidilir.")
    public void hy_sayfanın_en_altındakı_make_an_appointment_bölümüne_gidilir() {
        Assert.assertTrue(us11Page.makeAnAppointmentText.isDisplayed());
        ReusableMethods.hooverByJS(us11Page.makeAnAppointmentText);
        System.out.println(us11Page.makeAnAppointmentText.getText());

    }

    @Given("HY Sayfanın en üst sağ kısmındaki Profile Ikonu'na tiklanir.")
    public void hySayfanınEnÜstSağKısmındakiProfileIkonuNaTiklanir() {
        us10Pages.profilIkonuButonu.click();
    }
    @Then("HY İsim bölümüne {string} girilir.")
    public void hy_isim_bölümüne_girilir(String string) {
    String fakerFirstName=faker.name().firstName();
     us11Page.firstnameTextBox.sendKeys(fakerFirstName);
     Assert.assertEquals(fakerFirstName,us10Pages.firstnameTextBox.getAttribute("value"));

    }

    @Then("HY Soyisim bölümüne {string} girilir.")
    public void hy_soyisim_bölümüne_girilir(String string) {
        String fakerLastname=faker.name().lastName();
        us11Page.lastNameTextBox.sendKeys(fakerLastname);
        Assert.assertEquals(fakerLastname,us10Pages.lastnameTextBox.getAttribute("value"));

    }

    @Then("HY Şifre yerine {string} girilir.")
    public void hy_şifre_yerine_girilir(String ssn) {
        String fakerSSN=faker.idNumber().ssnValid();
        us11Page.ssnTextBox.sendKeys(fakerSSN);
        Assert.assertEquals(fakerSSN,us11Page.ssnTextBox.getAttribute("value"));
    }

    @Then("HY Uygun bir {string} girilir.")
    public void hy_uygun_bir_girilir(String email) {
        String fakerEmail=faker.internet().emailAddress();
      us11Page.emailTextBox.sendKeys(fakerEmail);
        Assert.assertEquals(fakerEmail,us11Page.emailTextBox.getAttribute("value"));

    }

    @Then("HY Kullanılan {string} girilir.")
    public void hy_kullanılan_girilir(String phone) {
        String phoneNumber="555-555-5555";
      us11Page.phoneTextBox.sendKeys(phoneNumber);
        Assert.assertEquals(phoneNumber,us11Page.phoneTextBox.getAttribute("value"));

        ReusableMethods.waitFor(1);

    }



    @Then("HY Appointment Date time girilir.")
    public void hy_appointment_date_time_girilir() {
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        ReusableMethods.waitFor(1);
    }

    @Then("HY Send an Appointment Date time butonuna tiklanir.")
    public void hy_send_an_appointment_date_time_butonuna_tıklanır() {
     us11Page.sendAppointmentButonu.click();

    }

    @Given("HY Anasayfadan Başarılı kayıt yapıldı yazısı görülmelidir.")
    public void hyAnasayfadanBaşarılıKayıtYapıldıYazısıGörülmelidir() {
        ReusableMethods.waitFor(1);
        String expectedText="Appointment registration saved!";
        Assert.assertTrue(us11Page.anaSaydadanBasarılıKayıtOlusturmaYazısı.getText().contains(expectedText));
        System.out.println(us11Page.anaSaydadanBasarılıKayıtOlusturmaYazısı.getText());

    }

    @Then("HY Görüntülenen randevu bilgilerinin en solundaki Edit Butonuna tıklamalıdır.")
    public void hy_görüntülenen_randevu_bilgilerinin_en_solundaki_edit_butonuna_tıklamalıdır() {
        Assert.assertTrue(us11Page.editButonu.isDisplayed());
        ReusableMethods.waitFor(2);
        us11Page.editButonu.click();


    }

    @Then("HY Create or Edit Appointment sayfası görülmelidir.")
    public void hy_create_or_edit_appointment_sayfası_görülmelidir() {
        Assert.assertTrue(us11Page.createEditAppointmentText.isDisplayed());
    }

    @When("HY ID bilgisi görünür olmaldır.")
    public void hy_ıd_bilgisi_görünür_olmaldır() {
        Assert.assertTrue(us11Page.idTextBox.isDisplayed());
    }

    @When("HY Start Date Time bilgisi görünür olmalıdır.")
    public void hy_start_date_time_bilgisi_görünür_olmalıdır() {
        Assert.assertTrue(us11Page.startDateTimeTextBox.isDisplayed());
    }

    @Then("HY End Date Time bilgileri görünür olmalıdır.")
    public void hy_end_date_time_bilgileri_görünür_olmalıdır() {
        Assert.assertTrue(us11Page.endDateTimeTextBox.isDisplayed());
    }

    @Then("HY Status bilgisi görünür olmalıdır.")
    public void hy_status_bilgisi_görünür_olmalıdır() {
        Assert.assertTrue(us11Page.statusDropDown.isDisplayed());
    }

    @Then("HY Physician bilgileri görünür olmalıdır.")
    public void hy_physician_bilgileri_görünür_olmalıdır() {
        Assert.assertTrue(us11Page.physicianDropDown.isDisplayed());
    }


    @When("HY Status bölümü PENDING olarak seçilebilmelidir.")
    public void hy_status_bölümü_pendıng_olarak_seçilebilmelidir() {
       Select select=new Select(us11Page.statusDropDown);
       select.selectByValue("PENDING");
       ReusableMethods.waitFor(1);

      // String actualDropdown=us11Page.statusDropDown.getText();
      // String expectedDropDown="PENDING";
      //  System.out.println(actualDropdown);
      // Assert.assertTrue(us11Page.statusDropDown.getText().equals("PENDING"));
       // Assert.assertTrue(us11Page.statusDropDown.isDisplayed());
       // us11Page.anamnesisTextBox.sendKeys("deneme");
       // us11Page.treatmentTextBox.sendKeys("deneme");
       // us11Page.diagnosisTextBox.sendKeys("deneme");
       // us11Page.prescriptionTextBox.sendKeys("deneme");
       // us11Page.descriptionTextBox.sendKeys("deneme");
        //us11Page.saveButonu.click();
    }

    @When("HY Status bölümü COMPLETED olarak seçilebilmelidir.")
    public void hy_status_bölümü_completed_olarak_seçilebilmelidir() {
        Select select=new Select(us11Page.statusDropDown);
        select.selectByValue("COMPLETED");
        ReusableMethods.waitFor(1);
    }
    @When("HY Status bölümü CANCELLED olarak seçilebilmelidir.")
    public void hyStatusBölümüCANCELLEDOlarakSeçilebilmelidir() {
        Select select=new Select(us11Page.statusDropDown);
        select.selectByValue("CANCELLED");
        ReusableMethods.waitFor(1);
    }

    @When("HY Save butonu aktif omalıdır.")
    public void hy_save_butonu_aktif_omalıdır() {
        Assert.assertTrue(us11Page.saveButonu.isDisplayed());
    }

    @Given("HY Anamnesis bölümü doldurulabilmelidir.")
    public void hy_anamnesis_bölümü_doldurulabilmelidir() {
        us11Page.anamnesisTextBox.sendKeys("anamnesis");
    }

    @Given("HY Treatment bölümü doldurulabilmelidir.")
    public void hy_treatment_bölümü_doldurulabilmelidir() {
       us11Page.treatmentTextBox.sendKeys("treatment");
    }

    @Given("HY Diagnosis bölümü doldurulabilmelidir.")
    public void hy_diagnosis_bölümü_doldurulabilmelidir() {
       us11Page.diagnosisTextBox.sendKeys("diagnosis");
    }


    @Given("HY Prescription bölümü doldurulması zorunlu olmamalıdır.")
    public void hy_prescription_bölümü_doldurulması_zorunlu_olmamalıdır() {
       //bu kısmı doldurmadan save yapılmaldıır ve save basarılı olmaldıır
    }

    @Given("HY Description bölümü doldurulması zorunlu olmamalıdır.")
    public void hy_description_bölümü_doldurulması_zorunlu_olmamalıdır() {
        //bu kısmı doldurmadan save yapılmaldıır ve save basarılı olmaldıır
        //bu ıksıı ııcın uygun assert u kurmak lazım

    }



}
