package pl.put.poznan.transformer.logic;

import java.lang.Character;

public class ExpandAbbreviation extends TextTransformer{

    public ExpandAbbreviation (IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text){

        return expandAbbreviation(this.transInterface.transform(text));
    }

    private String expandAbbreviation(String text)
    {
        String[] abbreviations = {"prof.", "dr", "np.", "itd.", "itp.", "nr", "mgr"};
        String[] expansions = {"profesor", "doktor", "na przykład", "i tak dalej", "i tym podobne", "numer", "magister"};
        String[] words = text.split(" ");
        StringBuilder newText = new StringBuilder();


        for(int i = 0; i < abbreviations.length; i++)
        {
            for(int j = 0; j < words.length; j++){
                if(words[j].toLowerCase().equals(abbreviations[i])){
                    if(Character.isUpperCase(words[j].charAt(0))){
                        words[j] = expansions[i].substring(0, 1).toUpperCase() + expansions[i].substring(1);
                    }
                    else{
                        words[j] = expansions[i];
                    }

                }
            }
        }

        for(int j = 0; j < words.length; j++) {
            if (j == 0) newText.append(words[j]);
            else newText.append(" ").append(words[j]);
        }

        return newText.toString();
    }
}
