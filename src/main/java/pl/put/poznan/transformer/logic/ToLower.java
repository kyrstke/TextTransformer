package pl.put.poznan.transformer.logic;

public class ToLower extends TextTransformer{

    public ToLower(IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text){
        return toLower(this.transInterface.transform(text));
    }

    private String toLower(String text)
    {
        return text.toLowerCase();
    }
}
