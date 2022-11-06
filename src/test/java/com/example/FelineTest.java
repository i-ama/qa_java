package com.example;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FelineTest {
    Feline feline = new Feline();

    //Проверка метода eatMeat
    @Test
    public void eatMeatGetCorrectListOfFood() throws Exception {
        List<String> expectedResultList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualResult = feline.eatMeat();
        assertEquals("List of eatMeat is incorrect", expectedResultList, actualResult);
    }

    //Проверка метода getFamily
    @Test
    public void getFamilyCorrectValue() {
        String expectedResultList = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals("getFamily is incorrect", expectedResultList, actualResult);
    }

    //Проверка метода getKittens()
    @Test
    public void getKittensCorrectValueWithoutKittensCount() {
        int expectedResultList = 1;
        int actualResult = feline.getKittens();
        assertEquals("kittensCount is incorrect", expectedResultList, actualResult);
    }

    //Проверка метода getKittens(int kittensCount)
    @Test
    public void getKittensCorrectValueWithKittensCount() {
        int expectedResultList = 5;
        int actualResult = feline.getKittens(5);
        assertEquals("kittensCount is incorrect", expectedResultList, actualResult);
    }
}