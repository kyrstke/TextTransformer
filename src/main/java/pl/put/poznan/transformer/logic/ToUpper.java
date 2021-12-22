package pl.put.poznan.transformer.logic;
/**
 * Class changing all the characters to UPPERCASE
 *
 * @author Jan Kabzinski
 * @version 1.0
 */
public class ToUpper extends TextTransformer{
     /**
     * Constructor of text transformation class.
     *
     * @param textInput text to decorate
     */
    public ToUpper(IText transInterface) {
        super(transInterface);
    }
    /**
     * Method performing the transformation
     *
     * @return text after transformation
     */
    @Override
    public String transform(String text){
        return toUpper(text);
    }
    /**
     * Method converting given text to UPPERCASE
     *
     * @param text given string by user
     * @return text after transformation
     */
    private String toUpper(String text)
    {
        return text.toUpperCase();
    }
}
