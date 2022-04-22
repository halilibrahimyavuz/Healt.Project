package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US25_Pages {

    public US25_Pages(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement insanIkonuElementi;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signinSekmesiElementi;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement UsernameTextbox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement PasswordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signinBotunuElementi;

    @FindBy(xpath = "//span[text()='Mehmet memet']")
    public WebElement girisYapilabildiYazisi;

    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement MypagesSekmesiElementi;

    @FindBy(xpath = "//span[text()='Make an Appointment']")
    public WebElement makeanAppointmentElementi;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstnameTextbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement SendanAppointmentRequestElementi;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement randevualindiYazisi;

    //TC-02 icin
    @FindBy(xpath = "(//a[@href='#appointment'])[1]")
    public WebElement makeanappointmentElementi;

    @FindBy(xpath = "//span[.='Appointment date can not be past date!']")
    public WebElement tarihHataliUyariYazisi;

    @FindBy(xpath = "//input[@name='appoDate']")
    public WebElement DateTimeBox;

    @FindBy(xpath = "//div[@class='Toastify__toast-body']")
    public WebElement kayitYapildiYazisi;



}
