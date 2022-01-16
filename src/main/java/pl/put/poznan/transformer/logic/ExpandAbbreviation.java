package pl.put.poznan.transformer.logic;

/**
 * Class to expand abbreviations.
 */
public class ExpandAbbreviation extends TextTransformer{
    Abbreviations abbreviations;

    /**
     * Constructor of text transformation class.
     * @param transInterface text to decorate
     */
    public ExpandAbbreviation (IText transInterface) {
        super(transInterface);
    }

    /**
     * Method performing the transformation
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text){

        return expandAbbreviation(this.transInterface.transform(text));
    }

    /**
     * Method to expand abbreviations
     * @param text given string by user
     * @return text after transformation
     */
    private String expandAbbreviation(String text)
    {
        return text;
    }
}
