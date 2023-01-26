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

public class C01_JsAlerts {

    // https://the-internet.herokuapp.com/javascript_alerts
    // 3 method olusturun ve 3 butonu test edin

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
        // ilk butona click yapin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        // OK diyerek alert'i kapatin

        driver.switchTo().alert().accept();
        // OK butonuna basildigini test edin
        WebElement resultElementi= driver.findElement(By.xpath("//p[@id='result']"));
        Thread.sleep(2000);
        String expectedYazi= "You successfully clicked an alert";
        String actualResultYazisi= resultElementi.getText();

        Assert.assertEquals(expectedYazi,actualResultYazisi);
    }

    @Test
    public void test02() throws InterruptedException {
        // ikinci butona basin
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(2000);
        // alert uzerindeki yazinin "I am a JS Confirm" oldugunu test edin

        String expectedAlertYazisi="I am a JS Confirm";
        String actualAlertYazisi= driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        // cancel diyerek alert'i kapatin
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);

        // cancel'a basildigini test edin

        String expectedSonucYazisi="You clicked: Cancel";

        WebElement resultElementi= driver.findElement(By.xpath("//p[@id='result']"));

        String actualSonucYazisi= resultElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }

    @Test
    public void test03() throws InterruptedException {
        // ucuncu alert butonuna click yapin
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(2000);
        // cikan alert'e "Selenium heyecandir" yazdirin
        driver.switchTo().alert().sendKeys("Selenium heyecandir");
        Thread.sleep(2000);

        // OK butonuna basarak alert'i kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(2000);

        // cikan sonuc yazisinin "Selenium heyecandir" icerdigini test edin

        String expectedIcerik="Selenium heyecandir";

        WebElement resultElementi= driver.findElement(By.xpath("//p[@id='result']"));

        String actualSonucYazisi= resultElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }

}
