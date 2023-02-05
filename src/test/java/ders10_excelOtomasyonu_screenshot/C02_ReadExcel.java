package ders10_excelOtomasyonu_screenshot;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {
        String dosyYolu= "src/test/java/ders10_excelOtomasyonu_screenshot/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //	    - 1.satirdaki 2.hucreye gidelim ve yazdiralim
        Cell istenenCell = workbook.getSheet("Sayfa1").getRow(0).getCell(1);
        System.out.println("1.satirdaki 2.cell : "+istenenCell);
        //		- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String satir1cell2Str = istenenCell.toString();
        //		- 2.satir 4.cell’in afganistan’in baskenti Kabil oldugunu test edelim
        Cell satir2cell4Cell= workbook.getSheet("Sayfa1").getRow(1).getCell(3);
        String expectedResult="Kabil";
        String actualResult= satir2cell4Cell.toString();
        Assert.assertEquals(expectedResult,actualResult);

        //		- Satir sayisini bulalim
        // getLastRowNum() kullanilan son satirin index'ini verir

        System.out.println(workbook.getSheet("Sayfa1").getLastRowNum()+1);
        //		- Fiziki olarak kullanilan satir sayisini bulun
        // getPhysicalNumberOfRows() bos olmayan satir sayisini verir
        System.out.println("Fiziki kullanilan satir sayisi : "+workbook.getSheet("Sayfa1").getPhysicalNumberOfRows());
        //		- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> ulkeisimleriMap= new TreeMap<>();

        for (int i = 0; i <= workbook.getSheet("Sayfa1").getLastRowNum(); i++) {

            String ulkeIsmi= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskentIsmi= workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();
            ulkeisimleriMap.put(ulkeIsmi,baskentIsmi);
        }

        System.out.println(ulkeisimleriMap);

        System.out.println(ulkeisimleriMap.get("Turkey"));
        System.out.println(ulkeisimleriMap.get("Albania"));

    }
}
