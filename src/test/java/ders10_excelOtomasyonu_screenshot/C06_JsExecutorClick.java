package ders10_excelOtomasyonu_screenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseMethod;

public class C06_JsExecutorClick extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.

        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Remove butonuna js executor ile basin.

        WebElement removeButonu = driver.findElement(By.xpath("//button[text()='Remove']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",removeButonu);

        Thread.sleep(3000);
    }

}
