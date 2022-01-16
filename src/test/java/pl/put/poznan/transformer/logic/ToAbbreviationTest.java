package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class ToAbbreviationTest {

    private IText textTransformer;

    @BeforeEach
    public void setupTextTransformer()
    {
        textTransformer = new ToAbbreviation(new InputString());
    }

    @Test
    public void testBasic()
    {
        String text = "Każdy doktor był kiedyś magistrem.";
        String result = "Każdy dr był kiedyś magistrem.";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testCapitals()
    {
        String text = "Każdy Doktor był kiedyś magistrem.";
        String result = "Każdy Dr był kiedyś magistrem.";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testWithCommasAndDots()
    {
        String text = "Magister, na przykład Filip to nie DOKTOR.";
        String result = "Mgr, np. Filip to nie Dr.";

        Assertions.assertEquals(result,  textTransformer.transform(text));
    }

    @Test
    public void testHarderPhrase()
    {
        String text = "Numer telefonu Doktora to 997 420 i tak dalej, na przykład 111";
        String result = "Nr telefonu Doktora to 997 420 itd., np. 111";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testSame()
    {
        String text = "Dzień dobry, poproszę 2 pomidory";

        Assertions.assertEquals(text, textTransformer.transform(text));
    }

    @Test
    public void testFakeFriends()
    {
        String text = "Doktorek to nie doktor, skończył magisterkę.";
        String result = "Doktorek to nie dr, skończył magisterkę.";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void testAll()
    {
        String text = "profesor doktor na Przykład I tak dalej i tym podobne Numer magister";
        String result = "prof. dr np. Itd. itp. Nr mgr";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }


    /**
     * tests using mockito
     */
    @Test
    public void testMockBasic()
    {
        IText iText = mock(IText.class);

        when(iText.transform("magister Doktor, na przykład, dwa")).thenReturn("mgr Dr, np., dwa");

        ToAbbreviation text = new ToAbbreviation(iText);
        String result = text.transform("magister Doktor, na przykład, dwa");
        verify(iText).transform("magister Doktor, na przykład, dwa");

        assertEquals("mgr Dr, np., dwa", result);
    }

    @Test
    public void testMockHarder()
    {
        IText iText = mock(IText.class);

        when(iText.transform("Pamiętaj, aby do garnka dodać na przykład brokuł, marchewkę, i tym podobne.")).thenReturn("Pamiętaj, aby do garnka dodać na przykład brokuł, marchewkę, i tym podobne.");

        ToAbbreviation text = new ToAbbreviation(iText);
        String result = text.transform("Pamiętaj, aby do garnka dodać na przykład brokuł, marchewkę, i tym podobne.");
        verify(iText).transform("Pamiętaj, aby do garnka dodać na przykład brokuł, marchewkę, i tym podobne.");

        assertEquals("Pamiętaj, aby do garnka dodać np. brokuł, marchewkę, itp..", result);
    }

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