package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.US05_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

public class US05_stepdefinitions
{
    US05_pages us05_pages = new US05_pages();
    public static Faker faker = new Faker();
    String firstname;
    String lastname;
    String ssn;
    String email;
    String phone;
    String username;
    String password;

    @Given("TY kullanici signIn olur")
    public void ty_kullanici_sign_ın_olur()
    {
        us05_pages.login("TYPatientUsername","TYPatientPassword");
    }

    @Then("TY kullanici signIn isleminin barasili olarak gerceklestigini dogrular")
    public void tyKullaniciSignInIslemininBarasiliOlarakGerceklestiginiDogrular()
    {
        JSUtils.clickElementByJS(us05_pages.profileIcon);
        us05_pages.profileIcon.click();
        Assert.assertTrue(us05_pages.loginPageSignOutButton.isDisplayed());
    }

    @Then("TY kullanici My Pages Butonuna Tiklar ve Menu'den 'Make An Appointment' Secenegini Secer")
    public void ty_kullanici_my_pages_butonuna_tiklar_ve_menu_den_make_an_appointment_secenegini_secer()
    {
        JSUtils.clickElementByJS(us05_pages.myPagesButtonu);
        JSUtils.clickElementByJS(us05_pages.loginPageMakeAnAppointmentButtonu);
        String expectedAppointmentHeader = ConfigReader.getProperty("TYexpectedAppointmentHeader");
        Assert.assertEquals(expectedAppointmentHeader,us05_pages.loginPageMakeAnAppointmentHeader.getText());
    }

    @Then("TY First Name Textbox'inda Yazan Kullanici Adi ile Login Islemini Gerceklestiren Kullanici Adinin Ayni Oldugu Test Edilir")
    public void ty_first_name_textbox_inda_yazan_kullanici_adi_ile_login_ıslemini_gerceklestiren_kullanici_adinin_ayni_oldugu_test_edilir()
    {
        String expectedFirstName = ConfigReader.getProperty("TYPatientFirstname");
        Assert.assertEquals(expectedFirstName,us05_pages.loginPageFirstnameTextBox.getAttribute("value"));
        us05_pages.logout();
    }

    @Given("TY Last Name Textbox'inda Yazan Kullanici Adi ile Login Islemini Gerceklestiren Kullanici Soyadinin Ayni Oldugu Test Edilir")
    public void ty_last_name_textbox_inda_yazan_kullanici_adi_ile_login_ıslemini_gerceklestiren_kullanici_soyadinin_ayni_oldugu_test_edilir()
    {
        String expectedLastName = ConfigReader.getProperty("TYPatientLastname");
        Assert.assertEquals(expectedLastName,us05_pages.loginPageLastnameTextBox.getAttribute("value"));
        us05_pages.logout();
    }


    @Given("TY SSN Textbox'inda Yazan SSN ile Login Islemini Gerceklestiren Kullanici SSN bilgisinin Ayni Oldugu Test Edilir")
    public void ty_ssn_textbox_inda_yazan_ssn_ile_login_ıslemini_gerceklestiren_kullanici_ssn_bilgisinin_ayni_oldugu_test_edilir()
    {
       String expectedSSN = ConfigReader.getProperty("TYPatientSSN");
       Assert.assertEquals(expectedSSN,us05_pages.loginPageSSNTextBox.getAttribute("value"));
       us05_pages.logout();
    }


    @Given("TY email Textbox'inda Yazan email ile Login Islemini Gerceklestiren Kullanici email bilgisinin Ayni Oldugu Test Edilir")
    public void ty_email_textbox_inda_yazan_email_ile_login_ıslemini_gerceklestiren_kullanici_email_bilgisinin_ayni_oldugu_test_edilir()
    {
        String expectedEmail = ConfigReader.getProperty("TYPatientEmail");
        Assert.assertEquals(expectedEmail,us05_pages.loginPageEmailTextBox.getAttribute("value"));
        us05_pages.logout();
    }

