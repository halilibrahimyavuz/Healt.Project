package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US23_pages {
    public US23_pages() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement loginIkon;



    @FindBy (xpath = "//span[text()='Sign in']")
    public WebElement signInElementi;

    @FindBy (xpath = "//input[@name='username']")
    public WebElement usernameTextbox;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passwordTextbox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement signInButtonu;

    @FindBy (xpath = "//span[text()='MY PAGES']")
    public WebElement myPagesButtonu;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement searchPatientButton;

    @FindBy(xpath = "//span[text()='Edit']")
    public WebElement editButton;

    @FindBy(xpath = "//span[text()= 'Payment / Invoice Process']")
    public WebElement paymentInvoiceProcessButton;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement showInvoiceButton;

    @FindBy(xpath = "//span[text()='View Results']")
    public WebElement viewResultButton;


    @FindBy (xpath = "//span[text()='My Appointments']")
    public WebElement loginPageMyAppointmentsButtonu;

    @FindBy (xpath = "//span[text()='Make an Appointment']")
    public WebElement loginPageMakeAnAppointmentButtonu;

    @FindBy (xpath = "//h2[text()='Make an Appointment']")
    public WebElement makeAnAppointmentHeader;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement editeButonu;


    @FindBy(xpath = "//select[@id='appointment-status']")
    public WebElement statusDropDownButton;

    @FindBy(xpath = "//textarea[@id='appointment-anamnesis']")
    public WebElement anamnesisTextBox;

    @FindBy(xpath = "//textarea[@id='appointment-treatment']")
    public WebElement treatmentTextBox;

    @FindBy(xpath = "//textarea[@id='appointment-diagnosis']")
    public WebElement diagnosisTextBox;

    @FindBy(xpath = "//textarea[@id='aappointment-prescription']")
    public WebElement prescriptionTextBox;

    @FindBy(xpath = "//textarea[@id='appointment-description']")
    public WebElement descriptionTextBox;

    @FindBy(xpath = "//select[@id='appointment-physician']")
    public WebElement physicianDropDown;


    @FindBy (xpath = "//input[@name='ssn']")
    public WebElement sSNTextBox;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@name='phone']")
    public WebElement phoneTextBox;

    @FindBy (xpath = "//div[text()='Phone number is invalid']")
    public WebElement loginPagePhoneErrorLine1;

    @FindBy (xpath = "(//div[@class='text-danger form-group'])/div[@class='invalid-feedback']")
    public WebElement loginPagePhoneErrorLine2;

    @FindBy (xpath = "//input[@name='appoDate']")
    public WebElement loginPageDateTextBox;

    @FindBy(xpath = "//input[@name='startDate']")
    public WebElement startDateBox;

    @FindBy(xpath = "//input[@name='endDate']")
    public WebElement endDateBox;

    @FindBy(xpath = "//td[text()= '111-47-4785']")
    public WebElement sonucId;

    @FindBy(xpath = "//div[@class='Toastify__progress-bar Toastify__progress-bar--animated Toastify__progress-bar--success']")
    public WebElement updateSuccess;

    @FindBy (xpath = "//span[text()='Appointment date can not be past date!']")
    public WebElement loginPageDateErrorLine;

        @FindBy (xpath = "(//a[@class='d-flex align-items-center dropdown-toggle nav-link'])[2]")
    public WebElement loginPageUserAccountButton;

    @FindBy (xpath = "//span[text()='Sign out']")
    public WebElement signOutButton;

    @FindBy (xpath = "(//div[@role='alert'])/span/strong")
    public WebElement alertText;
    // dynamic + static path ile alert textini alıyoruz

    //------------------------ana sayfadan
    @FindBy (xpath = "//a[@class='appointment-btn scrollto']")
    public WebElement mainpageMakeAnAppointmentButtonu;

    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement firstnameTextBox;

    @FindBy (xpath = "//div[text()='Your FirstName is required.']")
    public WebElement mainpageFirstnameErrorLine;

    @FindBy (xpath = "//input[@name='lastName']")
    public WebElement lastnameTextBox;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement saveButton;

    @FindBy (xpath = "//div[text()='Your LastName is required.']")
    public WebElement mainpageLastnameErrorLine;

     @FindBy (xpath = "//div[text()='Your SSN is required.']")
    public WebElement mainpageSSNErrorLine;

        @FindBy (xpath = "(//div[@class='text-danger form-group'])/div[@class='invalid-feedback']")
    public WebElement mainpageEmailErrorLine;
    // xpath/xpath kullandim

        @FindBy (xpath = "(//div[@class='text-danger form-group'])/div[@class='invalid-feedback']")
    public WebElement mainpagePhoneErrorLine;

    @FindBy (xpath = "//input[@name='appoDate']")
    public WebElement dateTextBox;

    @FindBy(xpath = "//a[@class='btn btn-success btn-sm']")
    public WebElement requestAtestButton;

    @FindBy(xpath = "//input[@id='1402']")
    public WebElement ureRadioButton;

    @FindBy(xpath = "//input[@id='1404']")
    public WebElement sodiumRadioButton;

    @FindBy(xpath = "//input[@id='30199']")
    public WebElement glucoseRadioButton;

    @FindBy (xpath = "//span[text()='Send an Appointment Request']")
    public WebElement sendAnAppointmentRequestButton;

    @FindBy(xpath = "//span[text()='Show Appointments']")
    public WebElement showAppointmentButton;

    @FindBy(xpath = "//span[text()='Show Tests']")
    public WebElement showTestsButton;

    @FindBy (xpath = "//span[text()='Registration']")
    public WebElement registrationHeader;
    //-----------

    @FindBy (xpath = "//input[@name='firstPassword']")
    public WebElement registrationPageNewPassword;

    @FindBy (xpath = "//input[@name='secondPassword']")
    public WebElement registrationPageNewPasswordConfirmation;

    @FindBy (xpath = "//button[@id='register-submit']")
    public WebElement registrationPageRegisterButton;


}
