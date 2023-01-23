package ders02_driverMethodlari_webelement;

public class C03_Webelement {
    public static void main(String[] args) {
        /*


        biz bir web sayfasina gittigimizde gozlerimizle gordugumuz her element
        bir WebElement'tir (yazilar, buton, resim, link, yazi kutulari vb..)

        Her webelemnt bir HTML kodu ile olusturulur

        ornegin amazon anasayfadaki arama kutusu bir webelement tir ve
        arama kutusunun HTML kodlari

        <input type="text" id="twotabsearchtextbox" value="" name="field-keywords"
        autocomplete="off" placeholder="" class="nav-input nav-progressive-attribute"
        dir="auto" tabindex="0" aria-label="" spellcheck="false">

        Herbir webelementi olusturan HTML kodunda
        1- tag : baslik demektir, kucuktur isaretinden sonra gelen ilk yazidir.
        2- attribute
        3- attribute value

        Bunlar kullanilarak webelemnti unique bir sekilde tarif etmeliyiz

        Selenium'da webelementleri locate etmek(driver'a tarif etmek) icin 8 tane locator vardir
        bunlardan ilk 6'si spesifik elementler icin kullanilabilirken
        son iki tanesi olan xpath ve css selector HER WEBELEMENT icin kullanilabilir


        spesifik elemntler icin kullanilabilecek locator'lar
        1- id
        2- classname
        3- name
        bu uc tanesi attribute ismidir ve kullanacagimiz webelementin
        HTML kodunda bu attribute'ler varsa kullanilir
        ornegin 16.satirda yazdigimiz amazon arama kutusu icin ucu de kullanilabilir
        cunku 3 attribute de var
        ancak bu attribute'ler kullanildiginda unique locate oluyor mu kontrol etmeliyiz

        4- tagname
        tag name ile benzersiz deger bulmak coooook zordur
        genelde cok tercih edilmez

        5- linktext
        6- partialLinktext

        sadece linkler icin kullanilirlar.
        HTML elementlerde link'ler genelde a tag'i ile olusturulur
        eger link'teki tum yazi ile tarif edeceksek linkText
        eger yazinin tamamini degil de bir bolumu ile tarif edeceksek
        partialLinkText kullanilir
         */
    }
}
