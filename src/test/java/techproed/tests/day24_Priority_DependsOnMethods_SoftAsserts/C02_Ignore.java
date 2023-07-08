package techproed.tests.day24_Priority_DependsOnMethods_SoftAsserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;

public class C02_Ignore {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    /*
    Birden fazla test methodu calistirmak istedigimizde o anlik gereksiz gordugumuz test methodunu
    atlamak (ignore) isteyebiliriz. Bunun icin @Test notasyonu ustune yada yanina @Ignore notasyonu
    eklememiz yeterlidir.@Ignore notasyonu ile atladigimiz method konsolda gozukmez raporlamalarda gozukur.
        Eger bir methodu tamamen iptal etmek isterseniz @Test notasyonundan sonra parametre olarak (enabled = false)
    kullanabilirsiniz.
     */
    @Ignore
    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");//--> ikinci olarak amazon calissin
    }

    @Test(enabled = false)//-->Eger bir methodu tamamen iptal etmek isterseniz
    public void youtubeTest() {
        driver.get("https://youtube.com");//--> youtube once calissin
    }

    @Test
    public void facebookTest() {
        driver.get("https://facebook.com");//-->Son olarak facebook calissin
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}