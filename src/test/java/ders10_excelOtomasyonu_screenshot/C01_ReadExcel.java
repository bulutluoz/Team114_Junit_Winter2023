package ders10_excelOtomasyonu_screenshot;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        /*
            Excel dosyasi fiziki olarak bilgisayarimizda
            Bizim kod ortaminda online olarak bilgisayardaki bir dosya uzerinde calismamiz mumkun degil

            Java bize ihtiyacimiz oldugunda
            bilgisayarimizdaki fiziki bir dosyadaki bilgileri okuma,
            ve kod ortamimizdan yolladigimiz bilgilerle
            dosyayi update etme imkanlari veriyor

            Bu sebepten oturu
            biz kod ortamimizda excel'in bir kopyasini olusturup
            exceldeki tum bilgileri, kopya excelimize kaydedecegiz
            kod ortamimizda oldugundan kopya excel uzerinde istedigimiz islemleri yapip
            isimiz bittikten sonra excel dosyasini update etmek istersek
            kopya exceldeki tum bilgileri, fiziki excel dosyasina kaydedebiliriz

         */

        // 1- fiziki excel dosyasina Java ile ulasalim

        String dosyaYolu= "src/test/java/ders10_excelOtomasyonu_screenshot/ulkeler.xlsx";
        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 2- Java ile ulastigimiz excel dosyasinin bir kopyasini
        //    kod ortamimizda olusturalim

        Workbook workbook = WorkbookFactory.create(fis);

        // 3- Bundan sonra excelin bir kopyasina kod ortaminda sahibiz
        //    simdi excelde birden fazla sayfa olabileceginden ilgili sayfaya gitmeliyiz

        Sheet sheet= workbook.getSheet("Sayfa1");

        Row row = sheet.getRow(11);
        // excel'deki Azerbaycan'in turkce baskent ismi
        // 12.satir, 4.sutunda
        // Ancak excel otomasyonunda satir ve cell bilgileri index kullandigi icin
        // 11.index'deki satirin, 3.indexindeki cell'i yazdirdik.

        Cell cell= row.getCell(3);

        System.out.println(cell);




    }
}
