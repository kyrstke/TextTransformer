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


    /**
     * tests using mockito
     */
    @Test
    public void testMockBasic()
    {
        IText iText = mock(IText.class);

        when(iText.transform("Testy można przeprowadzić np. za pomocą Mocków.")).thenReturn("Testy można przeprowadzić na przykład za pomocą Mocków.");

        ExpandAbbreviation text = new ExpandAbbreviation(iText);
        String result = text.transform("Testy można przeprowadzić np. za pomocą Mocków.");
        verify(iText).transform("Testy można przeprowadzić np. za pomocą Mocków.");

        assertEquals("Testy można przeprowadzić na przykład za pomocą Mocków.", result);
    }

    @Test
    public void testMockHarder()
    {
        IText iText = mock(IText.class);

        when(iText.transform("Lubię warzywa, np. ziemniaki, brokuły, itp., a najbardziej marchewki.")).thenReturn("Lubię warzywa, na przykład ziemniaki, brokuły, i tym podobne, a najbardziej marchewki.");

        ExpandAbbreviation text = new ExpandAbbreviation(iText);
        String result = text.transform("Lubię warzywa, np. ziemniaki, brokuły, itp., a najbardziej marchewki.");
        verify(iText).transform("Lubię warzywa, np. ziemniaki, brokuły, itp., a najbardziej marchewki.");

        assertEquals("Lubię warzywa, na przykład ziemniaki, brokuły, i tym podobne, a najbardziej marchewki.", result);
    }
}