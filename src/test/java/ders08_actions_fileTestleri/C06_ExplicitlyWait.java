package ders08_actions_fileTestleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C06_ExplicitlyWait {

    //1. Bir class olusturun : WaitTest
    //2. Iki tane metod olusturun : implicitWait() , explicitWait()
    //
    //	 Iki metod icin de asagidaki adimlari test edin.
    //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    //4. Remove butonuna basin.
    //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
    //6. Add buttonuna basin
    //7. It’s back mesajinin gorundugunu test edin


    @Test
    public void implicitlyWaitTesti() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsGoneElementi= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));

        Assert.assertTrue(itsGoneElementi.isDisplayed());
        //6. Add buttonuna basin

        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin

        WebElement itsBackElementi=driver.findElement(By.xpath("//p[@id=\"message\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());

        Thread.sleep(3000);
        driver.close();

    }

    @Test
    public void explicitlyWaitTesti(){

        // Explicitly wait sadece implicitly wait'in bekleme suresinden
        // daha fazla zamana ihtiyac duyan spesifik gorevlerde kullanilir
        // IW ==> tum sayfa ve tum webelementler icin gecerli maximum bekleme suresi iken
        // EW ==> sadece bir webelement ve tanimlanan tek bir islem icin gecerli olur
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        // it's gone yazisinin gorunur olmasi icin beklememiz gerekiyor
        // once locate edip sonra o element gorunur oluncaya kadar bekle diyemeyiz
        // cunku OLMAYAN elementi locate edemeyiz

        // BU islem icin locate'i driver'a verip,
        // bu locate 'de istedigim eleman gorunur oluncaya kadar bekle demeliyiz
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(45));

        WebElement itsGoneElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        //6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        //7. It’s back mesajinin gorundugunu test edin


        WebElement itsBackElementi= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@id=\"message\"]")));
        Assert.assertTrue(itsBackElementi.isDisplayed());


        driver.close();

    }
}
