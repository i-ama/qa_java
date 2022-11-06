package com.example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTestWithParameters {
    private final String animalKind;
    private final String expectedResult;

    public AnimalTestWithParameters(String animalKind, String expectedResult) {
        this.animalKind = animalKind;
        this.expectedResult = expectedResult;
    }

    //Параметры для параметризированного теста getFoodCheckList
    @Parameterized.Parameters
    public static Object[][] testData() {
        return  new Object[][] {
                {"Травоядное", "Трава, Различные растения"},
                {"Хищник", "Животные, Птицы, Рыба"},
        };
    }

    //Параметризированный тест для всех условий в методе getFood (кроме исключений)
    @Test
    public void getFoodCheckList() throws Exception {
        Animal animal = new Animal();
        animal.getFood(animalKind);
        List<String> expectedResultList;
        expectedResultList = List.of(expectedResult.split(", "));
        List<String> actualResult = animal.getFood(animalKind);
        assertEquals("List is incorrect", expectedResultList, actualResult);

    }
}