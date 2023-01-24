package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BeforeClassAfterClass {

    /*
        3 farkli test method'u olusturun
        1. method'da amazon anasayfaya gidip
           amazon'da oldugunuzu test edin
        2. method'da arama kutusuna Nutella yazip aratin
           ve sonuc yazisinin Nutella icerdigini test edin
        3. method'da ilk Nutella urunune tiklayip
           urun isminin Nutella icerdigini test edin
     */
    static WebDriver  driver;

    /*
        JUnit'de @BeforeClass ve @AfterClass notasyonlarinin kullanildigi method'lar
        static olarak isaretlenmek zorundadir
     */
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        //1. method'da amazon anasayfaya gidip
        //   amazon'da oldugunuzu test edin
        driver.get("https://www.amazon.com");

        String expectedUrlIcerik="amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Amazon testi PASSED");
        }else{
            System.out.println("Amazon testi FAILED");
        }

    }

    @Test
    public void test02(){
        // 2. method'da arama kutusuna Nutella yazip aratin
        //    ve sonuc yazisinin Nutella icerdigini test edin

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYaziElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedIcerik= "Nutella";
        String actualSonucYazisi= sonucYaziElementi.getText();

        if (actualSonucYazisi.contains(expectedIcerik)){
            System.out.println("Nutella arama testi PASSED");
        }else{
            System.out.println("Nutella arama testi FAILED");
        }


    }

    @Test
    public void test03(){
        //3. method'da ilk Nutella urunune tiklayip
        //   urun isminin Nutella icerdigini test edin

        WebElement ilkUrunElementi= driver.findElement(By.xpath("(//div[@class='a-section a-spacing-base'])[1]"));

        ilkUrunElementi.click();

        String actualUrunIsmi= driver.findElement(By.xpath("//span[@id='productTitle']")).getText();
        String expectedIcerik="Nutella";

        if (actualUrunIsmi.contains(expectedIcerik)){
            System.out.println("Ilk urun testi PASSED");
        }else{
            System.out.println("Ilk urun testi FAILED");
        }
    }

}
