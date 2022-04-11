package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US06_pages {

    public US06_pages(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(id = "account-menu")
    public WebElement accountMenu;
    @FindBy(id="login-item")
    public WebElement loginButonu;
    @FindBy(id = "username")
    public WebElement usernameKutusu;
    @FindBy(id = "password")
    public WebElement passwordKutusu;

    @FindBy (xpath = "//span[text()='Settings']")
    public WebElement settingsButonu;

    @FindBy(id="firstName")
    public WebElement firstnameKutusu;

    @FindBy(id="lastName")
    public WebElement lastnameKutusu;

    @FindBy(id="email")
    public WebElement emailKutusu;

    @FindBy (xpath = "//span[text()='Save']")
    public WebElement saveButonu;

    @FindBy(xpath = "//div[@class='invalid-feedback']")
    public WebElement invalisYazisi;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement yesilSaveContainer;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--error toastify-toast']")
    public WebElement kirmiziSaveContainer;
    @FindBy(xpath = "//div[text()='This field is invalid']")
    public WebElement invalidYazisi;

    @FindBy(xpath = "//span[text()='Sign out']")
    public WebElement signOut;


}
