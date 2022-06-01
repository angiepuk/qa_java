package com.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class LionTest {
    @Mock
    Feline feline;

    private String sexValue;
    private boolean expected;


    public LionTest(String sexValue, boolean expected){
        this.sexValue = sexValue;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getSexData() {
        return new Object[][] {
                { "Самка",  false},
                { "Самец",  true},
        };
    }

    @Test
    public void shouldGetHasMane() throws Exception {
        Lion lion = new Lion(sexValue, feline);
        assertEquals(expected, lion.doesHaveMane());
    }


}
