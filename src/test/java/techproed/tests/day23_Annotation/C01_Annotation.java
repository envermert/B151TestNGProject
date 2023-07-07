package techproed.tests.day23_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {
    /*
    BeforeSuite , test ve class en basta bir sefer
    AfterSuite, test ve class en son da bir sefer calisir
    before ve after methodlar ise her testin basinda sonunda bir kez calisir
     */
    @BeforeSuite
    public void suite(){
        System.out.println("Her seyden once bir kez BeforSuite calisir");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Testlerden once bir kez calisir");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("Her class'dan once bir kez calisir");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("Junitteki @Before notasyonu gibi her methoddan once calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test1 calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test2 calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test3 calisti");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Her seyden sonra 1 kez calisir");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Butun testlerden sonra 1 kez calisir");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Her class'dan sonra 1 kez calisir");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Junit'teki @After notasyonu gibi her method'dan sonra calisir");
    }
}
