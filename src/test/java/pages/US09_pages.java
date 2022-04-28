package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US09_pages {

    public  US09_pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='account-menu']")
    public WebElement anasayfaInsanIkonu;

    @FindBy(xpath = "//a[@id='login-item']")
    public WebElement anasayfaInsanIkonuSignInElementi;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement loginUsernameTextBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement loginPasswordTextBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginSignInButonu;

    @FindBy(xpath = "//li[@id='entity-menu']")
    public WebElement myPagesDropdownMenuElementi;

    @FindBy(xpath = "//span[text()='Search Patient']")
    public WebElement myPagesDropdownMenuSearchPatientElementi;

    @FindBy(xpath = "//span[text()='Patients']")
    public WebElement patientsTableElementi;

    @FindBy(xpath = "//input[@name='ssn']")
    public WebElement patientsTableSSNsearchTextBox;

    @FindBy(xpath = "(//span[text()='View'])[1]")
    public WebElement patientsTableHastaViewElementi;

    @FindBy(xpath = "(//span[text()='Edit'])[1]")
    public WebElement patientsTableHastaEditElementi;


    // Hasta bilgileri Edit Sayfasi
    @FindBy(xpath = "//input[@name='id']")
    public WebElement hastaBilgileriGuncellemeIdTextBoxElementi;

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement hastaBilgileriGuncellemeFirstNameTextBoxElementi;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement hastaBilgileriGuncellemeLastNameTextBoxElementi;

    @FindBy(xpath = "//input[@name='birthDate']")
    public WebElement hastaBilgileriGuncellemeBirthDateTextBoxElementi;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement hastaBilgileriGuncellemeEmailTextBoxElementi;

    @FindBy(xpath = "//input[@name='phone']")
    public WebElement hastaBilgileriGuncellemePhoneTextBoxElementi;

    @FindBy(xpath = "//select[@name='gender']")
    public WebElement hastaBilgileriGuncellemeGenderSelectMenuElementi;

    @FindBy(xpath = "//select[@name='bloodGroup']")
    public WebElement hastaBilgileriGuncellemeBloodGroupSelectMenuElementi;

    @FindBy(xpath = "//input[@name='adress']")
    public WebElement hastaBilgileriGuncellemeAdressTextBoxElementi;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement hastaBilgileriGuncellemeDescriptionTextBoxElementi;

    @FindBy(xpath = "//select[@name='user.id']")
    public WebElement hastaBilgileriGuncellemeUserSelectMenuElementi;

    @FindBy(xpath = "//select[@name='country.id']")
    public WebElement hastaBilgileriGuncellemeCountrySelectMenuElementi;

    @FindBy(xpath = "//select[@name='cstate.id']")
    public WebElement hastaBilgileriGuncellemeStateSelectMenuElementi;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement hastaBilgileriGuncellemeSaveButonuElementi;


    @FindBy(xpath = "//span[text()='SSN']")
    public WebElement hastaBilgisiGoruntulemeSSNElementi;

    @FindBy(xpath = "//div[@role='alert']")
    public WebElement hastaBilgisiGuncellemeBasariliYazisi;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement alertButton;


    @FindBy(xpath = "//td[text()='27605']")
    public WebElement arananHastaId;



    //US28

    @FindBy(xpath = "//span[text()='Items&Titles']")
    public WebElement itemTitlesDropdownMenu;

    @FindBy(xpath = "(//a[@href='/country'])[1]")
    public WebElement itemTitlesDropdownMenuCountryElementi;

    @FindBy(xpath = "(//a[@href='/c-state'])[1]")
    public WebElement itemTitlesDropdownMenuStateCityElementi;

    // Country steps

    @FindBy(xpath = "//span[text()='Create a new Country']")
    public WebElement countriesTableCreateANewCountryButton;

    @FindBy(xpath = "//span[text()='Create or edit a Country']")
    public WebElement createOraEditCountryTableYazisi;

    @FindBy(xpath = "//input[@id='country-name']")
    public WebElement createOraEditCountryTableCountryNameTextBox;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createOraEditCountryTableCountryDateTextBox;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement createOraEditCountryTableSaveButton;

    @FindBy(xpath = "//div[@class='Toastify__toast-container Toastify__toast-container--top-left toastify-container']")
    public WebElement basariliCountryEklemeAlertBox;

    // StateCity steps

    @FindBy(xpath = "//a[@id='jh-create-entity']")
    public WebElement statesCitiesTableCreateANewStateButton;

    @FindBy(xpath = "//input[@id='c-state-name']")
    public WebElement createOrEditaStateCityTableNameTextBox;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createOrEditaStateCityTableDateTextBox;

    @FindBy(xpath = "//select[@name='state.id']")
    public WebElement createOrEditaStateCityTableStateCityDropdownMenu;

    @FindBy(xpath = "//button[@id='save-entity']")
    public WebElement createOrEditaStateCityTableSaveButton;










    // US 28
    @FindBy(xpath = "//a[@href='/country/80063/delete']")
    public WebElement countrySayfasiIlkDeleteYazisiGoruntuleme;

    @FindBy(xpath = "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement countrySayfasiIlkDeleteButonu;

    @FindBy(xpath = "//button[@id='jhi-confirm-delete-country']")
    public WebElement countrySayfasiDeleteOnayIkinciDeleteButonu;

    @FindBy(xpath = "//div[text()='A Country is deleted with identifier 77105']")
    public WebElement countrySilindiDogrulamaYazisi;




    // US26

    @FindBy(xpath = "(//a[@class='d-flex align-items-center nav-link'])[6]")
    public WebElement anasayfaContactMenu;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement contactSayfasiNameTextBox;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement contactSayfasiEmailTextBox;

    @FindBy(xpath = "//input[@name='subject']")
    public WebElement contactSayfasiSubjectTextBox;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement contactSayfasiMessageTextBox;

    @FindBy(xpath = "//button[@id='register-submit']")
    public WebElement contactSayfasiSendButton;

    @FindBy(xpath = "//div[@class='Toastify__toast Toastify__toast--success toastify-toast']")
    public WebElement contactGondermeBasariliMesaji;

}
