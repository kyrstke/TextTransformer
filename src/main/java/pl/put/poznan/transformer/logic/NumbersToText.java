package pl.put.poznan.transformer.logic;

public class NumbersToText extends TextTransformer {
    public NumbersToText(IText transInterface) {
        super(transInterface);
    }
    @Override
    public String transform(String text){
        return numbersToText(text);
    }

    private String numbersToText(String text)
    {
        return text;
    }
}
