package ders08_actions_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class C02_KeyboardActions extends TestBaseMethod {

    @Test
    public void test01(){

        /*
            Bir tablo doldurulurken
            Rastgele isim,soyisim,tel no, adres, sehir, password....
            gibi bilgileri rastgele girmek istersek
            faker kutuphanesinden faydalaniriz

            Bunun icin oncelikle Faker dependency'yi pom.xml'e ekler
            ve kullanmak icin de Faker class'indan bir obje olustururuz

         */
        Faker faker= new Faker();
        // facebook anasayfaya gidin
        driver.get("https://www.facebook.com");
        // cookies uyarisini kapatin
        WebElement cookiesAcceptButonu= driver.findElement(By.xpath("//button[@title='Only allow essential cookies']"));
        cookiesAcceptButonu.click();
        // yeni kayit olustur butonuna basin
        driver.findElement(By.linkText("Create new account")).click();
        // acilan formda tum alanlari doldurun
        WebElement isimKutusu= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions= new Actions(driver);
        String mail=faker.internet().emailAddress();

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(mail)
                .sendKeys(Keys.TAB)
                .sendKeys(mail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12")
                .sendKeys(Keys.TAB)
                .sendKeys("Feb")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();

        // kaydol tusuna basin
    }

}
