package pl.put.poznan.transformer.logic;

public class ToAbbreviation extends TextTransformer{
    Abbreviations abbreviations;
    public ToAbbreviation(IText transInterface) {
        super(transInterface);
    }
    @Override
    public String transform(String text){
        return toAbbreviation(this.transInterface.transform(text));
    }

    private String toAbbreviation(String text)
    {
        return text;
    }
}
