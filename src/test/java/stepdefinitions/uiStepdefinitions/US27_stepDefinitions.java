package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.poi.ss.formula.atp.Switch;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.US05_pages;
import pages.US16_pages;
import pages.US27_WebTablePage;
import utilities.*;
import io.cucumber.datatable.DataTable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;
import static pages.ObjectInitializer.us05_pages;
import static pages.US16_pages.*;

public class US27_stepDefinitions
{


    US05_pages us05_pages = new US05_pages();
    US16_pages us16_pages = new US16_pages();
    US27_WebTablePage us27_webTablePage = new US27_WebTablePage();
    public static Faker faker = new Faker();
    public static Actions actions = new Actions(Driver.getDriver());
    static String name;
    static String email;
    static String subject;
    static String message;
    static String messageID;
    static WebElement messageIDElementi;


    @Given("TY Kullanici URL Adresine Gider ve {string} Olarak Sign In Olur")
    public void tyKullaniciURLAdresineGiderVeOlarakSignInOlur(String role)
    {
        us05_pages.login("TY"+role+"Username","TY"+role+"Password");
    }
    @Then("TY Kullanici Sign-In Isleminin Basarili Olarak Gerceklestigini Dogrular")
    public void ty_kullanici_sign_ın_ısleminin_basarili_olarak_gerceklestigini_dogrular()
    {
        JSUtils.clickElementByJS(us05_pages.profileIcon);
        us05_pages.profileIcon.click();
        Assert.assertTrue(us05_pages.loginPageSignOutButton.isDisplayed());
    }
    @Then("TY Kullanici Navigation Bar'dan {string} a Tiklar")
    public void tyKullaniciNavigationBarDanATiklar(String item)
    {
        selectNavigationBarItem(item);
    }
    @Then("TY Kullanici Acilan Dropdown Menuden {string} Secenegine Tiklar")
    public void tyKullaniciAcilanDropdownMenudenSecenegineTiklar(String item)
    {
        selectDropdownItem(item);
    }
    @And("TY Kullanici {string} Sayfasinin Acildigini Dogrular")
    public void tyKullaniciSayfasininAcildiginiDogrular(String secim)
    {
        String expectedHeader = ConfigReader.getProperty("TY" + secim + "ExpectedHeader");
        String actualHeader = us16_pages.acilanSayfaHeader.getText();
        Assert.assertEquals(expectedHeader,actualHeader);
    }
    @Then("TY Kullanici Messages Tablosunda Title Basliklarinin Oldugunu Dogrular")
    public void tyKullaniciMessagesTablosundaTitleBasliklarininOldugunuDogrular(io.cucumber.datatable.DataTable dataTable)
    {
        List<String > headerTitleDataList = dataTable.row(0);
        List<String > headerDatalariList = new ArrayList<>();

        for (WebElement each : us27_webTablePage.headerDatalariList)
        {
            headerDatalariList.add(each.getText());
        }

        for(String each : headerTitleDataList)
           {
               Assert.assertTrue(headerDatalariList.contains(each));
           }
    }
    @Then("TY Kullanici Random Data Ile Yeni Mesaj Olusturur")
    public void tyKullaniciRandomDataIleYeniMesajOlusturur()
    {
        JSUtils.clickElementByJS(us16_pages.createANewMessageButton);
        name = faker.name().firstName();
        email = faker.internet().emailAddress();
        subject = faker.lorem().sentence();
        message = faker.lorem().sentence();
        credentialWebElement("Name").sendKeys(name);
        credentialWebElement("Email").sendKeys(email);
        credentialWebElement("Subject").sendKeys(subject);
        credentialWebElement("Message").sendKeys(message);
        JSUtils.clickElementByJS(us16_pages.createANewMessagePageSaveButton);
    }
    @Then("TY Kullanici  Olusturulan Bu Mesajin ID Numarasini Kaydeder")
    public void ty_kullanici_olusturulan_bu_mesajin_ıd_numarasini_kaydeder()
    {
        String toastifyText = us16_pages.toastifyContainer.getAttribute("innerText");
        messageID = toastifyText.substring(toastifyText.length()-5);

    }
    @Then("TY Kullanici Message Table Header'da ID Alanina Tiklayarak Mesajlari En Son Olusturulandan Baslayarak Siralar")
    public void ty_kullanici_message_table_header_da_ıd_alanina_tiklayarak_mesajlari_en_son_olusturulandan_baslayarak_siralar()
    {
        selectHeaderItem("ID");
    }
    @And("TY Kullanici Message Table'da Ilk Satida Yer Alan Datalarin Mesaj Olusturuken Kullandigi Datalar Oldugunu Dogrular")
    public void tyKullaniciMessageTableDaIlkSatidaYerAlanDatalarinMesajOlusturukenKullandigiDatalarOldugunuDogrular(io.cucumber.datatable.DataTable dataTable)
    {
        List<String > headerTitleDataList = dataTable.row(0);
        String ecpectedMessage;
        for (String each : headerTitleDataList)
        {
            switch(each)
            {
                case "ID":
                    ecpectedMessage = us27_webTablePage.hucreWebElementGetir(1,1);
                    Assert.assertEquals(messageID,ecpectedMessage);
                    break;
                case "Name":
                    ecpectedMessage = us27_webTablePage.hucreWebElementGetir(1,2);
                    Assert.assertEquals(name,ecpectedMessage);
                    break;
                case "Email":
                    ecpectedMessage = us27_webTablePage.hucreWebElementGetir(1,3);
                    Assert.assertEquals(email,ecpectedMessage);
                    break;
                case "Subject":
                    ecpectedMessage = us27_webTablePage.hucreWebElementGetir(1,4);
                    Assert.assertEquals(subject,ecpectedMessage);
                    break;
                case "Message":
                    ecpectedMessage = us27_webTablePage.hucreWebElementGetir(1,5);
                    Assert.assertEquals(message,ecpectedMessage);
                    break;
            }
        }
    }

