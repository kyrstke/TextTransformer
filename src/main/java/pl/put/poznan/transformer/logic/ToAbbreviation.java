package pl.put.poznan.transformer.logic;

import java.lang.Character;

public class ToAbbreviation extends TextTransformer {

    public ToAbbreviation(IText transInterface) {
        super(transInterface);
    }

    @Override
    public String transform(String text) {

        return toAbbreviation(this.transInterface.transform(text));
    }

    private String toAbbreviation(String text) {
        String[] expansions = {"profesor", "doktor", "na przykład", "i tak dalej", "i tym podobne", "numer", "magister"};
        String[] abbreviations = {"prof.", "dr", "np.", "itd.", "itp.", "nr", "mgr"};
        String[] words = text.split(" ");
        StringBuilder newText = new StringBuilder();
        boolean comma = false, dot = false;


        for (int i = 0; i < words.length; i++) {
            if (words[i].endsWith(",")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
                comma = true;
            } else if (words[i].endsWith(".")) {
                words[i] = words[i].substring(0, words[i].length() - 1);
                dot = true;
            }
            for (int j = 0; j < expansions.length; j++) {
                if (words[i].toLowerCase().equals(expansions[j])) {
                    if (Character.isUpperCase(words[i].charAt(0))) {
                        words[i] = abbreviations[j].substring(0, 1).toUpperCase() + abbreviations[j].substring(1);
                    } else {
                        words[i] = abbreviations[j];
                    }
                    break;
                } else if (words[i].toLowerCase().equals(expansions[3].substring(0, 1))) {
                    if (words[i + 1].toLowerCase().equals(expansions[3].substring(2, 5))) {
                        if (words[i+2].endsWith(",")) {
                            words[i+2] = words[i+2].substring(0, words[i+2].length() - 1);
                            comma = true;
                        } else if (words[i+2].endsWith(".")) {
                            words[i+2] = words[i+2].substring(0, words[i+2].length() - 1);
                            dot = true;
                        }
                        if (words[i + 2].toLowerCase().equals(expansions[3].substring(6,11))) {
                            if (Character.isUpperCase(words[i].charAt(0))) {
                                words[i] = abbreviations[3].substring(0, 1).toUpperCase() + abbreviations[3].substring(1);
                            } else {
                                words[i] = abbreviations[3];
                            }
                            words[i + 1] = "";
                            words[i + 2] = "";
                            break;
                        }
                    } else if (words[i + 1].toLowerCase().equals(expansions[4].substring(2, 5))) {
                        if (words[i+2].endsWith(",")) {
                            words[i+2] = words[i+2].substring(0, words[i+2].length() - 1);
                            comma = true;
                        } else if (words[i+2].endsWith(".")) {
                            words[i+2] = words[i+2].substring(0, words[i+2].length() - 1);
                            dot = true;
                        }
                        if (words[i + 2].toLowerCase().equals(expansions[4].substring(6, 13))) {
                            if (Character.isUpperCase(words[i].charAt(0))) {
                                words[i] = abbreviations[4].substring(0, 1).toUpperCase() + abbreviations[4].substring(1);
                            } else {
                                words[i] = abbreviations[4];
                            }
                            words[i + 1] = "";
                            words[i + 2] = "";
                            break;
                        }
                    }
                } else if (words[i].toLowerCase().equals(expansions[2].substring(0, 2))) {
                    if (words[i+1].endsWith(",")) {
                        words[i+1] = words[i+1].substring(0, words[i+1].length() - 1);
                        comma = true;
                    } else if (words[i+1].endsWith(".")) {
                        words[i+1] = words[i+1].substring(0, words[i+1].length() - 1);
                        dot = true;
                    }
                    if (words[i + 1].toLowerCase().equals(expansions[2].substring(3))) {
                        if (Character.isUpperCase(words[i].charAt(0))) {
                            words[i] = abbreviations[2].substring(0, 1).toUpperCase() + abbreviations[2].substring(1);
                        } else {
                            words[i] = abbreviations[2];
                        }
                        words[i + 1] = "";
                        break;
                    }
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