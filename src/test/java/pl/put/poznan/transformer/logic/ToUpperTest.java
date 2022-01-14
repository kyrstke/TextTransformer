package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ToUpperTest {

    @Test
    public void testMockLower()
    {
        IText iText = mock(IText.class);

        when(iText.transform("poddaje sie, ale nie zawsze")).thenReturn("PODDAJE SIE, ALE NIE ZAWSZE");

        ToUpper text = new ToUpper(iText);
        String result = text.transform("poddaje sie, ale nie zawsze");
        verify(iText).transform("poddaje sie, ale nie zawsze");

        assertEquals("PODDAJE SIE, ALE NIE ZAWSZE", result);
    }

    @Test
    public void testMockSpecialSigns()
    {
        IText iText = mock(IText.class);

        when(iText.transform("@#$%^&*(*&^^&*((*&&*/*-+")).thenReturn("@#$%^&*(*&^^&*((*&&*/*-+");

        ToUpper text = new ToUpper(iText);
        String result = text.transform("@#$%^&*(*&^^&*((*&&*/*-+");
        verify(iText).transform("@#$%^&*(*&^^&*((*&&*/*-+");

        assertEquals("@#$%^&*(*&^^&*((*&&*/*-+", result);
    }

    @Test
    public void testMockPolishSigns()
    {
        IText iText = mock(IText.class);

        when(iText.transform("ciężkie przęsło, PRZEŁĘCZ")).thenReturn("CIĘŻKIE PRZĘSŁO, PRZEŁĘCZ");

        ToUpper text = new ToUpper(iText);
        String result = text.transform("ciężkie przęsło, PRZEŁĘCZ");
        verify(iText).transform("ciężkie przęsło, PRZEŁĘCZ");

        assertEquals("CIĘŻKIE PRZĘSŁO, PRZEŁĘCZ", result);
    }
}