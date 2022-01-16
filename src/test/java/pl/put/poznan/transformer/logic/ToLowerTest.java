package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ToLowerTest {
    @Test
    public void testMockUpper()
    {
        IText iText = mock(IText.class);

        when(iText.transform("PODDAJE SIE, ALE NIE ZAWSZE")).thenReturn("poddaje sie, ale nie zawsze");

        ToLower text = new ToLower(iText);
        String result = text.transform("PODDAJE SIE, ALE NIE ZAWSZE");
        verify(iText).transform("PODDAJE SIE, ALE NIE ZAWSZE");

        assertEquals("poddaje sie, ale nie zawsze", result);
    }

    @Test
    public void testMockLowerWithPolish()
    {
        IText iText = mock(IText.class);

        when(iText.transform("leżałem na oddziale ratunkowym po czołówce z ciężarówką")).thenReturn("leżałem na oddziale ratunkowym po czołówce z ciężarówką");

        ToLower text = new ToLower(iText);
        String result = text.transform("leżałem na oddziale ratunkowym po czołówce z ciężarówką");
        verify(iText).transform("leżałem na oddziale ratunkowym po czołówce z ciężarówką");

        assertEquals("leżałem na oddziale ratunkowym po czołówce z ciężarówką", result);
    }
}