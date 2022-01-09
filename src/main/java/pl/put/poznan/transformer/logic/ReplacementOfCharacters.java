package pl.put.poznan.transformer.logic;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * Klas changes Polish characters to Latin characters
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
        return ReplacementOfCharacters(this.transInterface.transform(text));
    }
    /**
     * Method changes Polish characters to Latin characters
     *
     * @param text given string by user
     * @return text after transformation
     */


    private String ReplacementOfCharacters(String text)
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

//        *\final String tab00c0 = "AAAAAAACEEEEIIII" +
//                "DNOOOOO\u00d7\u00d8UUUUYI\u00df" +
//                "aaaaaaaceeeeiiii" +
//                "\u00f0nooooo\u00f7\u00f8uuuuy\u00fey" +
//                "AaAaAaCcCcCcCcDd" +
//                "DdEeEeEeEeEeGgGg" +
//                "GgGgHhHhIiIiIiIi" +
//                "IiJjJjKkkLlLlLlL" +
//                "lLlNnNnNnnNnOoOo" +
//                "OoOoRrRrRrSsSsSs" +
//                "SsTtTtTtUuUuUuUu" +
//                "UuUuWwYyYZzZzZzF";
//        char[] vysl = new char[text.length()];
//        char one;
//        for (int i = 0; i < text.length(); i++) {
//            one = text.charAt(i);
//            if (one >= '\u00c0' && one <= '\u017f') {
//                one = tab00c0.charAt((int) one - '\u00c0');
//            }
//            vysl[i] = one;
//        }
//        return new String(vysl);*\


        return String.valueOf(result);
    }
    }



