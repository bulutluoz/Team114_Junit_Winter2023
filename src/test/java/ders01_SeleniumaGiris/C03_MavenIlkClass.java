package ders01_SeleniumaGiris;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_MavenIlkClass {

    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        // driver objesi bizim websayfalarinda yapmak istedigimiz
        // tum otomasyon islemlerini bizim adimiza yapar


        // driver.get(istenenUrl) istenen url'e gider
        // https: yazmazsaniz calismaz
        // www yazmasaniz calisir

        driver.get("https://www.amazon.com");

        // tam ekran yapmak isterseniz

        driver.manage().window().maximize();

        // eger kodlarinizin belirli bir sure ilerlememesini isterseniz
        // Thread.sleep(istenen mili saniye) method'unu kullanabilirsiniz

        Thread.sleep(5000);

        // Otomasyon yapmak icin actigimiz driver'i kapatmak icin
        driver.close();


    }
}
