package ders01_SeleniumaGiris;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_IlkTest {

    public static void main(String[] args) {
        // gerekli ayarlamalari yapip, driver'i olusturun

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // amazon anasayfaya gidin

        driver.get("https://www.amazon.com");

        // amazon anasayfaya gittiginizi test edin

        // bir tester olarak butun isimiz expected deger ile actual degeri karsilastirmaktir
        // eger ikisi ayni ise test passed olur
        // ikisi ayni degilse test failed olur

        // bize testi nasil yapacagimiz soylenmedigi icin
        // kendi yontemimizi belirleyebiliriz
        // ben bu test icin gerceklesen(actual) url'in amazon kelimesi ivcerdigini kontrol edecegim

        String expectedMetin= "amazon";
        String actualUrl= driver.getCurrentUrl();

        if (actualUrl.contains(expectedMetin)){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Url istenen metni icermiyor, Test FAILED");
        }
    }
}
