package pages;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;

import java.util.List;
import java.util.Locale;

public class US16_pages
{
    public US16_pages()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    static Faker faker = new Faker();

    //@FindBy(xpath = "//span[text()='Items&Titles']")
    //public WebElement itemsAndTitles;

    // @FindBy(xpath = "//span[text()='Patient']") --> method icerisinde locate alindi
    // public WebElement dropdownPatient;

    // @FindBy(xpath = "//span[text()='Room']") --> method icerisinde locate alindi
    // public WebElement dropdownRoom;

    // @FindBy(xpath = "//span[text()='Messages']") --> method icerisinde locate alindi
    // public WebElement dropdownMessages;

    @FindBy(xpath = "(//h2[@id='room-heading'])/span[text()='Rooms']")
    public WebElement headerRooms;

    @FindBy(xpath = "(//h2[@id='c-message-heading'])/span[text()='Messages']")
    public WebElement headerMessages;

    @FindBy(xpath= "//h2/span")
    public WebElement acilanSayfaHeader;

    @FindBy(xpath= "//span[text()='Create a new Message']")
    public WebElement createANewMessageButton;

    @FindBy(xpath= "//span[text()='Create a new Room']")
    public WebElement createANewRoomButton;

    @FindBy(xpath= "//button[@type='submit']")
    public WebElement createANewMessagePageSaveButton;

    @FindBy(xpath= "//div[@class='Toastify__toast-body']")
    public WebElement toastifyContainer;

    @FindBy(xpath= "//h3")
    public WebElement messagePageSonu;

    @FindBy(xpath= "(//div[@class='invalid-feedback'])[1]")
    public WebElement messagePageInvalidFeedbackForName;

    @FindBy(xpath= "(//div[@class='invalid-feedback'])[2]")
    public WebElement messagePageInvalidFeedbackForEmail2;

    @FindBy(xpath= "(//div[@class='invalid-feedback'])[1]")
    public WebElement messagePageInvalidFeedbackForEmail1;

    @FindBy(xpath= "(//div[@class='invalid-feedback'])[3]")
    public WebElement messagePageInvalidFeedbackForSubject;

    @FindBy(xpath= "(//a[@class='btn btn-info btn-sm'])[1]")
    public WebElement viewButton;

    @FindBy(xpath= "(//a[@class='btn btn-primary btn-sm'])[1]")
    public WebElement editButton;

    //@FindBy(className= "btn btn-primary")
    //public List<WebElement> viewIcindekiEditButton;

    @FindBy(xpath= "//a[@class='btn btn-primary']")
    public WebElement viewIcindekiEditButton;

    @FindBy(xpath= "(//a[@class='btn btn-danger btn-sm'])[1]")
    public WebElement deleteButton;

    //@FindBy(xpath= "//button[@id='jhi-confirm-delete-cMessage']")
    //public WebElement popUpDeleteButton;

    @FindBy(id = "jhi-confirm-delete-cMessage")
    public WebElement popUpDeleteMessageButton;

    @FindBy(xpath = "//input[@name='roomNumber']")
    public WebElement createANewRoomPageRoomNumberTextBox;

    @FindBy(xpath = "//select[@name='roomType']")
    public WebElement createANewRoomPageRoomTypeDropDown;

    @FindBy(xpath = "//input[@name='status']")
    public WebElement createANewRoomPageStatusCheckBox;

    @FindBy(xpath = "//input[@name='price']")
    public WebElement createANewRoomPagePriceTextBox;

    @FindBy(xpath = "//input[@name='description']")
    public WebElement createANewRoomPageDescriptionTextBox;

    @FindBy(xpath = "//input[@name='createdDate']")
    public WebElement createANewRoomPageCreatedDateTextBox;

    @FindBy(xpath= "//button[@type='submit']")
    public WebElement createANewRoomPageSaveButton;

    @FindBy(xpath= "//button[@type='submit']")
    public WebElement createRoomExpectedInvalidFeedbackForRoomNumber;

    @FindBy(xpath= "//div[@class='invalid-feedback']")
    public WebElement createRoomInvalidFeedback; // ?????

    @FindBy(id = "jhi-confirm-delete-room")
    public WebElement popUpDeleteRoomButton;

   // selenium automation library -> page factory adinda bir ozelligim var(POM demis)
   // mesela @FindBy() kullanimi bunlardan sadece bir tanesi.

    public By deleteRoomButton=By.id("jhi-confirm-delete-room");

    //By getDeleteRoomButton2 = By.ByXPath();

    public static void selectDropdownItem(String item)
    {
        WebElement dropdownItem = Driver.getDriver().findElement(By.xpath("//span[text()='"+ item +"']"));
        JSUtils.clickElementByJS(dropdownItem);
    }
    public static void selectNavigationBarItem(String item)
    {
        WebElement navigationBarItem = Driver.getDriver().findElement(By.xpath("//span[text()='"+ item +"']"));
        JSUtils.clickElementByJS(navigationBarItem);
    }
    public static void selectHeaderItem(String item)
    {
        WebElement headerItem = Driver.getDriver().findElement(By.xpath("//span[text()='"+ item +"']"));
        JSUtils.clickElementByJS(headerItem);
    }
    public static WebElement credentialWebElement(String credential)
    {
        credential = credential.toLowerCase();
        WebElement credentialName = Driver.getDriver().findElement(By.xpath("//input[@name='"+ credential +"']"));
        return credentialName;
    }
    public static WebElement viewIcindekiEditButonu()
    {
        WebElement buton = Driver.getDriver().findElement(By.xpath("//a[@class='btn btn-primary']"));
        return buton;
    }
    public static WebElement popUpDeleteButonu()
    {
        WebElement buton = Driver.getDriver().findElement(By.id("jhi-confirm-delete-cMessage"));
        return buton;
    }
    public WebElement roomNumberInvalidFeedback()
    {
        WebElement element = Driver.getDriver().findElement(RelativeLocator.with(By.className("invalid-feedback")).below(createANewRoomPageRoomNumberTextBox).above(createANewRoomPageRoomTypeDropDown));
        return element;


    }
    public WebElement priceInvalidFeedback()
    {
        WebElement element = Driver.getDriver().findElement(RelativeLocator.with(By.className("invalid-feedback")).below(createANewRoomPageStatusCheckBox).above(createANewRoomPageDescriptionTextBox));
        return element;


    }



}
