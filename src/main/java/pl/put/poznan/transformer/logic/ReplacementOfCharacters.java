package pl.put.poznan.transformer.logic;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Class changing Polish characters to Latin characters
 *
 * @author Anastasiia Trubchaninova
 * @version 1.0
 */
public class ReplacementOfCharacters extends TextTransformer{
    /**
     * Constructor of text transformation class.
     *
     * @param transInterface text to decorate
     */
    public ReplacementOfCharacters(IText transInterface) {
        super(transInterface);
    }
    /**
     * Method performing the transformation
     *
     * @return text after transformation
     */

    @Override
    public String transform(String text){
        return replacementOfCharacters(this.transInterface.transform(text));
    }
    /**
     * Method changing Polish characters to Latin characters
     *
     * @param text given string by user
     * @return text after transformation
     */


    private String replacementOfCharacters(String text)
    {

        char [] badPhrases = {'ł','Ł','ą','Ą','ć','Ć','ę','ń','ó','ś','ż','ź','Ę','Ń','Ó','Ś','Ż','Ź'};
        char[] goodPhrases = {'l','L','a','A','c','C','e','n','o','s','z','z','E','N','O','S','Z','Z'};
        char[] result = new char[text.length()];
        String badPhrasesString = String.valueOf(badPhrases);
        for(int i=0;i < text.length(); i++)
        {

            int x = badPhrasesString.indexOf(text.charAt(i));

            {
                if(x==-1)
                {
                    result[i]=text.charAt(i);
                }
                else
                    result[i]=goodPhrases[x];
            }
        }
        return String.valueOf(result);
    }
    }



