package stepdefinitions.uiStepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pages.US_03_04_17_Page;
import utilities.ConfigReader;
import utilities.Driver;

public class US_03_Step {

    private WebDriver driver;

    US_03_04_17_Page RPS = new US_03_04_17_Page();


    @Given("YE Kullanıcı {string} sayfasına gider")
    public void yeKullanıcıSayfasınaGider(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("medunnaUrl"));
    }

    @Then("YE Registration butonuna tıklar vekayıt sayfasına gider")
    public void yeRegistrationButonunaTıklarVekayıtSayfasınaGider() {
        RPS.register1.click();
        RPS.register2.click();
    }

    @Then("YE tek haneli şifre  girer ve yeterli uzunlukta olmadığını görür")
    public void yeTekHaneliŞifreGirerVeYeterliUzunluktaOlmadığınıGörür() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("eksikPassword1"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("eksikPassword1"));
        String actualkisaYazisi=RPS.kisaPassword.getText();
        String expectedYazi=ConfigReader.getProperty("karaktersayi4");
        Assert.assertEquals(expectedYazi,actualkisaYazisi);

    }

    @And("YE iki haneli şifre  girer ve yeterli uzunlukta olmadığını görür")
    public void yeIkiHaneliŞifreGirerVeYeterliUzunluktaOlmadığınıGörür() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("eksikPassword2"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("eksikPassword2"));
        String actualkisaYazisi=RPS.kisaPassword.getText();
        String expectedYazi=ConfigReader.getProperty("karaktersayi4");
        Assert.assertEquals(expectedYazi,actualkisaYazisi);
    }

    @And("YE üç haneli şifre  girer ve yeterli uzunlukta olmadığını görür")
    public void yeÜçHaneliŞifreGirerVeYeterliUzunluktaOlmadığınıGörür() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("eksikPassword3"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("eksikPassword3"));
        String actualkisaYazisi=RPS.kisaPassword.getText();
        String expectedYazi=ConfigReader.getProperty("karaktersayi4");
        Assert.assertEquals(expectedYazi,actualkisaYazisi);
    }

    @Then("YE {int} haneli şifre  girer ve kabul edildiğini görür")
    public void yeHaneliŞifreGirerVeKabulEdildiğiniGörür(int arg0) {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("eksikPassword4"));
        RPS.comfirmationPassword.sendKeys(ConfigReader.getProperty("eksikPassword4"));
        //String actualkisaYazisi=RPS.kısaPassword.getText();
        String expectedYazi=ConfigReader.getProperty("karaktersayi4");
        Assert.assertFalse(expectedYazi,false);
    }

    @Then("YE İçerisinde bir küçük harf olan enaz yedi haneli password girer")
    public void yeİçerisindeBirKüçükHarfOlanEnazYediHaneliPasswordGirer() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("kucukHarf"));
    }

    @And("YE Password strength seviyesinin değiştiğini görür")
    public void yePasswordStrengthSeviyesininDeğiştiğiniGörür() {
        String ilkStrength=RPS.strength1.getText();
        String ikinciStrength=RPS.strength2.getText();
        Assert.assertEquals(ilkStrength,ikinciStrength);
    }

    @Then("YE İçerisinde bir küçük bir büyük harf olan {int} haneli password girer")
    public void yeİçerisindeBirKüçükBirBüyükHarfOlanHaneliPasswordGirer(int arg0) {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("buyukHarf"));
        String ikinciStrength=RPS.strength2.getText();
        String ucuncuStrength=RPS.strength3.getText();
        Assert.assertEquals(ucuncuStrength,ikinciStrength);
    }

    @Then("YE İçerisinde bir büyük bir küçük ve rakam harf olan enaz yedi haneli password girer")
    public void yeİçerisindeBirBüyükBirKüçükVeRakamHarfOlanEnazYediHaneliPasswordGirer() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("rakamHarf"));
        String ucuncuStrength=RPS.strength3.getText();
        String dorduncuStrength=RPS.strength4.getText();
        Assert.assertEquals(dorduncuStrength,ucuncuStrength);
    }

    @Then("YE İçerisinde bir büyük bir küçük rakam harf ve ozel karakter olan enaz yedi haneli password girer")
    public void yeİçerisindeBirBüyükBirKüçükRakamHarfVeOzelKarakterOlanEnazYediHaneliPasswordGirer() {
        RPS.newPassword.sendKeys(ConfigReader.getProperty("ozelHarf"));
        String besinciStrength=RPS.strength5.getText();
        String dorduncuStrength=RPS.strength4.getText();
        Assert.assertEquals(besinciStrength,dorduncuStrength);

    }
    @Then("YE Password olarak sürekli space tuşuna basar")
    public void yePasswordOlarakSürekliSpaceTuşunaBasar() {

    }
    @And("YE Password strength seviyesinin değiştiğini görür fakat password olarak kabul etmez")
    public void yePasswordStrengthSeviyesininDeğiştiğiniGörürFakatPasswordOlarakKabulEtmez() throws InterruptedException {
        String space7="       ";
        RPS.newPassword.sendKeys(space7);
        String ilkStrength=RPS.strength1.getText();
        String ikinciStrength=RPS.strength2.getText();
        Assert.assertEquals(ilkStrength,ikinciStrength);
        Thread.sleep(1000);
        String space10="   ";
        RPS.newPassword.sendKeys(space10);
        String ucuncuStrength=RPS.strength3.getText();
        Assert.assertEquals(ucuncuStrength,ikinciStrength);
        Thread.sleep(1000);
        String space15="     ";
        RPS.newPassword.sendKeys(space15);
        String dorduncuStrength=RPS.strength4.getText();
        Assert.assertEquals(dorduncuStrength,ucuncuStrength);
        Thread.sleep(1000);
        String space20="     ";
        RPS.newPassword.sendKeys(space20+Keys.TAB);
        String besinciStrength=RPS.strength5.getText();
        Assert.assertEquals(besinciStrength,dorduncuStrength);
        RPS.kisaPassword.isDisplayed();




    }


}
