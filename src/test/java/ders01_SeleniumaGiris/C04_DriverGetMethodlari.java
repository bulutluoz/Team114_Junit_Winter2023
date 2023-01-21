package ders01_SeleniumaGiris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_DriverGetMethodlari {

    public static void main(String[] args) throws InterruptedException {
        // Otomasyonun ilk adimi
        // driver'i olusturmak ve bunun icin gerekli ayarlari yapmaktir

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.wisequarter.com");

        System.out.println(driver.getTitle());
        // IT Bootcamp, Distance education method - Wise Quarter Course

        System.out.println(driver.getCurrentUrl());
        // https://wisequarter.com/

        System.out.println(driver.getPageSource());

        System.out.println(driver.getWindowHandle());
        // CDwindow-20ADBCB7B4032C146E1BEB3B89E6727A
        // CDwindow-B70C28BC84C49C76057CB4C365D6C78D
        // driver her olusturuldugunda acilan her bir sayfa icin
        // benzersiz bir handle degeri alir
        // driver.getWindowHandles() : eger testimiz calisirken
        // birden fazla sayfa aciliyorsa, tamaminin windowHandleDegerlerini getirir
        // windowHandleDegeri test yaparken birden fazla sayfa acilirsa
        // bu sayfalar arasinda gecis yapmak icin kullanilir


        Thread.sleep(5000);
        driver.close();
    }
}
