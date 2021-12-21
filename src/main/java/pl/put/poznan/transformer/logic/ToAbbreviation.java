package pl.put.poznan.transformer.logic;

public class ToAbbreviation extends TextTransformer{
    Abbreviations abbreviations;
    public ToAbbreviation(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return toAbbreviation(super.transform());
    }

    private String toAbbreviation(String text)
    {
        return text;
    }
}
