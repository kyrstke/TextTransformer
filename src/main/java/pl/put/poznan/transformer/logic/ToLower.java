package pl.put.poznan.transformer.logic;

/**
 *Class changing all the characters to LOWERCASE
 */
public class ToLower extends TextTransformer{
    /**
     *Constructor of text transformation class.
     * @param transInterface text to decorate
     */

    public ToLower(IText transInterface) {
        super(transInterface);
    }

    /**
     *Constructor of text transformation class.
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text){
        return toLower(this.transInterface.transform(text));
    }

    /**
     * The method changes all the characters to LOWERCASE
     * @param text given string by user
     * @return text after transformation
     */
    private String toLower(String text)
    {
        return text.toLowerCase();
    }
}
