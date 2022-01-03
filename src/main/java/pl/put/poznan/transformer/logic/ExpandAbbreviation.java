package pl.put.poznan.transformer.logic;

public class ExpandAbbreviation extends TextTransformer{
    Abbreviations abbreviations;
    public ExpandAbbreviation (IText transInterface) {
        super(transInterface);
    }
    @Override
    public String transform(String text){

        return expandAbbreviation(this.transInterface.transform(text));
    }

    private String expandAbbreviation(String text)
    {
        return text;
    }
}
