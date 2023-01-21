package ders01_SeleniumaGiris;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_ManuelYuklemeIleDriverOlusturma {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriver driver= new ChromeDriver();

        driver.get("https://www.amazon.com");

        /*
                Testleri otomasyon yapabilmek icin 3 bileseni bir araya getirdik
                - Java
                - Selenium
                - IntelliJ

                4.bilesen olarak kutuphaneleri projemize daha kolay eklememize
                ve bu kutuphaneleri kolayca update edebilmemize imkan taniyan
                Maven'i projemize ekleyecegiz
         */
    }
}
