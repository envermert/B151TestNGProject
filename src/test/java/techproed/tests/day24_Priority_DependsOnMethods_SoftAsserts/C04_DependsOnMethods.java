package techproed.tests.day24_Priority_DependsOnMethods_SoftAsserts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class C04_DependsOnMethods {

    //BeforeMethod kullanirsak her testten once BeforeMethod calisir daha sonra test methodu calisir.
    // Farkli test methoduna gecince BeforeMethod bos bir driver aciyor ve aranan locate' i bulamayip hata verir
    //Ama BeforeClass yaparsak class basinda bir kez calistigi icin devaminda tum test methodlari
    // birbirine bagli oldugu icin tek tek calismaya devam eder
    WebDriver driver;
    @AfterMethod
    public void tearDown() {
       // driver.close();
    }
/*
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
*/
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

    @Test(dependsOnMethods = "test03")
    public void test04() {
        System.out.println("test04");
    }

    @Test(dependsOnMethods = "test04")
    public void test05() {
        System.out.println("test05");
    }
}
