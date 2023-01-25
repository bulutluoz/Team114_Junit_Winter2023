package ders05_junitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropdownMenu {

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test
    public void dropdownTesti() throws InterruptedException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // arama kutusunun yanindaki dropdown menuden books secenegini secin
            // - once dropdown menuyu locate edelim
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
            // - Select class'indan bir obje olusturup, parametre olarak locate ettigimiz ddm'yu girelim
        Select select= new Select(ddm);
            // - select objesini kullanarak istenen islemi yapin
        select.selectByVisibleText("Books");
        // arama kutusuna Java yazip aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);

        // arama sonuclarinin 1000'den fazla oldugunu test edin
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        // Verilen bir metinden sayiyi alip
        // onu tam sayiya cevirmemiz icin Java'dan String Manipulation method'larini kullaniriz

        String sonucYazisiStr= sonucYaziElementi.getText();

        String[] sonucYaziArr = sonucYazisiStr.split(" ");

        String sonucSayisiStr= sonucYaziArr[3];

        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D","");

        // elde ettigimiz String sonuc sayisini integer'a cevirmeliyiz

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        // Artik testimizi yapabiliriz

        int expectedAramaSonucu=1000;
        Assert.assertTrue(sonucSayisiInt>expectedAramaSonucu);

        Thread.sleep(2000);

    }
}
