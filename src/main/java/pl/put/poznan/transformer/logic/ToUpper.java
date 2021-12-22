package pl.put.poznan.transformer.logic;

/**
 * Class changing all the characters to CAPITALS
 *
 * @author Jan Kabzinski
 * @version 1.0
 */
public class ToUpper extends TextTransformer {

    /**
     * Constructor of text transformation class.
     *
     * @param textInput text to decorate
     */
    public ToUpper(IText textInput) {
        super(textInput);
    }

    /**
     * Function performing the transformation
     *
     * @return text after transformation
     */
    @Override
    public String transform() {
        return toUpper(super.transform());
    }

    /**
     * Function converting given text to UPPER text.
     *
     * @param text given string by user
     * @return text after transformation
     */
    private String toUpper(String text) {
        return text.toUpperCase();
    }
}
