package ders03_xpath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_TextIleXpath {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        //1- https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        //2- Add Element butonuna basin
        driver.findElement(By.xpath("//button[text()='Add Element']")).click();

        //3- Delete butonu’nun gorunur oldugunu test edin

        WebElement deleteButonu= driver.findElement(By.xpath("//button[text()='Delete']"));

        if (deleteButonu.isDisplayed()){
            System.out.println("Delete butonu gorunuyor, test PASSED");
        }else{
            System.out.println("Delete butonu gorunmuyor, Test FAILED");
        }
        Thread.sleep(2000);
        //4- Delete tusuna basin

        deleteButonu.click();
        //5- “Add/Remove Elements” yazisinin gorunur oldugunu test edin

        WebElement addRemoveYaziElementi= driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        if (addRemoveYaziElementi.isDisplayed()){
            System.out.println("Add remove yazisi gorunuyor, test PASSED");
        }else{
            System.out.println("Add remove yazisi gorunmuyor, Test FAILED");
        }

        Thread.sleep(2000);
        driver.close();
    }
}
