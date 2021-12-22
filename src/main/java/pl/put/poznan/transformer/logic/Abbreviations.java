package pl.put.poznan.transformer.logic;

import java.util.Map;

public class Abbreviations {
    Map abbreviations;
    public Abbreviations(Map abbreviations ){
        this.abbreviations =abbreviations;
    }
    public Map getAbbreviations()
    {
        return this.abbreviations;
    }
}
