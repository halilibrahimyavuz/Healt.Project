package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.US05_pages;
import pages.US16_pages;
import utilities.JSUtils;

public class US16_stepdefinitions
{


    US05_pages us05_pages = new US05_pages();
    US16_pages us16_pages = new US16_pages();
    public static Faker faker = new Faker();


    @Given("TY Kullanici Create a New Room Butonuna Tiklar")
    public void ty_kullanici_create_a_new_room_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Number TextBox'ina Tiklar ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur")
    public void ty_kullanici_room_number_text_box_ina_tiklar_ve_daha_once_kullanilmamis_bir_oda_numarasi_ıle_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Type Secer")
    public void ty_kullanici_room_type_secer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Price TextBox'ina Tiklar ve Valid Bir Ifade Ile Doldurur")
    public void ty_kullanici_price_text_box_ina_tiklar_ve_valid_bir_ıfade_ıle_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Description TextBox'ina Tiklar Ve {int}'den Daha Az Sayida Karakter Iceren Bir Metin Girer")
    public void ty_kullanici_description_text_box_ina_tiklar_ve_den_daha_az_sayida_karakter_ıceren_bir_metin_girer(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Create Date Alanini {string} Formatinda Guncel \\(Bugun veya Ileri Bir Tarih) Bir Tarih Ile Doldurur")
    public void ty_kullanici_create_date_alanini_formatinda_guncel_bugun_veya_ıleri_bir_tarih_bir_tarih_ıle_doldurur(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("TY Kullanici Room Number TextBox'ina Tiklar")
    public void ty_kullanici_room_number_text_box_ina_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Type TextBox'ina Tiklar")
    public void ty_kullanici_room_type_text_box_ina_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Number TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular")
    public void ty_kullanici_room_number_text_box_inin_altinda_this_field_is_required_yazisinin_gorundugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Number TextBox'ini Zaten Var Olan Bir Oda Numarasi Ile Doldurur")
    public void ty_kullanici_room_number_text_box_ini_zaten_var_olan_bir_oda_numarasi_ıle_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Type Alanin default Olarak TWIN Secili Oldugunu Dogrular")
    public void ty_kullanici_room_type_alanin_default_olarak_twın_secili_oldugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Type Alanindaki Seceneklerin TWIN, DELUXE, PREMIUM_DELUXE, SUIT ve DAYCARE Oldugunu Dogrular")
    public void ty_kullanici_room_type_alanindaki_seceneklerin_twın_deluxe_premıum_deluxe_suıt_ve_daycare_oldugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Gelen PopUp Mesajinin Kirmizi Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alir")
    public void ty_kullanici_gelen_pop_up_mesajinin_kirmizi_renkte_oldugunu_dogrulamak_ıcin_ekran_resmi_alir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici PopUp Uzerinde Yer Alan Mesajin {string}  Oldugunu Dogrular")
    public void ty_kullanici_pop_up_uzerinde_yer_alan_mesajin_oldugunu_dogrular(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Status Checkbox'inin Isaretler")
    public void tyKullaniciStatusCheckboxIninIsaretler()
    {

    }

    @Then("TY Kullanici Price TextBox'inin Altinda 'This field is required.' Yazisinin Gorundugunu Dogrular")
    public void ty_kullanici_price_text_box_inin_altinda_this_field_is_required_yazisinin_gorundugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Price TextBox'ini Invalid Bir 'Price' Ile Doldurur ve Price TextBox'inin Altinda This field should be at least {int}. Yazisinin Gorundugunu Dogrular")
    public void ty_kullanici_price_text_box_ini_ınvalid_bir_price_ıle_doldurur_ve_price_text_box_inin_altinda_this_field_should_be_at_least_yazisinin_gorundugunu_dogrular(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Price TextBox'ini Temizler")
    public void ty_kullanici_price_text_box_ini_temizler() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Price TextBox'ini Valid Bir Ifade Ile Doldurur ve Bir Hata Mesaji Almadigini Dogrulamak Icin Ekran Resmi Alir")
    public void ty_kullanici_price_text_box_ini_valid_bir_ıfade_ıle_doldurur_ve_bir_hata_mesaji_almadigini_dogrulamak_ıcin_ekran_resmi_alir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("TY Kullanici Description TextBox'ina Tiklar")
    public void ty_kullanici_description_text_box_ina_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Created Date TextBox'ina Tiklar")
    public void ty_kullanici_created_date_text_box_ina_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Description TextBox'i Bos Birakildiginda Bir Hata Mesaji Alinmadigini Dogrulamak Icin Ekran Resmi Alir")
    public void ty_kullanici_description_text_box_i_bos_birakildiginda_bir_hata_mesaji_alinmadigini_dogrulamak_ıcin_ekran_resmi_alir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Description TextBox'ina {int}'den Daha Cok Sayida Karakter Iceren Bir Metin Girer")
    public void ty_kullanici_description_text_box_ina_den_daha_cok_sayida_karakter_ıceren_bir_metin_girer(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Description TextBox'ini Temizler Ve Bos Birakir")
    public void ty_kullanici_description_text_box_ini_temizler_ve_bos_birakir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Created Date Alaninda Default Olarak Yazan Tarihin Sistem Tarihi Ile Ayni Oldugunu Dogrular")
    public void ty_kullanici_created_date_alaninda_default_olarak_yazan_tarihin_sistem_tarihi_ıle_ayni_oldugunu_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("TY Kullanici Room Number TextBox'ina Tiklar Ve Daha Once Kullanilmamis Bir Oda Numarasi Ile Doldurur")
    public void tyKullaniciRoomNumberTextBoxInaTiklarVeDahaOnceKullanilmamisBirOdaNumarasiIleDoldurur()
    {

    }


    @Then("TY Kullanici Create Date Alanini gg\\/aa\\/yy Formatinda Gecmis Bir Tarih Ile Doldurur")
    public void ty_kullanici_create_date_alanini_gg_aa_yy_formatinda_gecmis_bir_tarih_ıle_doldurur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Gelen PopUp Mesajinin Kirmizi Renkte Oldugunu Dogrulamak Icin Ekran Resmi Alinir")
    public void ty_kullanici_gelen_pop_up_mesajinin_kirmizi_renkte_oldugunu_dogrulamak_ıcin_ekran_resmi_alinir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Textbox'ta Yazan Ile Girilen Degerin Ayni Olmadigini Dogrular")
    public void textboxTaYazanIleGirilenDegerinAyniOlmadiginiDogrular()
    {

    }
    @Then("TY Kullanici Create Date Alanini {string} Formatinda Gecmis Bir Tarih Ile Doldurur")
    public void tyKullaniciCreateDateAlaniniGgAaYyFormatindaGecmisBirTarihIleDoldurur()
    {

    }
    @Then("TY Kullanici Room Type Sutununda Farkli Turdeki Odalarin Gorundugunu Dogrular ve Ekran Resmi Alir")
    public void ty_kullanici_room_type_sutununda_farkli_turdeki_odalarin_gorundugunu_dogrular_ve_ekran_resmi_alir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Rooms Table'in Header'inda Yer Alan Room Type'a Tiklar")
    public void ty_kullanici_rooms_table_in_header_inda_yer_alan_room_type_a_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Type Sutununda TWIN Tipindeki Odalarin Gorundugunu Dogrular Ve Ekran Resmi Alir")
    public void ty_kullanici_room_type_sutununda_twın_tipindeki_odalarin_gorundugunu_dogrular_ve_ekran_resmi_alir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Type Sutununda DAYCARE Tipindeki Odalarin Gorundugunu Dogrular Ve Ekran Resmi Alir")
    public void ty_kullanici_room_type_sutununda_daycare_tipindeki_odalarin_gorundugunu_dogrular_ve_ekran_resmi_alir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici MANUEL: Kullanici SUITE Tipindeki Odalari Goruntuleyebilmek Icin SearchBox'a SUITE Yazarak Arama Yapar")
    public void ty_kullanici_manuel_kullanici_suıte_tipindeki_odalari_goruntuleyebilmek_ıcin_search_box_a_suıte_yazarak_arama_yapar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("TY Kullanici Yeni Oda Olusturur")
    public void ty_kullanici_yeni_oda_olusturur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Table Header'da ID Alanina Tiklayarak Odalari En Son Olusturulandan Baslayarak Siralar")
    public void ty_kullanici_room_table_header_da_ıd_alanina_tiklayarak_odalari_en_son_olusturulandan_baslayarak_siralar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin View Butonuna Basar")
    public void ty_kullanici_room_table_da_ılk_satirda_yer_alan_odanin_view_butonuna_basar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Acilan Room Sayfasinda Edit Butonuna Tiklar")
    public void ty_kullanici_acilan_room_sayfasinda_edit_butonuna_tiklar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Create or edit a Room Sayfasinin Acildigini Dogrular")
    public void ty_kullanici_create_or_edit_a_room_sayfasinin_acildigini_dogrular() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Room Number TextBox'ina Tiklar, Temizler Ve Daha Once Kullanilmamis Yeni Bir Room Number Girer")
    public void ty_kullanici_room_number_text_box_ina_tiklar_temizler_ve_daha_once_kullanilmamis_yeni_bir_room_number_girer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Status'e Tiklar \\(Secili Ise Kaldirmis, Secili Degilse Secmis Olur)")
    public void ty_kullanici_status_e_tiklar_secili_ıse_kaldirmis_secili_degilse_secmis_olur() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Price TextBox'ina Tiklar, Temizler Ve Yeni Bir Price Degeri Girer")
    public void ty_kullanici_price_text_box_ina_tiklar_temizler_ve_yeni_bir_price_degeri_girer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("TY Kullanici Description TextBox'ina Tiklar, Temizler Ve Yeni Bir Description Girer")
    public void ty_kullanici_description_text_box_ina_tiklar_temizler_ve_yeni_bir_description_girer() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin Edit Butonuna Basar")
    public void ty_kullanici_room_table_da_ılk_satirda_yer_alan_odanin_edit_butonuna_basar() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


    @Then("TY Kullanici Room Table'da Ilk Satirda Yer Alan Odanin Delete Butonuna Basar")
    public void tyKullaniciRoomTableDaIlkSatirdaYerAlanOdaninDeleteButonunaBasar()
    {

    }
}
