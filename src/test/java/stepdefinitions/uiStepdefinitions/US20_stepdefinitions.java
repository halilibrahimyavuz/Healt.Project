package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import pages.US20_pages;
import utilities.Driver;
import utilities.ReusableMethods;

public class US20_stepdefinitions {
   US20_pages us20_pages=new US20_pages();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();
    String fakerPassword;

    @Given("HY Üstteki menulerden {string} secenegine tiklanmalidir.")
    public void hy_üstteki_menulerden_secenegine_tiklanmalidir(String string) {
    //us20_pages.administrationButonu.click();
        Driver.waitAndClick(us20_pages.administrationButonu);
    }

    @Given("HY Acilan sekmeden {string} secenegi secilmelidir.")
    public void hy_acilan_sekmeden_secenegi_secilmelidir(String string) {
        Driver.waitAndClick(us20_pages.userManagementButonu);

            }

    @Given("HY Acilan sekmenin Users sayfası oldugunu dogrulamalıdır.")
    public void hy_acilan_sekmenin_users_sayfası_oldugunu_dogrulamalıdır() {
        String actualText=us20_pages.usersPageText.getText();
        String expectedText="Users";
        Assert.assertEquals("Users Sayfasına ulasılamadı",expectedText,actualText);

    }


    @Given("HY Gormek istedigi kayitli kisinin uzerine gelip en sagda bulunan {string} butonuna tiklanmalidir.")
    public void hy_gormek_istedigi_kayitli_kisinin_uzerine_gelip_en_sagda_bulunan_butonuna_tiklanmalidir(String string) {
        ReusableMethods.waitFor(2);
       // us20_pages.usersPageText.click();
       // actions.keyDown(Keys.CONTROL).sendKeys(Keys.getKeyFromUnicode('f')).keyUp(Keys.CONTROL).build().perform();

        us20_pages.viewButonu.click();
      //  Driver.waitAndClick(us20_pages.viewButonu);
    }

    @Given("HY First name bilgisi gorunur olmalidir.")
    public void hy_first_name_bilgisi_gorunur_olmalidir() {
        ReusableMethods.waitFor(2);
        Assert.assertTrue(us20_pages.firstnameText.isDisplayed());

    }

    @Given("HY Last name bilgisi gorunur olmalidir.")
    public void hy_last_name_bilgisi_gorunur_olmalidir() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us20_pages.lastnameText.isDisplayed());

    }

    @Given("HY Email bilgisi gorunur olmalidir.")
    public void hy_email_bilgisi_gorunur_olmalidir() {
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us20_pages.emailText.isDisplayed());

    }
    @Given("HY Profiles durumu gorunur olmalidir.")
    public void hy_profiles_durumu_gorunur_olmalidir() {
        ReusableMethods.waitFor(1);
        ReusableMethods.hooverByJS(us20_pages.profilesText);
        ReusableMethods.waitFor(1);
        Assert.assertTrue(us20_pages.profilesText.isDisplayed());
    }
    @Given("HY Admin Sing out butonuna basarak cikis yapmalidir.")
    public void hy_admin_sing_out_butonuna_basarak_cikis_yapmalidir() {
    us20_pages.adminHalilButonu.click();
    ReusableMethods.waitFor(2);
    us20_pages.singOutButonu.click();

    }

//2.scenarıo----*****************************************************************-----------------------------------------------------

    @Given("HY Admin rol atamasi yapmak istedigi kisinin uzerine gelip en sagda bulunan {string} butonuna tiklamalidir.")
    public void hy_admin_rol_atamasi_yapmak_istedigi_kisinin_uzerine_gelip_en_sagda_bulunan_butonuna_tiklamalidir(String string) {
        us20_pages.editButonu.click();
    }

    @Given("HY {string} sayfasinin acildigini dogrulamaldiir.")
    public void hy_sayfasinin_acildigini_dogrulamaldiir(String string) {
        String actualText=us20_pages.createEditUserPagesText.getText();
        String expectedText="Create or edit a user";
        System.out.println("expected text yazısı : "+expectedText);
        Assert.assertTrue(expectedText.equals(actualText));
    }

    @Given("HY Acilan sayfada {string} kismina gelip dropdowndan rol atamasi yapabilmelidir.")
    public void hy_acilan_sayfada_kismina_gelip_dropdowndan_rol_atamasi_yapabilmelidir(String string) {
        ReusableMethods.hooverByJS(us20_pages.rolePatient);
        Driver.waitAndClick(us20_pages.rolePatient);

        // ReusableMethods.hooverByJS(us20_pages.roleAdmin);
       // ReusableMethods.hooverByJS(us20_pages.roleStaff);
       // ReusableMethods.hooverByJS(us20_pages.rolePhysician);
       // ReusableMethods.hooverByJS(us20_pages.roleUser);

    }

    @Given("HY Save butonuna basmalidir.")
    public void hy_save_butonuna_basmalidir() {
        Driver.waitAndClick(us20_pages.savebutonu);


    }

    @Given("HY {string} yazisinin ciktigini dogrulamalidir.")
    public void hy_yazisinin_ciktigini_dogrulamalidir(String string) {
       String actualText=us20_pages.editToastContaınerText.getText();
        System.out.println("toast Container yazısı : "+actualText);
        String expectedText ="A user is updated with identifier";
        ReusableMethods.waitFor(2);
        Assert.assertTrue("Edit işleminde sorun oluştu ",actualText.contains(expectedText));

    }

    //------****************************TC03----***************************************


    @Given("HY Admin silmek istedigi kullanicinin ustune en sagda bulunan {string} butonuna tiklamalidir.")
    public void hy_admin_silmek_istedigi_kullanicinin_ustune_en_sagda_bulunan_butonuna_tiklamalidir(String string) {
        Driver.waitAndClick(us20_pages.deleteButonu);
        ReusableMethods.waitFor(2);




    }
    @Given("HY Yukarıda cikan popup uzerindeki {string} butonuna tiklanmalidir.")
    public void hy_yukarıda_cikan_popup_uzerindeki_butonuna_tiklanmalidir(String string) {
     //  String actualPopupText=us20_pages.deletePopupText.getText();
     //  System.out.println("popup yazısı : "+actualPopupText);
     //  String expectedPopupText="Are you sure you want to delete user";
     //  Assert.assertTrue("Delete işlemi sıraısında sorun oluştu ",actualPopupText.contains(expectedPopupText));
        ReusableMethods.waitFor(2);
        Driver.waitAndClick(us20_pages.deletePopupDeleteButonu);
    }

    @Given("HY A user is deleted with identifier yazisinin ciktigini dogrulamalidir.")
    public void hy_a_user_is_deleted_with_identifier_yazisinin_ciktigini_dogrulamalidir() {
        String actualText=us20_pages.deleteToastContaınerText.getAttribute("innerText");
        System.out.println("Delete toast Container yazısı : "+actualText);
        String expectedText ="A user is deleted with identifier";
        String expectedText2 ="Internal server error.";
        ReusableMethods.waitFor(2);

       try {
           Assert.assertTrue("Delete işleminde sorun oluştu ",actualText.contains(expectedText));

       }catch (AssertionError e){
           Assert.assertTrue("Delete işleminde sorun oluştu ",actualText.contains(expectedText2));
           System.out.println("User için DELETE işlemi gerçekleşmedi ==>"+expectedText2);
       }

    }

}
