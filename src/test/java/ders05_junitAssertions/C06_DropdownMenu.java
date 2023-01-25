package ders05_junitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C06_DropdownMenu {
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
    public void test01(){
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        // arama kutusu yanindaki dropdown menuden Books secenegini secin
        WebElement ddm=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select= new Select(ddm);

        select.selectByVisibleText("Books");

        // sectigimiz option'i yazdirin
        // secilen option'i yazdirmak icin select objesi uzerinden

        System.out.println(select.getFirstSelectedOption().getText());

        // Dropdown menude toplam 28 option oldugunu test edin

        int ddmOptionSayisi=select.getOptions().size();

        Assert.assertEquals(28, ddmOptionSayisi);
    }
}
