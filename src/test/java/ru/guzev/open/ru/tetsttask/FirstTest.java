package ru.guzev.open.ru.tetsttask;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstTest {

    @BeforeClass
    public void setUp(){
        Selenide.open("http://www.google.com");
    }

    @Test
    public void firstTest(){
        System.out.println("готово");
        Assert.assertTrue(true);
    }
}
