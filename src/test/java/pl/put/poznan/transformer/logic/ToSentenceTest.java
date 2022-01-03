package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ToSentenceTest {
    private IText textTransformer;

    @BeforeEach
    public void setupTextTransformer()
    {
        textTransformer = new ToSentence(new InputString());
    }

    @Test
    public void testSentenceCase()
    {
        String text = "Czuję się zaskoczony, zmieszany i wstrząśnięty. Zupełnie nie jak ja. Aha";
        Assertions.assertEquals(text,textTransformer.transform(text));
    }
    @Test
    public void testLowerCase()
    {
        String text = "marley już nie żył. nie ulega to najmniejszej wątpliwości";
        String result = "Marley już nie żył. Nie ulega to najmniejszej wątpliwości";
        Assertions.assertEquals(result,textTransformer.transform(text));
    }

    @Test
    public void testUpperCase()
    {
        String text = "SKŁAMAŁBYM, RZECZĄC, ŻE SIĘ TEGO SPODZIEWAŁEM. ODCHODZĘ";
        String result = "Skłamałbym, rzecząc, że się tego spodziewałem. Odchodzę";
        Assertions.assertEquals(result,textTransformer.transform(text));
    }

    @Test
    public void testMixedCase()
    {
        String text = "WIDZąc to, obrÓCił sIę na PIĘCIe. YIKES - rZekŁ.";
        String result = "Widząc to, obrócił się na pięcie. Yikes - rzekł.";
        Assertions.assertEquals(result,textTransformer.transform(text));
    }

    @Test
    public void testMultipleSpaces()
    {
        String text = "mam już dość nie mów mi nic.    pozwól żyć";
        String result = "Mam już dość nie mów mi nic.    Pozwól żyć";
        Assertions.assertEquals(result,textTransformer.transform(text));
    }
}