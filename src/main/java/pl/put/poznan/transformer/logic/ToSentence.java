package pl.put.poznan.transformer.logic;

public class ToSentence extends TextTransformer{

    public ToSentence(IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text){
        return toSentence(this.transInterface.transform(text));
    }

    private String toSentence(String text)
    {
        String answer = "";
        boolean istnienia = true;
        for (int i = 0; i < text.length();i++)
        {
            if(istnienia){
                answer += Character.toUpperCase(text.charAt(i));
            }
            else{
                answer += Character.toLowerCase(text.charAt(i));
            }

            if(text.charAt(i) != ' ') {
                istnienia = false;
            }

            if(text.charAt(i) == '.') {
                istnienia = true;
            }
        }
        return answer;
    }
}
