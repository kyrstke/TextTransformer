package pl.put.poznan.transformer.logic;


public class Reverse extends TextTransformer{

    public Reverse(IText transInterface) {
        super(transInterface);
    }
    @Override
    public String transform(String text){
        return reverse(this.transInterface.transform(text));
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

