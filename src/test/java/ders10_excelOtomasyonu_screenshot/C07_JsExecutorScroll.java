package ders10_excelOtomasyonu_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class C07_JsExecutorScroll extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {
        //wisequarter anasayfasina gidin, js executor ile
        driver.get("https://www.wisequarter.com");
        Thread.sleep(3000);
        // tanitim resmini kapatin
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        // alt kisimda bulunan “Go To Career Page” butonuna kadar asagi inin
        // ve bu butona click yapin

        WebElement automationEngineer= driver.findElement(By.xpath("(//img[@alt='Automation Engineer'])[1]"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();",automationEngineer);

        jse.executeScript("alert('yasasinnnn');");
        Thread.sleep(5000);


    }
}
