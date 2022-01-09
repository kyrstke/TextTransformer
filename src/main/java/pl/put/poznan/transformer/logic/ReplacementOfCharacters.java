package pl.put.poznan.transformer.logic;
import java.text.Normalizer;

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
        String[] result = new String[text.length()];
        char[] splittedText =  text.toCharArray();
        for(int i=0;i < goodPhrases.length; i++)
        {
////if ploska index
//            if(badPhrases.toString().indexOf(text.charAt(i)) != -1){
//                result[i] = String.valueOf(splittedText[i]);
//            }else{
//
//                int indexOfGood = badPhrases.toString().indexOf(text.charAt(i));
//                result[i] = String.valueOf(goodPhrases[indexOfGood]);
//            }
            int x = text.indexOf(badPhrases[i]);
            if(x > -1)
            {
                if(x!=0)
                {
                    text = text.substring(0,x) + goodPhrases[i] + text.substring(x+goodPhrases[i].length());
                }
                else
                    text = goodPhrases[i] + text.substring(goodPhrases[i].length());
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


        return text;
    }
    }



