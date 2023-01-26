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

public class C02_BasicAuthentication {
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
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        // driver.get("https://the-internet.herokuapp.com/basic_auth");
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : admin
        // 	password      : admin
        //
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        WebElement tebrikMesajElementi= driver.findElement(By.tagName("p"));

        String expectedIcerik="Congratulations";
        String actualYazi=tebrikMesajElementi.getText();

        Assert.assertTrue(actualYazi.contains(expectedIcerik));

    }
}
