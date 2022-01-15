package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ExpandAbbreviationTest {
    private IText textTransformer;

    @BeforeEach
    public void setupTextTransformer()
    {
        textTransformer = new ExpandAbbreviation(new InputString());
    }

    @Test
    public void testBasic()
    {
        String text = "Każdy dr był kiedyś magistrem.";
        String result = "Każdy doktor był kiedyś magistrem.";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testCapitals()
    {
        String text = "Każdy Dr był kiedyś magistrem.";
        String result = "Każdy Doktor był kiedyś magistrem.";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testWithCommasAndDots()
    {
        String text = "Mgr, np. Filip to nie DR.";
        String result = "Magister, na przykład Filip to nie Doktor.";

        Assertions.assertEquals(result,  textTransformer.transform(text));
    }

    @Test
    public void testHarderPhrase()
    {
        String text = "Nr telefonu Dra to 997 420 itd., np. 111";
        String result = "Numer telefonu Dra to 997 420 i tak dalej, na przykład 111";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testSame()
    {
        String text = "Dzień dobry, poproszę drugiego pomidora";

        Assertions.assertEquals(text, textTransformer.transform(text));
    }


    @Test
    public void testAll()
    {
        String text = "prof. dr np. Itd. itp. Nr mgr";
        String result = "profesor doktor na przykład I tak dalej i tym podobne Numer magister";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }
//
//
//    /**
//     * tests using mockito
//     */
//    @Test
//    public void testMockRest()
//    {
//        IText iText = mock(IText.class);
//
//        when(iText.transform("32.01")).thenReturn("trzydzieści dwa i jedna setna");
//
//        NumbersToText text = new NumbersToText(iText);
//        String result = text.transform("32.01");
//        verify(iText).transform("32.01");
//
//        assertEquals("trzydzieści dwa i jedna setna", result);
//    }
//
//    @Test
//    public void testMockNegative()
//    {
//        IText iText = mock(IText.class);
//
//        when(iText.transform("-0.03")).thenReturn("minus trzy setne");
//
//        NumbersToText text = new NumbersToText(iText);
//        String result = text.transform("-0.03");
//        verify(iText).transform("-0.03");
//
//        assertEquals("minus trzy setne", result);
//    }
//
//    @Test
//    public void testMockMultipleTrans()
//    {
//        IText iText = mock(IText.class);
//
//        when(iText.transform("janusz ma 32.03 zlotych na konica a halyna -3.99 euro")).thenReturn("janusz ma trzydzieście dwa i trzy setne zlote na konica a " +
//                "halyna minus trzy i dziewięćdziesiąt dziewięć setnych euro");
//
//        NumbersToText text = new NumbersToText(iText);
//        String result = text.transform("janusz ma 32.03 zlotych na konica a halyna -3.99 euro");
//        verify(iText).transform("janusz ma 32.03 zlotych na konica a halyna -3.99 euro");
//
//        assertEquals("janusz ma trzydzieście dwa i trzy setne zlote na konica a " +
//                "halyna minus trzy i dziewięćdziesiąt dziewięć setnych euro", result);
//    }
//
//    @Test
//    public void testMockAboveBelowLimit()
//    {
//        IText iText = mock(IText.class);
//
//        when(iText.transform("10000 w portfelu i -1324.345 na koncie")).thenReturn("10000 w portfelu i -1324.345 na koncie");
//
//        NumbersToText text = new NumbersToText(iText);
//        String result = text.transform("10000 w portfelu i -1324.345 na koncie");
//        verify(iText).transform("10000 w portfelu i -1324.345 na koncie");
//
//        assertEquals("10000 w portfelu i -1324.345 na koncie", result);
//    }
}