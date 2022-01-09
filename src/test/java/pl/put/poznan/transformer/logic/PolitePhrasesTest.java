package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PolitePhrasesTest {

    private IText textTransformer;

    @BeforeEach
    public void setupTextTransformer()
    {
        textTransformer = new PolitePhrases(new InputString());
    }

    @Test
    public void testCorrectText()
    {
        String text = "Ty, Tobą i w ogóle";
        Assertions.assertEquals(text,textTransformer.transform(text));
    }

    @Test
    public void testLowerCase()
    {
        String text = "ciebie w tobie to raczej mało jest";
        String result = "Ciebie w Tobie to raczej mało jest";
        Assertions.assertEquals(result,textTransformer.transform(text));
    }

    @Test
    public void testUpperCase()
    {
        String text = "CIEBIE CHYBA TO WYWRÓCIŁO";
        Assertions.assertEquals(text, textTransformer.transform(text));
    }
    @Test
    public void testMixedCase()
    {
        String text = "TY, PoKEMOnowa czcioNkA dLa cIEBie, chyba";
        Assertions.assertEquals(text, textTransformer.transform(text));
    }

}