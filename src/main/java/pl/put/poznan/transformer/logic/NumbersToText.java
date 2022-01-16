package pl.put.poznan.transformer.logic;

/**
 * This class transforms numbers into letters
 */
public class NumbersToText extends TextTransformer {
    /**
     *Constructor of text transformation class.
     * @param transInterface text to decorate
     */
    public NumbersToText(IText transInterface) {
        super(transInterface);
    }

    /**
     *Method performing the transformation
     * @param text given string by user
     * @return text after transformation
     */
    @Override
    public String transform(String text) {
        return numbersToText(this.transInterface.transform(text));
    }

    /**
     * This method transforms numbers into letters
     * @param text given string by user
     * @return text after transformation
     */
    private String numbersToText(String text) {

        String[] arr_text = text.split(" ");
        StringBuilder resultBuilder = new StringBuilder("");

        for(String word : arr_text)
        {
            try
            {
                Float.parseFloat(word);
                if ((Float.parseFloat(word)>1000)||(Float.parseFloat(word)<-1000))
                {
                    resultBuilder.append(word).append(" ");
                    continue;
                }
            }
            catch (NumberFormatException e){
                resultBuilder.append(word).append(" ");
                continue;
            }

            String[] parts = word.split("[.]");
            if (parts.length > 1)
            {
                resultBuilder.append(floatToText(parts)).append(" ");
            }
            else
            {
                resultBuilder.append(intToText(Integer.parseInt(parts[0]), false));
            }
        }
        return resultBuilder.toString().trim();
    }

    /**
     * Method makes ends.
     * @param parts text elements after division
     * @return text after transformation
     */
    private String floatToText(String[] parts)
    {
        String[] koncowki = {"ych", "a", "e", "e", "e"};
        String[] czesci = {"dziesiąt", "setn"};
        StringBuilder restBuilder = new StringBuilder("");

        if(Integer.parseInt(parts[0])!=0)
        {
            restBuilder.append("i ");
        }
        int value = Integer.parseInt(parts[1]);
        if ((value-((value/10)*10))!=1)
        {
            restBuilder.append(intToText(value, true)).append(czesci[parts[1].length()-1]);
        }
        else if (value == 0)
        {
            restBuilder.append(intToText(value, false));
        }
        else
        {
            restBuilder.append(intToText(value, false)).append(czesci[parts[1].length()-1]);
        }

        if (value<=4) {
            restBuilder.append(koncowki[value]);
        }
        else if ((value > 10)&&(value < 20))
        {
            restBuilder.append(koncowki[0]);
        }
        else if (((value-((value/10)*10))<=4)&&((value-((value/10)*10))>1))
        {
            restBuilder.append(koncowki[value-((value/10)*10)]);
        }
        else {
            restBuilder.append(koncowki[0]);
        }

        if(Integer.parseInt(parts[0])!=0)
        {
            return intToText(Integer.parseInt(parts[0]), false) + restBuilder;
        }
        else
        {
            if(parts[0].charAt(0)=='-')
            {
                return "minus " + restBuilder;
            }
            else
            {
                return restBuilder.toString();

            }
        }

    }

    /**
     * Method transforms numbers into letters
     * @param number number from text
     * @param rest rest from text
     * @return text after transformation
     */
    private String intToText(int number, Boolean rest) {
        String[] jednosci = {"zero", "jeden", "dwa", "trzy", "cztery", "pięć", "sześć", "siedem", "osiem", "dziewięć"};
        String[] nastki = {"dziesięć", "jedenaście", "dwanaście", "trzynaście", "czternaście", "piętnaście", "szesnaście", "siedemnaście", "osiemnaście", "dziewiętnaście"};
        String[] dziesiatki = {"dwadzieścia", "trzydzieści", "czterdzieści"};
        String[] setki = {"sto", "dwieście", "trzysta", "czterysta"};
        String[] reszta = {"zero", "jedna", "dwie"};

        StringBuilder resultBuilder = new StringBuilder("");

        if(number < 0)
        {
            resultBuilder.append("minus ");
            number *= -1;
        }
        if ((number == 0)) {
            resultBuilder.append((jednosci[0])).append(" ");
        }
        while(number!=0) {

            if ((number < 3) && (rest)) {
                return resultBuilder.append(reszta[number]).append(" ").toString();
            }
            if (number < 10) {
                resultBuilder.append(jednosci[number]).append(" ");
                break;
            }
            if (number < 20) {
                resultBuilder.append(nastki[number % 10]).append(" ");
                break;
            }
            if (number < 50) {
                resultBuilder.append(dziesiatki[(number / 10) - 2]).append(" ");
                number %= 10;
            }
            if ((number < 100) && (number >= 50)) {
                resultBuilder.append(jednosci[number / 10]).append("dziesiąt ");
                number %= 10;
            }
            if ((number < 500) && (number >= 100)) {
                resultBuilder.append(setki[(number / 100) - 1]).append(" ");
                number %= 100;
            }
            if ((number < 1000) && (number >= 500)) {
                resultBuilder.append(jednosci[number / 100]).append("set ");
                number %= 100;
            }
            if (number == 1000) {
                resultBuilder.append("tysiąc ");
                return resultBuilder.toString();
            }
        }
        return resultBuilder.toString();
    }

}
