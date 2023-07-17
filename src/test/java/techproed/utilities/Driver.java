package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private Driver(){
    /*
    Driver class'indan obje olusturmanin onune gecebilmek icin
    default constructor'i private yaparak bunu engellemis oluruz
    Bu kaliba'da Singleton pattern denir.
     */
    }
    /*
    POM( Page Object Model)
            Test senaryolarinin daha az kod ile yazilmasina ve bakiminin daha kolay yapilmasina
    olanak saglayan yazilim test yontemidir. TestNG ve Cucumber frameworklerinde POM kalibi kullanilir.

     */

    static WebDriver driver;
    public static WebDriver getDriver(){
           /*
            Driver'i her cagirdigimizda yeni bir pencere acilmasinin onune gecmek icin
        if blogu icinde Eger driver'a deger ATANMAMISSA deger ata, eger deger atanmissa
        driver'i ayni sayfada return et.
             */
        if (driver==null){//--> Driver'a deger atanmamissa
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
         if(driver!= null){//-->Driver'a deger atanmissa, bos degilse
            driver.close();
            driver=null;//--> Driver'i kapattiktan sonra bosalt
        }

    }

    public static void quitDriver(){
        if(driver!= null){//-->Driver'a deger atanmissa, bos degilse
            driver.quit();
            driver=null;//--> Driver'i kapattiktan sonra bosalt
        }

    }
}
