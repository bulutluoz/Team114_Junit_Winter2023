package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBaseClass {

    static WebDriver driver;
    // access modifier yazilmazsa default access modifier gecerli olur
    // default access modifier sadece icinde bulundugu utilities package'da gecerlidir
    // baska package'dan driver'a ulasmak icin
    //  - herkes ulasabilsin dersek public
    //  - sadece child class'lar ulasabilsin dersek protected kullanilmalidir

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}
