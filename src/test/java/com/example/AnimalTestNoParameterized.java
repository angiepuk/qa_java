package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnimalTestNoParameterized {
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

    @Test
    public void exceptionTest(){
        Animal animal = new Animal();
        Exception e = assertThrows(Exception.class, () -> {animal.getFood("Млекопитающее");});
        assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
    }
}
