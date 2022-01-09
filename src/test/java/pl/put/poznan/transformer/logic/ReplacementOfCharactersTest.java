package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ReplacementOfCharactersTest {
    private IText textTransformer;

    @BeforeEach
    public void setupTextTransformer()
    {
        textTransformer = new ReplacementOfCharacters(new InputString());
    }

    @Test
    public void testIn()
    {
        String text = "Wpłać 123 ";
        String result = "Wplac 123 ";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }
    @Test
    public void testOutside()
    {
        String text = "ł  Ą ć";
        String result = "l  A c";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }
    @Test
    public void testTogether()
    {
        String text = "łć 123 ŹŻę";
        String result = "lc 123 ZZe";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }
    @Test
    public void testNumbers()
    {
        String text = "9ć1 12ł Ś17";
        String result = "9c1 12l S17";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }
    @Test
    public void testMock1()
    {
        IText iText = mock(IText.class);

        when(iText.transform("kąt")).thenReturn("kat");

        ReplacementOfCharacters text = new ReplacementOfCharacters(iText);
        String result = text.transform("kąt");
        verify(iText).transform("kąt");

        assertEquals("kat", result);
    }

    @Test
    public void TestMock2() throws Exception {
        IText iText = mock(IText.class);
        when(iText.transform("Pada śnieg")).thenReturn("Pada śnieg");
        ReplacementOfCharacters text = new ReplacementOfCharacters(iText);
        String result = text.transform("Pada śnieg");
        verify(iText).transform("Pada śnieg");
        assertEquals("Pada snieg", result);
    }
}
