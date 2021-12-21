package pl.put.poznan.transformer.logic;

public class ToLower extends TextTransformer{

    public ToLower(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return toLower(super.transform());
    }

    private String toLower(String text)
    {
        return text.toLowerCase();
    }
}
