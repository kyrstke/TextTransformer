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
}

