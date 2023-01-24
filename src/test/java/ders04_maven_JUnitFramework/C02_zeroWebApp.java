package ders04_maven_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_zeroWebApp {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //3. Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        // burada back yapmamiz gerekiyor
        driver.navigate().back();
        //6. Online banking menusunden Pay Bills sayfasina gidin
        // online banking linkini tiklayalim
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        // paybills linkini tiklayalim
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("200");
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        //9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini test edin

        WebElement mesajElementi= driver.findElement(By.xpath("//div[@id='alert_content']"));

        if (mesajElementi.isDisplayed()){
            System.out.println("Test PASSED");
        }else{
            System.out.println("Mesaj gorunmuyor, testFAILED");
        }

        // biz sadece mesajin gorundugunu test ettik
        // eger mesajin icerigini de test etmek isterseniz
        // actual ve expected yazilari kaydedip
        // bunlarin esit olup olmadigini test edebiliriz

        driver.close();
    }
}
