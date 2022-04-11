package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US10_page {
 public US10_page(){
     PageFactory.initElements(Driver.getDriver(),this);
 }

    @FindBy (xpath = "//*[@id='account-menu']")
    public WebElement profilIkonuButonu;

    @FindBy (xpath = "//a[@tabindex='0'][2]")
    public WebElement registerDropDownButonu;

    @FindBy (xpath = "//*[text()='Registration']")
    public WebElement registrationSayfasıText;


    @FindBy (xpath = "//input[@name='ssn']")
    public WebElement ssnTextBox;

    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement firstnameTextBox;


    @FindBy (xpath = "//input[@name='lastName']")
    public WebElement lastnameTextBox;

    @FindBy (xpath = "//input[@name='username']")
    public WebElement usernameTextBox;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@name='firstPassword']")
    public WebElement firstpasswordTextBox;

    @FindBy (xpath = "//*[@name='secondPassword']")
    public WebElement secondpasswordTextBox;

    @FindBy (xpath = "//*[@id='register-submit']")
    public WebElement registerOnayButonu;

    @FindBy(xpath = "//div[text()='Registration Saved']")
    public WebElement toastContainerMassage;
    //-------------------------------------------2-----------------
    @FindBy (xpath = "//*[@id='login-item']")
    public WebElement singInButonu;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement singInUsernameTextBox;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement singInPasswordTextBox;

    @FindBy (xpath = "//*[@type='submit']")
   public WebElement singInSingInButonu;

    @FindBy (xpath = "//*[text()='MY PAGES']")
   public WebElement myPagesButonu;

    @FindBy (xpath = "//*[text()='My Appointments']")
   public WebElement myAppointmentsButonu;

    @FindBy (xpath = "//*[text()='Appointments']")
    public WebElement apppointmentsPagesText;

    @FindBy (xpath = "//tbody//tr[1]")
    public List<WebElement> alınanRandevular;

    @FindBy (xpath = "//tbody//tr//td[1]")
    public WebElement ilkRandevuID;

    //------------------3-----------------------
    @FindBy (xpath = "//tbody//tr//td[2]")
    public WebElement startDateTime;

    @FindBy (xpath = "//tbody//tr//td[3]")
    public WebElement endDateTime;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public WebElement status;


}
