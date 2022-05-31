package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import java.util.List;
import static org.junit.Assert.*;


public class FelineTest {

    @Mock
    Feline feline;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void eatMeatTest() throws Exception{
        Feline feline = new Feline();
        List <String> actu1al = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actu1al);
    }


    @Test
    public void getFamilyTest() {
        Feline feline = new Feline();
        String actual = feline.getFamily();
        assertEquals("Кошачьи", actual);
    }


    @Test
    public void getKittensTest() {
        Feline feline = new Feline();
        int actual = feline.getKittens();
        assertEquals(1, actual);
    }


    @Test
    public void getKittensTestWithInputData(){
        int actual = feline.kittensCount;
        assertEquals(feline.getKittens(3), actual);
    }
}