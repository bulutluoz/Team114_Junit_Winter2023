package utilities;

import org.openqa.selenium.By;

public class ReusableMethods extends TestBaseMethod{

    public static String getCellValue(int satir, int sutun){
        // //tbody/tr[7]/td[3]

        String dinamikXPath= "//tbody/tr["+satir+"]/td["+sutun+"]";


        return driver.findElement(By.xpath(dinamikXPath)).getText();
    }
}
