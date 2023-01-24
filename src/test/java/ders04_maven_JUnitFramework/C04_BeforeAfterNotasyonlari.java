package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfterNotasyonlari {

    // 3 farkli test methodu olusturun, bu method'larda
    // amazon, wisequarter ve youtube anasayfalarina gidip
    // o sayfalara gittigimizi test edin ve sayfayi kapatin

    /*
        JUnit notasyonlar sayesinde
        her test method'undan veya her test class'indan once veya sonra
        calistirilmasi gereken kodlar varsa
        bunlari ayri bir method olarak hazirlayabiliriz

        boylece ayni kodlari tekrar tekrar yazmak zorunda kalmayiz
     */
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        System.out.println("setup");
    }
    @After
    public void teardown(){
        System.out.println("teardown");
        driver.close();
    }

    @Test
    public void test01(){

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
        driver.get("https://www.wisequarter.com");

        String expectedUrlIcerik="wisequarter";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Wisequarter testi PASSED");
        }else{
            System.out.println("WiseQuarter testi FAILED");
        }
    }
    @Test
    public void test03(){
        driver.get("https://www.youtube.com");

        String expectedUrlIcerik="youtube";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlIcerik)){
            System.out.println("Youtube testi PASSED");
        }else{
            System.out.println("Youtube testi FAILED");
        }
    }
}
