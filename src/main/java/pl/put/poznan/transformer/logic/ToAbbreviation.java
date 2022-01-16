package pl.put.poznan.transformer.logic;

/**
 * This class makes Abbreviation
 */
public class ToAbbreviation extends TextTransformer{
    Abbreviations abbreviations;

    /**
     * Constructor of text transformation class.
     * @param transInterface text to decorate
     */
    public ToAbbreviation(IText transInterface) {
        super(transInterface);
    }

    /**
     * Method performing the transformation
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text){
        return toAbbreviation(this.transInterface.transform(text));
    }

    /**
     * This method makes Abbreviation
     * @param text given string by user
     * @return text after transformation
     */
    private String toAbbreviation(String text)
    {
        return text;
    }
}