    @Then("TY Kullanici Message Table Header'da ID Alanina Tiklayarak Mesajlari Ilk Olusturulandan Baslayarak Siralar")
    public void ty_kullanici_message_table_header_da_ıd_alanina_tiklayarak_mesajlari_ılk_olusturulandan_baslayarak_siralar()
    {
        selectHeaderItem("ID");

    }
    @Then("TY Kullanici Sayfayi, Olusturdugu Yeni Mesajin ID Numarasini Gorene Kadar Kaydirir ve Kaydirirken Olusturulmus Tum Mesajlari Goruntuler")
    public void ty_kullanici_sayfayi_olusturdugu_yeni_mesajin_ıd_numarasini_gorene_kadar_kaydirir_ve_kaydirirken_olusturulmus_tum_mesajlari_goruntuler()
    {
        ReusableMethods.waitFor(2);
        JSUtils.scrollIntoVIewJS(us16_pages.messagePageSonu);
        ReusableMethods.waitFor(2);
    }
    @Then("TY Kullanici SignOut Olur")
    public void ty_kullanici_sign_out_olur()
    {
        us05_pages.logout();
    }
    @Given("TY Kullanici Create a New Message Butonuna Tiklar")
    public void ty_kullanici_create_a_new_message_butonuna_tiklar()
    {
        JSUtils.clickElementByJS(us16_pages.createANewMessageButton);
    }
    @Then("TY Kullanici Create or edit a Message Sayfasinin Acildigini Dogrular")
    public void ty_kullanici_create_or_edit_a_message_sayfasinin_acildigini_dogrular()
    {
        String expectedHeader = ConfigReader.getProperty("TYCreateOrEditAMessageExpectedHeader");
        String actualHeader = us16_pages.acilanSayfaHeader.getText();
        Assert.assertEquals(expectedHeader,actualHeader);
    }
    @Then("TY Kullanici {string} TextBox'ina Tiklar")
    public void tyKullaniciTextBoxInaTiklar(String credentialsName)
    {
        JSUtils.clickElementByJS(credentialWebElement(credentialsName));
        credentialWebElement(credentialsName).sendKeys(" ");
    }

