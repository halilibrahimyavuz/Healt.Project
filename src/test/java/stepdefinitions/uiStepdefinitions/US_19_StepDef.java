package stepdefinitions.uiStepdefinitions;

import io.cucumber.java.en.*;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.US_19_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US_19_StepDef {

    US_19_pages us_19_pages = new US_19_pages();
    Actions actions=new Actions(Driver.getDriver());


    @Given("Admin url'e gider.")
    public void admin_url_e_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("medunna_url"));
    }

    @Then("Admin insan ikonuna tiklar")
    public void adminInsanIkonunaTiklar() throws InterruptedException {
        Thread.sleep(2000);
        us_19_pages.insanikonu.click();
    }


    @Then("Admin signin sekmesine tiklar")
    public void admin_signin_sekmesine_tiklar() throws InterruptedException {
        Thread.sleep(1000);
        us_19_pages.signinSekmesi.click();

    }
    @Then("Admin bir  username saglar")
    public void admin_bir_username_saglar() {
       Driver.waitAndClick(us_19_pages.usernametextBox);
        actions.sendKeys(ConfigReader.getProperty("rusername")).perform();
    }
    @Then("Admin bir password saglar")
    public void admin_bir_password_saglar() {
         us_19_pages.passwordtextBox.click();
         actions.sendKeys(ConfigReader.getProperty("rpassword")).perform();
    }
    @Then("Admin sign in buttonuna tiklar")
    public void admin_sign_in_buttonuna_tiklar() {
         us_19_pages.signinButtonu.click();
    }

    @Then("Admin items-titles'e butonuna tiklar")
    public void admin_items_titles_e_butonuna_tiklar() throws InterruptedException {
        Thread.sleep(2000);
        Driver.waitAndClick(us_19_pages.itemsTitlesButton);
        //us_19_pages.itemsTitlesButton.click();

    }


    @Then("Admin acilan sekmede Staff'a tiklar")
    public void admin_acilan_sekmede_staff_a_tiklar() throws InterruptedException {
        Thread.sleep(500);
        Driver.waitAndClick(us_19_pages.staffSekmesi);

    }
    @Then("Admin Create a new Staff'a tiklar")
    public void admin_create_a_new_staff_a_tiklar() throws InterruptedException {
        Thread.sleep(500);
        Driver.waitAndClick(us_19_pages.createButtonu);


    }
    @Then("Admin Snn girer")
    public void admin_snn_girer() {
        us_19_pages.searcSsnTextBox.sendKeys(ConfigReader.getProperty("rasearchssn"));

    }
    @Then("Admin Use Search tiklar")
    public void admin_use_search_tiklar() {
        Driver.waitAndClick(us_19_pages.useSsnSearchTikla);

    }
    @Then("Admin  Search User 'a tiklar")
    public void admin_search_user_a_tiklar() throws InterruptedException {
        Thread.sleep(500);
        Driver.waitAndClick(us_19_pages.searchtextBox);
    }
    @And("Sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }

    //TC_02'nin adimlari

    @Then("Admin acilan sayfada son sayfaya gider")
    public void admin_acilan_sayfada_son_sayfaya_gider() throws InterruptedException {
        //actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        //wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(16));
        //wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody//tr//td[1]"),20));
        //ReusableMethods.scroolDownToVisibleElement(us_19_pages.goLastpageButonelement);
        //ReusableMethods.waitFor(2);
        //us_19_pages.goLastpageButonelement.click();

        Driver.waitAndClick(us_19_pages.testID);

    }
    @Then("Admin kayitli Staff'in Editine tiklar")
    public void admin_kayitli_staff_in_editine_tiklar() throws InterruptedException {
           //Thread.sleep(2000);
           //us_19_pages.kayitliStaff.click();
        actions.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
          Driver.waitAndClick(us_19_pages.editButtonu);
    }
    @Then("Admin bos alanlari doldurur")
    public void admin_bos_alanlari_doldurur() {
        //us_19_pages.editfirstname.click();
        //us_19_pages.editfirstname.clear();
        Driver.waitAndClick(us_19_pages.countryTextBox);
        Driver.waitAndClick(us_19_pages.turkyElementi);
        us_19_pages.turkyElementi.click();
        actions.sendKeys(Keys.TAB);
        Select select =new Select(us_19_pages.statetextBox);
        select.selectByIndex(2);

        //Driver.waitAndClick(us_19_pages.saveButtonu);
    }

    //TC_03'ün stepleri

    @Then("Admin kayitli Staffta view'e tiklar")
    public void adminKayitliStafftaViewETiklar() {
        actions.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
        Driver.waitAndClick(us_19_pages.viewButton);
    }


    @And("Admin kayitli staffi delete eder")
    public void adminKayitliStaffiDeleteEder() {
        Driver.waitAndClick(us_19_pages.testID);
        actions.sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).sendKeys(Keys.ARROW_RIGHT).perform();
        Driver.waitAndClick(us_19_pages.deleteButtonu);

    }
}
