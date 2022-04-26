package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.US05_pages;
import pages.US16_pages;
import pages.US27_WebTablePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static pages.US16_pages.*;

public class US16_stepdefinitions
{


    US05_pages us05_pages = new US05_pages();
    US16_pages us16_pages = new US16_pages();
    public static Faker faker = new Faker();
    US27_WebTablePage us27_webTablePage = new US27_WebTablePage();
    public static String date;



    @Given("TY Kullanici Create a New Room Butonuna Tiklar")
    public void ty_kullanici_create_a_new_room_butonuna_tiklar()
    {
        JSUtils.clickElementByJS(us16_pages.createANewRoomButton);
    }

    @Then("TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur")
    public void ty_kullanici_room_number_text_box_ina_tiklar_ve_daha_once_kullanilmamis_bir_oda_numarasi_ıle_doldurur()
    {
        int rastgeleSayi = (int)(Math.random() *10000 + 10000);
        us16_pages.createANewRoomPageRoomNumberTextBox.sendKeys(""+rastgeleSayi);
    }

    @Then("TY Kullanici Room Type Secer")
    public void ty_kullanici_room_type_secer()
    {
       Driver.selectAnRandomItemFromDropdown(us16_pages.createANewRoomPageRoomTypeDropDown);
    }

    @Then("TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur")
    public void ty_kullanici_price_text_box_ina_tiklar_ve_valid_bir_ıfade_ıle_doldurur()
    {
        us16_pages.createANewRoomPagePriceTextBox.clear();
        us16_pages.createANewRoomPagePriceTextBox.sendKeys(faker.number().digits(3));
    }

    @Then("TY Kullanici Description TextBox'ina Tiklar Ve {int}'den Daha Az Sayida Karakter Iceren Bir Metin Girer")
    public void ty_kullanici_description_text_box_ina_tiklar_ve_den_daha_az_sayida_karakter_ıceren_bir_metin_girer(Integer maxCharNumber)
    {
        String metin = faker.lorem().paragraph(5);
        Boolean buyukMu = metin.length()>=maxCharNumber;
        if(buyukMu == true)
        {
            while(buyukMu)
            {
                metin = faker.lorem().paragraph(1);
                buyukMu = metin.length()>=maxCharNumber;
            }
        }
        us16_pages.createANewRoomPageDescriptionTextBox.sendKeys(metin);
    }

