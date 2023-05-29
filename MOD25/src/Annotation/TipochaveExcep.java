package Annotation;

public class TipochaveExcep extends Exception{

    private static final long serialVersionUID = -1389494676398525746L;

    public TipochaveExcep(String msg){
        this(msg, null);
    }

    public TipochaveExcep(String msg, Throwable e) {
        super(msg, e);
    }
}
