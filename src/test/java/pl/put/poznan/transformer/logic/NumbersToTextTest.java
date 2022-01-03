package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumbersToTextTest {
    private IText textTransformer;

    @BeforeEach
    public void setupTextTransformer()
    {
        textTransformer = new NumbersToText(new InputString());
    }

    @Test
    public void returnTextRepresentation()
    {
        String text = "Wpłać 123 złoty";
        String result = "Wpłać sto dwadzieścia trzy złoty";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void returnSame()
    {
        String text = "Kara za kopalnie w Turowie wynosi 10000000 euro i tyle";

        Assertions.assertEquals(text,  textTransformer.transform(text));
    }

    @Test
    public void returnWithRest()
    {
        String text = "Pokemon go kosztuje 12.03 złoty za dzień";
        String result = "Pokemon go kosztuje dwanaście i trzy setne złoty za dzień";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void returnZero()
    {
        String text = "zero to 0 a 0 to zero";
        String result = "zero to zero a zero to zero";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void returnMultipleNumInText()
    {
        String text = "8.12 + 4.03 = 12.15";
        String result = "osiem i dwanaście setnych + cztery i trzy setne = dwanaście i piętnaście setnych";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void returnNegativeNumInText()
    {
        String text = "-0.3 jest jak -0.03 ale nie do końca";
        String result ="minus trzy dziesiąte jest jak minus trzy setne ale nie do końca";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }

    @Test
    public void returnLongNumbers()
    {
        String text = "999.99 to prawie 1000 tak jak -1000 to prawie -999.99";
        String result = "dziewięćset dziewięćdziesiąt dziewięć i dziewięćdziesiąt dziewięć setnych to prawie tysiąc tak " +
                "jak minus tysiąc to prawie minus dziewięćset dziewięćdziesiąt dziewięć i dziewięćdziesiąt dziewięć setnych";

        Assertions.assertEquals(result, textTransformer.transform(text));
    }
}