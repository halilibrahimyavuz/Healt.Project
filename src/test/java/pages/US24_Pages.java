package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US24_Pages {


    public US24_Pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement insanIkonuElementi;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signinSekmesiElementi;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameTextbox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signinBotunuElementi;

    @FindBy(xpath = "//span[text()='Mehmet memet']")
    public WebElement girisYapildi;

    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement mypagesSekmesiElementi;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement myappointmentsElementi;

    @FindBy(xpath = "//h2[@id='appointment-heading']")
    public WebElement appointmentsRandevuSayfasi;

    @FindBy(xpath = "//input[@name='fromDate']")
    public WebElement fromDateTextBox;

    @FindBy(xpath = "//input[@name='toDate']")
    public WebElement toDateTextBox;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement showTestSekmesi;


    @FindBy(xpath = "//a[@class='btn btn-info btn-sm']")
    public WebElement viewResultsElementi;

    @FindBy(xpath = "(//a[@class='btn btn-link btn-sm'])[1]")
    public WebElement idDegeri;

    @FindBy(xpath = "(//tbody//tr//td)[2]")
    public WebElement nameDegeri;

    @FindBy(xpath = "(//tbody//tr//td)[4]")
    public WebElement defaultMinValueDegeri;

    @FindBy(xpath = "(//tbody//tr//td)[5]")
    public WebElement  defaultMaxValueDegeri;

    @FindBy(xpath = "(//tbody//tr//td)[6]")
    public WebElement testDegeri;

    @FindBy(xpath = "(//tbody//tr//td)[8]")
    public WebElement  dateDegeri;


    @FindBy(xpath = "//a[@class='btn btn-warning btn-sm']")
    public WebElement ShowInvoiceSekmesi;

    @FindBy(xpath = "//th[text()='INVOICE']")
    public WebElement faturaYazisiElementi;

   @FindBy(xpath = "//thead")
    public WebElement faturaResmi;
}


