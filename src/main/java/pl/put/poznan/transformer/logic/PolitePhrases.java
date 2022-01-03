package pl.put.poznan.transformer.logic;

import java.util.Locale;

public class PolitePhrases extends TextTransformer{

    public PolitePhrases(IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text){
        return politePhrases(this.transInterface.transform(text));
    }


    private String politePhrases(String text)
    {
        String[] badPhrases = {"ty","ciebie","tobie","tobą"};
        String[] goodPhrases = {"Ty","Ciebie","Tobie","Tobą"};
        for(int i=0;i < goodPhrases.length; i++)
        {
            int x = text.indexOf(badPhrases[i]);
            if(x > -1)
            {
                if(x!=0)
                text = text.substring(0,x-1) + goodPhrases[i] + text.substring(x+goodPhrases[i].length(), text.length()-1);
                else
                    text = goodPhrases[i] + text.substring(goodPhrases[i].length(), text.length()-1);
            }
        }
        return text;
    }
}
