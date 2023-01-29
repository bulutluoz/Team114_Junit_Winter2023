package ders08_actions_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseMethod;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadsTesti extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {

        //1. Tests packagenin altina bir class oluşturalim : C04_FileDownload
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim


        driver.findElement(By.linkText("logo.png")).click();


        Thread.sleep(5000);
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // dosya Downloads'a indirilir

        String dinamikDosyaYolu= System.getProperty("user.home") +"/Downloads/logo.png";

        //  Files.exists(Paths.get(dinamikDosyaYolu))  true veya false doner

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));
    }

}