    @Then("TY Kullanici Create Date Alanini {string} Formatinda Guncel \\(Bugun veya Ileri Bir Tarih) Bir Tarih Ile Doldurur")
    public void ty_kullanici_create_date_alanini_formatinda_guncel_bugun_veya_ıleri_bir_tarih_bir_tarih_ıle_doldurur(String string)
    {
        String date = ReusableMethods.setTheDateByRandomWithTime("MM-dd-00yyyy-HH:mm",1,"feature");
        JSUtils.scrollIntoVIewJS(us16_pages.createANewRoomPageCreatedDateTextBox);
        us16_pages.createANewRoomPageCreatedDateTextBox.clear();
        us16_pages.createANewRoomPageCreatedDateTextBox.sendKeys(date);

        //ReusableMethods.waitFor(5);


    }
    @Then("TY Kullanici Room Number TextBox'ina Tiklar")
    public void ty_kullanici_room_number_text_box_ina_tiklar()
    {
        JSUtils.clickElementByJS(us16_pages.createANewRoomPageRoomNumberTextBox);
        us16_pages.createANewRoomPageRoomNumberTextBox.sendKeys("");

    }
    @Then("TY Kullanici Price TextBox'ina Tiklar")
    public void tyKullaniciPriceTextBoxInaTiklar()
    {
        JSUtils.clickElementByJS(us16_pages.createANewRoomPagePriceTextBox);
        us16_pages.createANewRoomPageRoomNumberTextBox.sendKeys(" ");
        ReusableMethods.waitFor(1);
    }
    @And("TY Kullanici Room Number TextBox'inin Altinda {string} Yazisinin Gorundugunu Dogrular")
    public void tyKullaniciRoomNumberTextBoxIninAltindaYazisininGorundugunuDogrular(String invalidMessage)
    {
        String expectedText =invalidMessage;
        String actualText = us16_pages.createRoomInvalidFeedback.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @And("TY Kullanici Room Number TextBox'ini {string} String Ifadesi Ile Doldurur")
    public void tyKullaniciRoomNumberTextBoxIniStringIfadesiIleDoldurur(String string)
    {
        JSUtils.clickElementByJS(us16_pages.createANewRoomPageRoomNumberTextBox);
        us16_pages.createANewRoomPageRoomNumberTextBox.sendKeys(string);
    }

    @Then("TY Kullanici Room Number TextBox'ini Zaten Var Olan Bir Oda Numarasi Ile Doldurur")
    public void ty_kullanici_room_number_text_box_ini_zaten_var_olan_bir_oda_numarasi_ıle_doldurur()
    {
        us16_pages.createANewRoomPageRoomNumberTextBox.clear();
        JSUtils.clickElementByJS(us16_pages.createANewRoomPageRoomNumberTextBox);
        us16_pages.createANewRoomPageRoomNumberTextBox.sendKeys(ConfigReader.getProperty("TYExistRoomNumber"));
    }

    @And("TY Kullanici Room Type Alanin Default Olarak {string} Secili Oldugunu Dogrular")
    public void tyKullaniciRoomTypeAlaninDefaultOlarakSeciliOldugunuDogrular(String option)
    {
        /*
        String expectedData = option;
        Select select = new Select(us16_pages.createANewRoomPageRoomTypeDropDown);
        List<WebElement> selectList = select.getOptions();
        WebElement element = null;
        for (WebElement each : selectList)
        {
            if(each.getText() == option)
            {
                element = each;
            }
        }
        Assert.assertTrue(element.isSelected());

         */
        String text1 = us16_pages.createANewRoomPageRoomTypeDropDown.getText();
        String text2 = us16_pages.createANewRoomPageRoomTypeDropDown.getAttribute("innerText");
        System.out.println("text1 = " + text1); // text1 = TWIN DELUXE PREMIUM_DELUXE SUITE DAYCARE
        System.out.println("text2 = " + text2); // text2 = TWIN DELUXE PREMIUM_DELUXE SUITE DAYCARE

    }

    @And("TY Kullanici Room Type Alanindaki Secenekler Arasinda Asagidaki Seceneklerin Bulundugunu Dogrular")
    public void tyKullaniciRoomTypeAlanindakiSeceneklerArasindaAsagidakiSeceneklerinBulundugunuDogrular(DataTable dataTable)
    {
        List<String> optionList = dataTable.row(0);
        Select select = new Select(us16_pages.createANewRoomPageRoomTypeDropDown);
        List<WebElement> selectListElement = select.getOptions();
        List<String> selectListString = new ArrayList<>();

        for (WebElement each : selectListElement)
        {
            selectListString.add(each.getText());
        }
        for (String each : optionList)
        {
            Assert.assertTrue(selectListString.contains(each));
        }

    }

    @Then("TY Kullanici Gelen PopUp Mesajinin Kirmizi Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir")
    public void ty_kullanici_gelen_pop_up_mesajinin_kirmizi_renkte_oldugunu_dogrulamak_ıcin_ekran_resmi_alir()
    {
        try {
            ReusableMethods.getScreenshot("CreateANewRoom");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("TY Kullanici PopUp Uzerinde Yer Alan Mesajin {string}  Oldugunu Dogrular")
    public void ty_kullanici_pop_up_uzerinde_yer_alan_mesajin_oldugunu_dogrular(String string)
    {
        ReusableMethods.waitFor(5);
        String toastifyText = us16_pages.toastifyContainer.getAttribute("innerText");
        Assert.assertEquals(string,toastifyText);
    }

    @Then("TY Kullanici Status Checkbox'inin Isaretler")
    public void tyKullaniciStatusCheckboxIninIsaretler()
    {
        JSUtils.clickElementByJS(us16_pages.createANewRoomPageStatusCheckBox);
    }
    @And("TY Kullanici Price TextBox'inin Altinda {string} Yazisinin Gorundugunu Dogrular")
    public void tyKullaniciPriceTextBoxIninAltindaYazisininGorundugunuDogrular(String invalidMessage)
    {
        String expectedText =invalidMessage;
        String actualText = us16_pages.createRoomInvalidFeedback.getText();
        Assert.assertEquals(expectedText,actualText);
    }
    @And("TY Kullanici Price TextBoxini Invalid Bir Price Ile Doldurur ve Price TextBoxinin Altinda {string} Yazisinin Gorundugunu Dogrular")
    public void tyKullaniciPriceTextBoxiniInvalidBirPriceIleDoldururVePriceTextBoxininAltindaYazisininGorundugunuDogrular(String invalidMessage)
    {
        us16_pages.createANewRoomPagePriceTextBox.sendKeys(faker.lorem().sentence());
        String expectedText =invalidMessage;
        String actualText = us16_pages.createRoomInvalidFeedback.getText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Then("TY Kullanici Price TextBox'ini Temizler")
    public void ty_kullanici_price_text_box_ini_temizler()
    {
        us16_pages.createANewRoomPagePriceTextBox.clear();
    }

    @Then("TY Kullanici Price TextBox'ini Valid Bir Ifade Ile Doldurur ve Bir Hata Mesaji Almadigini Dogrulamak Icin Ekran Resmi Alir")
    public void ty_kullanici_price_text_box_ini_valid_bir_ıfade_ıle_doldurur_ve_bir_hata_mesaji_almadigini_dogrulamak_ıcin_ekran_resmi_alir()
    {
        us16_pages.createANewRoomPagePriceTextBox.sendKeys(faker.number().digits(3));
    }
    @Then("TY Kullanici Description TextBox'ina Tiklar")
    public void ty_kullanici_description_text_box_ina_tiklar()
    {
        JSUtils.scrollIntoVIewJS(us16_pages.createANewRoomPageDescriptionTextBox);
        JSUtils.clickElementByJS(us16_pages.createANewRoomPageDescriptionTextBox);

    }

    @Then("TY Kullanici Created Date TextBox'ina Tiklar")
    public void ty_kullanici_created_date_text_box_ina_tiklar()
    {
        JSUtils.clickElementByJS(us16_pages.createANewRoomPageCreatedDateTextBox);

    }

    @Then("TY Kullanici Description TextBox'i Bos Birakildiginda Bir Hata Mesaji Alinmadigini Dogrulamak Icin Ekran Resmi Alir")
    public void ty_kullanici_description_text_box_i_bos_birakildiginda_bir_hata_mesaji_alinmadigini_dogrulamak_ıcin_ekran_resmi_alir()
    {

        try {
            ReusableMethods.getScreenshot("Description_Bos_Birakilabilir_Description_Bos_Birakildiginda_Hata_Alinmiyor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Then("TY Kullanici Description TextBox'ina {int}'den Daha Cok Sayida Karakter Iceren Bir Metin Girer")
    public void ty_kullanici_description_text_box_ina_den_daha_cok_sayida_karakter_ıceren_bir_metin_girer(int maxCharNumber)
    {
        String metin = faker.lorem().paragraph(7);
        Boolean kucukMu = metin.length()<maxCharNumber;
        if(kucukMu == true)
        {
            while(kucukMu)
            {
                metin = faker.lorem().paragraph(7);
                kucukMu = metin.length()<maxCharNumber;
            }
        }
        us16_pages.createANewRoomPageDescriptionTextBox.sendKeys(metin);
    }

    @Then("TY Kullanici Description TextBox'ini Temizler Ve Bos Birakir")
    public void ty_kullanici_description_text_box_ini_temizler_ve_bos_birakir()
    {
        us16_pages.createANewRoomPageDescriptionTextBox.clear();
    }

    @Then("TY Kullanici Created Date Alaninda Default Olarak Yazan Tarihin Sistem Tarihi Ile Ayni Oldugunu Dogrular")
    public void ty_kullanici_created_date_alaninda_default_olarak_yazan_tarihin_sistem_tarihi_ıle_ayni_oldugunu_dogrular()
    {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'00:00"); // "dd-MM-yyyy'T'00:00"
        String timeF;
        timeF = formatter.format(time);
        String expectedValue = timeF;
        String actualValue = us16_pages.createANewRoomPageCreatedDateTextBox.getAttribute("value");
        //System.out.println("expectedValue = " + expectedValue);
        //System.out.println("actualValue = " + actualValue);
        Assert.assertEquals(expectedValue,actualValue);

    }

    @Then("TY Kullanici Gelen PopUp Mesajinin Kirmizi Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir")
    public void ty_kullanici_gelen_pop_up_mesajinin_kirmizi_renkte_oldugunu_dogrulamak_ıcin_ekran_resmi_alinir()
    {
        try {
            ReusableMethods.getScreenshot("Description_Bos_Birakilabilir_Description_Bos_Birakildiginda_Hata_Alinmiyor");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @And("TY Kullanici Create Date Alanini aa.gg.yy Formatindaki Date Datalar Ile Doldurur Ve Create Date Alinda Yazan Deger Ile Girilen Degerin Ayni Olmadigini Dogrular")
    public void tyKullaniciCreateDateAlaniniAaGgYyFormatindakiDateDatalarIleDoldururVeCreateDateAlindaYazanDegerIleGirilenDegerinAyniOlmadiginiDogrular(DataTable dataTable)
    {
        // yanlıs format - guncel tarih
        List<String> dateList = dataTable.row(0);
        String day;
        String mounth;
        String year;
        String hour;
        String minute;

        for (String each : dateList)
        {
            day = each.substring(0, 2);
            mounth = each.substring(3, 5);
            year = each.substring(8, 12);
            hour = each.substring(13, 15);
            minute = each.substring(16);

            each = year + "-" + mounth + "-" + day + "T" + hour + ":" + minute;
            us16_pages.createANewRoomPageCreatedDateTextBox.clear();
            us16_pages.createANewRoomPageCreatedDateTextBox.sendKeys(each);
            //System.out.println("each = " + each);
            // |12.13.002030.00.00|01.31.002030.00.00|
            //System.out.println("expectedValue = " + each);
            //System.out.println("actualValue = " + us16_pages.createANewRoomPageCreatedDateTextBox.getAttribute("value"));

            Assert.assertFalse(each.equals(us16_pages.createANewRoomPageCreatedDateTextBox.getAttribute("value")));
            // 2022-04-24T00:00 olması gereken format
            // each 12.13.002030.00.00
        }
    }
    @And("TY Kullanici Create Date Alanini aa\\/gg\\/yy Formatindaki Dateler Ile Doldurur Ve Textbox'ta Yazan Ile Girilen Degerin Ayni Olmadigini Dogrular")
    public void tyKullaniciCreateDateAlaniniAaGgYyFormatindakiDatelerIleDoldururVeTextboxTaYazanIleGirilenDegerinAyniOlmadiginiDogrular(DataTable dataTable)
    {
        // yanlıs format - guncel tarih
        List<String> dateList = dataTable.row(0);
        String day;
        String mounth;
        String year;
        String hour;
        String minute;

        for (String each : dateList)
        {
            day = each.substring(0, 2);
            mounth = each.substring(3, 5);
            year = each.substring(8, 12);
            hour = each.substring(13, 15);
            minute = each.substring(16);

            each = year + "-" + mounth + "-" + day + "T" + hour + ":" + minute;
            us16_pages.createANewRoomPageCreatedDateTextBox.sendKeys(each);
            //System.out.println("each = " + each);
            // |12.13.002030.00.00|01.31.002030.00.00|
            //System.out.println("expectedValue = " + each);
            //System.out.println("actualValue = " + us16_pages.createANewRoomPageCreatedDateTextBox.getAttribute("value"));

            Assert.assertFalse(each.equals(us16_pages.createANewRoomPageCreatedDateTextBox.getAttribute("value")));
            // 2022-04-24T00:00 olması gereken format
            // each 12.13.002030.00.00
        }
    }
    @Then("TY Kullanici Create Date Alanini gg\\/aa\\/yy Formatinda Gecmis Bir Tarih Ile Doldurur")
    public void ty_kullanici_create_date_alanini_gg_aa_yy_formatinda_gecmis_bir_tarih_ıle_doldurur()
    {
        // dogru format -gecmis tarih
        date = ReusableMethods.setTheDateByRandomWithTime("dd-MM-00yyyy-HH:mm",1,"past");
        us16_pages.createANewRoomPageCreatedDateTextBox.clear();
        us16_pages.createANewRoomPageCreatedDateTextBox.sendKeys(date);
        //ReusableMethods.waitFor(10);
    }

    @Then("TY Kullanici Room Type Sutununda Farkli Turdeki Odalarin Gorundugunu Dogrular ve Ekran Resmi Alir")
    public void ty_kullanici_room_type_sutununda_farkli_turdeki_odalarin_gorundugunu_dogrular_ve_ekran_resmi_alir()
    {
        List<String> sutunElemanlariList = us27_webTablePage.sutunGetir(2);
        Boolean farklıMı = false;
        for (int i=0; i<sutunElemanlariList.size()-1 ; i++)
        {
            if(i!=sutunElemanlariList.size()-1)
            {
                Boolean condition = sutunElemanlariList.get(i) != sutunElemanlariList.get(i+1);
                if(condition == true)
                {
                    farklıMı = true;
                    break;
                }
            }
        }

        Assert.assertTrue(farklıMı);
    }

    @Then("TY Kullanici Rooms Table'in Header'inda Yer Alan Room Type'a Tiklar")
    public void ty_kullanici_rooms_table_in_header_inda_yer_alan_room_type_a_tiklar()
    {
        selectHeaderItem("Room Type");
        ReusableMethods.waitFor(2);
    }
    @And("TY Kullanici Room Type Sutununda {string} Tipindeki Odalarin Gorundugunu Dogrular Ve Ekran Resmi Alir")
    public void tyKullaniciRoomTypeSutunundaTipindekiOdalarinGorundugunuDogrularVeEkranResmiAlir(String type)
    {
        List<String> sutunElemanlariList = us27_webTablePage.sutunGetir(3);
        for (String each : sutunElemanlariList)
        {
            Assert.assertTrue(each.equals(type));
        }
        try {
            ReusableMethods.getScreenshot("Ayni Tipte Odalar Gorunuyor");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Then("TY Kullanici MANUEL: Kullanici SUITE Tipindeki Odalari Goruntuleyebilmek Icin SearchBox'a SUITE Yazarak Arama Yapar")
    public void ty_kullanici_manuel_kullanici_suıte_tipindeki_odalari_goruntuleyebilmek_ıcin_search_box_a_suıte_yazarak_arama_yapar()
    {
        // search box olmadigi icin otomasyon yapilamiyor. Bu bir BUG
    }

    @Given("TY Kullanici Yeni Oda Olusturur")
    public void ty_kullanici_yeni_oda_olusturur()
    {
        JSUtils.clickElementByJS(us16_pages.createANewRoomButton);
        int rastgeleSayi = (int)(Math.random() *10000 + 10000);
        us16_pages.createANewRoomPageRoomNumberTextBox.sendKeys(""+rastgeleSayi);
        Driver.selectAnRandomItemFromDropdown(us16_pages.createANewRoomPageRoomTypeDropDown);
        us16_pages.createANewRoomPagePriceTextBox.sendKeys(faker.number().digits(3));
        String metin = faker.lorem().paragraph(5);
        Boolean buyukMu = metin.length()>=255;
        if(buyukMu == true)
        {
            while(buyukMu)
            {
                metin = faker.lorem().paragraph(1);
                buyukMu = metin.length()>=255;
            }
        }
        us16_pages.createANewRoomPageDescriptionTextBox.sendKeys(metin);
        String date = ReusableMethods.setTheDateByRandomWithTime("MM-dd-00yyyy-HH:mm",1,"feature");
        us16_pages.createANewRoomPageCreatedDateTextBox.clear();
        us16_pages.createANewRoomPageCreatedDateTextBox.sendKeys(date);
        JSUtils.scrollIntoVIewJS(us16_pages.createANewMessagePageSaveButton);
        JSUtils.clickElementByJS(us16_pages.createANewMessagePageSaveButton);

    }

    @Then("TY Kullanici Room Table Header'da ID Alanina Tiklayarak Odalari En Son Olusturulandan Baslayarak Siralar")
    public void ty_kullanici_room_table_header_da_ıd_alanina_tiklayarak_odalari_en_son_olusturulandan_baslayarak_siralar()
    {
        selectHeaderItem("ID");
        ReusableMethods.waitFor(2);
    }

    @Given("TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin View Butonuna Basar")
    public void ty_kullanici_room_table_da_ılk_satirda_yer_alan_odanin_view_butonuna_basar()
    {
        JSUtils.clickElementByJS(us16_pages.viewButton);
    }

    @Then("TY Kullanici Acilan Room Sayfasinda Edit Butonuna Tiklar")
    public void ty_kullanici_acilan_room_sayfasinda_edit_butonuna_tiklar()
    {
        JSUtils.clickElementByJS(viewIcindekiEditButonu());
        ReusableMethods.waitFor(2);
    }

    @Then("TY Kullanici Create or edit a Room Sayfasinin Acildigini Dogrular")
    public void ty_kullanici_create_or_edit_a_room_sayfasinin_acildigini_dogrular()
    {
        String expectedHeader = ConfigReader.getProperty("TYCreateOrEditARoomExpectedHeader");
        String actualHeader = us16_pages.acilanSayfaHeader.getText();
        Assert.assertEquals(expectedHeader,actualHeader);
    }

    @Then("TY Kullanici Room Number TextBox'ina Tiklar, Temizler Ve Daha Once Kullanilmamis Yeni Bir Room Number Girer")
    public void ty_kullanici_room_number_text_box_ina_tiklar_temizler_ve_daha_once_kullanilmamis_yeni_bir_room_number_girer()
    {
        us16_pages.createANewRoomPageRoomNumberTextBox.click();
        us16_pages.createANewRoomPageRoomNumberTextBox.clear();
        int rastgeleSayi = (int)(Math.random() *10000 + 10000);
        us16_pages.createANewRoomPageRoomNumberTextBox.sendKeys(""+rastgeleSayi);
    }

    @Then("TY Kullanici Status'e Tiklar \\(Secili Ise Kaldirmis, Secili Degilse Secmis Olur)")
    public void ty_kullanici_status_e_tiklar_secili_ıse_kaldirmis_secili_degilse_secmis_olur()
    {
        us16_pages.createANewRoomPageStatusCheckBox.click();
    }

    @Then("TY Kullanici Price TextBox'ina Tiklar, Temizler Ve Yeni Bir Price Degeri Girer")
    public void ty_kullanici_price_text_box_ina_tiklar_temizler_ve_yeni_bir_price_degeri_girer()
    {
        us16_pages.createANewRoomPagePriceTextBox.click();
        us16_pages.createANewRoomPagePriceTextBox.clear();
        us16_pages.createANewRoomPagePriceTextBox.sendKeys(faker.number().digits(3));
    }

    @Then("TY Kullanici Description TextBox'ina Tiklar, Temizler Ve Yeni Bir Description Girer")
    public void ty_kullanici_description_text_box_ina_tiklar_temizler_ve_yeni_bir_description_girer()
    {
        us16_pages.createANewRoomPageDescriptionTextBox.click();
        us16_pages.createANewRoomPageDescriptionTextBox.clear();
        us16_pages.createANewRoomPageDescriptionTextBox.sendKeys(faker.lorem().sentence());

    }

    @Given("TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin Edit Butonuna Basar")
    public void ty_kullanici_room_table_da_ılk_satirda_yer_alan_odanin_edit_butonuna_basar()
    {
        JSUtils.clickElementByJS(us16_pages.editButton);
    }


    @Then("TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin Delete Butonuna Basar")
    public void tyKullaniciRoomTableDaIlkSatirdaYerAlanOdaninDeleteButonunaBasar()
    {
        JSUtils.clickElementByJS(us16_pages.deleteButton);
        ReusableMethods.waitFor(2);
    }

    @Then("TY Kullanici Room Sayfasinda Acilan PopUp'da Delete Butonuna Tiklar")
    public void tyKullaniciRoomSayfasindaAcilanPopUpDaDeleteButonunaTiklar()
    {
        ReusableMethods.waitFor(2);
        JSUtils.clickElementByJS(us16_pages.popUpDeleteRoomButton); // --> bad request olusturdu
        // us16_pages.popUpDeleteButton.click(); // --> bad request olusturdu
        //actions.moveToElement(us16_pages.popUpDeleteButton).click().perform(); // --> sonunda calisti
        //JSUtils.clickElementByJS(us16_pages.popUpDeleteButton);

        //JSUtils.clickElementByJS(popUpDeleteButonu());

       // us16_pages.popUpDeleteRoomButton.click();
        //Driver.getDriver().findElement(us16_pages.deleteRoomButton).click();
        //Driver.getDriver().findElement(us16_pages.deleteRoomButton).findElement(By.xpath(""));
        // ilginc locate ---> eger @FindBy bbilimiyursan ya da bir locate'i stringde tutman gerekiyorsa
        // Stringde tutma By classindasn olusturacagin bir elementte tut

        // yunus hocamdan
       // Driver.waitAndClick(RPS.testID);
       // Thread.sleep(1000);
       // Driver.waitAndClick(RPS.delete);
       // Thread.sleep(1000);
       // Driver.waitAndClick(RPS.delete2);

    }


}
