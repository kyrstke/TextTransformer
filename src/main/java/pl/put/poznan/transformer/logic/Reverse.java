package pl.put.poznan.transformer.logic;


import java.util.Locale;

public class Reverse extends TextTransformer{

    public Reverse(IText textInput) {
        super(textInput);
    }
    @Override
    public String transform(){
        return reverse(super.transform());
    }

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
//    String[] dividedText = text.split(" ");
//    String[] inverted = new String[dividedText.length];
//
//        for (int j = 0; j < dividedText.length; j++) {
//        String[] word = dividedText[j].split("");
//        String[] result = new String[word.length];
//
//        for (int i = 0; i < word.length; i++) {
//            if (Character.isUpperCase(word[i].charAt(0)))
//                result[i] = upper(word[word.length - 1 - i]);
//            else
//                result[i] = lower(word[word.length - 1 - i]);
//        };
//
//        inverted[j] = String.join("", result);
//    }
//
//        return String.join(" ", inverted);
}

