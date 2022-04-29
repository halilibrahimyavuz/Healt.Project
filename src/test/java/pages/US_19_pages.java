package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_19_pages {

    public US_19_pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div/ul/li[@id = 'account-menu']")
    public WebElement insanikonu;

    @FindBy(xpath = "//span[text()='Sign in']")
    public WebElement signinSekmesi;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernametextBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordtextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signinButtonu;

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemsTitlesButton;

    @FindBy(xpath = "//span[text()='Staff']")
    public WebElement staffSekmesi;

    @FindBy(xpath = "//span[text()='Create a new Staff']")
    public WebElement createButtonu;

    @FindBy(xpath = "//input[@name='searchSSN']")
    public WebElement searcSsnTextBox;

    @FindBy(xpath = "//input[@name='useSSNSearch']")
    public WebElement useSsnSearchTikla;

    @FindBy(xpath = "//button[text()='Search User']")
    public WebElement searchtextBox;

    //TC_02'nin locatleri
    @FindBy(xpath = "//a[.='»»']")
    public WebElement goLastpageButonelement;

    @FindBy(xpath = "(//a[@class='page-link'])[5]")
    public WebElement sayfaSonunaGel;

    @FindBy(xpath = "((//a[@class='btn btn-primary btn-sm'])[4]")
    public WebElement kayitliStaff;

    @FindBy (xpath = "//thead/tr/th[1]")
    public WebElement testID;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[5]")
    public WebElement editButtonu;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[5]")
    public WebElement deleteButtonu;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement editfirstname;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement countryTextBox;

    @FindBy(xpath = "//option[@value='1202']")
    public WebElement turkyElementi;

    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement statetextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveButtonu;

    @FindBy(xpath = "(//a[@class='btn btn-info btn-sm'])[6]")
    public WebElement viewButton;







}
