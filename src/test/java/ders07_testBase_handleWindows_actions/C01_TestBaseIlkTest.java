package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBaseMethod;

public class C01_TestBaseIlkTest extends TestBaseMethod {

    @Test
    public void test01(){
        // amazona gidin
        driver.get("https://www.amazon.com");
        // amazona gittigimizi test edelim
        // url'de amazon kelimesi olsun
        String expectedIcerik= "amazon";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedIcerik));
    }
}
