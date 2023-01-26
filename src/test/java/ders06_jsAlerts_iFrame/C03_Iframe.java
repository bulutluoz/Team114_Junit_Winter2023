package ders06_jsAlerts_iFrame;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Iframe {

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        /*
            Gittiginiz bir web sayfasinda
            aldiginiz locate dogru olmasina ragmen
            webelementi kullanamiyorsaniz
            kullanmak istediginiz web element bir iframe icerisinde olabilir

            bunu anlamak icin
            kullanmak isedigimiz webelementin
            bir iframe'in child'i veya grand child'i olup olmadigini kontrol etmeliyiz

            Eger kullanmak istedigimiz webelement
            bir iframe'in icinde ise
            once o iframe'e switchTO() ile gecmeliyiz

            Gecis yapmak icin iframe'i locate edip
            bir webelement olarak kaydetmeliyiz

            IFrame'de isimiz bittikten sonra
            ana sayfaya donmek istersek
            YINE switchTo() kullanmaliyiz
         */
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2 ) Bir metod olusturun: iframeTest
        //	- “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.
        WebElement anIframeYaziElementi= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeYaziElementi.isEnabled());
        System.out.println(anIframeYaziElementi.getText());
        //	- Text Box’a “Merhaba Dunya!” yazin.
        // once iframe'e gecis yapalim

        WebElement iframeElementi= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);


        WebElement textBoxElementi= driver.findElement(By.xpath("//*[@id='tinymce']"));
        Thread.sleep(2000);
        textBoxElementi.clear();
        textBoxElementi.sendKeys("Merhaba dunya");
        //	- TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin
        //   	ve  konsolda yazdirin.
        // once anasayfaya gecmeliyiz

        // driver.switchTo().parentFrame();
        // eger ic ice iframe'ler varsa bu kod bir ust iframe'e gecis saglar

        driver.switchTo().defaultContent(); // ana sayfaya gecis yapar


        WebElement elementalSeleniumElementi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());
        System.out.println(elementalSeleniumElementi.getText());
        Thread.sleep(5000);
    }
}
