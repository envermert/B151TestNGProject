package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    /*
        Bir sayfanin locatelerini page class'inda tutariz. Bir constructor olusturup locatelere ulasabilmek icin
    Pagefacatory'den initelements() methodu ile driver'imizi bu class'a tanimlariz.
        findelement() methodu yerine @FindBy notasyonu ile bu notasyona parametre olarak locateleri gireriz.
     */

    public OpenSourcePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath="//*[@name='username']")
    public WebElement username;

    @FindBy(xpath="//*[@name='password']")
    public WebElement password;

    @FindBy(xpath="//*[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath="//h6")
    public WebElement verify;
}
