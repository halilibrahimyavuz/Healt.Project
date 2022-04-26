package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US0018_page {
    public US0018_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "account-menu")
    public WebElement AccountButon;

    @FindBy(id = "login-item")
    public WebElement SigninButon;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement Username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement Password;

    @FindBy(xpath = "(//span[.='Sign in'])[3]")
    public WebElement SigninEnter;

    @FindBy(xpath = "//span[.='Items&Titles']")
    public WebElement ItemsTitles;

    @FindBy(xpath = "//span[.='Physician']")
    public WebElement Physician;

    @FindBy(xpath = "(//*[.='Edit'])[2]")
    public WebElement Edit;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement EditPageFirstname;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement EditPageLastname;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement EditPageAddress;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement EditPageDescription;

    @FindBy(xpath = "//input[@name='examFee']")
    public WebElement EditPageExamFee;

    @FindBy(xpath = "save-entity")
    public WebElement EditPageSave;

    @FindBy(xpath = "//span[.='Create a new Physician']")
    public WebElement CreateANewPhysician;

    @FindBy(xpath = "//input[@name='useSSNSearch']")
    public WebElement UseSearch;

    @FindBy(id = "searchSSN")
    public WebElement SearchSsnButon;

    @FindBy(xpath = "//button[@class='btn btn-secondary']")
    public WebElement SearchUser;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement FirstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement LastName;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement Birthdate;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement Phone;

    @FindBy(xpath = "//select[@name='speciality']")
    public WebElement Speciality;

    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement imageCleaner;

    @FindBy(id = "file_image")
    public WebElement Image;

    @FindBy(xpath = "//input[@name='examFee']")
    public WebElement ExamFee;

    @FindBy(xpath = "//select[@name='user.id']")
    public WebElement User;

    @FindBy(xpath = "(//tr//th//span)[1]")
    public WebElement PhysiciansPageID;

    @FindBy(xpath = "(//a[@class='btn btn-link btn-sm'])[1]")
    public WebElement PhysiciandID;

    @FindBy(xpath = "(//tr//th//span)[2]")
    public WebElement PhysiciansPageSSN;

    @FindBy(xpath = "(//tr//td)[2]")
    public WebElement PhysiciansSSN;

    @FindBy(xpath = "(//tr//th//span)[3]")
    public WebElement PhysiciansPageFirstName;

    @FindBy(xpath = "(//tr//td)[3]")
    public WebElement PhysiciansFirstname;

    @FindBy(xpath = "(//tr//th//span)[4]")
    public WebElement PhysiciansPageLastName;

    @FindBy(xpath = "(//tr//td)[4]")
    public WebElement PhysiciansLastname;

    @FindBy(xpath = "(//tr//th//span)[5]")
    public WebElement PhysiciansPageBirthDate;

    @FindBy(xpath = "(//tr//th//span)[6]")
    public WebElement PhysiciansPagePhoneNumber;

    @FindBy(xpath = "//*[contains(text(),'An unexpected error has occurred.')]")
    public WebElement UnexpectedErrorText;

    @FindBy(xpath = "//*[contains(text(),'User')]")
    public WebElement UserFoundSuccessAlertText;

    @FindBy(xpath = "(//*[@class='page-link'])[6]")
    public WebElement FindPhysician;

    @FindBy(xpath = "(//div//a)[103]")
    public WebElement Delete;

    @FindBy(xpath = "(//div[@class='table-responsive'])[2]")
    public WebElement TableResponsive;

    @FindBy(xpath = "(//*[@class='btn btn-danger btn-sm'])[20]")
    public WebElement birinciSayfaDelete;

    @FindBy(xpath = "//*[.='Cancel']")
    public WebElement birinciSayfaCancel;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement Cancel;



}