    @And("TY kullanici phone textbox'ini invalid {string} ile doldurur ve invalid phone number uyarısı alır")
    public void tyKullaniciPhoneTextboxIniInvalidIleDoldururVeInvalidPhoneNumberUyarısıAlır(String phone)
    {

        us05_pages.loginPagePhoneTextBox.sendKeys(phone + Keys.ENTER);
        ReusableMethods.waitFor(1);
        String expectedErrorLine = ConfigReader.getProperty("TYPhoneExpectedError1");
        Assert.assertEquals(expectedErrorLine,us05_pages.loginPagePhoneErrorLine1.getText());
        us05_pages.loginPagePhoneTextBox.clear();
        us05_pages.logout();

    }

    @Given("TY kullanici signOut olur")
    public void tyKullaniciSignOutOlur()
    {
        us05_pages.logout();
    }

    @And("TY kullanici phone textbox'ini bos birakir ve Phone number is required uyarisini alir")
    public void tyKullaniciPhoneTextboxIniBosBirakirVePhoneNumberIsRequiredUyarisiniAlir()
    {
        us05_pages.loginPagePhoneTextBox.sendKeys(" " + Keys.TAB);
        ReusableMethods.waitFor(1);
        String expectedErrorLine = ConfigReader.getProperty("TYPhoneExpectedError2");
        Assert.assertEquals(expectedErrorLine,us05_pages.loginPagePhoneErrorLine2.getText());
        us05_pages.loginPagePhoneTextBox.clear();
    }

    @And("TY kullanici phone textbox'ini valid bir deger ile doldurur ve Send An Appointment butonuna basar")
    public void tyKullaniciPhoneTextboxIniValidBirDegerIleDoldururVeSendAnAppointmentButonunaBasar()
    {
        us05_pages.loginPagePhoneTextBox.sendKeys(ConfigReader.getProperty("TYValidPhoneNumber") );
        JSUtils.clickElementByJS(us05_pages.loginPageSendAnAppointmentRequestButton);
        // bazen basmayabiliyormus, tikanirsa burayi keys enter yaparsın ??????????????????
    }


    @Then("TY kullanici randevunun basarili bir sekilde kaydedildigini cikan popup ile dogrular")
    public void ty_kullanici_randevunun_basarili_bir_sekilde_kaydedildigini_cikan_popup_ile_dogrular()
    {
        String expectedAlertYazısı = ConfigReader.getProperty("TYBasariliAlertYazisi");
        Assert.assertEquals(expectedAlertYazısı, us05_pages.alertText.getAttribute("innerText"));
        us05_pages.logout();
    }

    @Given("TY kullanici My Pages Butonuna Tiklar ve Menu'den My Appointment Secenegini Secer")
    public void tyKullaniciMyPagesButonunaTiklarVeMenuDenMyAppointmentSeceneginiSecer()
    {
        JSUtils.clickElementByJS(us05_pages.myPagesButtonu);
        JSUtils.clickElementByJS(us05_pages.loginPageMyAppointmentsButtonu);


    }

    @Then("TY kullanici randevusunun olustugunu dogrular")
    public void tyKullaniciRandevusununOlustugunuDogrular()
    {
        //bunu nasıl dogrulayacagımı bilmiyorum, sor!!!
        us05_pages.logout();
    }

    // -------------------------------------------

    @Given("TY kullanici url'e gider")
    public void tyKullaniciUrlEGider()
    {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
    }

    @Then("TY kullanici Make an Appointment butonuna tiklar")
    public void tyKullaniciMakeAnAppointmentButonunaTiklar()
    {
        JSUtils.clickElementByJS(us05_pages.mainpageMakeAnAppointmentButtonu);
    }

    @And("TY kullanici Send an Appointment Request butonunu gorene kadar sayfayi kaydirir")
    public void tyKullaniciSendAnAppointmentRequestButonunuGoreneKadarSayfayiKaydirir()
    {
        JSUtils.scrollIntoVIewJS(us05_pages.mainpageSendAnAppointmentRequestButton);
    }

    @Then("TY kullanici First Name kutusuna tiklar ve tab karakterine basar")
    public void tyKullaniciFirstNameKutusunaTiklarVeTabKarakterineBasar()
    {
        JSUtils.clickElementByJS(us05_pages.mainpageFirstnameTextBox);
        us05_pages.mainpageFirstnameTextBox.sendKeys(Keys.TAB);
    }

