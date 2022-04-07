package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US07_pages
{
    public US07_pages()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
