package ders09_cookies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBaseMethod;

import java.util.List;

public class C02_WebTables extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {
        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");
        //2.Sayfanin en altina inin
        Actions actions= new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(2000);
        //3.Web table tum body’sini yazdirin
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println("tum body : "+tumBody.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));

        Assert.assertTrue(satirlarListesi.size()==9);

        //5.Tum satirlari yazdirin

        int satirNo=1;

        for (WebElement eachSatir:satirlarListesi
             ) {
            System.out.println("====="+satirNo+".satir=====");
            System.out.println(eachSatir.getText());
            satirNo++;
        }
        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> birinciSatirElementleriList= driver.findElements(By.xpath("//tbody/tr[1]/td"));
        Assert.assertTrue(birinciSatirElementleriList.size()==13);

        //7. 5.sutunu yazdirin
        System.out.println("==========5.Sutun elementleri==========");
        List<WebElement> besinciSutunElementleriList= driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachElement:besinciSutunElementleriList
             ) {
            System.out.println(eachElement.getText());
        }
        //8.Satir ve sutun sayisini parametre olarak alip,
        // hucredeki bilgiyi String olarak döndüren bir method olusturun
        // bir hucreye ulasmak icin //tbody/tr[7]/td[3] buradaki sayilari degistirmemiz gerekiyor

        System.out.println("Istenen hucredeki bilgiler\n"+ReusableMethods.getCellValue(5, 7));


        Thread.sleep(2000);
    }


}
