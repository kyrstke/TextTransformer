package pl.put.poznan.transformer.logic;

import java.util.Map;

/**
 * Class to make abbreviations
 */
public class Abbreviations {
    Map abbreviations;

    /**
     * Constructor of text transformation class.
     * @param abbreviations text to decorate
     */

    public Abbreviations(Map abbreviations ){
        this.abbreviations =abbreviations;
    }

    /**
     * Method to make abbreviations
     * @return text after transformation
     */
    public Map getAbbreviations()
    {
        return this.abbreviations;
    }
}
