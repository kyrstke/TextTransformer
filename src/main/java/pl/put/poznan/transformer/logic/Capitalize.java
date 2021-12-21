package pl.put.poznan.transformer.logic;

public class Capitalize extends TextTransformer{

    public Capitalize(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return Capitalize(super.transform());
    }

    private String Capitalize(String text)
    {
        /*if(text.length() > 0) {
            text[0] =;
            for (int i = 1; i < text.length(); i++)
        }*/
        return text;
    }

}
