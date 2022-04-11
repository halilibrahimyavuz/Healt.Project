package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US11_page {
    public US11_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(xpath = "//*[text()='Make an Appointment']")
    public WebElement makeAnAppointmentText;

    @FindBy (xpath = "//input[@name='firstName']")
    public WebElement firstnameTextBox;

    @FindBy (xpath = "//input[@name='lastName']")
    public WebElement lastNameTextBox;

    @FindBy (xpath = "//input[@name='ssn']")
    public WebElement ssnTextBox;

    @FindBy (xpath = "//input[@name='email']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//input[@name='phone']")
    public WebElement phoneTextBox;

    @FindBy (xpath = "//input[@name='appoDate']")
    public WebElement appointmentDateTime;

    @FindBy (xpath = "//*[@id='register-submit']")
    public WebElement sendAppointmentButonu;

    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement editButonu;

    @FindBy (xpath = "//*[text()='Create or Edit an Appointment']")
    public WebElement createEditAppointmentText;

    @FindBy (xpath = "//*[@name='id']")
    public WebElement idTextBox;

    @FindBy (xpath = "//*[@name='startDate']")
    public WebElement startDateTimeTextBox;

    @FindBy (xpath = "//*[@name='endDate']")
    public WebElement endDateTimeTextBox;

    @FindBy (xpath = "//*[@name='status']")
    public WebElement statusDropDown;

    @FindBy (xpath = "//*[@name='physician.id']")
    public WebElement physicianDropDown;

    @FindBy (xpath = "//*[text()='Appointment registration saved!']")
    public WebElement anaSaydadanBasarılıKayıtOlusturmaYazısı;

    @FindBy (xpath = "//*[@id='save-entity']")
    public WebElement saveButonu;

    @FindBy(xpath = "//*[@id='appointment-anamnesis']")
    public WebElement anamnesisTextBox;

    @FindBy(xpath = "//*[@id='appointment-treatment']")
    public WebElement treatmentTextBox;

    @FindBy(xpath = "//*[@id='appointment-diagnosis']")
    public WebElement diagnosisTextBox;

    @FindBy(xpath = "//*[@id='appointment-prescription']")
    public WebElement prescriptionTextBox;

    @FindBy(xpath = "//*[@id='appointment-description']")
    public WebElement descriptionTextBox;










}
