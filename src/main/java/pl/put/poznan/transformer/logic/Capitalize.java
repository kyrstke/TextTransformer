package pl.put.poznan.transformer.logic;
import org.apache.commons.lang.WordUtils;

public class Capitalize extends TextTransformer{

    public Capitalize(IText transInterface) {
        super(transInterface);
    }
    @Override
    public String transform(String text){
        return capitalize(this.transInterface.transform(text));
    }

    private String capitalize(String text)
    {
        return WordUtils.capitalizeFully(text);
    }

}
