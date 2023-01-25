package ders05_junitAssertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_AssertionMethodlari {
    // 3 test method'u olusturup
    // class level'da verilen bir tamsayinin
    // - 100'den buyuk oldugunu
    // - cift sayi oldugunu
    // - 3 basamakli oldugunu test edin

    int sayi= 3600;

    @Test
    public void test01(){

        // - 100'den buyuk oldugunu

        Assert.assertTrue(sayi>100);
    }

    @Test
    public void test02(){
        // - cift sayi oldugunu

        Assert.assertEquals(0,sayi%2);
    }

    @Test
    public void test03(){
        // - 3 basamakli oldugunu test edin

        Assert.assertTrue(sayi>99 && sayi<1000);
    }
}
