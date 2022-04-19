package stepdefinitions.uiStepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import pages.US14_pages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US14_stepdefinitions {

    US14_pages usondort = new US14_pages();
    Faker faker=new Faker();




    @Given("BA Physician medunna url gider")
    public void ba_physician_medunna_url_gider() {

        Driver.getDriver().get(ConfigReader.getProperty("url"));

    }

    @Given("BA Account butonuna tiklar")
    public void ba_account_butonuna_tiklar()  {
        ReusableMethods.waitFor(1);
        usondort.accountMenu.click();

    }

    @Given("BA Sign in butonuna tiklar")
    public void ba_sign_in_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        usondort.SigninButon1.click();

    }

    @Given("BA Physician username ve password girer")
    public void ba_physician_username_ve_password_girer() {

        usondort.username.sendKeys(ConfigReader.getProperty("username"));
        usondort.password.sendKeys(ConfigReader.getProperty("password"));

    }

    @Then("BA Sign in butonuna tiklar ve giris yapar")
    public void ba_sign_in_butonuna_tiklar_ve_giris_yapar() {
        ReusableMethods.waitFor(1);
        usondort.SigninButon2.click();

    }

    @When("BA MY PAGES butonuna tiklar")
    public void ba_my_pages_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        usondort.mypages.click();

    }

    @When("BA My Inpatients butonuna tiklar")
    public void ba_my_inpatients_butonuna_tiklar() {

        usondort.MyInpatients.click();

    }

    @Then("BA In Patients basligi gorulur")
    public void ba_in_patients_basligi_gorulur()  {
        ReusableMethods.waitFor(1);
        System.out.println(usondort.InPatientsYazisi.getText());
        Assert.assertTrue(usondort.InPatientsYazisi.isDisplayed());


    }
    @Then("BA DoctorID goruntuler")
    public void ba_doctor_id_goruntuler() {

        Assert.assertTrue(usondort.inPatientsPageID.isDisplayed());


    }
    @Then("BA StartDate goruntuler")
    public void ba_start_date_goruntuler() {
        Assert.assertTrue(usondort.inpatientsPageStartDate.isDisplayed());

    }
    @Then("BA EndDate goruntuler")
    public void ba_end_date_goruntuler() {
        Assert.assertTrue(usondort.inpatientsPageEndDate.isDisplayed());

    }
    @Then("BA Status durumunu goruntuler")
    public void ba_status_durumunu_goruntuler() {
        Assert.assertTrue(usondort.inpatientsPageStatus.isDisplayed());


    }
    @Then("BA CreatedDate goruntuler")
    public void ba_created_date_goruntuler() {

        Assert.assertTrue(usondort.inpatientsPageCreatedDate.isDisplayed());

    }
    @Then("BA Room bilgisini goruntuler")
    public void ba_room_bilgisini_goruntuler() {

        Assert.assertTrue(usondort.inpatientsPageRoom.isDisplayed());

    }
    @Then("BA AppointmentID goruntuler")
    public void ba_appointment_id_goruntuler() {

        Assert.assertTrue(usondort.inpatientsPageAppointment.isDisplayed());

    }
    @Then("BA Patient bilgisini goruntuler")
    public void ba_patient_bilgisini_goruntuler() {
        Assert.assertTrue(usondort.inpatientsPagePatient.isDisplayed());


    }

    @Then("BA Edit butonuna tiklar")
    public void ba_edit_butonuna_tiklar() {
        ReusableMethods.waitFor(1);
        usondort.Edit.click();

    }

    @Then("BA Description bolumunu gunceller")
    public void ba_description_bolumunu_gunceller() throws InterruptedException {

        ReusableMethods.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,250)");
        usondort.EditPageDescription.clear();
        usondort.EditPageDescription.sendKeys(faker.medical().symptoms());



    }
    @Then("BA Created Date bolumunu gunceller")
    public void ba_created_date_bolumunu_gunceller() {
        ReusableMethods.waitFor(1);
        usondort.EditPageCreatedDate.sendKeys("08/08/2022");
    }


    @Then("BA Status durumunu gunceller")
    public void ba_status_durumunu_gunceller() {

        Select select=new Select(usondort.EditPageStatus);
        select.selectByIndex(1);

    }
    @When("BA Room bolumu guncellenir")
    public void ba_room_bolumu_guncellenir() {
        Select select=new Select(usondort.EditPageroom);
        select.selectByIndex(6);

    }
    @Then("BA Save butonuna tiklar")
    public void ba_save_butonuna_tiklar() {
        ReusableMethods.waitForClickablility(usondort.EditPageSave,5);



    }
    @Then("Ba Yeni giris yapmak icin sayfayi kapatir")
    public void ba_yeni_giris_yapmak_icin_sayfayi_kapatir() {
        Driver.closeDriver();
    }
    @Given("BA Create or edit sayfasinda ID bolumunu gunceller")
    public void ba_create_or_edit_sayfasinda_id_bolumunu_gunceller() {
        Driver.getDriver().get(ConfigReader.getProperty("url"));
        ReusableMethods.waitFor(1);
        usondort.accountMenu.click();
        ReusableMethods.waitFor(1);
        usondort.SigninButon1.click();
        ReusableMethods.waitFor(1);
        usondort.username.sendKeys(ConfigReader.getProperty("username"));
        usondort.password.sendKeys(ConfigReader.getProperty("password"));
        usondort.SigninButon2.click();
        ReusableMethods.waitFor(1);
        usondort.mypages.click();
        ReusableMethods.waitFor(1);
        usondort.MyInpatients.click();
        ReusableMethods.waitFor(1);
        usondort.Edit.click();

    }

    @Given("BA Create or edit sayfasinda ID StartDate EndDate Appointment Patient bolumunu gunceller")
    public void ba_create_or_edit_sayfasinda_id_start_date_end_date_appointment_patient_bolumunu_gunceller() throws InterruptedException {
        Thread.sleep(2000);
        usondort.EditPageID.sendKeys("6060");
        ReusableMethods.waitFor(1);
        usondort.EditPageStartDate.sendKeys("7070");
        ReusableMethods.waitFor(1);
        usondort.EditPageEndDate.sendKeys("8080");
        ReusableMethods.waitFor(1);
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollBy(0,365)");
        usondort.EditPageAppointment.click();
        usondort.EditPagePatient.click();
        usondort.EditPageSave.click();

    }

    @Then("BA Sayfayi kapatir")
    public void ba_sayfayi_kapatir() {
        ReusableMethods.waitFor(1);
        Driver.closeDriver();
    }

}

