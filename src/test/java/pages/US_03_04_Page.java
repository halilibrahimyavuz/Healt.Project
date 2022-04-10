package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US_03_04_Page {

    public US_03_04_Page(){
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
    public WebElement kısaPassword;

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

    WebDriver driver;
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

}
