package pl.put.poznan.transformer.logic;

/**
 * Abstract class
 *
 * @author Jan Kabzinski, Filip Kokosza
 * @version 1.0
 */
public abstract class TextTransformer implements IText {

    protected IText textInput;
    public TextTransformer(IText textInput) {
        this.textInput = textInput;
    }

    @Override
    public String transform() {
        return textInput.transform();
    }

}
