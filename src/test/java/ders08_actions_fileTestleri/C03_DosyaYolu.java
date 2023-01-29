package ders08_actions_fileTestleri;

import org.junit.Test;

public class C03_DosyaYolu {

    @Test
    public void test(){

// /Users/ahmetbulutluoz/IdeaProjects/com.team114/src/test/java/ders08_actions_fileTestleri/C03_DosyaYolu.java

// Users/mel/IdeaProjectsu/com.team114/src/test/java/ders_8_actions_file_testleri/C03_Dosya_yolu.java


// /Users/ahmetbulutluoz/Desktop
// C:\Users\dogan\Desktop
// C:\Users\nigar\OneDrive\Desktop\Diplomam.jpg

        /*
                Java kisisel bilgisayarlarin farkliliklarindan bagimsiz
                bir dosya yolu olusturmak icin
                bize 2 kisa yol veriyor
         */

        System.out.println(System.getProperty("user.dir"));
        // icinde oldugumuz projenin dosya yolunu verir
        // /Users/ahmetbulutluoz/IdeaProjects/com.team114
        // /Users/mel/IdeaProjectsu/com.team114


        System.out.println(System.getProperty("user.home"));
        // kullandigimiz bilgisayarin temel dosya yolunu verir
        // /Users/ahmetbulutluoz
        // C:\Users\dogan
        // C:\Users\nigar

        // Biz masaustumuzdeki abc.txt dosyasina ait dosya yolunu yazarsak
        // /Users/ahmetbulutluoz/Desktop/abc.txt  olur

        // Downloads daki xyz.jpg dosyasinin yolu
        // /Users/ahmetbulutluoz/Downloads/xyz.jpg

        // ancak bu yazim dinamik olmaz, sadece ahmetbulutluoz kullanicisinda calisir
        // eger dinamik yapmak istersek

        // /Users/ahmetbulutluoz/Desktop/abc.txt  ==> System.getProperty("user.home") +"/Desktop/abc.txt"
        // /Users/ahmetbulutluoz/Downloads/xyz.jpg==> System.getProperty("user.home") + "/Downloads/xyz.jpg"


    }
}
