package pages;

import org.junit.Test;

public class deneme
{
    @Test
    public void test01()
    {
        US05_pages us05_pages = new US05_pages();
        us05_pages.login("TYPatientUsername","TYPatientPassword");
    }
}
