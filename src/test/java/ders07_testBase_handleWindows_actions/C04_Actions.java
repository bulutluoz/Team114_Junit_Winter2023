package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

import java.util.Set;

public class C04_Actions extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElementi= driver.findElement(By.xpath("//*[@id='hot-spot']"));

        Actions actions=new Actions(driver);

        actions.contextClick(ciziliAlanElementi).perform();
        Thread.sleep(3000);


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi="You selected a context menu";
        String actualAlertYazisi= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        String ilkSayfaWindowHandleDegeri= driver.getWindowHandle();
        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        Set<String> windowHandleSeti= driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";

        for (String each: windowHandleSeti
             ) {

            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }
        }


        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        Thread.sleep(3000);
        WebElement yaziElementi= driver.findElement(By.tagName("h1"));

        String expectedYazi="Elemental Selenium";
        String actualYazi=yaziElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        Thread.sleep(3000);
    }
}
