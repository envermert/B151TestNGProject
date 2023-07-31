package techproed.tests.day30_Listeners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

@Listeners(techproed.utilities.Listeners.class)
public class C01_ListenersTest1 {
    /*
        Bir class'da listeners kullanabilmek icin class'dan once @Listeners notasyonu eklememiz gerekir.
    Ve bu notasyon icine olusturdugumuz Listeners class'inin yolunu parametre olarak eklemeliyiz.
     */

    @Test(invocationCount = 10,successPercentage = 90)
    /*
    Test methodlarınızı birden fazla çalıştırmak isterseniz @ test notasyonundan sonrava invocationCount
    parametresi ile belirttiğimiz sayı kadar testlerimiz tekrar çalışır.
    Listeners ile onTestFailedButWithinSuccessPercentage() bu methodu kullanmak istersek @Test notasyonundan sonra
    invocationCount = 10 ile birlikte successPercentage parametresi kullanarak ornegin testlerim 10 kez calissin
    successPercentage parametresine belirttigim %90 bize 10 kez calisan testlerimizden 1 tanesi fail olsa bile
    bu testi passed olarak verecektir. Eger iki test fail olursa onTestFailedButWithinSuccessPercentage() bu method
    devreye girecektir.

    */

    public void test01() {
        System.out.println("PASSED");
        Assert.assertTrue(true);

        Assert.assertEquals(2,2);
    }

    @Test
    public void test02() {
        System.out.println("FAILED");
        Assert.assertFalse(false);
    }

    @Test
    public void test03() {
        System.out.println("SKIP");
        throw new SkipException("Bu method atlandi");

    }

    @Test
    public void test04() {
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        Driver.getDriver().findElement(By.id("lkjlkjhlj")).click();
    }
}
