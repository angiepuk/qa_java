package com.example;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoRule;
import org.junit.Rule;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(Parameterized.class)

public class AnimalTest extends TestCase {

    @Mock
    Animal animal;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testDetFamily(){
        Animal animal = new Animal();
        String actual = animal.getFamily();
        assertEquals("Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи", actual);
    }


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


    @Test
    public void exceptionTest(){
        Animal animal = new Animal();
        Exception e = assertThrows(Exception.class, () -> {animal.getFood("Млекопитающее");});
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
    }
}