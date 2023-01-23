package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Xpath {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        /*
            Su ana kadar gordugumuz 6 locator
                - id
                - name
                - classname
                - tagname
                - linkText
                - partialLinkText
            Webelement'in HTML kodlarina baglidir.
            HTML kod istenen ozelliklerde degilse
            bu locator'lari kullanarak, unique bir locate yapamayabiliriz

            Bizim her webelementi unique olarak locate edebilecek
            COK GUCLU bir locator'a ihtiyacimiz var
         */
    }
}
