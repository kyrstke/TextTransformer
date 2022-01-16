package pl.put.poznan.transformer.logic;

import java.util.Locale;

/**
 * Тhis class makes addressing more polite
 */
public class PolitePhrases extends TextTransformer{
    /**
     *
     * @param transInterface text to decorate
     */
    public PolitePhrases(IText transInterface) {
        super(transInterface);
    }

    /**
     *Constructor of text transformation class.
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text){
        return politePhrases(this.transInterface.transform(text));
    }

    /**
     *Method performing the transformation
     * @param text given string by user
     * @return text after transformation
     */
    private String politePhrases(String text)
    {
        String[] badPhrases = {"ty","ciebie","tobie","tobą"};
        String[] goodPhrases = {"Ty","Ciebie","Tobie","Tobą"};
        for(int i=0;i < goodPhrases.length; i++)
        {
            while(text.contains(badPhrases[i]))
            {
                int x = text.indexOf(badPhrases[i]);
                if(x!=0)
                {
                    text = text.substring(0,x) + goodPhrases[i] + text.substring(x+goodPhrases[i].length());
                }
                else
                    text = goodPhrases[i] + text.substring(goodPhrases[i].length());
            }
        }
        return text;
    }
}
