package ders09_cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

import java.util.List;
import java.util.WeakHashMap;

public class C03_WebTablesDuzensiz extends TestBaseMethod {

    @Test
    public void test01(){
        //Bir Class olusturun D19_WebtablesHomework
        //  1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //  2. Headers da bulunan basliklari yazdirin
        List<WebElement> headerElementleriList= driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        for (WebElement eachElelemnt:headerElementleriList
             ) {
            System.out.println(eachElelemnt.getText());
        }
        //  3. 3.sutunun basligini yazdirin

        System.out.println("3.sutunun basligi : " + headerElementleriList.get(2).getText());
        //  4. Tablodaki tum datalari yazdirin
        List<WebElement> tumElementlerList= driver.findElements(By.xpath("//div[@class='rt-td']"));

        for (WebElement eachElement:tumElementlerList
             ) {
            if (!eachElement.getText().isBlank()){
                System.out.println(eachElement.getText());
            }
        }
        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

        int bosOlmayanHucreSayisi=0;

        for (WebElement eachElement:tumElementlerList
        ) {
            if (!eachElement.getText().isBlank()){
               bosOlmayanHucreSayisi++;
            }
        }

        System.out.println("Bos olmayan hucre sayisi : " + bosOlmayanHucreSayisi);
        //  6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarListesi= driver.findElements(By.xpath("//div[@class='rt-tr-group']"));
        System.out.println("Tablodaki satir sayisi : " + satirlarListesi.size());
        //  7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sutun sayisi : " + headerElementleriList.size());
        //  8. Tablodaki 3.kolonu yazdirin
        List<WebElement> ucuncuSutunElementleriList=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        System.out.println("3.sutun elementleri");
        for (WebElement eachElement:ucuncuSutunElementleriList
        ) {
            if (!eachElement.getText().isBlank()){
                System.out.println(eachElement.getText());
            }
        }
        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        List<WebElement> isimSutunuElementleriList= driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
        List<WebElement> salarySutunuElementleriList= driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][5]"));

        String arananKisi="Kierra";

        for (int i = 0; i < isimSutunuElementleriList.size(); i++) {

            if (isimSutunuElementleriList.get(i).getText().equals(arananKisi)){

                System.out.println(arananKisi+"'nin maasi : " +
                       salarySutunuElementleriList.get(i).getText() );
            }
        }



    }
}
