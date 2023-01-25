package ders05_junitAssertions;

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

public class C04_Assertions {
    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin
    //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    //	○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    static WebDriver driver;

    @BeforeClass
    public static void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
        WebElement cookiesElementi= driver.findElement(By.xpath("//button[@aria-label='Accept the use of cookies and other data for the purposes described']"));
        Thread.sleep(2000);
        cookiesElementi.click();
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test01(){
        //	○ titleTest 	=> Sayfa başlığının “YouTube” oldugunu test edin

        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Test
    public void test02(){
        //	○ imageTest 	=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());

    }

    @Test
    public void test03(){
        //	○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBoxElementi= driver.findElement(By.xpath("//input[@id='search']"));

        Assert.assertTrue(searchBoxElementi.isEnabled());
    }

    @Test
    public void test04(){
        //	○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        String expectedTitle="youtube";
        String actualTitle= driver.getTitle();

        Assert.assertNotEquals(expectedTitle,actualTitle);
    }
}
