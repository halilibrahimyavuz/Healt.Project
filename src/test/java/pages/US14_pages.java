package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_pages {
    public US14_pages(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "account-menu")
    public WebElement accountMenu;

    @FindBy(id = "login-item")
    public WebElement SigninButon1;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "(//span[.='Sign in'])[3]")
    public WebElement SigninButon2;

    @FindBy(xpath = "(//a[@aria-haspopup='true'])[1]")
    public WebElement mypages;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement MyInpatients;

    @FindBy(xpath = "//*[text()='In Patients']")
    public WebElement InPatientsYazisi;

    @FindBy(xpath = "(//th//span)[1]")
    public WebElement inPatientsPageID;

    @FindBy(xpath = "(//th//span)[2]")
    public WebElement inpatientsPageStartDate;

    @FindBy(xpath = "(//th//span)[3]")
    public WebElement inpatientsPageEndDate;

    @FindBy(xpath = "(//th//span)[4]")
    public WebElement inpatientsPageStatus;

    @FindBy(xpath = "(//th//span)[5]")
    public WebElement inpatientsPageDescription;

    @FindBy(xpath = "(//th//span)[6]")
    public WebElement inpatientsPageCreatedDate;

    @FindBy(xpath = "(//th//span)[7]")
    public WebElement inpatientsPageRoom;

    @FindBy(xpath = "(//th//span)[8]")
    public WebElement inpatientsPageAppointment;

    @FindBy(xpath = "(//th//span)[9]")
    public WebElement inpatientsPagePatient;

    @FindBy(xpath = "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement Edit;

    @FindBy(xpath = "(//input[@type='text'])[1]")
    public WebElement EditPageID;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement EditPageStartDate;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement EditPageEndDate;

    @FindBy(xpath = "//input[@id='in-patient-description']")
    public WebElement EditPageDescription;

    @FindBy(xpath = "//input[@id='in-patient-createdDate']")
    public WebElement EditPageCreatedDate;

    @FindBy(xpath = "//select[@id='in-patient-appointment']")
    public WebElement EditPageAppointment;

    @FindBy(xpath = "//select[@name='status']")
    public WebElement EditPageStatus;

    @FindBy(xpath = "//select[@name='room.id']")
    public WebElement EditPageroom;

    @FindBy(xpath = "//select[@id='in-patient-patient']")
    public WebElement EditPagePatient;

    @FindBy(id = "save-entity")
    public WebElement EditPageSave;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement EditPageAlertText;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[6]")
    public WebElement SignOutButon;

    @FindBy(xpath = "//*[text()='Back']")
    public WebElement BackButton;

    @FindBy(xpath = "(//*[text()='Edit'])[2]")
    public WebElement Edit2;


}
