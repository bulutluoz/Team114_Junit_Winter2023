package ders07_testBase_handleWindows_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseMethod;

public class C05_ActionsDragAndDrop extends TestBaseMethod {

    @Test
    public void test01() throws InterruptedException {
        //Yeni bir class olusturalim: MouseActions2
        //1- https://demoqa.com/droppable adresine gidelim
            driver.get("https://demoqa.com/droppable");
        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim

        WebElement dragMe= driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropHere=driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        Actions actions= new Actions(driver);

        actions.dragAndDrop(dragMe,dropHere).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin

        WebElement droppedElementi= driver.findElement(By.xpath("//p[text()='Dropped!']"));

        String expectedYaziElementi="Dropped!";
        String actualYaziElementi=droppedElementi.getText();

        Assert.assertEquals(expectedYaziElementi,actualYaziElementi);

        Thread.sleep(5000);
    }
}
