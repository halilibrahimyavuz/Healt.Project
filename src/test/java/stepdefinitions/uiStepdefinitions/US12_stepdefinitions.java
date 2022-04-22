package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US12_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class US12_stepdefinitions {

    Faker faker =new Faker();
    US12_pages us12_pages = new US12_pages();
    ReusableMethods reusableMethods=new ReusableMethods();
    Actions actions =new Actions(Driver.getDriver());
    Select select;
    int ileriRandevuTarihi=9;
    static String hastaSSN="";



    @Given("EA Kullanici {string} anasayfaya gider")
    public void ea_kullanici_anasayfaya_gider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }
    @Then("EA Make an Appointment butonuna tıklar")
    public void ea_make_an_appointment_butonuna_tıklar() {
        us12_pages.appointmentButton.click();
        reusableMethods.waitFor(2);
    }
    @Then("EA FirstName TextBox doldurur")
    public void ea_first_name_text_box_doldurur() {
        us12_pages.firstname.sendKeys(faker.name().firstName());
    }
    @Given("EA LastName TextBox doldurur")
    public void ea_last_name_text_box_doldurur() {
        us12_pages.lastname.sendKeys(faker.name().lastName());
    }
    @Given("EA SSN numarasi girer")
    public void ea_ssn_numarasi_girer() {
        hastaSSN=faker.idNumber().ssnValid();
        us12_pages.ssnNumber.sendKeys(hastaSSN);
        //us12_pages.ssnNumber.sendKeys(ConfigReader.getProperty("HastaKayitSSN"));
    }
    @Given("EA Email adresi girer")
    public void ea_email_adresi_girer() {

        us12_pages.emailTextbox.sendKeys(faker.internet().emailAddress());
    }
    @Given("EA Phone number girer")
    public void ea_phone_number_girer() {

        us12_pages.phoneTextbox.sendKeys(faker.phoneNumber().subscriberNumber(10));
    }
    @Given("EA Appointment DateTime secer")
    public void ea_appointment_date_time_secer() {
        LocalDate localDate=LocalDate.now();
        LocalDate eklenmisLocalDate = localDate.plusDays(ileriRandevuTarihi);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkInDate = eklenmisLocalDate.format(duzenliDateStart);
        us12_pages.dateTextbox.sendKeys(checkInDate);
        reusableMethods.waitFor(3);
    }

    @Given("EA Send an Appointment Request Butonuna tiklar")
    public void ea_send_an_appointment_request_butonuna_tiklar() {
        us12_pages.kayitButton.click();
        reusableMethods.waitFor(2);
    }
    @Given("EA Hastanin randevu kaydi yapildigi dogrulanir")
    public void ea_hastanin_randevu_kaydi_yapildigi_dogrulanir() {
        reusableMethods.waitFor(2);
        String hastaRandevuDOgrulama="Appointment registration saved!";
        Assert.assertTrue(us12_pages.alertButton2.getText().equals(hastaRandevuDOgrulama));
        reusableMethods.waitFor(1);
    }
    @Given("EA Kullanici sayfayi kapatir")
    public void ea_kullanici_sayfayi_kapatir() {
      Driver.closeDriver();
    }

    //US0012-TC002

    @Then("EA Sag ust kosede bulunan icona tiklar")
    public void ea_sag_ust_kosede_bulunan_icona_tiklar() {
        us12_pages.sign_inIcon.click();
        reusableMethods.waitFor(1);
    }
    @Then("EA Sign-in butonuna tiklar")
    public void ea_sign_in_butonuna_tiklar() {
        us12_pages.sign_inFirstButton.click();
        reusableMethods.waitFor(1);
    }
    @Then("EA Kayitli  staff Username girer")
    public void ea_kayitli_staff_username_girer() {
        us12_pages.sign_inUserNameTextBox
                .sendKeys(ConfigReader.getProperty("US12_kayitliStaffUsername"));
        reusableMethods.waitFor(1);
    }
    @Then("EA Kayitli  staff Password girer")
    public void ea_kayitli_staff_password_girer() {
        us12_pages.sign_inPasswordTextBox
                .sendKeys(ConfigReader.getProperty("US12_kayitliStaffPassword"));
        reusableMethods.waitFor(1);
    }
    @Then("EA ikinci Sign-in butonuna tiklar")
    public void ea_ikinci_sign_in_butonuna_tiklar() {
        us12_pages.sign_inSecondButton.click();
        reusableMethods.waitFor(1);
    }
    @Then("EA Staff olarak oturum acildigi dogrulanir")
    public void ea_staff_olarak_oturum_acildigi_dogrulanir() {
        Assert.assertTrue(us12_pages.staffOturumDogrulama.isDisplayed());
    }

    //US0012-TC003

    @Then("EA Kullanici Staff olarak oturum acar")
    public void ea_kullanici_staff_olarak_oturum_acar() {

        us12_pages.staffOturumAcma();
    }
    @Then("EA Kullanici\\(Staff) MyPages bolumune tiklar")
    public void ea_kullanici_staff_my_pages_bolumune_tiklar() {
        us12_pages.staffMypages.click();
        reusableMethods.waitFor(2);

    }
    @Then("EA Kullanici\\(Staff) Search Patient\\(Hasta arama) bolumune tiklar")
    public void ea_kullanici_staff_search_patient_hasta_arama_bolumune_tiklar() {
        us12_pages.staffSearchPatient.click();
        reusableMethods.waitFor(2);
    }
    @Then("EA Kullanici\\(Staff) Aradigi hastanin SSN numarasini Patient SSN bolunume girer")
    public void ea_kullanici_staff_aradigi_hastanin_ssn_numarasini_patient_ssn_bolunume_girer() {
        us12_pages.staffPatientSSN.click();
        reusableMethods.waitFor(2);
        us12_pages.staffPatientSSN.sendKeys(hastaSSN);
        //us12_pages.staffPatientSSN.sendKeys(ConfigReader.getProperty("HastaKayitSSN"));
        reusableMethods.waitFor(3);
    }
    @Then("EA Kullanici\\(Staff) SSN numarasini girdigi hastanin satirindaki ShowAppointments butonuna tiklar")
    public void ea_kullanici_staff_ssn_numarasini_girdigi_hastanin_satirindaki_show_appointments_butonuna_tiklar() {
       us12_pages.sagaKaydirmaElementi.click();
        actions.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT)
                .perform();
        reusableMethods.waitFor(2);
        us12_pages.staffShowAppointments.click();
    }
    @Then("EA Kullanici\\(Staff) ShowAppointments butonuna tikladikdan sonra Edit butonuna tiklar")
    public void ea_kullanici_staff_show_appointments_butonuna_tikladikdan_sonra_edit_butonuna_tiklar() {
        reusableMethods.waitFor(2);
        us12_pages.staffEditButton.click();
    }
    @Then("EA Kullanici\\(Staff) acilan status dropbox bolumunden pending kismini secer")
    public void ea_kullanici_staff_acilan_status_dropbox_bolumunden_pending_kismini_secer() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(2);
        select=new Select(us12_pages.staffStatusPendingSecimi);
        System.out.println(select);
        select.selectByIndex(1);
    }
    @Then("EA Kullanici\\(Staff) acilan Physician dropbox bolumunden hastanin atanacagi doktoru secer")
    public void ea_kullanici_staff_acilan_physician_dropbox_bolumunden_hastanin_atanacagi_doktoru_secer() {
        us12_pages.staffAnamnesisTextBox.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(2);

        select=new Select(us12_pages.staffDoktorSecimiDropbox);
        select.selectByVisibleText("46099:Team84 US0012-Doktor:FAMILY_MEDICINE");
        //46099:Team84 US0012-Doktor:FAMILY_MEDICINE42975:Enes ArslanDoctor:FAMILY_MEDICINE
    }
    @Then("EA Kullanici\\(Staff) save butonuna tiklar")
    public void ea_kullanici_staff_save_butonuna_tiklar() {
        reusableMethods.waitFor(1);
        us12_pages.staffSaveButton.click();
    }
    @Then("EA Hastanin ilgili  hastanin ilgili doktora atamasinin yapildigi test edilir")
    public void ea_hastanin_ilgili_hastanin_ilgili_doktora_atamasinin_yapildigi_test_edilir() {
        reusableMethods.waitFor(1);
       //String expectedResult ="The Appointment is updated with identifier";
       //Assert.assertTrue(us12_pages.staffDoktoratamasiAlert.getText().contains(expectedResult));
         Assert.assertTrue(us12_pages.alertButton.isDisplayed());
    }

    //US0012-TC004

    @Then("EA Kayitli doktor username girer")
    public void ea_kayitli_doktor_username_girer() {
        us12_pages.sign_inUserNameTextBox.
                sendKeys(ConfigReader.getProperty("US12_kayitliDoctorUsername"));
    }
    @Then("EA Kayitli doktor password girer")
    public void ea_kayitli_doktor_password_girer() {
        us12_pages.sign_inPasswordTextBox.
                sendKeys(ConfigReader.getProperty("US12_kayitliDoctorPassword"));
    }
    @Then("EA Doktor olarak oturum acildigi dogrulanir")
    public void ea_doktor_olarak_oturum_acildigi_dogrulanir() {
        Assert.assertTrue(us12_pages.doktorOturumAcmaDogrulama.isDisplayed());
        reusableMethods.waitFor(2);
    }

    //US0012-TC005

    @Then("EA Kullanici Doktor olarak oturum acar")
    public void ea_kullanici_doktor_olarak_oturum_acar() {

        us12_pages.doktorOturumAcma();
    }
    @Given("EA Kullanici\\(Doktor) MyPages bolumune tiklar")
    public void ea_kullanici_doktor_my_pages_bolumune_tiklar() {
        us12_pages.doktorMyPagesBolumu.click();
        reusableMethods.waitFor(2);
    }
    @Then("EA MyAppointment bolumune tiklar")
    public void ea_my_appointment_bolumune_tiklar() {
        us12_pages.doktorMyAppointmentsBolumu.click();
        reusableMethods.waitFor(2);
    }
    @Then("EA Kendisinden randevu alan hasta adi ile ayni satirda bulunan Edit bolumune tiklar")
    public void ea_kendisinden_randevu_alan_hasta_adi_ile_ayni_satirda_bulunan_edit_bolumune_tiklar() {
        LocalDate localDate=LocalDate.now();
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkInDateFromDoktor = localDate.format(duzenliDateStart);
        us12_pages.fromDateDoktorHastaSecimi.sendKeys(checkInDateFromDoktor);
        reusableMethods.waitFor(1);

        LocalDate checkInDateDoktorIleriTarih= localDate.plusDays(14);
        String checkInDateToDoktor = checkInDateDoktorIleriTarih.format(duzenliDateStart);
        us12_pages.toDateDoktorHastaSecimi.sendKeys(checkInDateToDoktor);
        reusableMethods.waitFor(10);

        us12_pages.doktorEditBolumu.click();
        reusableMethods.waitFor(5);
    }
    @Then("EA Create  or Edit an Appointment yazisinin gorunurlugu dogrulanir")
    public void ea_create_or_edit_an_appointment_yazisinin_gorunurlugu_dogrulanir() {
        Assert.assertTrue(us12_pages.doktorCreateOrEditTtextBox.isDisplayed());
        reusableMethods.waitFor(2);
    }
    @Then("EA Kullanici\\(Doktor) Request A Test bolumune tiklar")
    public void ea_kullanici_doktor_request_a_test_bolumune_tiklar() {
        us12_pages.doktorRequestATestButton.click();
        reusableMethods.waitFor(2);
    }
    @Then("EA Test Items yazisinin gorunurlugu dogrulanir")
    public void ea_test_ıtems_yazisinin_gorunurlugu_dogrulanir() {
        Assert.assertTrue(us12_pages.doktorTestItemsTextBox.isDisplayed());
    }

    ////US0012-TC006

    @Then("EA Urea testi secer")
    public void ea_urea_testi_secer() {
        us12_pages.testsUrea.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsUrea.isSelected());
    }
    @Then("EA Creatinine testi secer")
    public void ea_creatinine_testi_secer() {
        us12_pages.testsCreatine.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsCreatine.isSelected());
    }
    @Then("EA Sodium testi secer")
    public void ea_sodium_testi_secer() {
        us12_pages.testsSodium.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsSodium.isSelected());
        reusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }
    @Then("EA Potassium testi secer")
    public void ea_potassium_testi_secer() {
        reusableMethods.waitFor(2);
        us12_pages.testsPotassium.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsPotassium.isSelected());
    }
    @Then("EA Total protein	 testi secer")
    public void ea_total_protein_testi_secer() {
        us12_pages.testsTotalProtein.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsTotalProtein.isSelected());
    }
    @Then("EA Hemoglobin testi secer")
    public void ea_hemoglobin_testi_secer() {
        us12_pages.testsHemoglobin.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsHemoglobin.isSelected());
    }
    @Then("EA Albumin testi secer")
    public void ea_albumin_testi_secer() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(2);
        us12_pages.testsAlbumin.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsAlbumin.isSelected());
    }
    @Then("EA Glucose testi secer")
    public void ea_glucose_testi_secer() {
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(2);
        us12_pages.testsGlucose.click();
        reusableMethods.waitFor(2);
        Assert.assertTrue(us12_pages.testsGlucose.isSelected());
        actions.sendKeys(Keys.END).sendKeys(Keys.PAGE_UP).perform();
        reusableMethods.waitFor(2);
    }
    @Then("EA Save  butonuna tiklar")
    public void ea_save_butonuna_tiklar() {
        us12_pages.testsSaveButton.click();
        reusableMethods.waitFor(2);
    }
    @Then("EA Testlerin kaydedildigi kontrol edilir")
    public void ea_testlerin_kaydedildigi_kontrol_edilir() {

        Assert.assertTrue(us12_pages.alertButton.isDisplayed());
    }


}
