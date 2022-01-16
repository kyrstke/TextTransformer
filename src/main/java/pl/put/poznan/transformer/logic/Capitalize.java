package pl.put.poznan.transformer.logic;
import org.apache.commons.lang.WordUtils;

/**
 *Сlass capitalize the first word in a sentence
 */
public class Capitalize extends TextTransformer{
    /**
     *Constructor of text transformation class.
     *@param transInterface text to decorate
     */
    public Capitalize(IText transInterface) {
        super(transInterface);
    }

    /**
     * Method performing the transformation
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text){
        return capitalize(this.transInterface.transform(text));
    }

    /**
     * Method capitalize the first word in a sentence
     * @param text given string by user
     * @return text after transformation
     */
    private String capitalize(String text)
    {
        return WordUtils.capitalizeFully(text);
    }

}
