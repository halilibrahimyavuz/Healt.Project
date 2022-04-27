package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.US_03_04_17_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;


public class US_04_Step {



    US_03_04_17_Page RPS = new US_03_04_17_Page();

    @And("YE Sing in butonuna tıklar ve giris sayfasına gider")
    public void yeSingInButonunaTıklarVeGirisSayfasınaGider() throws InterruptedException {
        RPS.register1.click();
        RPS.singInButton1.click();

    }

    @Then("YE Geçerli bir kullanıcı adı ve şifre girer ve Sing in butonuna tıklar")
    public void yeGeçerliBirKullanıcıAdıVeŞifreGirerVeSingInButonunaTıklar() throws InterruptedException {
        RPS.userBox.sendKeys(ConfigReader.getProperty("validUserName") + Keys.TAB);
        RPS.passwordBox.sendKeys(ConfigReader.getProperty("validPassword") + Keys.ENTER);

    }

    @And("YE başarılı bir giriş yapabildiğini görür")
    public void yeBaşarılıBirGirişYapabildiğiniGörür() {
        String actUrl= JSUtils.getUrlByJS();
        String expUrl="https://medunna.com/login";
        Assert.assertEquals(expUrl,actUrl);

    }

    @And("YE Remember me sçeneğini görebilir")
    public void yeRememberMeSçeneğiniGörebilir() {
        RPS.rememberMe.isDisplayed();
    }

    @Then("YE Remember me sçeneğine tıklayabilir")
    public void yeRememberMeSçeneğineTıklayabilir() {
        JSUtils.clickElementByJS(RPS.rememberMe);
        RPS.rememberCheckBox.isDisplayed();
        }

    @Then("YE Did you forget your password? secenegini görür")
    public void yeDidYouForgetYourPasswordSeceneginiGörür() {
        RPS.sifremiUnuttum.isDisplayed();
    }

    @And("YE butona tıkladığında Reset your password sayfanına gider")
    public void yeButonaTıkladığındaResetYourPasswordSayfanınaGider() {
        JSUtils.clickElementByJS(RPS.sifremiUnuttum);
        String expUrl="https://medunna.com/account/reset/request";
        String actUrl=JSUtils.getUrlByJS();
        Assert.assertEquals(expUrl,actUrl);
    }

    @And("YE You don't have an account yet? Register a new account seçeneğini görebilmeli")
    public void yeYouDonTHaveAnAccountYetRegisterANewAccountSeçeneğiniGörebilmeli() {
        RPS.newAccount.isDisplayed();
    }

    @Then("YE You don't have an account yet? butonuna tıkladığında ve Registration sayfasına gidebilmeli")
    public void yeYouDonTHaveAnAccountYetButonunaTıkladığındaVeRegistrationSayfasınaGidebilmeli() {
        JSUtils.clickElementByJS(RPS.newAccount);
        String actUrl=JSUtils.getUrlByJS();
        String expUrl="https://medunna.com/account/register";
        Assert.assertEquals(expUrl,actUrl);
    }

    @And("YE Cancel butonunu görebilmeli")
    public void yeCancelButonunuGörebilmeli() throws InterruptedException {
        RPS.cancel.isDisplayed();
        System.out.println(JSUtils.getUrlByJS());
    }

    @Then("YE Cancel butonuna tıkladığında {string} sayfasından çıkabilmeli")
    public void yeCancelButonunaTıkladığındaSayfasındanÇıkabilmeli(String arg0) {
       JSUtils.clickElementByJS(RPS.cancel);
       String actUrl=JSUtils.getUrlByJS();
       String expUrl="https://medunna.com/home";
       Assert.assertEquals(expUrl,actUrl);

    }

  @And("singOut yapar ve sayfayı kapatır")
    public void singoutYaparVeSayfayıKapatır() {
        RPS.register1.click();
        RPS.singOut.click();
      Driver.closeDriver();
    }


}