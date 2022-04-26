package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US20_pages {
    public US20_pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //@FindBy notasyonu ile locatelerı buraya koyacagız.

    @FindBy (xpath ="//*[text()='Administration']")
    public WebElement administrationButonu;

    @FindBy (xpath ="//*[text()='User management']")
    public WebElement userManagementButonu;

    @FindBy (xpath = "//*[text()='Users']")
    public WebElement usersPageText;

    @FindBy (xpath = "(//span[@class='d-none d-md-inline'])[1]")
    public WebElement viewButonu;

    @FindBy (xpath = "//*[text()='First name']")
    public  WebElement firstnameText;

    @FindBy (xpath = "//*[text()='Last name']")
    public  WebElement lastnameText;

    @FindBy (xpath = "//*[text()='Email']")
    public  WebElement emailText;

    @FindBy (xpath = "//*[text()='Profiles']")
    public  WebElement profilesText;

    @FindBy (xpath = "//*[text()='Admin Halil']")
    public WebElement adminHalilButonu;


    @FindBy (xpath = "//*[text()='Sign out']")
    public WebElement singOutButonu;

    @FindBy (xpath = "(//*[text()='Edit'])[1]")
    public WebElement editButonu;

    @FindBy (xpath = "//*[text()='Create or edit a user']")
    public WebElement createEditUserPagesText;

    @FindBy (xpath = "//*[text()='ROLE_ADMIN']")
    public WebElement roleAdmin;

    @FindBy (xpath = "//*[text()='ROLE_USER']")
    public WebElement roleUser;

    @FindBy (xpath = "//*[text()='ROLE_PATIENT']")
    public WebElement rolePatient;

    @FindBy (xpath = "//*[text()='ROLE_STAFF']")
    public WebElement roleStaff;

    @FindBy (xpath = "//*[text()='ROLE_PHYSICIAN']")
    public WebElement rolePhysician;

    @FindBy (xpath = "//*[text()='Save']")
    public WebElement savebutonu;

    @FindBy (xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement editToastContaınerText;

    @FindBy (xpath = "(//*[text()='Delete'])[10]")
    public WebElement deleteButonu;

    @FindBy (xpath = "//*[text()='Are you sure you want to delete user admin?']")
    public WebElement deletePopupText;

    @FindBy (xpath = "/html/body/div[2]/div/div[1]/div/div/div[3]/button[2]")
    public WebElement deletePopupDeleteButonu;

    @FindBy (xpath = "//div[@class='Toastify__toast-body']")
    public WebElement deleteToastContaınerText;






}
