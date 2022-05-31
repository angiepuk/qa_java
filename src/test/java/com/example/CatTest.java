package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.junit.Rule;
import java.util.List;

public class CatTest {

    @Mock
    Cat cat;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void getSoundCatTest(){
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Mock
    Feline feline;

    @Test
    public void getFoodCatTest() throws Exception{
    cat = new Cat(feline);
    Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
    assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }
}