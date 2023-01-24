package ders04_maven_JUnitFramework;

import org.junit.*;

public class C07_Before_BeforeClass {

    /*
    @BeforeClass, @AfterClass ile @Before,@After arasinda iki temel fark vardir

        1- @BeforeClass, @AfterClass kullanan method'lar static yapilmalidir
        2- @Before,@After her method'dan once ve sonra calisir
           Eger bize verilen gorev her method'dan sonra browser'i kapatmayi iceriyorsa
           bunlari kullanmak gerekir

           eger testler ayni web sayfasinda iseler ve her method'dan sonra
           browser'i kapatmamiz gerekmiyorsa
           o zaman @BeforeClass, @AfterClass kullanilmalidir

           @BeforeClass, class calismaya basladiginda  ayarlari yapar
           ve tum testler bittikten sonra @AfterClass browser'i kapatir
     */
    @BeforeClass
    public static void setupClass(){
        System.out.println("BeforeClass Calisti");
    }
    @Before
    public void setupMethod(){
        System.out.println("Before calisti");
    }
    @After
    public void teardownMethod(){
        System.out.println("After Calisti");
    }

    @AfterClass
    public static void teardownClass(){
        System.out.println("AfterClass Calisti");
    }

    @Test
    public void test01(){
        System.out.println("test01 calisti");
    }

    @Test
    public void test02(){
        System.out.println("test02 calisti");
    }

    @Test
    public void test03(){
        System.out.println("test03 calisti");
    }

}
