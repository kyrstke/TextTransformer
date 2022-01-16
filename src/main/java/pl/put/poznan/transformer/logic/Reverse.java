package pl.put.poznan.transformer.logic;

/**
 * This class outputs characters in reverse order
 *
 * @author Jan Kabzinski
 * @version 1.0
 */

public class Reverse extends TextTransformer{
    /**
     * Constructor of text transformation class.
     * @param transInterface  text to decorate
     */
    public Reverse(IText transInterface) {
        super(transInterface);
    }

    /**
     * Method performing the transformation
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text){
        return reverse(this.transInterface.transform(text));
    }

    /**
     * This method outputs characters in reverse order
     * @param text given string by user
     * @return text after transformation
     */
    private String reverse(String text)
    {
        String lowered = text.toLowerCase();
        String out="";
        char ch;
        for (int i = 0; i < text.length(); i++)
        {
            ch = lowered.charAt(i);
            if(Character.isUpperCase(text.charAt(text.length()-1-i)))
            {
                ch = Character.toUpperCase(ch);
            }
            out= ch+out;
        }
        return out;

    }
}

