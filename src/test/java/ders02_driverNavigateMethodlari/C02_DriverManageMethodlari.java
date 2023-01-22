package ders02_driverNavigateMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_DriverManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            Wait konusu ilerde detayli olarak anlatilacak
            su an icin bilmemiz gereken kismi
            implicitlyWait sayfanin yuklenmesi ve
            kullanilacak webelementlerinin bulunmasi icin bir sure belirler
            bu sure icerisinde gorevi yapabilirse hemen yoluna devam eder
            belirlenen sure bittiginde hala gorev yapilamadi ise
            hata verir
         */

        driver.get("https://www.amazon.com");

        Thread.sleep(2000);
        System.out.println("maximim boyutta position : "+driver.manage().window().getPosition());
        System.out.println("maximize boyutta size : "+driver.manage().window().getSize());


        driver.manage().window().fullscreen();
        Thread.sleep(2000);

        System.out.println("fullscreen boyutta position : "+driver.manage().window().getPosition());
        System.out.println("fullscreen boyutta size : "+driver.manage().window().getSize());

        // window'u istedigimiz boyut ve konuma getirme

        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().window().setPosition(new Point(140,30));
        Thread.sleep(5000);
        System.out.println("istenen boyutta position : "+driver.manage().window().getPosition());
        System.out.println("istenen boyutta size : "+driver.manage().window().getSize());


        driver.close();

    }
}
