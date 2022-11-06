package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    private Feline feline;


    //Проверка метода getSound
    @Test
    public void getSoundCheckMessage() {
        String expectedResult = "Мяу";
        Cat cat = new Cat(feline);
        String actualResult = cat.getSound();
        Assert.assertEquals("Message is incorrect", expectedResult, actualResult);
    }

    //Проверка метода getFood
    @Test
    public void getFoodCorrectListOfFood() throws Exception {
        Cat cat = new Cat(feline);
        Mockito.when(feline.eatMeat()).thenReturn(Collections.singletonList("Животные, Птицы, Рыба"));
        List<String> expectedResult = Collections.singletonList("Животные, Птицы, Рыба");
        List<String> actualResult = cat.getFood();
        Assert.assertEquals("List of food is incorrect", expectedResult, actualResult);
    }
}