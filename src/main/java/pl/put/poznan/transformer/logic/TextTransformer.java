package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
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
