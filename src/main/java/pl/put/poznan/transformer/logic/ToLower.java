package pl.put.poznan.transformer.logic;

public class ToLower extends TextTransformer{

    public ToLower(IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text){
        return toLower(text);
    }

    private String toLower(String text)
    {
        return text.toLowerCase();
    }
}
