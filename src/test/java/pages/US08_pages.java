package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static pages.ObjectInitializer.*;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;



public class US08_pages {



    public US08_pages()
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
    @FindBy(id = "account-menu")
    public WebElement accountMenu;
    @FindBy(xpath = "//span[.='Password']")
    public  WebElement passwordButonu;
    @FindBy(xpath = "//input[@name='currentPassword']")
    public  WebElement currentPassword;
    @FindBy(xpath = "//input[@name='newPassword']")
    public  WebElement newPassword;
    @FindBy(xpath = "//input[@name='confirmPassword']")
    public  WebElement confirmPassword;
    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public  WebElement notConfirmationText;
    @FindBy(xpath = "//span[.='Sign out']")
    public  WebElement signoutButonu;
    @FindBy(xpath = "(//li[@style='background-color: rgb(255, 153, 0);'])[2]")
    public  WebElement ikinciBar;
    @FindBy(xpath = "(//li[@style='background-color: rgb(0, 255, 0);'])[5]")
    public  WebElement besinciBar;
    @FindBy(xpath = "//li[@style='background-color: rgb(255, 0, 0);']")
    public  WebElement birinciBar;
    @FindBy(xpath = "//button[@type='submit']")
    public  WebElement saveButonu;
    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public  WebElement passwordChangedText;
}
