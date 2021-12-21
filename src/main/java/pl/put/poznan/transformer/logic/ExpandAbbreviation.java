package pl.put.poznan.transformer.logic;

public class ExpandAbbreviation extends TextTransformer{
    Abbreviations abbreviations;
    public ExpandAbbreviation (IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return expandAbbreviation(super.transform());
    }

    private String expandAbbreviation(String text)
    {
        return text;
    }
}
