package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_03_04_17_Page {
    public US_03_04_17_Page(){
        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//div/ul/li[@id = 'account-menu']")
    public WebElement register1;

    @FindBy(xpath = "//div/ul//li[7]//span[text()='Register']")
    public WebElement register2;

    @FindBy (xpath = "//input[@name='firstPassword']")
    public WebElement newPassword;

    @FindBy (xpath = "//input[@name='secondPassword']")
    public WebElement comfirmationPassword;

    @FindBy (xpath = "//div[@class='invalid-feedback']")
    public WebElement kisaPassword;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[1]")
    public WebElement strength1;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[2]")
    public WebElement strength2;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[3]")
    public WebElement strength3;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[4]")
    public WebElement strength4;

    @FindBy(xpath = "(//div/ul/li[@class='point'])[5]")
    public WebElement strength5;


    @FindBy (xpath = "//span[text()='Sign in']")
    public WebElement singInButton1;

    @FindBy(xpath = "//input[@placeholder='Your username']")
    public WebElement userBox;

    @FindBy (xpath = "//input[@placeholder='Your password']")
    public WebElement passwordBox;

    @FindBy (xpath = "//input[@id='rememberMe']")
    public WebElement rememberMe;

    @FindBy(xpath = "//input[@value='true']")
    public WebElement rememberCheckBox;

    @FindBy(xpath = "//a[@href='/account/reset/request']")
    public WebElement sifremiUnuttum;

    @FindBy (xpath = "(//div/a[@href='/account/register'])[2]")
    public WebElement newAccount;

    @FindBy (xpath = "(//div/button[@type='button'])[2]")
    public WebElement cancel;

    @FindBy (xpath = "//span[text()='Sign out']")
    public WebElement singOut;

    @FindBy (xpath = "//span[text()='Items&Titles']")
    public WebElement itemTitle;

    @FindBy (xpath = "//span[text()='Test Item']")
    public WebElement testItem;

    @FindBy (xpath = "//span[text()='Create a new Test Item']")
    public WebElement createTestItem;

    @FindBy (xpath = "//input[@name='name']")
    public WebElement testName;

    @FindBy (xpath = "//input[@name='description']")
    public WebElement testdescription;

    @FindBy (xpath = "//input[@name='price']")
    public WebElement testPrice;

    @FindBy (xpath = "//input[@name='defaultValMin']")
    public WebElement minValue;

    @FindBy (xpath = "//input[@name='defaultValMax']")
    public WebElement maxValue;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement saveButton;

    //@FindBy (xpath = "//div[text()='A new Test Item is created with identifier 81844']")
    //public WebElement islemBasarili;

    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement islemBasarili;

    @FindBy (xpath = "//thead/tr/th[1]")
    public WebElement testID;

    @FindBy (xpath = "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement view;

    @FindBy (xpath = "(//span[text()='Test Item'])[2]")
    public WebElement viewSayfa;

    @FindBy (xpath = "//span[text()='Edit']")
    public WebElement edit;

    @FindBy (xpath = "(//span[text()='Delete'])[1]")
    public WebElement delete;

    @FindBy (xpath = "(//div/button[@type='button'])[3]")
    public WebElement delete2;



}
