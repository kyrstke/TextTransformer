package pl.put.poznan.transformer.logic;

public class ToUpper extends TextTransformer{

    public ToUpper(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return super.transform().toUpperCase();
    }
}