    @Then("TY Kullanici Name TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular")
    public void ty_kullanici_name_text_box_inin_altinda_this_field_is_required_yazisinin_gorundugunu_dogrular()
    {
       String expectedText = ConfigReader.getProperty("TYCreateMessageExpectedInvalidFeedbackForName");
       String actualText = us16_pages.messagePageInvalidFeedbackForName.getText();
       Assert.assertEquals(expectedText,actualText);
    }
    @Then("TY Kullanici Email TextBox'inin Altinda 'Your email is required.' Yazisinin Gorundugunu Dogrular")
    public void ty_kullanici_email_text_box_inin_altinda_your_email_is_required_yazisinin_gorundugunu_dogrular()
    {
        String expectedText = ConfigReader.getProperty("TYCreateMessageExpectedInvalidFeedbackForEmail1");
        String actualText = us16_pages.messagePageInvalidFeedbackForEmail2.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Then("TY Kullanici Subject TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular")
    public void ty_kullanici_subject_text_box_inin_altinda_this_field_is_required_yazisinin_gorundugunu_dogrular()
    {
        String expectedText = ConfigReader.getProperty("TYCreateMessageExpectedInvalidFeedbackForSubject");
        String actualText = us16_pages.messagePageInvalidFeedbackForSubject.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Then("TY Kullanici Name TextBox'ina Tiklar ve Isim Girer")
    public void ty_kullanici_name_text_box_ina_tiklar_ve_ısim_girer()
    {
        JSUtils.clickElementByJS(credentialWebElement("Name"));
        credentialWebElement("Name").sendKeys(faker.name().fullName());
    }
    @Then("TY Kullanici Email TextBox'ina Tiklar @mail.com Icermeyen Bir Mail Girer")
    public void ty_kullanici_email_text_box_ina_tiklar_mail_com_ıcermeyen_bir_mail_girer()
    {
        JSUtils.clickElementByJS(credentialWebElement("Email"));
        credentialWebElement("Email").sendKeys(ConfigReader.getProperty("TYInvalidEmail"));
    }
    @Then("TY Kullanici Email TextBox'inin Altinda 'This field is invalid' Yazisinin Gorundugunu Dogrular")
    public void ty_kullanici_email_text_box_inin_altinda_this_field_is_invalid_yazisinin_gorundugunu_dogrular()
    {
        String expectedText = ConfigReader.getProperty("TYCreateMessageExpectedInvalidFeedbackForEmail2");
        String actualText = us16_pages.messagePageInvalidFeedbackForEmail1.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @Then("TY Kullanici Email TextBox'ina Tiklar Ve Valid Bir Mail Girer")
    public void tyKullaniciEmailTextBoxInaTiklarVeValidBirMailGirer()
    {
        JSUtils.clickElementByJS(credentialWebElement("Email"));
        credentialWebElement("Email").clear();
        String validEmail = faker.internet().emailAddress();
        Boolean yahooMu = validEmail.contains("yahoo");
        if(yahooMu == true)
        {
            while(yahooMu)
            {
                validEmail = faker.internet().emailAddress();
                yahooMu = validEmail.contains("yahoo");
            }
        }
        credentialWebElement("Email").sendKeys(validEmail);
    }
    @Then("TY Kullanici Subject TextBox'ina Tiklar ve Konuyu Girer")
    public void ty_kullanici_subject_text_box_ina_tiklar_ve_konuyu_girer()
    {
        JSUtils.clickElementByJS(credentialWebElement("Subject"));
        credentialWebElement("Subject").sendKeys(faker.lorem().sentence());
    }
    @Then("TY Kullanici Message TextBox'ina Tiklar ve Mesaji Girer")
    public void ty_kullanici_message_text_box_ina_tiklar_ve_mesaji_girer()
    {
        JSUtils.clickElementByJS(credentialWebElement("Message"));
        credentialWebElement("Message").sendKeys(faker.lorem().sentence());
    }
    @Then("TY Kullanici Save Butonuna Tiklar")
    public void ty_kullanici_save_butonuna_tiklar()
    {
        JSUtils.clickElementByJS(us16_pages.createANewMessagePageSaveButton);
    }
    @Then("TY Kullanici Gelen PopUp Mesajinin Yesil Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir")
    public void ty_kullanici_gelen_pop_up_mesajinin_yesil_renkte_oldugunu_dogrulamak_ıcin_ekran_resmi_alir() throws IOException {
      // try {
      //     ReusableMethods.waitFor(1);
      //     ReusableMethods.getScreenshot("CreateANewMessage");
      // } catch (IOException e) {
      //     e.printStackTrace();
      // }
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("CreateANewMessage");

    }
    @Then("TY Kullanici PopUp Uzerinde Yer Alan Mesajin {string}  Icerdigini Dogrular")
    public void ty_kullanici_pop_up_uzerinde_yer_alan_mesajin_ıcerdigini_dogrular(String string)
    {
      // ReusableMethods.waitFor(5);
       //String toastifyText = us16_pages.toastifyContainer.getAttribute("innerText");
        WebElement yesilToastify = us16_pages.toastifyList.get(0);
        String toastifyText = yesilToastify.getAttribute("innerText");

        // String toastifyText2 = us16_pages.toastifyContainer.getText();
      // System.out.println("toastifyText = " + toastifyText);
      // System.out.println("toastifyText2 = " + toastifyText2);
       Assert.assertTrue(toastifyText.contains(string));
      // Assert.assertTrue(toastifyText2.contains(string));
      // ReusableMethods.waitFor(2);
        // tostify locateini gormuyor
    }
    @Given("TY Kullanici Messages Table'da Ilk Satirda Yer Alan Mesajin View Butonuna Basar")
    public void ty_kullanici_messages_table_da_ılk_satirda_yer_alan_mesajin_view_butonuna_basar()
    {

        JSUtils.clickElementByJS(us16_pages.viewButton);
    }
    @Given("TY Kullanici Acilan Message Sayfasinda Edit Butonuna Tiklar")
    public void ty_kullanici_acilan_message_sayfasinda_edit_butonuna_tiklar()
    {
        //JSUtils.clickElementByJS(us16_pages.viewIcindekiEditButton);
        JSUtils.clickElementByJS(viewIcindekiEditButonu());
        ReusableMethods.waitFor(2);
    }
    @Then("TY Kullanici Name TextBox'ina Tiklar, Temizler Ve Yeni Name'i Girer")
    public void ty_kullanici_name_text_box_ina_tiklar_temizler_ve_yeni_name_i_girer()
    {
        credentialWebElement("Name").clear();
        credentialWebElement("Name").sendKeys(faker.name().fullName());
    }
    @Then("TY Kullanici Email TextBox'ina Tiklar, Temizler Ve Yeni Email'i Girer")
    public void ty_kullanici_email_text_box_ina_tiklar_temizler_ve_yeni_email_i_girer()
    {
        credentialWebElement("Email").clear();
        credentialWebElement("Email").sendKeys(faker.internet().emailAddress());
    }
    @Then("TY Kullanici Subject TextBox'ina Tiklar, Temizler Ve Yeni Suject'i Girer")
    public void ty_kullanici_subject_text_box_ina_tiklar_temizler_ve_yeni_suject_i_girer()
    {
        credentialWebElement("Subject").clear();
        credentialWebElement("Subject").sendKeys(faker.lorem().sentence());
    }
    @Then("TY Kullanici Message TextBox'ina Tiklar, Temizler Ve Yeni Message'i Girer")
    public void ty_kullanici_message_text_box_ina_tiklar_temizler_ve_yeni_message_i_girer()
    {
        credentialWebElement("Message").clear();
        credentialWebElement("Message").sendKeys(faker.lorem().sentence());
    }
    @And("TY Kullanici Save Butonunu Gorene Kadar Kaydirir Ve Save Butonuna Basar")
    public void tyKullaniciSaveButonunuGoreneKadarKaydirirVeSaveButonunaBasar()
    {
        JSUtils.scrollIntoVIewJS(us16_pages.createANewMessagePageSaveButton);
        JSUtils.clickElementByJS(us16_pages.createANewMessagePageSaveButton);
    }
    @Given("TY Kullanici Room Table'da Ilk Satirda Yer Alan Mesajin Edit Butonuna Basar")
    public void ty_kullanici_room_table_da_ılk_satirda_yer_alan_mesajin_edit_butonuna_basar()
    {
        JSUtils.clickElementByJS(us16_pages.editButton);
    }
    @Given("TY Kullanici Room Table'da Ilk Satirda Yer Alan Mesajin Delete Butonuna Basar")
    public void ty_kullanici_room_table_da_ılk_satirda_yer_alan_mesajin_delete_butonuna_basar()
    {
        JSUtils.clickElementByJS(us16_pages.deleteButton);
        ReusableMethods.waitFor(2);
    }

    @Then("TY Kullanici Message Sayfasinda Acilan PopUp'da Delete Butonuna Tiklar")
    public void tyKullaniciMessageSayfasindaAcilanPopUpDaDeleteButonunaTiklar()
    {

        JSUtils.clickElementByJS(us16_pages.popUpDeleteMessageButton); // --> bad request olusturdu
        // us16_pages.popUpDeleteButton.click(); // --> bad request olusturdu
        //actions.moveToElement(us16_pages.popUpDeleteButton).click().perform(); // --> sonunda calisti
        //JSUtils.clickElementByJS(us16_pages.popUpDeleteButton);

        //JSUtils.clickElementByJS(popUpDeleteButonu());
    }

}
