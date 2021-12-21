package pl.put.poznan.transformer.logic;
import org.apache.commons.lang.WordUtils;

public class Capitalize extends TextTransformer{

    public Capitalize(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return capitalize(super.transform());
    }

    private String capitalize(String text)
    {
        return WordUtils.capitalizeFully(text);
    }

}
