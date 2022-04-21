package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US27_pages
{
    public US27_pages()
    {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
