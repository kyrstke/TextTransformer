package pl.put.poznan.transformer.logic;

public class RemoveDuplicates extends TextTransformer{
    public RemoveDuplicates (IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(String text){
        return removeDuplicates(this.transInterface.transform(text));
    }

    private String removeDuplicates(String text)
    {
        return text;
    }
}
