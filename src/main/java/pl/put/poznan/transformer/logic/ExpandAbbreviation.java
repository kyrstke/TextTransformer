package pl.put.poznan.transformer.logic;

import java.lang.Character;
import java.util.HashSet;
import java.util.Set;

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
        String[] expansionsWithDots = {"np.", "itd.", "itp."};
        Set<String> abbreviationsWithDots = new HashSet<String>();
        abbreviationsWithDots.add("prof.");
        abbreviationsWithDots.add("np.");
        abbreviationsWithDots.add("itd.");
        abbreviationsWithDots.add("itp.");
        String[] words = text.split(" ");
        StringBuilder newText = new StringBuilder();
        boolean comma = false;
        boolean dot = false;


        for(int i = 0; i < words.length; i++) {
            if (words[i].endsWith(",")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
                comma = true;
            }
            else if (words[i].endsWith(".") && !abbreviationsWithDots.contains(words[i].toLowerCase())) {
                words[i] = words[i].substring(0, words[i].length() - 1);
                dot = true;
            }
            for (int j = 0; j < abbreviations.length; j++) {
                if (words[i].toLowerCase().equals(abbreviations[j])) { //TODO add variable to store lower word
                    if (Character.isUpperCase(words[i].charAt(0))) {
                        words[i] = expansions[j].substring(0, 1).toUpperCase() + expansions[j].substring(1);
                    } else {
                        words[i] = expansions[j];
                    }
                    break;
                }
            }
            if (comma) {
                if (i == 0 || words[i].equals("")) newText.append(words[i]).append(",");
                else newText.append(" ").append(words[i]).append(",");
            } else if (dot) {
                if (i == 0 || words[i].equals("")) newText.append(words[i]).append(".");
                else newText.append(" ").append(words[i]).append(".");
            } else {
                if (i == 0 || words[i].equals("")) newText.append(words[i]);
                else newText.append(" ").append(words[i]);
            }
            comma = false;
            dot = false;
        }
        return newText.toString();
    }
}
