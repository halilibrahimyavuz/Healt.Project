package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US01_pages {



    public US01_pages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div/ul/li[@id = 'account-menu']")
    public WebElement accountMenu;

    @FindBy(xpath = "//div/ul//li[7]//span[text()='Register']")
    public WebElement register2;

    @FindBy(id="ssn")
    public WebElement ssnTextBox;
    @FindBy(id = "firstName")
    public WebElement firstnameTextBox;
    @FindBy(id = "lastName")
    public WebElement lastnameTextBox;
    @FindBy(id = "username")
    public WebElement usernameTextBox;
    @FindBy(id = "email")
    public WebElement emailTextbox;
    @FindBy(xpath = "//*[text()='New password']/following::input")
    public WebElement firstPasswordTextBox;

    @FindBy(id= "secondPassword")
    public WebElement newPasswordTextBox;
    @FindBy(id = "register-submit")
    public WebElement registerButton;
    @FindBy(xpath = "//*[contains(text(),'Registration Saved')]")
    public WebElement successMessageToastContainer;
    @FindBy(xpath = "//span[.='Registration']")
    public WebElement registrationYaziElementi;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement SSNTextBox;

    @FindBy(xpath = "//div[.='Your SSN is required.']")
    public WebElement SSNBosBirakilmazYazisi;

    @FindBy(xpath = "//div[.='Your SSN is invalid']")
    public WebElement SSNGecersizYazisi;

    @FindBy(xpath = "//div[.='Your FirstName is required.']")
    public WebElement FirstnameBosBirakilmazYazisi;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement lastNameTextBox;

    @FindBy(xpath = "//div[.='Your LastName is required.']")
    public WebElement LastnameBosBirakilmazYazisi;


    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 0, 0)')]")
    public WebElement passwordStrength1;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(255, 153, 0)')]")
    public WebElement passwordStrength2;

    @FindBy(xpath = "//*[@id='strengthBar']/li[contains(@style,'rgb(153, 255, 0)')]")
    public WebElement passwordStrength3;

    @FindBy(xpath = "(//div[@class='invalid-feedback'])[1]")
    public WebElement ssnGecersizYazisi;

    @FindBy(xpath = "//div[.='Your username is required.']")
    public WebElement usernameBosBirakilmazYazisi;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement emailTextBox;
    @FindBy(xpath = "//div[.='Your email is required.']")
    public WebElement emailBosBirakilmazYazisi;


}


