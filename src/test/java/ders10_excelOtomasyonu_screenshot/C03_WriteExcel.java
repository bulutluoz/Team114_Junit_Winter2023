package ders10_excelOtomasyonu_screenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void test01() throws IOException {
        //1) Yeni bir Class olusturalim WriteExcel
        //2) Yeni bir test method olusturalim writeExcelTest()
        String dosyaYolu= "src/test/java/ders10_excelOtomasyonu_screenshot/ulkeler.xlsx";
        FileInputStream fis= new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet= workbook.getSheet("Sayfa1");
        //3) Adimlari takip ederek 1.satira kadar gidelim
        //4) 5.hucreye yeni bir cell olusturalim
        //5) Olusturdugumuz hucreye “Nufus” yazdiralim
        sheet.getRow(0).createCell(4).setCellValue("Nufus");
        //6) 2.satir nufus kolonuna 1500000 yazdiralim
        sheet.getRow(1).createCell(4).setCellValue(1500000);
        //7) 10.satir nufus kolonuna 250000 yazdiralim
        sheet.getRow(9).createCell(4).setCellValue(250000);
        //8) 15.satir nufus kolonuna 54000 yazdiralim
        sheet.getRow(14).createCell(4).setCellValue(54000);

        //9) Dosyayi kaydedelim
        //   yaptigimiz degisiklikleri fiziki excel'in kopyasi olan workbook uzerinde yaptik
        //   bu degisiklikleri excel'e kaydetmek istersek bu defa FileOutputStream olusturmaliyiz
        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        workbook.write(fos);
        //10)Dosyayi kapatalim
        fis.close();
        fos.close();
        workbook.close();

    }
}
