package ders08_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class C05_FileUploadsTest extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");
        //chooseFile butonuna basalim
        //Yuklemek istediginiz dosyayi secelim.
        /*
            Selenium webDriver kullanir
            ve webDriver bilgisayarimizdaki dosyalara ulasamaz
            klasorleri acip kapatamaz

            Ancak bunun yerine Selenium yukleme yapabilmek icin
            bize bir yontem olusturmustur
         */

        // once yuklemek istediginiz dosyanin dosya yolunu olusturun
        String dinamikDosyaYolu = System.getProperty("user.home")+ "/Downloads/logo.png";

        // sonra chooseFile butonunu locate edip
        // olusturdugumuz dosyaYolunu bu webelement'e sendkeys ile yollayalim

        WebElement chooseFileButonu= driver.findElement(By.id("file-upload"));

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //Upload butonuna basalim.

        driver.findElement(By.id("file-submit")).click();

        //“File Uploaded!” textinin goruntulendigini test edelim.

        WebElement yuklendiYaziElementi= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));

        Assert.assertTrue(yuklendiYaziElementi.isDisplayed());
        Thread.sleep(5000);
    }
}