    @And("TY kullanici Firstname'in altinda Your FirstName is required. yazisini gorur")
    public void tyKullaniciFirstnameInAltindaYourFirstNameIsRequiredYazisiniGorur()
    {
        Assert.assertTrue(us05_pages.mainpageFirstnameErrorLine.isDisplayed());
        String expectedFirstnameError = ConfigReader.getProperty("TYFirstnameExpectedError");
        Assert.assertEquals(expectedFirstnameError,us05_pages.mainpageFirstnameErrorLine.getText());
    }

    @Given("TY kullanici Last Name kutusuna tiklar ve tab karakterine basar")
    public void tyKullaniciLastNameKutusunaTiklarVeTabKarakterineBasar()
    {
        JSUtils.clickElementByJS(us05_pages.mainpageLastnameTextBox);
        us05_pages.mainpageLastnameTextBox.sendKeys(Keys.TAB);
    }

    @Then("TY kullanici Lastname'in altinda Your LastName is required. yazisini gorur")
    public void tyKullaniciLastnameInAltindaYourLastNameIsRequiredYazisiniGorur()
    {
        Assert.assertTrue(us05_pages.mainpageLastnameErrorLine.isDisplayed());
        String expectedLastnameError = ConfigReader.getProperty("TYLastnameExpectedError");
        Assert.assertEquals(expectedLastnameError,us05_pages.mainpageLastnameErrorLine.getText());
    }

    @Given("TY kullanici SSN kutusuna tiklar ve tab karakterine basar")
    public void tyKullaniciSSNKutusunaTiklarVeTabKarakterineBasar()
    {
        JSUtils.clickElementByJS(us05_pages.mainpageSSNTextBox);
        us05_pages.mainpageSSNTextBox.sendKeys(Keys.TAB);
    }

    @Then("TY kullanici SSN'in altinda Your SSN is required. yazisini gorur")

    public void tyKullaniciSSNInAltindaYourSSNIsRequiredYazisiniGorur()
    {
        Assert.assertTrue(us05_pages.mainpageSSNErrorLine.isDisplayed());
        String expectedSSNError = ConfigReader.getProperty("TYSSNExpectedError");
        Assert.assertEquals(expectedSSNError,us05_pages.mainpageSSNErrorLine.getText());
    }


    @Given("TY kullanici Email kutusuna tiklar ve tab karakterine basar")
    public void ty_kullanici_email_kutusuna_tiklar_ve_tab_karakterine_basar()
    {
        JSUtils.clickElementByJS(us05_pages.mainpageEmailTextBox);
        us05_pages.mainpageEmailTextBox.sendKeys(Keys.TAB);
    }

    @Then("TY kullanici Email'in altinda Your email is required. yazisini gorur")
    public void tyKullaniciEmailInAltindaYourEmailIsRequiredYazisiniGorur()
    {
        Assert.assertTrue(us05_pages.mainpageEmailErrorLine.isDisplayed());
        String expectedEmailError = ConfigReader.getProperty("TYEmailExpectedError1");
        Assert.assertEquals(expectedEmailError,us05_pages.mainpageEmailErrorLine.getText());
    }

    @Then("TY kullanici @ ve . icermeyen gecersiz bir mail girer")
    public void ty_kullanici_ve_icermeyen_gecersiz_bir_mail_girer()
    {
        us05_pages.mainpageEmailTextBox.sendKeys(ConfigReader.getProperty("TYInvalidEmail"));
    }

    @Then("TY kullanici Email'in altinda This field is invalid yazisini gorur")
    public void ty_kullanici_email_in_altinda_this_field_is_invalid_yazisini_gorur()
    {
        Assert.assertTrue(us05_pages.mainpageEmailErrorLine.isDisplayed());
        String expectedEmailError = ConfigReader.getProperty("TYEmailExpectedError2");
        Assert.assertEquals(expectedEmailError,us05_pages.mainpageEmailErrorLine.getText());
    }

    @Given("TY kullanici Phone kutusuna tiklar ve tab karakterine basar")
    public void tyKullaniciPhoneKutusunaTiklarVeTabKarakterineBasar()
    {
        JSUtils.clickElementByJS(us05_pages.mainpagePhoneTextBox);
        us05_pages.mainpagePhoneTextBox.sendKeys(Keys.TAB);
    }

