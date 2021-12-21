package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public abstract class TextTransformer implements IText {

    //private final String[] transforms;
    private IText textInput;
    //private final String[] transforms;
    public TextTransformer(IText textInput) {
        this.textInput = textInput;
        //this.transforms = transforms;
    }

    @Override
    public String transform() {
        return textInput.transform();
    }

}
