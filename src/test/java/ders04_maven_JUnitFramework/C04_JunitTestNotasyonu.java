package ders04_maven_JUnitFramework;

import org.junit.Test;

public class C04_JunitTestNotasyonu {

    // bir class icerisinde 3 test olusturun
    // bu testleri istersek hep birlikte
    // istersek de ayri ayri calistirabilelim

    // simdiye kadar hep main method icinde islem yaptik ancak birden fazla main method olusturamayiz

    // JUnit'in bize sagladigi en buyuk avantaj
    // main method mecburiyetini ortadan kaldirmaktir

    // Oncelikle JUnit kutuphanesini projemize ekleyelim


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
