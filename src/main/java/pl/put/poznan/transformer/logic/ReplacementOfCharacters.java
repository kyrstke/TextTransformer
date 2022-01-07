package pl.put.poznan.transformer.logic;

public class ReplacementOfCharacters extends TextTransformer{

    public ReplacementOfCharacters(IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text){
        return ReplacementOfCharacters(this.transInterface.transform(text));
    }

    private String ReplacementOfCharacters(String text)
    {
        String[] badPhrases = {"ł","Ł","ą","Ą","ć","Ć","ę","ń","ó","ś","ż","ź","Ę","Ń","Ó","Ś","Ż","Ź"};
        String[] goodPhrases = {"l","L","a","A","c","C","e","n","o","s","z","z","E","N","O","S","Z","Z"};
        for(int i=0;i < goodPhrases.length; i++)
        {
            int x = text.indexOf(badPhrases[i]);
            if(x > -1)
            {
                if(x!=0)
                {
                    text = text.substring(0,x) + goodPhrases[i] + text.substring(x+goodPhrases[i].length(), text.length());
                }
                else
                    text = goodPhrases[i] + text.substring(goodPhrases[i].length(), text.length());
            }
        }
        return text;
    }


}