    @Then("TY kullanici Phone'in altinda Phone number is required. yazisini gorur")
    public void tyKullaniciPhoneInAltindaPhoneNumberIsRequiredYazisiniGorur()
    {
        Assert.assertTrue(us05_pages.mainpagePhoneErrorLine.isDisplayed());
        String expectedPhoneError = ConfigReader.getProperty("TYPhoneExpectedError2");
        Assert.assertEquals(expectedPhoneError,us05_pages.mainpagePhoneErrorLine.getText());
    }

    @Given("TY kullanici First Name kutusunu doldurur")
    public void tyKullaniciFirstNameKutusunuDoldurur()
    {

        firstname = faker.name().name();
        us05_pages.mainpageFirstnameTextBox.sendKeys(firstname);
    }

    @And("TY kullanici Last Name kutusunu doldurur")
    public void tyKullaniciLastNameKutusunuDoldurur()
    {
        lastname = faker.name().lastName();
        us05_pages.mainpageLastnameTextBox.sendKeys(lastname);
    }

    @And("TY kullanici SSN kutusunu doldurur")
    public void tyKullaniciSSNKutusunuDoldurur()
    {
        ssn = faker.idNumber().ssnValid();
        us05_pages.mainpageSSNTextBox.sendKeys(ssn);
    }

    @And("TY kullanici Email kutusunu valid bir deger ile doldurur")
    public void tyKullaniciEmailKutusunuValidBirDegerIleDoldurur()
    {
        email = faker.internet().emailAddress();
        us05_pages.mainpageEmailTextBox.sendKeys(email);
    }

    @And("TY kullanici Phone kutusunu doldurur")
    public void tyKullaniciPhoneKutusunuDoldurur()
    {

        phone = ConfigReader.getProperty("TYValidPhoneNumber");
        //phone = faker.phoneNumber().subscriberNumber(10);
        // burada cell phone ya da phone secince formata uygun olmuyor
        // subscriberNumber(10) 10 karakterli rakam gonderiyor ancak - ler olmadigi icin phone numberi
        // config readerdan gonderecegim, hep ayni numarayi kullanmis olacagim
        us05_pages.mainpagePhoneTextBox.sendKeys(phone);
    }

    @Then("TY kullanici enter tusuna basar")
    public void tyKullaniciEnterTusunaBasar()
    {
        us05_pages.mainpagePhoneTextBox.sendKeys(Keys.ENTER);
    }

    @When("TY kullanici register butonuna tiklar ve randevu alirken kullandigi bilgiler ile formu doldurarak kayit olur")
    public void tyKullaniciRegisterButonunaTiklarVeRandevuAlirkenKullandigiBilgilerIleFormuDoldurarakKayitOlur()
    {

        System.out.println("bakalım ssn in fakerdan gelen degeri mi tutulmus:" + ssn);
       JSUtils.clickElementByJS(us05_pages.profileIcon);
       JSUtils.clickElementByJS(us05_pages.registerElementi);
       Assert.assertTrue(us05_pages.registrationHeader.isDisplayed());
       us05_pages.registrationPageSSN.sendKeys(ssn);
       us05_pages.registrationPageFirstname.sendKeys(firstname);
       us05_pages.registrationPageLastname.sendKeys(lastname);
       username = faker.name().username();
       us05_pages.registrationPageUsername.sendKeys(username);
       us05_pages.registrationPageEmail.sendKeys(email);
       password = faker.internet().password();
       us05_pages.registrationPageNewPassword.sendKeys(password);
       us05_pages.registrationPageNewPasswordConfirmation.sendKeys(password);

       JSUtils.clickElementByJS(us05_pages.registrationPageRegisterButton);


    }

    @Then("TY kullanici TY kullanici randevusunun olustugunu cikan popup ile dogrular")
    public void tyKullaniciTYKullaniciRandevusununOlustugunuCikanPopupIleDogrular()
    {
        String expectedAlertYazısı = ConfigReader.getProperty("TYBasariliAlertYazisi");
        Assert.assertEquals(expectedAlertYazısı, us05_pages.alertText.getAttribute("innerText"));
    }



}

