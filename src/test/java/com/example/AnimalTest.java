package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;


@RunWith(Parameterized.class)

public class AnimalTest extends TestCase {


    private String animalKind;
    private List<String> expectedList;
    private List<String> actual;


    public AnimalTest(String animalKind, List<String> expectedList) {
        this.animalKind = animalKind;
        this.expectedList = expectedList;
    }


    @Parameterized.Parameters
    public static Object[] getListFood() {
        return new Object[][] {
                { "Травоядное", List.of("Трава", "Различные растения")},
                { "Хищник", List.of("Животные", "Птицы", "Рыба")},
        };
    }


    @Test
    public void shouldGetListFood() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalKind);
        assertEquals(actual, expectedList);
    }

}