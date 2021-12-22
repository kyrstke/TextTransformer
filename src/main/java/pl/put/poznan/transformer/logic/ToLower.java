package pl.put.poznan.transformer.logic;

/**
 * Class changing all the characters to lowercase
 *
 * @author Jan Kabzinski
 * @version 1.0
 */
public class ToLower extends TextTransformer{

    /**
     * Constructor of text transformation class.
     *
     * @param textInput text to decorate
     */
    public ToLower(IText textInput) {
        super(textInput);
    }

    /**
     * Method performing the transformation
     *
     * @return text after transformation
     */
    @Override
    public String transform(){
        return toLower(super.transform());
    }

    /**
     * Method converting given text to lowercase
     *
     * @param text given string by user
     * @return text after transformation
     */
    private String toLower(String text)
    {
        return text.toLowerCase();
    }
}
