package pl.put.poznan.transformer.logic;

public class InputString implements IText{

    private String text;

    private final String[] transforms;

    public InputString(String[] transforms, String text ){
        this.transforms = transforms;
        this.text = text;
    }

    @Override
    public String transform(){
        return this.text;
    }
}
