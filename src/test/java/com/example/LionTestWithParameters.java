package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class LionTestWithParameters {

    static Feline feline;
    private final String sex;
    private final boolean expectedResult;

    public LionTestWithParameters(Feline feline, String sex, boolean expectedResult) {
        this.expectedResult = expectedResult;
        this.feline = feline;
        this.sex = sex;
    }


    //Параметры для параметризированного теста getFoodCheckList
    @Parameterized.Parameters
    public static Object[][] testData() {
        return  new Object[][] {
                {feline, "Самец", true},
                {feline, "Самка", false},
        };
    }

    //Параметризированный тест для всех условий конструктора
    @Test
    public void doesHaveMane() throws Exception {
        Lion lion = new Lion(sex, feline);
        boolean actualResult = lion.doesHaveMane();
        Assert.assertEquals("hasMah is incorrect", expectedResult, actualResult);
    }
}