package techproed.tests.day28_DataProvider;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtil;
import techproed.utilities.Driver;

public class C05_DataProviderUtilKullanimi {


    @Test(dataProvider = "sehirVerileri",dataProviderClass = DataProviderUtil.class)
    public void test01(String sehir,String bolge, String plaka) {

        System.out.println(sehir+ " | " +bolge+ " | " +plaka );





    }
}
