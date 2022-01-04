package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NumbersToTextTest {
    private IText textTransformer;

    @BeforeEach
    public void setupTextTransformer()
    {
        textTransformer = new NumbersToText(new InputString());
    }

    @Test
    public void testTextRepresentation()
    {
        String text = "Wpłać 123 złoty";
        String result = "Wpłać sto dwadzieścia trzy złoty";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testSame()
    {
        String text = "Kara za kopalnie w Turowie wynosi 10000000 euro i tyle";

        Assertions.assertEquals(text,  textTransformer.transform(text));
    }

    @Test
    public void testWithRest()
    {
        String text = "Pokemon go kosztuje 12.03 złoty za dzień";
        String result = "Pokemon go kosztuje dwanaście i trzy setne złoty za dzień";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testZero()
    {
        String text = "zero to 0 a 0 to zero";
        String result = "zero to zero a zero to zero";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testMultipleNumInText()
    {
        String text = "8.12 + 4.03 = 12.15";
        String result = "osiem i dwanaście setnych + cztery i trzy setne = dwanaście i piętnaście setnych";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testNegativeNumInText()
    {
        String text = "-0.3 jest jak -0.03 ale nie do końca";
        String result ="minus trzy dziesiąte jest jak minus trzy setne ale nie do końca";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testLongNumbers()
    {
        String text = "999.99 to prawie 1000 tak jak -1000 to prawie -999.99";
        String result = "dziewięćset dziewięćdziesiąt dziewięć i dziewięćdziesiąt dziewięć setnych to prawie tysiąc tak " +
                "jak minus tysiąc to prawie minus dziewięćset dziewięćdziesiąt dziewięć i dziewięćdziesiąt dziewięć setnych";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    /**
     * tests using mockito
     */
    @Test
    public void testMockRest()
    {
        IText iText = mock(IText.class);

        when(iText.transform("32.01")).thenReturn("trzydzieści dwa i jedna setna");

        NumbersToText text = new NumbersToText(iText);
        String result = text.transform("32.01");
        verify(iText).transform("32.01");

        assertEquals("trzydzieści dwa i jedna setna", result);
    }

    @Test
    public void testMockNegative()
    {
        IText iText = mock(IText.class);

        when(iText.transform("-0.03")).thenReturn("minus trzy setne");

        NumbersToText text = new NumbersToText(iText);
        String result = text.transform("-0.03");
        verify(iText).transform("-0.03");

        assertEquals("minus trzy setne", result);
    }

    @Test
    public void testMockMultipleTrans()
    {
        IText iText = mock(IText.class);

        when(iText.transform("janusz ma 32.03 zlotych na konica a halyna -3.99 euro")).thenReturn("janusz ma trzydzieście dwa i trzy setne zlote na konica a " +
                "halyna minus trzy i dziewięćdziesiąt dziewięć setnych euro");

        NumbersToText text = new NumbersToText(iText);
        String result = text.transform("janusz ma 32.03 zlotych na konica a halyna -3.99 euro");
        verify(iText).transform("janusz ma 32.03 zlotych na konica a halyna -3.99 euro");

        assertEquals("janusz ma trzydzieście dwa i trzy setne zlote na konica a " +
                "halyna minus trzy i dziewięćdziesiąt dziewięć setnych euro", result);
    }

    @Test
    public void testMockAboveBelowLimit()
    {
        IText iText = mock(IText.class);

        when(iText.transform("10000 w portfelu i -1324.345 na koncie")).thenReturn("10000 w portfelu i -1324.345 na koncie");

        NumbersToText text = new NumbersToText(iText);
        String result = text.transform("10000 w portfelu i -1324.345 na koncie");
        verify(iText).transform("10000 w portfelu i -1324.345 na koncie");

        assertEquals("10000 w portfelu i -1324.345 na koncie", result);
    }

}