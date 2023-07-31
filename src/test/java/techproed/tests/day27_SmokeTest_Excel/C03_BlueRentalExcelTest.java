package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {
    @Test
    public void test01() {
        /*
            Test yaptigimiz sayfadaki datalari .properties yada excel dosyasindan alabiliriz.
        .properties dosyasindan verileri okuyabilmemiz icin ConfigReader class'i olusturmustuk,
        Ayni sekilde excel dosyasindaki verileri okuyabilmek icin ExcelReader class'i olusturduk.
        Burdan alacagimiz email ve password bilgilerini String bir degiskene assign edip login testi
        yapacagimiz sitede sendKeys() methodu ile cok rahat kullanabiliriz.
         */
        ExcelReader reader = new ExcelReader("src/test/java/techproed/resources/mysmoketestdata.xlsx","customer_info");
        String email = reader.getCellData(1,0);
        String password = reader.getCellData(1,1);

        //BlueRentalCar sayfasina gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //mysmoketestdata excel dosyasindan bir kullanici ile login olalim
        BlueRentalPage rentalPage = new BlueRentalPage();
        rentalPage.login.click();
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(email, Keys.TAB,password,Keys.ENTER);
        ReusableMethods.bekle(2);

        //Login oldugumuzu dogrulayalim
        Assert.assertTrue(rentalPage.loginVerify.getText().contains("Sam Walker"));
         /*
         Login webelementi login olduktan sonrada ayni locate sahip olabilme ihtimaline karsi
         daha garanti bir dogrulama yapmak icin login olduktan sonra login webelementinin oldugu
         yerde login oldugumuz kullanici ismi cikacaktir.Bu webelementin yazisini getText() methodu
         ile alip kullanici ismini iceriyormu icermiyormu olarak test ederiz.
          */


        //Sayfayi kapatalim
        Driver.closeDriver();
    }
}
