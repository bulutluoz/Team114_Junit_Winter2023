package ders02_driverNavigateMethodlari;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_findElementMethodu {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            bir webelementi kullanabilmek icin driver'a yerini tarif etmemiz lazim
            adres bilgisi locator,

            driver'in, adresi verilen webelemente gidip onu locate etmesi icin ise
            findElement(Locator) kullanilir
         */

        driver.get("https://wwww.amazon.com");

        // arama cubuguna Nutella yazip aratalim

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);

        Thread.sleep(2000);

        // bir de Java aratalim

        aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java" + Keys.ENTER);


        Thread.sleep(10000);
        driver.close();



    }
}
