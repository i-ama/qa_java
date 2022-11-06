package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private final String sex = "Самец";
    @Mock
   private Feline feline;

    //Проверка метода getKittens()
    @Test
    public void getKittensCorrectValue() throws Exception {
        int expectedResult = 1;
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualResult = lion.getKittens();
        Assert.assertEquals("Kittens is incorrect", expectedResult, actualResult);
    }

    //Проверка метода getFood
    @Test
    public void getFoodCorrectListOfFood() throws Exception {
        Lion lion = new Lion(sex, feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> expectedResultList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = lion.getFood();
        assertEquals("List is incorrect", expectedResultList, actualResult);
    }

    //Проверяем отработку исключения
    @Test(expected = Exception.class)
    public void constructorThrowsExceptionOnUnsupportedSex() throws Exception {
        Lion lion = new Lion("Гермафродит", feline);
    }

    //Проверяем текст, выводимый при исключении
    @Test
    public void checkMessageInExceptionOnUnsupportedSex() {
        String expectedResult = "Используйте допустимые значения пола животного - самей или самка";
        Exception exception = null;

        try {
            Lion lion = new Lion("Гермафродит", feline);
        } catch (Exception ex) {
            exception = ex;
        }
        assertEquals(expectedResult, exception.getMessage());
    }
}