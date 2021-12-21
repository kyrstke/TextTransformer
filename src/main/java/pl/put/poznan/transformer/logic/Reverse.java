package pl.put.poznan.transformer.logic;


public class Reverse extends TextTransformer{

    public Reverse(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return reverse(super.transform());
    }

    private String reverse(String text)
    {
        return text;
    }
}

