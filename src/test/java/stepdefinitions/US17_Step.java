package stepdefinitions;


import Pojos.TestItems;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.US_03_04_17_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;
import utilities.ReusableMethods;

import static io.restassured.RestAssured.given;

public class US17_Step {

    Response response;
    TestItems testItem = new TestItems();
    US_03_04_17_Page RPS = new US_03_04_17_Page();

    //######################################################################################

    @Then("YE Sing in butonuna tıklar ve giriş sayfasına gider")
    public void yeSingInButonunaTıklarVeGirişSayfasınaGider() throws InterruptedException {
        RPS.register1.click();
        Thread.sleep(1000);
        RPS.singInButton1.click();
    }
    @And("YE Geçerli bir kullanıcı adı ve password girer ve Admin kullanıcı sayfasına ulaşır")
    public void yeGeçerliBirKullanıcıAdıVePasswordGirerVeAdminKullanıcıSayfasınaUlaşır() throws InterruptedException {
        RPS.userBox.sendKeys(ConfigReader.getProperty("adminUser17") + Keys.TAB);
        RPS.passwordBox.sendKeys(ConfigReader.getProperty("adminPassword17") + Keys.ENTER);
    }
    @Then("YE Items-Titles menusu altında Test Item a tıklar")
    public void yeItemsTitlesMenusuAltındaTestItemATıklar() throws InterruptedException {
        Driver.waitAndClick(RPS.itemTitle);
        Thread.sleep(1000);
        Driver.waitAndClick(RPS.testItem);
    }
    @And("YE Create a new Test Item butonuna tıklar ve Create or edit a Test Item sayfasına ulaşır")
    public void yeCreateANewTestItemButonunaTıklarVeCreateOrEditATestItemSayfasınaUlaşır() throws InterruptedException {
        RPS.createTestItem.click();
        Thread.sleep(1000);
    }
    @Then("YE İstenen {string}, {string}, {string}, {string}, {string} dataları girer ve Save butonuna tıklar")
    public void yeİstenenDatalarıGirerVeSaveButonunaTıklar(String name, String description, String price, String defaultValMin, String defaultValMax) {
        RPS.testName.sendKeys(name);
        RPS.testdescription.sendKeys(description);
        RPS.testPrice.sendKeys(price);
        RPS.minValue.sendKeys(defaultValMin);
        RPS.maxValue.sendKeys(defaultValMax);
        Driver.waitAndClick(RPS.saveButton);
    }
    @And("YE kayıt yaptiğini test eder")
    public void yeKayıtYaptiğiniTestEder() throws InterruptedException {
        ReusableMethods.waitFor(2);
        String basarili="A new Test Item is created with identifier";
        RPS.islemBasarili.getText().contains(basarili);
        Driver.closeDriver();
        /*System.out.println("kyit mesaji :"+RPS.islemBasarili.getText());
        String mesage=RPS.islemBasarili.getText();
        String arr[]=mesage.split(" ");
        System.out.println(Arrays.toString(arr));
        String id=arr[8];
        System.out.println(id);*/
    }

    //######################################################################################

    @And("YE Verilen ID li kaydı bulur ve View butonuna tıkla")
    public void yeVerilenIDLiKaydıBulurVeViewButonunaTıkla() throws InterruptedException {
        Driver.waitAndClick(RPS.testID);
        Thread.sleep(1000);
        Driver.waitAndClick(RPS.view);
        Thread.sleep(2000);
    }
    @Then("YE Test-Item i görüntüleyebildiğini test eder.")
    public void yeTestItemIGörüntüleyebildiğiniTestEder() throws InterruptedException {
        System.out.println(JSUtils.getUrlByJS());
        String actMesage=RPS.viewSayfa.getText();
        String expMesage="Test Item";
        System.out.println(actMesage);
        Assert.assertEquals(expMesage,actMesage);
        Driver.closeDriver();
    }

    //######################################################################################

    @And("YE  Edit butonuna tıklar")
    public void yeEditButonunaTıklar() throws InterruptedException {
        Driver.waitAndClick(RPS.testID);
        Thread.sleep(1000);
        Driver.waitAndClick(RPS.edit);
        Thread.sleep(1000);
    }
    @Then("YE Verileri dataları değiştirir ve Save butonuna basar")
    public void yeVerileriDatalarıDeğiştirirVeSaveButonunaBasar() {
        Driver.waitAndSendText(RPS.testName, ConfigReader.getProperty("name"));
        Driver.waitAndSendText(RPS.testdescription,ConfigReader.getProperty("description"));
        Driver.waitAndSendText(RPS.testPrice,ConfigReader.getProperty("price"));
        Driver.waitAndSendText(RPS.minValue,ConfigReader.getProperty("defaultValMin"));
        Driver.waitAndSendText(RPS.maxValue,ConfigReader.getProperty("defaultValMax"));
        Driver.waitAndClick(RPS.saveButton);
    }
    @And("YE kaydı güncelleyebildiğini test eder")
    public void yeKaydıGüncelleyebildiğiniTestEder() {
        ReusableMethods.waitFor(2);
        String upDate="A Test Item is updated";
        RPS.islemBasarili.getText().contains(upDate);
        Driver.closeDriver();
    }

    //######################################################################################

    @And("YE Verilen ID li kaydı bulur ve Delete butonuna tıkla")
    public void yeVerilenIDLiKaydıBulurVeDeleteButonunaTıkla() throws InterruptedException {
        Driver.waitAndClick(RPS.testID);
        Thread.sleep(1000);
        Driver.waitAndClick(RPS.delete);
        Thread.sleep(1000);
        Driver.waitAndClick(RPS.delete2);
    }
    @Then("YE mevcut kaydı sildiğini test eder")
    public void yeMevcutKaydıSildiğiniTestEder() {
        ReusableMethods.waitFor(2);
        String Delete="A Test Item is deleted";
        RPS.islemBasarili.getText().contains(Delete);
        Driver.closeDriver();
    }

}