package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class US12_pages {

    public US12_pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='appointment-btn scrollto']")
    public WebElement appointmentButton;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstname;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastname;

    @FindBy(xpath = "//input[@id='ssn']")
    public WebElement ssnNumber;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailTextbox;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement phoneTextbox;

    @FindBy(id = "appoDate")
    public WebElement dateTextbox;

    @FindBy(id = "register-submit")
    public WebElement kayitButton;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement alertButton;

    @FindBy(xpath = "//Strong[text()='Appointment registration saved!']")
    public WebElement alertButton2;

    @FindBy(xpath = "//a[@aria-haspopup='true']")
    public WebElement sign_inIcon;

    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement sign_inFirstButton;

    @FindBy(xpath = "//input[@placeholder='Your username']")
    public WebElement sign_inUserNameTextBox;

    @FindBy(xpath = "//input[@placeholder='Your password']")
    public WebElement sign_inPasswordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement sign_inSecondButton;

    @FindBy(xpath = "//span[text()='Team84 US0012-Staff']")
    public WebElement staffOturumDogrulama;

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement staffMypages;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement staffSearchPatient;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement staffPatientSSN;

    @FindBy(xpath = "//span[text()='Show Appointments']")
    public WebElement staffShowAppointments;

    @FindBy(xpath = "//span[text()='ID']")
    public WebElement sagaKaydirmaElementi;

    @FindBy(xpath = "//a[@class='btn btn-warning btn-sm']")
    public WebElement staffEditButton;

    @FindBy(xpath = "//Select[@name='status']")
    public WebElement staffStatusPendingSecimi;

    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement staffAnamnesisTextBox;

    @FindBy(xpath = "//select[@name='physician.id']")
    public WebElement staffDoktorSecimiDropbox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement staffSaveButton;

    @FindBy(xpath = "//div[text()='The Appointment is updated with identifier 54712']")
    public WebElement staffDoktoratamasiAlert;



    @FindBy(xpath = "//span[text()='Team84 US0012-Doktor']")
    public WebElement doktorOturumAcmaDogrulama;
    //Enes ArslanDoctor      Team84 US0012-Doktor

    @FindBy(xpath = "//span[text()='MY PAGES']")
    public WebElement doktorMyPagesBolumu;

    @FindBy(xpath = "//span[text()='My Appointments']")
    public WebElement doktorMyAppointmentsBolumu;

    @FindBy(name = "fromDate")
    public WebElement fromDateDoktorHastaSecimi;

    @FindBy(name = "toDate")
    public WebElement toDateDoktorHastaSecimi;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement doktorEditBolumu;

    @FindBy(xpath = "//span[text()='Create or Edit an Appointment']")
    public WebElement doktorCreateOrEditTtextBox;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement doktorRequestATestButton;

    @FindBy(xpath = "//h2[@id='c-test-item-heading']")
    public WebElement doktorTestItemsTextBox;

    @FindBy(xpath = "//input[@name='1402']")
    public WebElement testsUrea;

    @FindBy(xpath = "//input[@name='1403']")
    public WebElement testsCreatine;

    @FindBy(xpath = "//input[@name='1404']")
    public WebElement testsSodium;

    @FindBy(xpath = "//input[@name='1405']")
    public WebElement testsPotassium;

    @FindBy(xpath = "//input[@name='1406']")
    public WebElement testsTotalProtein;

    @FindBy(xpath = "//input[@name='1408']")
    public WebElement testsHemoglobin;

    @FindBy(xpath = "//input[@name='1407']")
    public WebElement testsAlbumin;

    @FindBy(xpath = "//input[@name='1401']")
    public WebElement testsGlucose;

    @FindBy(xpath = "//span[text()='Save']")
    public WebElement testsSaveButton;

    public void staffOturumAcma(){
        sign_inIcon.click();
        sign_inFirstButton.click();
        sign_inUserNameTextBox.sendKeys(ConfigReader.getProperty("US12_kayitliStaffUsername"));
        sign_inPasswordTextBox.sendKeys(ConfigReader.getProperty("US12_kayitliStaffPassword"));
        sign_inSecondButton.click();
    }

    public void doktorOturumAcma(){
        sign_inIcon.click();
        sign_inFirstButton.click();
        sign_inUserNameTextBox.sendKeys(ConfigReader.getProperty("US12_kayitliDoctorUsername"));
        sign_inPasswordTextBox.sendKeys(ConfigReader.getProperty("US12_kayitliDoctorPassword"));
        sign_inSecondButton.click();
    }
    public void pageDown() {
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).
                perform();

    }

}
