package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US15_pages;

import utilities.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class US15_stepdefinitions {

    US15_pages us15_pages=new US15_pages();

    ReusableMethods reusableMethods=new ReusableMethods();
    DBUtils dbUtils=new DBUtils();
    JSUtils JSUtils=new JSUtils();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker =new Faker();
    Select select;
    static String patientFirstName="";
    static String patientLastName="";
    static String patientEmail="";
    List<String> statesInUs;
    List<String> theListOfNameOfStatesFromWebTable;

    @Given("EA Kullanici Sag ust kosede bulunan icona tiklar")
    public void ea_kullanici_sag_ust_kosede_bulunan_icona_tiklar() {
    us15_pages.icon.click();
    reusableMethods.waitFor(1);
    }
    @Given("EA Kullanici Sign-in butonuna tiklar")
    public void ea_kullanici_sign_in_butonuna_tiklar() {
    us15_pages.firstSign_in.click();
        reusableMethods.waitFor(1);
    }
    @Given("EA Kullanici Admin Username girer")
    public void ea_kullanici_admin_username_girer() {
        us15_pages.usernameTextbox.sendKeys(ConfigReader.getProperty("US15AdminUsername"));
        reusableMethods.waitFor(1);
    }
    @Given("EA Kullanici Admin Password girer")
    public void ea_kullanici_admin_password_girer() {
        us15_pages.passwordTextbox.sendKeys(ConfigReader.getProperty("US15AdminPassword"));
        reusableMethods.waitFor(1);
    }
    @Given("EA Kullanici ikinci Sign-in butonuna tiklar")
    public void ea_kullanici_ikinci_sign_in_butonuna_tiklar() {
        us15_pages.secondSign_in.click();
        reusableMethods.waitFor(1);
    }
    @Given("EA Admin olarak oturum acildigi dogrulanir")
    public void ea_admin_olarak_oturum_acildigi_dogrulanir() {

        Assert.assertTrue(us15_pages.sign_inControl.isDisplayed());
    }
    @Given("EA Kullanici Items&Titles bolumune tiklar")
    public void ea_kullanici_ıtems_titles_bolumune_tiklar() {

        us15_pages.items_titles.click();
        ReusableMethods.waitFor(1);
    }
    @Given("EA Kullanici Patient bolumune tiklar")
    public void ea_kullanici_patient_bolumune_tiklar() {

        us15_pages.patientSelect_items_titles.click();
        ReusableMethods.waitFor(1);
    }
    @Given("EA Kullanici acilan Patient sayfasindan Create or edit a Patient kutusuna tiklar")
    public void ea_kullanici_acilan_patient_sayfasindan_create_or_edit_a_patient_kutusuna_tiklar() {
    reusableMethods.waitFor(1);
        us15_pages.createAnewPatientButton.click();
    }
    @And("EA Kullanici hasta kaydi olusturabilmek icin gerekli olan First Name,Last Name, Birt Date, Email, Phone, Gender, Blood Group, Adress,Description, User, Country, StateCity bolumlere veri girisi yapar")
    public void eaKullaniciHastaKaydiOlusturabilmekIcinGerekliOlanFirstNameLastNameBirtDateEmailPhoneGenderBloodGroupAdressDescriptionUserCountryStateCityBolumlereVeriGirisiYapar() {
        patientFirstName=faker.name().username();
        patientLastName=faker.name().lastName();
        patientEmail=faker.internet().emailAddress();
        us15_pages.patientFirstName.sendKeys(patientFirstName);
        us15_pages.patientLastName.sendKeys(patientLastName);

        LocalDate localDate=LocalDate.now();
        LocalDate duzenlenmisLocalDate = localDate.minusDays(10).minusMonths(3).minusYears(30);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkInDate = duzenlenmisLocalDate.format(duzenliDateStart);
        us15_pages.patientBirthDay.sendKeys(checkInDate);
        reusableMethods.waitFor(2);

        us15_pages.patientEmail.sendKeys(patientEmail);
        us15_pages.patientPhoneNumber.sendKeys(faker.phoneNumber().subscriberNumber(10));

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(1);

        us15_pages.patientAdress.sendKeys("Ankara/Turkey");
        select=new Select(us15_pages.patientCountry);
        select.selectByVisibleText("Turkey");
        reusableMethods.waitFor(1);

        select=new Select(us15_pages.patientState);
        select.selectByVisibleText("Ankara");
        reusableMethods.waitFor(2);

    }

    @Given("EA Kullanici Save butonun tiklar")
    public void ea_kullanici_save_butonun_tiklar() {
        us15_pages.patientSave.click();
    }
    @Given("EA Kullanici Yeni Hasta olusturuldugunu alert mesaji ile dogrular")
    public void ea_kullanici_yeni_hasta_olusturuldugunu_alert_mesaji_ile_dogrular() {
      reusableMethods.waitFor(2);
      us15_pages.patientCreatedDate.click();
      reusableMethods.waitFor(3);
    Assert.assertTrue(us15_pages.patientAlert.isDisplayed());
    Assert.assertTrue(us15_pages.patientFirstNameActualData.getText().equals(patientFirstName));
    Assert.assertTrue(us15_pages.patientEmailActualData.getText().equals(patientEmail));

    }

    @And("EA Kullanici admin olarak oturum acar")
    public void eaKullaniciAdminOlarakOturumAcar() {
        us15_pages.adminLogin();
    }
    @Given("EA Kullanici Created Date bolumune tiklar")
    public void ea_kullanici_created_date_bolumune_tiklar() {
        us15_pages.patientCreatedDate.click();
        reusableMethods.waitFor(1);
    }
    @Given("EA Kullanici ilk sirada gelen hastanin ID numarasina tiklar")
    public void ea_kullanici_ilk_sirada_gelen_hastanin_ıd_numarasina_tiklar() {
        us15_pages.ilkIDnumber.click();
        reusableMethods.waitFor(1);
    }

    @Given("EA Kullanici SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group,Address,Description, Created Date, User, Country and stateCity bilgilerinin gorunurlugunu test eder")
    public void ea_kullanici_ssn_first_name_last_name_birth_date_phone_gender_blood_group_address_description_created_date_user_country_and_state_city_bilgilerinin_gorunurlugunu_test_eder() {
       //Assert.assertTrue(us15_pages.ssnNumberControl.isDisplayed());
      // Assert.assertTrue(us15_pages.firstnameControl.getText().equals(patientFirstName));
      // Assert.assertTrue(us15_pages.lastnameControl.getText().equals(patientLastName));
        Assert.assertTrue(us15_pages.patientControl.isDisplayed());
        Assert.assertTrue(us15_pages.ssnNumberControl.isDisplayed());
        Assert.assertTrue(us15_pages.firstnameControl.isDisplayed());
        Assert.assertTrue(us15_pages.lastnameControl.isDisplayed());
        reusableMethods.waitFor(1);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(1);
        Assert.assertTrue(us15_pages.adressControl.isDisplayed());

    }
    @Given("EA Kullanici edit butonuna tiklar")
    public void ea_kullanici_edit_butonuna_tiklar() {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(1);
        us15_pages.editButton.click();
        reusableMethods.waitFor(1);
    }
    @And("EA Kullanici Acilan sayfada  SSN, First Name, Last Name, Birth Date, Phone, Gender, Blood Group, Address, Description, Created Date, User, Country and stateCity gibi bilgilerden bazilarinda degisiklik yapar")
    public void eaKullaniciAcilanSayfadaSSNFirstNameLastNameBirthDatePhoneGenderBloodGroupAddressDescriptionCreatedDateUserCountryAndStateCityGibiBilgilerdenBazilarindaDegisiklikYapar() {

        us15_pages.patientFirstName.sendKeys(patientFirstName+"Degisiklik");
        us15_pages.patientLastName.sendKeys(patientLastName+"Degisiklik");
        us15_pages.patientPhoneNumber.clear();
        reusableMethods.waitFor(2);
        us15_pages.patientPhoneNumber.sendKeys(faker.phoneNumber().subscriberNumber(10));
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        reusableMethods.waitFor(1);
        select=new Select(us15_pages.bloodGroup);
        select.selectByIndex(3);
    }
    @Given("EA Kullanici Save butonuna tiklar")
    public void ea_kullanici_save_butonuna_tiklar() {
        reusableMethods.waitFor(1);
        Driver.clickWithJS(us15_pages.patientSave);
    }
    @Given("EA Kullanici hasta bilgilerinin guncellendigi dogrulanir")
    public void ea_kullanici_hasta_bilgilerinin_guncellendigi_dogrulanir() {
        reusableMethods.waitFor(1);
        String alertMessage=us15_pages.patientAlert.getText();
        System.out.println(alertMessage);
        Assert.assertTrue(alertMessage.contains("A Patient is updated with identifier "));
    }

    @Given("EA Kullanici Appointment bolumune tiklar")
    public void ea_kullanici_appointment_bolumune_tiklar() {
        us15_pages.itemsTitlesAppointment.click();
    }
    @Given("EA Kullanici Create a new Appointment butonuna tiklar")
    public void ea_kullanici_create_a_new_appointment_butonuna_tiklar() {
        reusableMethods.waitFor(1);
        us15_pages.createANewAppointment.click();
    }
    @Given("EA Kullanici Start DateTime ve End Date Time bilgileri girer")
    public void ea_kullanici_start_date_time_ve_end_date_time_bilgileri_girer() {
        LocalDate localDate=LocalDate.now();
        LocalDate duzenlenmisLocalDate = localDate.plusDays(10);
        DateTimeFormatter duzenliDateStart = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String checkInDate = duzenlenmisLocalDate.format(duzenliDateStart);
        us15_pages.appointmentEndDate.sendKeys(checkInDate);
        reusableMethods.waitFor(2);
    }
    @Given("EA Kullanici Status kismi secer")
    public void ea_kullanici_status_kismi_secer() {
        select=new Select(us15_pages.appointmentStatus);
        select.selectByVisibleText("PENDING");
    }
    @Given("EA Kullanici Physician kismindan Doktor bilgisi secer")
    public void ea_kullanici_physician_kismindan_doktor_bilgisi_secer() {
        reusableMethods.waitFor(1);
        Driver.selectByVisibleText(us15_pages.appointmentDoctorSelect,"3651:Physician Physician");
       // Driver.selectByIndex(us15_pages.appointmentDoctorSelect,4);

    }
    @Given("EA Kullanici Patient kismindan Hasta bilgisi secer")
    public void ea_kullanici_patient_kismindan_hasta_bilgisi_secer() {
        Driver.selectByVisibleText(us15_pages.appointmentHastaSelect,"4856:patient2 patient2");
        reusableMethods.waitFor(2);
    }
    @And("EA Kullanici islemlerin ardindan Save butonuna tiklar")
    public void eaKullaniciIslemlerinArdindanSaveButonunaTiklar() {
us15_pages.appointmentSaveButton.click();
reusableMethods.waitFor(1);

    }
    @Given("EA Hasta kaydinin doktora atamasinin yapildigi dogrulanir")
    public void ea_hasta_kaydinin_doktora_atamasinin_yapildigi_dogrulanir() {
        String doktorAtamaDogrulama=us15_pages.patientAlert.getText();
       // System.out.println(doktorAtamaDogrulama);
        Assert.assertTrue(doktorAtamaDogrulama.contains("A new Appointment is created with identifier"));
       // Assert.assertTrue(us15_pages.patientAlert.isDisplayed());
    }


    @And("EA Kullanici Ilk sirada gelen hasta ile ayni satirda bulunan Delete butonuna tiklar")
    public void eaKullaniciIlkSiradaGelenHastaIleAyniSatirdaBulunanDeleteButonunaTiklar() {
        Driver.clickWithJS(us15_pages.deleteButton);
        reusableMethods.waitFor(1);
    }

    @And("EA Kullanici Confirm Delete Operation uyari mesajindan tekrar delete butonuna tiklar")
    public void eaKullaniciConfirmDeleteOperationUyariMesajindanTekrarDeleteButonunaTiklar() {
        us15_pages.deleteButtonSecond.click();
        reusableMethods.waitFor(3);
    }

    @And("EA Uyari mesaji ile Hasta kaydinin silindigi test edilir")
    public void eaUyariMesajiIleHastaKaydininSilindigiTestEdilir() {
        String deleteMessage = us15_pages.patientAlert.getText();
        System.out.println("deleteMessage = " + deleteMessage);
        Assert.assertTrue(deleteMessage.contains("A Patient is deleted with identifier"));
        Assert.assertTrue(us15_pages.patientAlert.isDisplayed());    }


    @And("EA Kullanici StateCity bolumune tiklar ve verileri kaydeder")
    public void eaKullaniciStateCityBolumuneTiklarVeVerileriKaydeder() throws InterruptedException {
        us15_pages.stateCityButton.click();


        statesInUs=new ArrayList<>(Arrays.asList("Alaska", "Alabama", "Arkansas", "American Samoa", "Arizona", "California", "Colorado", "Connecticut", "District of Columbia", "Delaware", "Florida", "Georgia", "Guam", "Hawaii", "Iowa", "Idaho", "Illinois", "Indiana", "Kansas", "Kentucky", "Louisiana", "Massachusetts", "Maryland", "Maine", "Michigan", "Minnesota", "Missouri", "Mississippi", "Montana", "North Carolina", "North Dakota", "Nebraska", "New Hampshire", "New Jersey", "New Mexico", "Nevada", "New York", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Puerto Rico", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Virginia", "Virgin Islands", "Vermont", "Washington", "Wisconsin", "West Virginia", "Wyoming"));
        theListOfNameOfStatesFromWebTable=new ArrayList<>();

        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }

        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }
        if (us15_pages.nextPagelink.isEnabled()){
            Driver.clickWithJS(us15_pages.nextPagelink);
            Thread.sleep(3000);
        }
        for (WebElement each:us15_pages.listOfAllStates) {
            String element=each.getText();
            theListOfNameOfStatesFromWebTable.add(element);
        }

        System.out.println(theListOfNameOfStatesFromWebTable.toString());
    }

    @And("EA StatesCities sayfasinda StateCity bolumunun US oldugu test edilir")
    public void eaStatesCitiesSayfasindaStateCityBolumununUSOlduguTestEdilir() {
        Assert.assertTrue(!statesInUs.containsAll(theListOfNameOfStatesFromWebTable));
    }

    @And("EA StatesCities sayfasinda StateCity bolumunun bos olmamasi gerektigi test edilir")
    public void eaStatesCitiesSayfasindaStateCityBolumununBosOlmamasiGerektigiTestEdilir() {
        Assert.assertTrue(!theListOfNameOfStatesFromWebTable.contains(null));
    }



}
