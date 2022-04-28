package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.US0018_page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US0018_stepdefinitions {

    US0018_page onsekiz=new US0018_page();
    Actions actions=new Actions(Driver.getDriver());
    Faker faker=new Faker();


    @Given("BA Medunna url gider")
    public void ba_medunna_url_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }
    @Given("BA Account menu tiklar")
    public void ba_account_menu_tiklar() {
        ReusableMethods.waitFor(1);
        onsekiz.AccountButon.click();

    }
    @Given("BA Sign in Enter tiklar")
    public void ba_sign_in_enter_tiklar() {
        ReusableMethods.waitFor(1);
        onsekiz.SigninButon.click();

    }
    @Given("BA Admin Username girer")
    public void ba_admin_username_girer() {
        onsekiz.UsernameBA.sendKeys(ConfigReader.getProperty("UsernameBA"));

    }
    @Given("BA Admin Password girer")
    public void ba_admin_password_girer() {
        onsekiz.PasswordBA.sendKeys(ConfigReader.getProperty("PasswordBA"));

    }
    @When("BA Sign in Enter tiklar Admin olarak giris yapar")
    public void ba_sign_in_enter_tiklar_admin_olarak_giris_yapar() {
        ReusableMethods.waitFor(1);
        onsekiz.SigninEnter.click();

    }
    @Then("BA Items Titles butona tiklar")
    public void ba_items_titles_butona_tiklar() {
        ReusableMethods.waitFor(1);
        onsekiz.ItemsTitles.click();

    }
    @Then("BA Physician butonuna tiklar")
    public void ba_physician_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        onsekiz.Physician.click();

    }
    @Then("BA Create a new Physician  butonuna tiklar")
    public void ba_create_a_new_physician_butonuna_tiklar() {
        onsekiz.CreateANewPhysician.click();

    }
    @Then("BA Use Search butonuna tiklar")
    public void ba_use_search_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        onsekiz.UseSearch.click();

    }
    @Then("BA Kayitli SSN girer")
    public void ba_kayitli_ssn_girer() {
        onsekiz.SearchSsnButon.sendKeys("174-72-3014");

    }
    @When("BA Search User butonuna tiklar")
    public void ba_search_user_butonuna_tiklar() {
        onsekiz.SearchUser.click();

    }
    @Then("BA User Found mesajini gorur")
    public void ba_user_found_mesajini_gorur() {
        onsekiz.UserFoundSuccessAlertText.isDisplayed();

    }

    @Given("BA Firstname girer")
    public void ba_firstname_girer() {
        onsekiz.FirstName.sendKeys(faker.name().firstName());
    }
    @Given("BA Lastname girer")
    public void ba_lastname_girer() {
        onsekiz.LastName.sendKeys(faker.name().lastName());

    }
    @Given("BA Birthdate girer")
    public void ba_birthdate_girer() {
        onsekiz.Birthdate.sendKeys("01/01/1983");

    }
    @Then("BA Phone number girer")
    public void ba_phone_number_girer() {
        onsekiz.Phone.sendKeys("917/174/138");

    }
    @Given("BA Doktor icin uzmanlik alani secer")
    public void ba_doktor_icin_uzmanlik_alani_secer() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,370)");
        ReusableMethods.waitFor(2);
        Select uzmanlik=new Select(onsekiz.Speciality);
        uzmanlik.selectByIndex(8);
    }

    @Given("BA Doktorun profil resmini yukler")
    public void ba_doktorun_profil_resmini_yukler() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,750)");
        Thread.sleep(2000);
        String path=System.getProperty("user.home")+"\\Desktop\\gif.png";
        onsekiz.Image.sendKeys(path);
        Thread.sleep(2000);




    }
    @Given("BA Doktorun muayene ucretini girer.")
    public void ba_doktorun_muayene_ucretini_girer() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.waitFor(3);
        js.executeScript("window.scrollBy(0,1100)");
        onsekiz.ExamFee.sendKeys("500");


    }
    @Given("BA Kayitli kullanicilar arasindan doktoru secer")
    public void ba_kayitli_kullanicilar_arasindan_doktoru_secer() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,1100)");
        Thread.sleep(2000);
        Select dermandar=new Select(onsekiz.User);
        dermandar.selectByValue("44189");
        ReusableMethods.waitFor(2);

    }
    @Given("BA Doktorlarin bilgilerini gorur")
    public void ba_doktorlarin_bilgilerini_gorur() throws InterruptedException {
        Thread.sleep(10000);
        Driver.waitForVisibility(onsekiz.PhysiciandID,5);
        Driver.waitForVisibility(onsekiz.PhysiciansSSN,5);
        Driver.waitForVisibility(onsekiz.PhysiciansFirstname,5);
        Driver.waitForVisibility(onsekiz.PhysiciansLastname,5);

    }

    @Then("BA Doktorun bilgisini duzenlemek icin Edit butona tiklar")
    public void ba_doktorun_bilgisini_duzenlemek_icin_edit_butona_tiklar() throws InterruptedException {
        Thread.sleep(15000);
        onsekiz.Edit.click();
        Thread.sleep(1000);
        Driver.waitAndClickElement(onsekiz.UseSearch,10);
        Thread.sleep(1000);
        onsekiz.SearchSsnButon.sendKeys("174-72-3014");
        Thread.sleep(1000);
        onsekiz.SearchUser.click();
        Thread.sleep(1000);
        onsekiz.EditPageFirstname.clear();
        onsekiz.EditPageFirstname.sendKeys("Cassion");
        onsekiz.EditPageLastname.clear();
        onsekiz.EditPageLastname.sendKeys("Lincoooln");
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(1000);
        onsekiz.EditPageAddress.clear();
        onsekiz.EditPageAddress.sendKeys(faker.address().fullAddress());
        Thread.sleep(2000);
        onsekiz.EditPageDescription.clear();
        onsekiz.EditPageDescription.sendKeys("Patient Info");
        Thread.sleep(2000);
        onsekiz.EditPageExamFee.clear();
        onsekiz.EditPageExamFee.sendKeys("1000");
        Thread.sleep(2000);

    }

    @Then("BA Mevcut  doktoru siler")
    public void ba_mevcut_doktoru_siler() throws InterruptedException {
        Thread.sleep(10000);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,2275)");
        Thread.sleep(8000);
        js.executeScript("arguments[0].scrollBy(800, 0);",onsekiz.TableResponsive);
        Thread.sleep(3000);
        onsekiz.birinciSayfaDelete.click();
        Thread.sleep(3000);
        onsekiz.birinciSayfaCancel.click();
        Thread.sleep(3000);



    }


}

