package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

import java.util.Set;

public class C03_WindowHandle extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {

        // https://the-internet.herokuapp.com/windows adrese gidin
            driver.get("https://the-internet.herokuapp.com/windows");
        // sayfadaki yazinin "Opening a new window" oldugunu test edin
        WebElement yaziElementi= driver.findElement(By.tagName("h3"));
        String expectedYazi="Opening a new window";
        String actualYazi= yaziElementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();

        // click here linkini tiklayin
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        /*
            Bir onceki class'da switchTo().newWindow diyerek yeni sayfa actigimizda
            driver da otomatik olarak yeni sayfaya gecmisti
            Ancak bu soruda switchTo().newWindow demeden
            tikladigimiz bir link 2.tab'i olusturdu

            BU DURUMDA driver OTOMATIK OLARAK yeni sayfaya GECMEZ

            Bizim Java'daki yontemleri kullanarak
            2.sayfanin windowHANDLEDEGERINI BULMAMIZ LAZIM

            getWindowhandles() iki sayfanin handle degerlerini Set olarak verir
            Set index desteklemedigi icin 2.windowhandleDegerini direk alamayiz

            Bir loop ileSet'i gozden gecirip
            ilksayfaWindowHandleDegeri'ne esit OLMAYAN String'i
            ikinciSayfaWindowhandleDegeri olarak atayalim
         */


        Set<String> windowHandleSeti=  driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";

        for (String each:windowHandleSeti
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }




        // ikinci sayfaya gecerek oradaki yazinin "New Window" oldugunu test edin
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        WebElement ikincisayfaYazi= driver.findElement(By.tagName("h3"));

         expectedYazi="New Window";
         actualYazi=ikincisayfaYazi.getText();

         Assert.assertEquals(expectedYazi,actualYazi);

        // yeniden ilk sayfaya gecerek, url'in
        // "https://the-internet.herokuapp.com/windows" oldugunu test edin

        driver.switchTo().window(ilkSayfaWindowHandleDegeri);

        String expectedUrl="https://the-internet.herokuapp.com/windows";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        Thread.sleep(5000);
    }

}
