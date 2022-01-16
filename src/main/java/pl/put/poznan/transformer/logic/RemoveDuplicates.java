package pl.put.poznan.transformer.logic;

/**
 * Тhis class removes duplicates
 */
public class RemoveDuplicates extends TextTransformer{
    /**
     *Constructor of text transformation class
     * @param textInput text to decorate
     */
    public RemoveDuplicates (IText textInput) {
        super(textInput);
    }

    /**
     *Method performing the transformation
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text){
        return removeDuplicates(this.transInterface.transform(text));
    }

    /**
     *Тhis method removes duplicates
     * @param text given string by user
     * @return text after transformation
     */
    private String removeDuplicates(String text)
    {
        return text;
    }
}
