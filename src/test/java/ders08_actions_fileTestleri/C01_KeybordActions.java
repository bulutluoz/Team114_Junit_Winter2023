package ders08_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

import java.security.Key;

public class C01_KeybordActions extends TestBaseMethod {


    @Test
    public void test01() throws InterruptedException {
        /*
              Driver bir web sayfasina gittiginde
              asagi bolumlerde oldugu icin gorunmeyen bir element'e islem yapmasini istersek
              islem yapilacagini veya yapilamayacigi ONGOREMEYIZ

              front-end developer'in yazdigi kodlara gore
              islem yapabildigimiz sayfalar olabilecegi gibi
              islem yapamayacagimiz sayfalar da olabilir

              isinizi garantiye almak isterseniz
              islem yapacaginiz webelemente kadar asagi inmelisiniz.
         */

        // wisequarter ana sayfaya gidin
            driver.get("https://www.wisequarter.com");
        // Java Test Automation Engineer
        // menusune kadar asagi inin

        Actions actions= new Actions(driver);

        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN).perform();


        // menuye click yapin
        driver.findElement(By.xpath("//img[@alt='Automation Engineer']")).click();

        // menuye click yapildigini test edin
        // url'de automation-engineer gectigini test edelim

        String expectedIcerik="automation-engineer";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));


        Thread.sleep(3000);
    }

}
