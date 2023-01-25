package ders05_junitAssertions;

import org.junit.Ignore;
import org.junit.Test;

public class C01_Assertions {
    /*
        JUnit framework'unun bize sagladigi avantajlardan biri de
        Konsolda aciklama satirlari arasinda testimizin passed veya failed oldugu bilgisini
        aramak zorunda kalmamamizdir.

        JUnit asagidaki konsolda 2 farkli alanda testlerimizin sonuclarini bize verir
        1- konsol'un hemen ustunde Tests passed ...., ignored .... , failed ....
        2- calisan class ve method'lari gosteren yan ekranda
           passed olanlar icin yesil tik
           failed olanlar icin kirmizi X
           ignore edilenler icin gri ... isaret cikar


       JUnit framework'deki bu ozelligin saglikli calismasi icin
       JUnit Assertions kullanilmalidir

       Assertions kullanilmazsa JUnit kodlarin calismasinda
       her hangi bir problemle karsilasmazsa
       testleri passed olarak isaretleyecektir.


     */

    // 3 test method'u olusturup
    // class level'da verilen bir tamsayinin
    // - 100'den buyuk oldugunu
    // - cift sayi oldugunu
    // - 3 basamakli oldugunu test edin

    int sayi= 2455;

    @Test
    public void test01(){
        // - 100'den buyuk oldugunu

        if (sayi>100){
            System.out.println("Sayi 100'den buyuk 1.test PASSED");
        }else {
            System.out.println("Sayi 100'den buyuk degil, 1.test FAILED");
        }

    }

    @Test
    public void test02(){
        // - cift sayi oldugunu

        if (sayi % 2 == 0){
            System.out.println("Verilen sayi, cift sayi. 2.test PASSED");
        }else {
            System.out.println("Verilen sayi, cift sayi degil. 2.test FAILED");
        }

    }

    @Test
    public void test03(){
        // - 3 basamakli oldugunu test edin

        if (sayi>99 && sayi<1000){
            System.out.println("Sayi 3 basamakli, 3.test PASSED");
        }else {
            System.out.println("Sayi 3 basamakli degil, 3.test FAILED");
        }

    }


}
