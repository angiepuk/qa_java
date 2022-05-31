package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.junit.runners.Parameterized;
import org.mockito.junit.MockitoRule;
import org.junit.Rule;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)

public class LionTest {

    @Mock
    Feline feline;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void getKittensTest() {
        Lion lion = new Lion(feline);
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }


    @Mock
    Lion lion;

    @Test
    public void doesHaveManeTest(){
        Lion lion = new Lion(feline);
        assertEquals(lion.hasMane, lion.doesHaveMane());
    }

    @Test
    public void getFoodLionTest() throws Exception{
        Lion lion = new Lion(feline);
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }


    private String sexValue;
    private boolean expected;
    private boolean actual;

    public LionTest(String sexValue, boolean expected){
       this.sexValue = sexValue;
       this.expected = expected;
   }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                { "Самка", false},
                { "Самец", true},
        };
    }

    @Test
    public void shouldGetHasMane() throws Exception {
        Lion lion = new Lion(feline);
        boolean actual = lion.Lion(sexValue);
        assertEquals(expected, actual);
    }

    @Test
    public void exceptionTest(){
        Lion lion = new Lion(feline);
        Exception e = assertThrows(Exception.class, () -> {lion.Lion("Самкич");});
        assertEquals("Используйте допустимые значения пола животного - самей или самка", e.getMessage());
    }
}
