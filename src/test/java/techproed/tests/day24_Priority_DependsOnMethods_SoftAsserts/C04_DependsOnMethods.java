package techproed.tests.day24_Priority_DependsOnMethods_SoftAsserts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {
    WebDriver driver;
    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @BeforeClass//boş bir driver açar @beforemethod her methoddan sonra çalıştığı için test02 hata verir çünkü element bulunamaz.
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @Test
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test(dependsOnMethods = "test01")
    public void test02() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
    }
    @Test
    public void test03() {
        System.out.println("test03");
    }

    @Test//(dependsOnMethods = "test03") buraya koyarsak ve test05 i çalıştırırsak TestNGException: alırız üst üste dependsOnMethod kullanılmamalı.
    public void test04() {
        System.out.println("test04");
        //sadece test04 'ü çalıştırmama rağmen test03 de çalıştı çünkü bağlı.
    }

    @Test(dependsOnMethods = "test04")
    public void test05() {
        System.out.println("test05");

    }

}