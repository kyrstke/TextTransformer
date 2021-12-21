package pl.put.poznan.transformer.logic;

public class RemoveDuplicates extends TextTransformer{
    public RemoveDuplicates (IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return removeDuplicates(super.transform());
    }

    private String removeDuplicates(String text)
    {
        return text;
    }
}
