package pl.put.poznan.transformer.logic;

import java.lang.Character;

public class ToAbbreviation extends TextTransformer{

    public ToAbbreviation(IText transInterface) { super(transInterface); }

    @Override
    public String transform(String text){

        return toAbbreviation(this.transInterface.transform(text));
    }

    private String toAbbreviation(String text)
    {
        String[] expansions = {"profesor", "doktor", "na przykład", "i tak dalej", "i tym podobne", "numer", "magister"};
        String[] abbreviations = {"prof.", "dr", "np.", "itd.", "itp.", "nr", "mgr"};
        String[] words = text.split(" ");
        StringBuilder newText = new StringBuilder();


        for(int i = 0; i < expansions.length; i++)
        {
            for(int j = 0; j < words.length; j++){
                if(words[j].toLowerCase().equals(expansions[i])){
                    if(Character.isUpperCase(words[j].charAt(0))){
                        words[j] = abbreviations[i].substring(0, 1).toUpperCase() + abbreviations[i].substring(1);
                    }
                    else{
                        words[j] = abbreviations[i];
                    }

                }
                else if(words[j].toLowerCase().equals(expansions[3].substring(0, 1))){
                    if(words[j+1].toLowerCase().equals(expansions[3].substring(2, 5))){
                        if(words[j+2].toLowerCase().equals(expansions[3].substring(6))) {
                            if (Character.isUpperCase(words[j].charAt(0))) {
                                words[j] = abbreviations[3].substring(0, 1).toUpperCase() + abbreviations[3].substring(1);
                            } else {
                                words[j] = abbreviations[3];
                            }
                            words[j+1] = "";
                            words[j+2] = "";
                            j+=2;
                        }
                    }
                    else if(words[j+1].toLowerCase().equals(expansions[4].substring(2, 5))){
                        if(words[j+2].toLowerCase().equals(expansions[4].substring(6))) {
                            if (Character.isUpperCase(words[j].charAt(0))) {
                                words[j] = abbreviations[4].substring(0, 1).toUpperCase() + abbreviations[4].substring(1);
                            } else {
                                words[j] = abbreviations[4];
                            }
                            words[j+1] = "";
                            words[j+2] = "";
                            j+=2;
                        }
                    }
                }
                else if(words[j].toLowerCase().equals(expansions[2].substring(0,2))){
                    System.out.println("Wykryto: na");
                    if(words[j+1].toLowerCase().equals(expansions[2].substring(3))){
                        System.out.println("Wykryto: przykład");
                        if(Character.isUpperCase(words[j].charAt(0))){
                            words[j] = abbreviations[2].substring(0, 1).toUpperCase() + abbreviations[2].substring(1);
                        }
                        else{
                            words[j] = abbreviations[2];
                        }
                        words[j+1] = "";
                        j++;
                    }
                }
            }
        }

        for(int j=0; j<words.length; j++) {
            if (j==0 || words[j].equals("")) newText.append(words[j]);
            else newText.append(" ").append(words[j]);
        }

        return newText.toString();
    }
}
