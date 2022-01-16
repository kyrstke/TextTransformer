package pl.put.poznan.transformer.logic;

/**
 * Class to input string to do transformations
 */
public class InputString implements IText{
    /**
     *
     * @param text given string by user
     * @return text
     */
    @Override
    public String transform(String text){
        return text;
    }
}
