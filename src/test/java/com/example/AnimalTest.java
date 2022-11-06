package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class AnimalTest {

    //Проверяем отработку исключения
    @Test(expected = Exception.class)
    public void checkThrowsExceptionOnUnsupportedSex() throws Exception {
        Animal animal = new Animal();
        String animalKind = "Не травоядное";
        animal.getFood(animalKind);
    }

    //Проверяем текст, выводимый при исключении
    @Test
    public void checkMessageInExceptionOnUnsupportedSex() {
        String expectedResult = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        Exception exception = null;

        try {
            Animal animal = new Animal();
            String animalKind = "Не травоядное";
            animal.getFood(animalKind);
        } catch (Exception ex) {
            exception = ex;
        }
        assertEquals(expectedResult, exception.getMessage());
    }

    //Проверяем текст, выводимый во время вызова метода getFamily
    @Test
    public void getFamilyReturnsValidString() {
        Animal animal = new Animal();
        String expectedResult = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        String actualResult = animal.getFamily();
        assertEquals("String is incorrect", expectedResult, actualResult);
    }
}