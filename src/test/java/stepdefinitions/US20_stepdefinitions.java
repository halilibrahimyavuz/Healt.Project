package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.US10_page;
import pages.US20_pages;
import utilities.ConfigReader;
import utilities.Driver;

public class US20_stepdefinitions {

    US20_pages us20_pages=new US20_pages();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    String fakerPassword;




    @Given("HY URL adresine gidilir")
    public void hy_url_adresine_gidilir() {
        Driver.getDriver().get(ConfigReader.getProperty(url));
        String actualTitle=Driver.getDriver().getTitle();
        System.out.println(actualTitle);
        String expectedTitle="MEDUNNA";
        Assert.assertEquals("MEDUNNA sayfasına gidilemedi",expectedTitle,actualTitle);
    }
    @Given("HY Sayfanin en üst sag kismindaki Profile Ikonu`na tiklanir.")
    public void hy_sayfanin_en_üst_sag_kismindaki_profile_ıkonu_na_tiklanir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Acilan sekmeden\"Sing in\" secenegi secilmelidir.")
    public void hy_acilan_sekmeden_sing_in_secenegi_secilmelidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Kullanici kayitli oldugu Username i girmelidir.")
    public void hy_kullanici_kayitli_oldugu_username_i_girmelidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Kullanıcı kayitli oldugu Password ü girmelidir.")
    public void hy_kullanıcı_kayitli_oldugu_password_ü_girmelidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Sing in butonuna basmalidir.")
    public void hy_sing_in_butonuna_basmalidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Üstteki menulerden {string} secenegine tiklanmalidir.")
    public void hy_üstteki_menulerden_secenegine_tiklanmalidir(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Acilan sekmeden {string} secenegi secilmelidir.")
    public void hy_acilan_sekmeden_secenegi_secilmelidir(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Gormek istedigi kayitli kisinin uzerine gelip en sagda bulunan {string} butonuna tiklanmalidir.")
    public void hy_gormek_istedigi_kayitli_kisinin_uzerine_gelip_en_sagda_bulunan_butonuna_tiklanmalidir(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY First name bilgisi gorunur olmalidir.")
    public void hy_first_name_bilgisi_gorunur_olmalidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Last name bilgisi gorunur olmalidir.")
    public void hy_last_name_bilgisi_gorunur_olmalidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Email bilgisi gorunur olmalidir.")
    public void hy_email_bilgisi_gorunur_olmalidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Profiles durumu gorunur olmalidir.")
    public void hy_profiles_durumu_gorunur_olmalidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Given("HY Admin Sing out butonuna basarak cikis yapmalidir.")
    public void hy_admin_sing_out_butonuna_basarak_cikis_yapmalidir() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
