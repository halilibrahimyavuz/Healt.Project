package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US21_pages {

    public US21_pages()
    {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[@class='d-flex align-items-center dropdown-toggle nav-link']")
    public WebElement kullaniciGirisBolumu;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[1]")
    public WebElement signinGiris;
    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signinButton;
    @FindBy(xpath = "//span[.='MY PAGES']")
    public  WebElement myPages;
    @FindBy(xpath = "//span[.='Search Patient']")
    public  WebElement searchPatient;
    @FindBy(xpath = "//input[@class='form-control']")
    public  WebElement patientSSN;

    @FindBy(xpath = "(//span[.='Edit'])[2]")
    public WebElement editButonu;
    @FindBy(xpath = "//input[@name='lastName']")
    public  WebElement lastnameButonu;
    @FindBy(xpath ="//*[@id='save-entity']")
    public  WebElement saveButonu;
    @FindBy(xpath = "//dd[.='abc']")
    public  WebElement lastnameKontrol;
    @FindBy(xpath = "//td[.='abc']")
    public  WebElement lastNameKontrol;
    @FindBy(xpath = "(//span[.='Show Appointments'])[2]")
    public WebElement showAppointments;
    @FindBy(xpath = "(//span[.='Edit'])[3]")
    public WebElement editButonuRandevu;
    @FindBy(xpath = "//textarea[@id='appointment-treatment']")
    public WebElement treatment;
    @FindBy(xpath = "//select[@id='appointment-status']")
    public  WebElement statusDropdown;
    @FindBy(xpath = "//textarea[@name='anamnesis']")
    public WebElement anamnesis;
    @FindBy(xpath = "//textarea[@name='diagnosis']")
    public WebElement diagnosis;
    @FindBy(xpath = "//select[@name='physician.id']")
    public WebElement doctorList;

    //div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']

}
