package pl.put.poznan.transformer.logic;

public class ToUpper extends TextTransformer{

    public ToUpper(IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text){
        return toUpper(text);
    }

    private String toUpper(String text)
    {
        return text.toUpperCase();
    }
}
