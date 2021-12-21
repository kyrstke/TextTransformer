package pl.put.poznan.transformer.logic;

public class ReadNumbers extends TextTransformer {
    public ReadNumbers(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return readNumbers(super.transform());
    }

    private String readNumbers(String text)
    {
        return text;
    }
}
