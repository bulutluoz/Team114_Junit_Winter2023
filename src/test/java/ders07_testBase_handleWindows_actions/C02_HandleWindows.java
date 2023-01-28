package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBaseMethod;

public class C02_HandleWindows extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {
        // Amazon anasayafaya gidelim
        driver.get("https://www.amazon.com");
        // Nutella aratalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        // arama sonuclarinin Nutella icerdigini test edelim
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik="Nutella";
        String actualSonucYazisi= aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        /*
            Testimizde yeni windows'a gittikten sonra yeniden ilk pencereye donus varsa
            daha ilk pencere'de iken o sayfanin windowHandleDegerini alip kaydetmeliyiz
         */

        String ilkSayfaWindowhandleDegeri= driver.getWindowHandle();

        // Yeni bir tab'da yeniden amazon'a gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        // Samsung aratalim
        // StaleElementReferenceException
        // arama kutusunu locate etmis olsak da, farkli bir windows'da locate ettigimiz icin
        // burada kullanilamiyor
        aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung" + Keys.ENTER);
        // Arama sonuclarinin Samsung icerdigini test edelim
        aramaSonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        expectedIcerik="Samsung";
        actualSonucYazisi= aramaSonucElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));
        // Yeniden Nutella arattigimiz sayfaya gecip, arama sonuclarini yazdiralim
        // daha onceden olusturulmus bir windows'a gecmek icin
        // o windows'un windowHandleDegerini bilmemiz gerekir.

        driver.switchTo().window(ilkSayfaWindowhandleDegeri);

        aramaSonucElementi= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        System.out.println(aramaSonucElementi.getText());



        Thread.sleep(5000);
    }
}
