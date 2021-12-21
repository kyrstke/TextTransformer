package pl.put.poznan.transformer.logic;

public class NumbersToText extends TextTransformer {
    public NumbersToText(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return numbersToText(super.transform());
    }

    private String numbersToText(String text)
    {
        return text;
    }
}
