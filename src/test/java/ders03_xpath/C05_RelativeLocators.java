package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class C05_RelativeLocators {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //1 ) https://www.diemol.com/selenium-4-demo/relative-locators-demo.html  adresine gidin
        driver.get("https://www.diemol.com/selenium-4-demo/relative-locators-demo.html");
        //2 ) Berlin’i  3 farkli relative locator ile locate edin
        // <img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">

        // Boston'in saginda tag'i img olan element seklinde locate edelim

        // once Boston webelementini locate etmeliyiz
        WebElement bostonElementi= driver.findElement(By.xpath("//*[@id='pid6_thumb']"));

        // sonra locate alirken By.... yerine RelativeLocator.with() methodunu kullaniyoruz
        // with methodunun icine asil kullanmak istedigimiz elementin
        // herhangi bir ozellligini yaziyoruz

        // en son olarak yerini tarif ediyoruz
        WebElement berlin1=
                driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(bostonElementi));


        //3 ) Relative locator’larin dogru calistigini test edin

        String actualIdDegeri= berlin1.getAttribute("id");
        String expectedIdDegeri= "pid7_thumb";

        if (actualIdDegeri.equals(expectedIdDegeri)){
            System.out.println("1.berlin locate testi PASSED");
        }else{
            System.out.println("1.berlin locate testi FAILED");
            System.out.println(actualIdDegeri);
        }


        // bir de Sailor'in ustundeki diye tarif edelim

        WebElement sailorElementi= driver.findElement(By.xpath("//*[@id='pid11_thumb']"));

        // <img id="pid7_thumb" src="bots/sl-berlin-bot.png" class="ui-li-thumb">

        WebElement berlin2=
                driver.findElement(RelativeLocator.with(By.className("ui-li-thumb")).above(sailorElementi));

        actualIdDegeri= berlin1.getAttribute("id");
        expectedIdDegeri= "pid7_thumb";

        if (actualIdDegeri.equals(expectedIdDegeri)){
            System.out.println("2.berlin locate testi PASSED");
        }else{
            System.out.println("2.berlin locate testi FAILED");
            System.out.println(actualIdDegeri);
        }

        driver.close();
    }
}
