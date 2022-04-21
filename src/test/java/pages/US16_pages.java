package pages;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtils;

import java.util.Locale;

public class US16_pages
{
    public US16_pages()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }

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
    public WebElement header;



    public static void selectDropdownItem(String item)
    {
        WebElement dropdownItem = Driver.getDriver().findElement(By.xpath("//span[text()='"+ item +"']"));
        JSUtils.clickElementByJS(dropdownItem);
    }

    public static void selectNavigationBarItem(String item)
    {
        WebElement dropdownItem = Driver.getDriver().findElement(By.xpath("//span[text()='"+ item +"']"));
        JSUtils.clickElementByJS(dropdownItem);
    }


}
